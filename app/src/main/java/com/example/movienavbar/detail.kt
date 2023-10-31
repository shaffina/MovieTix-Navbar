package com.example.movienavbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val buttonClick = findViewById<Button>(R.id.buytix)
        buttonClick.setOnClickListener {
            val intent = Intent(this, payment::class.java)
            startActivity(intent)
        }

        val backClick = findViewById<ImageView>(R.id.backButton)
        backClick.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }

    }
}