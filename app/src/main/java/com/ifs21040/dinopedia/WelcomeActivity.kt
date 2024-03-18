package com.ifs21040.dinopedia

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WelcomeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val btnStart = findViewById<Button>(R.id.buttongo)
        btnStart.setOnClickListener {
            val intent = Intent(this@WelcomeActivity, HomeActivity::class.java)
            intent.addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }

    }
}