package com.st.fuelcalculator

import com.st.fuelcalculator.fuel.FuelCalculator
import org.junit.Test

import org.junit.Assert.*


class FuelCalculatorTest {
    @Test
    fun testFuelCalculator() {
        assertEquals("665 руб.",
            FuelCalculator(251.0, 5.2, 51.0).calculatingStr())
    }
}