package com.example.movienavbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class summary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val selectedBioskop = intent.getStringExtra("selectedBioskop")
        val cinemaTextView = findViewById<TextView>(R.id.cinema)
        cinemaTextView.text = selectedBioskop

        val selectedSeat = intent.getStringExtra("selectedSeat")
        val seatTextView = findViewById<TextView>(R.id.seat)
        seatTextView.text = selectedSeat

        val selectedDate = intent.getStringExtra("selectedDate")
        val dateTextView = findViewById<TextView>(R.id.date)
        dateTextView.text = selectedDate

        val selectedMetode = intent.getStringExtra("selectedMetode")
        val MetodeTextView = findViewById<TextView>(R.id.cara)
        MetodeTextView.text = selectedMetode


        val buttonClick = findViewById<Button>(R.id.backhome)
        buttonClick.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }
    }
}