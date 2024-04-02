package com.example.joyfulapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

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
    }
}