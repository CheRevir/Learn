package com.cere.core.base

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VB : ViewDataBinding>(@LayoutRes private val contentLayoutId: Int) :
    AppCompatActivity() {
    lateinit var binding: VB
        private set
    lateinit var rootView: CoordinatorLayout
        private set
    lateinit var containerView: FrameLayout
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        val toolbar: Toolbar = findViewById(R.id.activity_base_toolbar)
        setSupportActionBar(toolbar)
        rootView = findViewById(R.id.activity_base_root)
        containerView = findViewById(R.id.activity_base_container)
        val content: View = layoutInflater.inflate(contentLayoutId, null)
        containerView.addView(content)
        binding = DataBindingUtil.bind(content)!!
    }
}