package com.cere.learn.initializer

import android.content.Context
import android.util.Log
import androidx.startup.Initializer

/*
 * Created by CheRevir on 2023/6/26
 */
class AppInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        Log.e("TAG", "create: ${context.packageName}")

    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}