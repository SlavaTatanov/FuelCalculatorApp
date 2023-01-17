package com.st.fuelcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalc: Button = findViewById(R.id.btn_calc)
        val btnSave: Button = findViewById(R.id.btn_save)

        btnCalc.setOnClickListener { result(btnSave) }

        }

    private fun result (btnSave: Button) {
        print(findViewById<EditText>(R.id.editTextKm).text.toString())
        btnSave.visibility = View.VISIBLE
        btnSave.setOnClickListener { secret(findViewById<Button>(R.id.btn_calc)) }
    }

    private fun secret (btnSave: Button) {
        btnSave.visibility = View.INVISIBLE
    }

    }
