package me.thomassuebwicha.util

import org.junit.Test

class TimeUtilsTest {

    @Test
    fun testSubtract90Minutes() {
        val (newHour, newMinute) = subtractMinutesFromTime(10, 30, 90)
        assert(newHour == 9 && newMinute == 0)
    }

    @Test
    fun testOvernightSubtraction() {
        val (newHour, newMinute) = subtractMinutesFromTime(1, 15, 90)
        assert(newHour == 0 && newMinute == 45)
    }

}