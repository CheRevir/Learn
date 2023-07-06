package com.cere.learn

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/*
 * Created by CheRevir on 2023/6/26
 */

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}