package com.st.fuelcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.st.fuelcalculator.databinding.ActivityMainBinding
import com.st.fuelcalculator.fuel.Fuel


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
        binding.btnClear.setOnClickListener { clear() }
        }

    /**
     * Выполняет основной расчет.
     * Функция обрабатывающая нажатие клавиши расчет.
     * Пытается: Создать экземпляр класса Fuel
     * и вызывать его атрибут result получая строку с результатом.
     * Если не вышло -> результат "Ошибка ввода"
     * Результат записывается в TextView. Выводит кнопку сохранить,
     * предлагая юзеру сохранить расчет. Если расчет не корректный, скроет кнопку сохранить.
     */
    private fun result () {
        val res: String = try {
            val km = binding.editTextKm.text.toString().toDouble()
            val cons = binding.editTextCons.text.toString().toDouble()
            val price = binding.editTextPrice.text.toString().toDouble()
            val people = binding.textViewPeople.text.toString().toInt()
            Fuel(km, cons, price, people, getText(R.string.money).toString()).result
        } catch (e: IllegalArgumentException) {
            getText(R.string.inputError).toString()
        }
        binding.textViewResult.text = res
    }

    /**
     * Выполняет очистку текстовых полей
     */
    private fun clear () {
        arrayOf(binding.editTextKm, binding.editTextCons, binding.editTextPrice).forEach {
            it.text = null
            it.clearFocus()
        }
        binding.textViewResult.text = getString(R.string.Null)
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

