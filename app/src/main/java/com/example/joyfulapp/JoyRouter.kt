package com.example.joyfulapp

import android.content.Context
import android.content.Intent

object JoyRouter {
    const val engineGroupId = "myFullOfJoyEngineGroup"

    private val routes = arrayOf(
        JoyRoute(
            route = "/blueScreen",
            intentProvider = {
                MyFlutterActivity.withNewEngineInGroup(engineGroupId)
                    .initialRoute("/blueScreen")
                    .build(it)
            }
        ),
        JoyRoute(
            route = "/pinkScreen",
            intentProvider = {
                MyFlutterActivity.withNewEngineInGroup(engineGroupId)
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