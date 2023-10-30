package com.cere.flutter.core

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import com.idlefish.flutterboost.FlutterBoost

@Suppress("unused")
class FlutterInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        Log.e("Flutter", "初始化")
        FlutterBoost.instance()
            .setup(context.applicationContext as Application, FlutterDelegate()) {

            }
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}