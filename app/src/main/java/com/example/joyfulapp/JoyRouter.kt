package com.example.joyfulapp

import android.content.Context
import android.content.Intent
import io.flutter.embedding.android.FlutterActivity

object JoyRouter {
    const val engineGroupId = "myFullOfJoyEngineGroup"

    private val routes = arrayOf(
        JoyRoute(
            route = "/blueScreen",
            intentProvider = {
                FlutterActivity.withNewEngineInGroup(engineGroupId)
                    .initialRoute("/blueScreen")
                    .build(it)
            }
        ),
        JoyRoute(
            route = "/pinkScreen",
            intentProvider = {
                FlutterActivity.withNewEngineInGroup(engineGroupId)
                    .initialRoute("/pinkScreen")
                    .build(it)
            }
        )
    )

    fun navigateTo(route: String, context: Context) {
        val theRoute = routes.find { it.route == route }
        if (theRoute != null) {
            context.startActivity(theRoute.intentProvider(context))
        }
    }
}

typealias IntentProvider = (context: Context) -> Intent
private class JoyRoute(
    val route: String,
    val intentProvider: IntentProvider,
)