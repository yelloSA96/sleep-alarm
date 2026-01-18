package me.thomassuebwicha.util

/**
 * Subtracts a specified number of minutes from a given time represented by hour and minute.
 *
 * @param hour The hour component of the time (0-23).
 * @param minute The minute component of the time (0-59).
 * @param minutesToSubtract The number of minutes to subtract.
 * @return A Pair containing the new hour and minute after subtraction.
 */
fun subtractMinutesFromTime(hour: Int, minute: Int, minutesToSubtract: Int): Pair<Int, Int> {
    val totalMinutes = hour * 60 + minute - minutesToSubtract
    val newHour = ((totalMinutes / 60) % 24 + 24) % 24
    val newMinute = ((totalMinutes % 60) + 60) % 60
    return Pair(newHour, newMinute)
}