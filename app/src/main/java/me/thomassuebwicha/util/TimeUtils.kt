package me.thomassuebwicha.util

fun subtractMinutesFromTime(hour: Int, minute: Int, minutesToSubtract: Int): Pair<Int, Int> {
    val totalMinutes = hour * 60 + minute - minutesToSubtract
    val newHour = ((totalMinutes / 60) % 24 + 24) % 24
    val newMinute = ((totalMinutes % 60) + 60) % 60
    return Pair(newHour, newMinute)
}