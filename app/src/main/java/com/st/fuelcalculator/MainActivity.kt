package com.st.fuelcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.st.fuelcalculator.fuel.FuelCalculator


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalc: Button = findViewById(R.id.btn_calc)
        val btnSave: Button = findViewById(R.id.btn_save)

        btnCalc.setOnClickListener { result(btnSave) }

        }

    private fun result (btnSave: Button) {
        val km = findViewById<EditText>(R.id.editTextKm).text.toString().toDouble()
        val cons = findViewById<EditText>(R.id.editTextCons).text.toString().toDouble()
        val price = findViewById<EditText>(R.id.editTextPrice).text.toString().toDouble()
        val res = FuelCalculator(km, cons, price).calculatingStr()
        findViewById<TextView>(R.id.textViewResult).text = res
        btnSave.visibility = View.VISIBLE
        btnSave.setOnClickListener { secret(findViewById<Button>(R.id.btn_calc)) }
    }

    private fun secret (btnSave: Button) {
        btnSave.visibility = View.INVISIBLE
    }

    }
