package com.st.fuelcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.st.fuelcalculator.fuel.FuelCalculator


class MainActivity : AppCompatActivity() {

    private lateinit var btnCalc: Button
    private lateinit var btnSave: Button
    private lateinit var btnPeopleMinus: Button
    private lateinit var btnPeoplePlus: Button
    private lateinit var editTextKm: EditText
    private lateinit var editTextCons: EditText
    private lateinit var editTextPrice: EditText
    private lateinit var textViewPeople: TextView
    private lateinit var textViewResult: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        Блок назначающий глобальныи переменным их значения из интерфейса
         */
        btnCalc= findViewById(R.id.btn_calc)
        btnSave = findViewById(R.id.btn_save)
        btnPeopleMinus = findViewById(R.id.btnPeopleMinus)
        btnPeoplePlus = findViewById(R.id.btnPeoplePlus)
        editTextKm = findViewById(R.id.editTextKm)
        editTextCons = findViewById(R.id.editTextCons)
        editTextPrice = findViewById(R.id.editTextPrice)
        textViewPeople = findViewById(R.id.peopleTextView)
        textViewResult = findViewById(R.id.textViewResult)

        /*
        Блок устанавливает слушателей
         */
        btnCalc.setOnClickListener { result(btnSave) }
        btnPeopleMinus.setOnClickListener { peopleTextViewChange(-1) }
        btnPeoplePlus.setOnClickListener { peopleTextViewChange(1) }
        btnSave.setOnClickListener { secret() }

        }

    /**
     * Выполняет основной расчет.
     * Функция обрабатывающая нажатие клавиши расчет. Создает экземпляр класса FuelCalculator
     * и вызывает его метод calculatingStr получая строку с результатом.
     * Результат записывается в TextView. Выводит кнопку сохранить,
     * предлагая юзеру сохранить расчет.
     */
    private fun result (btnSave: Button) {
        val km = editTextKm.text.toString().toDouble()
        val cons = editTextCons.text.toString().toDouble()
        val price = editTextPrice.text.toString().toDouble()
        val people = textViewPeople.text.toString().toInt()
        val res = FuelCalculator(km, cons, price, people).calculatingStr()
        textViewResult.text = res
        btnSave.visibility = View.VISIBLE
    }

    private fun secret () {
        btnCalc.visibility = View.INVISIBLE
    }

    /**
     * Изменяет количество людей, если оно меньше 1 то оставляет как есть
     * шаг - 1
     */
    private fun peopleTextViewChange (people: Int) {
        var res = textViewPeople.text.toString().toInt()
        if (peopleChecking(people)) {
            res += people
            if (res >= 1) {
                textViewPeople.text = res.toString()
            }
        }
    }

    /**
     * Проверяет что входящее значение 1 либо -1
     */
    private fun peopleChecking (people: Int): Boolean {
        return (people == 1 || people == -1)
    }
}
