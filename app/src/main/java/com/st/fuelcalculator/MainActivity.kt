package com.st.fuelcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.st.fuelcalculator.databinding.ActivityMainBinding
import com.st.fuelcalculator.fuel.FuelCalculator


class MainActivity : AppCompatActivity() {

    private lateinit var binding :ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /*
        Блок устанавливает слушателей
         */
        binding.btnCalc.setOnClickListener { result() }
        binding.btnPeopleMinus.setOnClickListener { peopleTextViewChange(-1) }
        binding.btnPeoplePlus.setOnClickListener { peopleTextViewChange(1) }
        binding.btnSave.setOnClickListener { secret() }

        }

    /**
     * Выполняет основной расчет.
     * Функция обрабатывающая нажатие клавиши расчет. Создает экземпляр класса FuelCalculator
     * и вызывает его метод calculatingStr получая строку с результатом.
     * Результат записывается в TextView. Выводит кнопку сохранить,
     * предлагая юзеру сохранить расчет.
     */
    private fun result () {
        val km = binding.editTextKm.text.toString().toDouble()
        val cons = binding.editTextCons.text.toString().toDouble()
        val price = binding.editTextPrice.text.toString().toDouble()
        val people = binding.textViewPeople.text.toString().toInt()
        val res = FuelCalculator(km, cons, price, people).calculatingStr()
        binding.textViewResult.text = res
        binding.btnSave.visibility = View.VISIBLE
    }

    private fun secret () {
        binding.btnCalc.visibility = View.INVISIBLE
    }

    /**
     * Изменяет количество людей, если оно меньше 1 то оставляет как есть
     * шаг - 1
     */
    private fun peopleTextViewChange (people: Int) {
        var res = binding.textViewPeople.text.toString().toInt()
        if (peopleChecking(people)) {
            res += people
            if (res >= 1) {
                binding.textViewPeople.text = res.toString()
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
