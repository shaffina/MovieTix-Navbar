package com.example.movienavbar

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import com.example.movienavbar.databinding.ActivityPaymentBinding
import java.util.*
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.Spinner


class payment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bioskop = resources.getStringArray(R.array.bioskop)
        val seat = resources.getStringArray(R.array.seat)
        val metode = resources.getStringArray(R.array.metode)
        var selectedBioskop: String = ""
        var selectedSeat: String = ""
        var selectedMetode: String = ""

        val spinnerBioskop = findViewById<Spinner>(R.id.spinbioskop)
        spinnerBioskop.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedBioskop = spinnerBioskop.selectedItem.toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        val spinnerSeat = findViewById<Spinner>(R.id.spinseat)
        spinnerSeat.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedSeat = spinnerSeat.selectedItem.toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        val spinnerMetode = findViewById<Spinner>(R.id.spinmetode)
        spinnerMetode.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedMetode = spinnerMetode.selectedItem.toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        with(binding) {
            val bioskopAdapter =
                ArrayAdapter(this@payment, android.R.layout.simple_spinner_dropdown_item, bioskop)
            bioskopAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinbioskop.adapter = bioskopAdapter
        }

        with(binding) {
            val seatAdapter =
                ArrayAdapter(this@payment, android.R.layout.simple_spinner_dropdown_item, seat)
            seatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinseat.adapter = seatAdapter
        }

        with(binding) {
            val metodeAdapter =
                ArrayAdapter(this@payment, android.R.layout.simple_spinner_dropdown_item, metode)
            metodeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinmetode.adapter = metodeAdapter
        }

        val backClick = findViewById<ImageView>(R.id.backButton)
        backClick.setOnClickListener {
            val intent = Intent(this, detail::class.java)
            startActivity(intent)
        }

        with(binding) {
            val currentTime = Calendar.getInstance()
            val year = currentTime.get(Calendar.YEAR)
            val month = currentTime.get(Calendar.MONTH)
            val day = currentTime.get(Calendar.DAY_OF_MONTH)

            // Setelah pengguna memilih tanggal dan memperbarui EditText, tambahkan teks tersebut ke dalam Intent
            val datePicker = DatePickerDialog(this@payment, object : DatePickerDialog.OnDateSetListener {
                @SuppressLint("SuspiciousIndentation")
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    val selectedDateString = String.format("%d / %d / %d", dayOfMonth, month + 1, year)
                    selectedDate.setText(selectedDateString)

                    val orderClick = findViewById<Button>(R.id.pembayaran)
                    orderClick.setOnClickListener {
                        val intent = Intent(this@payment, summary::class.java)
                        intent.putExtra("selectedBioskop", selectedBioskop)
                        intent.putExtra("selectedSeat", selectedSeat)
                        intent.putExtra("selectedDate", selectedDateString)
                        intent.putExtra("selectedMetode", selectedMetode)
                        startActivity(intent)}
                }
            }, year, month, day)

            selectDate.setOnClickListener { v ->
                datePicker.show()
            }

        }

    }
}