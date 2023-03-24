package com.st.fuelcalculator

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.action.ViewActions.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.allOf

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class FuelCalculatorInstrumentedTest {
    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    /**
     * Базовый тест вводим значения, считаем, проверяем
     */
    @Test
    fun calculate() {
        inputTestValues()

        onView(withId(R.id.btn_calc)).
        perform(click())

        onView(allOf(withId(R.id.textViewResult), withText("540")))
    }

    /**
     * Проверяем работоспособность кнопок на увеличение уменьшение кол-ва людей
     */
    @Test
    fun calculateWithPeople() {
        onView(withId(R.id.btnPeoplePlus))
            .perform(click())

        onView(withId(R.id.btnPeoplePlus))
            .perform(click())

        onView(withId(R.id.btnPeopleMinus))
            .perform(click())

        onView(allOf(withId(R.id.textViewPeople), withText("2")))

        inputTestValues()

        onView((withId(R.id.btn_calc)))
            .perform(click())

        onView(allOf(withId(R.id.textViewResult), withText("240")))
    }

    /**
     * Ввож тестовых значений
     */
    private fun inputTestValues() {
        onView(withId(R.id.editTextKm)).
        perform(typeText("200.0"))

        onView(withId(R.id.editTextCons)).
        perform(typeText("5.2"))

        onView(withId(R.id.editTextPrice)).
        perform(typeText("52")).
        perform(closeSoftKeyboard())
    }
}