package com.example.joyfulapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
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

        initFlutterFragment()
    }

    private fun initFlutterFragment() {

        val flutterFragment: FlutterFragment = FlutterFragment.withNewEngineInGroup(JoyRouter.engineGroupId)
            .initialRoute("/orangeSquare")
            .build()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, flutterFragment)
            .commit()
    }
}