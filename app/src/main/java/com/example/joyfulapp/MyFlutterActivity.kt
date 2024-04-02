package com.example.joyfulapp

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MyFlutterActivity : FlutterActivity() {
    companion object {
        fun withNewEngineInGroup(groupId: String = "my_group"): NewEngineInGroupIntentBuilder {
            return NewEngineInGroupIntentBuilder(MyFlutterActivity::class.java, groupId)
        }
    }
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, "com.example.joyfulapp")
            .setMethodCallHandler { call, result ->
                when (call.method) {
                    "goTo" -> {
                        call.argument<String>("route")?.let {
                            JoyRouter.navigateTo(it, this)
                        }
                    }
                    "goBack" -> {
                        onBackPressed()
                    }
                    else -> {
                        result.notImplemented()
                    }
                }
            }
    }
}