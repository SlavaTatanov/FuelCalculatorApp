package com.st.fuelcalculator.fuel

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

private class ResultFormatter(calculator: FuelCalculator, money: String) {
    val result = "${calculator.result.toInt()} ${money}\n${calculator.liters}"
}

/**
 * Вычисляет цену на топливо и выполняет форматрирование результата
 */
data class Fuel(
    private val km: Double,
    private val cons: Double,
    private val cost: Double,
    private val people: Int,
    val money: String
) {
    private val fuel = FuelCalculator(km, cons, cost, people)
    val result = ResultFormatter(fuel, money).result
}