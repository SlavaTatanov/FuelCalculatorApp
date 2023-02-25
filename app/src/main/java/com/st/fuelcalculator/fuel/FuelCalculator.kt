package com.st.fuelcalculator.fuel

import java.text.NumberFormat

/**
 * Класс для расчета расхода топлива
 * Принимает:
 * количество километров, расход на 100 км, стоимость за литр, и опционально количество людей
 */
class FuelCalculator(
    km: Double,
    cons: Double,
    cost: Double,
    people: Int = 1
) {
    init {
        require(km > 0) {"Неккоректное значение - км"}
        require(cons > 0) {"Неккоректное значение - расход"}
        require(cost > 0) {"Неккоректное значение - стоимость"}
    }

    /**
     * Потраченные литры
     */
    val liters = (cons / 100) * km

    /**
     * Результат расчета
     */
    val result= calculating(liters, cost, people)

    /**
     * Функция выполняющая расчет
     */
    private fun calculating (liters: Double, cost: Double, people: Int):Double {
        var res = liters * cost
        if (people != 1) {
            res /= people
        }
        return res
    }


    /**
     * Результат расчета
     */
    fun calculatingStr ():String {
        return result.toInt().toString()
    }
}

/**
 * Вычисляет цену на топливо и выполняет форматрирование результата
 */
data class Fuel(
    private val km: Double,
    private val cons: Double,
    private val cost: Double,
    private val people: Int,
    private val money: String
) {
    private val fuel = FuelCalculator(km, cons, cost, people)
    val result: String = NumberFormat.getCurrencyInstance().format(fuel.result)
}