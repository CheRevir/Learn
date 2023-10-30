package com.cere.flutter.core

import com.idlefish.flutterboost.FlutterBoost
import com.idlefish.flutterboost.FlutterBoostRouteOptions

class FlutterNavigator {
    companion object {
        @JvmStatic
        fun home() {
            val options = FlutterBoostRouteOptions.Builder()
                .pageName("home")
                .arguments(hashMapOf())
                .build()
            FlutterBoost.instance().open(options)
        }
    }
}