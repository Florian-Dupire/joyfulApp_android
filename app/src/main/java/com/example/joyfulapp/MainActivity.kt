package com.example.joyfulapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import io.flutter.embedding.android.FlutterActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1: Button = findViewById(R.id.buttonBlueScreen)
        val button2: Button = findViewById(R.id.buttonPinkScreen)

        // Set click listeners for each button
        button1.setOnClickListener {
            navigateToFlutterScreen("/blueScreen")
        }

        button2.setOnClickListener {
            navigateToFlutterScreen("/pinkScreen")
        }
    }

    private fun navigateToFlutterScreen(route: String) {
        startActivity(
            FlutterActivity
                .withNewEngine()
                .initialRoute(route)
                .build(this)
        );
    }
}