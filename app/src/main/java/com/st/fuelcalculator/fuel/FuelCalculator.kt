package com.st.fuelcalculator.fuel

/**
 * Класс для расчета расхода топлива
 * Принимает:
 * количество километров, расход на 100 км, стоимость за литр, и опционально количество людей
 */
class FuelCalculator(
    private val km: Float,
    private val cons: Float,
    private val cost: Float,
    private val people: Int = 1
) {

    private val result = calculating()

    /**
     * Функция выполняющая расчет
     */
    private fun calculating ():Float {
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