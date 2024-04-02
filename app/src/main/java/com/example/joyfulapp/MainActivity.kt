package com.example.joyfulapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngineGroup
import io.flutter.embedding.engine.FlutterEngineGroupCache


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFlutterEngineGroup()


        val button1: Button = findViewById(R.id.buttonBlueScreen)
        val button2: Button = findViewById(R.id.buttonPinkScreen)
        val button3: Button = findViewById(R.id.buttonGreenScreen)

        // Set click listeners for each button
        button1.setOnClickListener {
            JoyRouter.navigateTo("/blueScreen", this)
        }

        button2.setOnClickListener {
            JoyRouter.navigateTo("/pinkScreen", this)
        }

        button3.setOnClickListener {
            JoyRouter.navigateTo("/greenScreen", this)
        }
    }

    private fun initFlutterEngineGroup() {
        val flutterEngineGroup = FlutterEngineGroup(this)
        FlutterEngineGroupCache.getInstance().put(JoyRouter.engineGroupId, flutterEngineGroup)
    }
}