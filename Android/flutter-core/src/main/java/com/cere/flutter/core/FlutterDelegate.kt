package com.cere.flutter.core

import android.content.Intent
import android.util.Log
import com.idlefish.flutterboost.FlutterBoost
import com.idlefish.flutterboost.FlutterBoostDelegate
import com.idlefish.flutterboost.FlutterBoostRouteOptions
import com.idlefish.flutterboost.containers.FlutterBoostActivity
import io.flutter.embedding.android.FlutterActivityLaunchConfigs

class FlutterDelegate : FlutterBoostDelegate {

    override fun pushNativeRoute(options: FlutterBoostRouteOptions) {
        Log.e("Flutter", "pushNativeRoute: $options")
    }

    override fun pushFlutterRoute(options: FlutterBoostRouteOptions) {
        Log.e("Flutter", "pushFlutterRoute: $options")
        val intent: Intent =
            FlutterBoostActivity.CachedEngineIntentBuilder(FlutterBoostActivity::class.java)
                .backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.opaque)
                .destroyEngineWithActivity(false)
                .uniqueId(options.uniqueId())
                .url(options.pageName())
                .urlParams(options.arguments())
                .build(FlutterBoost.instance().currentActivity())
        FlutterBoost.instance().currentActivity().startActivity(intent)
    }
}