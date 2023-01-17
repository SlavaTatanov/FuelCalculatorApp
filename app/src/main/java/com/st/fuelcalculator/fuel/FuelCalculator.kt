package com.st.fuelcalculator.fuel

/**
 * Класс для расчета расхода топлива
 * Принимает:
 * количество километров, расход на 100 км, стоимость за литр, и опционально количество людей
 */
class FuelCalculator(
    private val km: Double,
    private val cons: Double,
    private val cost: Double,
    private val people: Int = 1
) {

    /**
     * Результат расчета, атрибут
     */
    private val result= calculating()

    /**
     * Функция выполняющая расчет
     */
    private fun calculating ():Double {
        var res = ((cons / 100) * km) * cost
        if (people != 1) {
            res /= people
        }
        return res
    }


    /**
     * Результат расчета
     */
    fun calculatingStr ():String {
        return "${result.toInt().toString()} руб."
    }
}