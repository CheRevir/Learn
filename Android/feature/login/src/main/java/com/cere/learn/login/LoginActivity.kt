package com.cere.learn.login

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import com.cere.core.base.BaseVMActivity
import com.cere.core.base.LoadingState
import com.cere.core.base.Progress
import com.cere.learn.login.databinding.ActivityLoginBinding

class LoginActivity :
    BaseVMActivity<ActivityLoginBinding, LoginViewModel>(R.layout.activity_login) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewBinding(content: View): ActivityLoginBinding {
        return ActivityLoginBinding.bind(content)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }
}