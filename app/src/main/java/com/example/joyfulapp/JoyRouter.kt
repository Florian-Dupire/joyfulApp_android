package com.example.joyfulapp

import android.content.Context
import android.content.Intent
import io.flutter.embedding.android.FlutterActivity

object JoyRouter {
    private val routes = arrayOf(
        JoyRoute(
            route = "/blueScreen",
            intentProvider = {
                FlutterActivity
                    .withNewEngine()
                    .initialRoute("/blue")
                    .build(it)
            }
        ),
        JoyRoute(
            route = "/pinkScreen",
            intentProvider = {
                FlutterActivity
                    .withNewEngine()
                    .initialRoute("/pink")
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