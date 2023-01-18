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
        val btnPeopleMinus: Button = findViewById(R.id.btnPeopleMinus)
        val btnPeoplePlus: Button = findViewById(R.id.btnPeoplePlus)

        btnCalc.setOnClickListener { result(btnSave) }
        btnPeopleMinus.setOnClickListener { peopleTextViewChange(-1) }
        btnPeoplePlus.setOnClickListener { peopleTextViewChange(1) }

        }

    /**
     * Функция обрабатывающая нажатие клавиши расчет. Создает экземпляр класса FuelCalculator
     * и вызывает его метод calculatingStr получая строку с результатом.
     * Результат записывается в TextView. Выводит кнопку сохранить,
     * предлагая юзеру сохранить расчет.
     */
    private fun result (btnSave: Button) {
        val km = findViewById<EditText>(R.id.editTextKm).text.toString().toDouble()
        val cons = findViewById<EditText>(R.id.editTextCons).text.toString().toDouble()
        val price = findViewById<EditText>(R.id.editTextPrice).text.toString().toDouble()
        val people = findViewById<TextView>(R.id.peopleTextView).text.toString().toInt()
        val res = FuelCalculator(km, cons, price, people).calculatingStr()
        findViewById<TextView>(R.id.textViewResult).text = res
        btnSave.visibility = View.VISIBLE
        btnSave.setOnClickListener { secret(findViewById<Button>(R.id.btn_calc)) }  // Надо заменить обработчик
    }

    private fun secret (btnSave: Button) {
        btnSave.visibility = View.INVISIBLE
    }

    private fun peopleTextViewChange (people: Int) {
        val peopleTextView = findViewById<TextView>(R.id.peopleTextView)
        var res = peopleTextView.text.toString().toInt()
        if (peopleChecking(people)) {
            res += people
            if (res >= 1) {
                peopleTextView.text = res.toString()
            }
        }
    }

    private fun peopleChecking (people: Int): Boolean {
        return (people == 1 || people == -1)
    }

    }
