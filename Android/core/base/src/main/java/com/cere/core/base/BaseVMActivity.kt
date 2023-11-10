package com.cere.core.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

abstract class BaseVMActivity<VM : ViewBinding, BM : BaseViewModel>(@LayoutRes val contentLayoutId: Int) :
    BaseActivity<VM>(contentLayoutId) {
    lateinit var viewModel: BM
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getViewModelProvider()

        viewModel.loadingState.observe(this) {
            when (it) {
                is LoadingState.SUCCESS -> {
                    loadingLayout.visibility = View.INVISIBLE
                }

                is LoadingState.FAIL -> {
                    loadingLayout.visibility = View.INVISIBLE
                }

                is LoadingState.LOADING -> {
                    loading.max = it.progress.max
                    loading.progress = it.progress.current
                    loadingLayout.isClickable = !it.progress.clickable
                    loadingLayout.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun getViewModelProvider(): BM {
        val type = javaClass.genericSuperclass
        if (type != null && type is ParameterizedType) {
            val tClass = type.actualTypeArguments[1] as Class<BM>
            return ViewModelProvider(this)[tClass]
        }
        throw IllegalArgumentException()
    }
}