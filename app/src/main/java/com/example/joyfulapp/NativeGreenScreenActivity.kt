package com.example.joyfulapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import io.flutter.embedding.android.FlutterFragment

class NativeGreenScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_native_green_screen)

        findViewById<Button>(R.id.backButton).setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        findViewById<Button>(R.id.buttonBlueScreen).setOnClickListener {
            JoyRouter.navigateTo("/blueScreen", this)
        }

        findViewById<Button>(R.id.buttonPinkScreen).setOnClickListener {
            JoyRouter.navigateTo("/pinkScreen", this)
        }

        initFlutterFragments()
    }

    private fun initFlutterFragments() {
        // init first fragment
        val flutterFragment1: FlutterFragment = FlutterFragment.withNewEngineInGroup(JoyRouter.engineGroupId)
            .initialRoute("/orangeSquare")
            .build()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView1, flutterFragment1)
            .commit()


        // init second fragment
        val flutterFragment2: FlutterFragment = FlutterFragment.withNewEngineInGroup(JoyRouter.engineGroupId)
            .initialRoute("/blueScreen")
            .build()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView2, flutterFragment2)
            .commit()
    }
}