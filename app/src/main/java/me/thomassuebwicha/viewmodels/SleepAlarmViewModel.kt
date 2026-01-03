package me.thomassuebwicha.viewmodels

import android.content.Context
import android.content.Intent
import android.provider.AlarmClock
import android.util.Log
import android.widget.Toast

fun setAlarm(context: Context, hour: Int, minute: Int, message: String) {
    try {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minute)
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_SKIP_UI, false) // Shows the Clock app UI
        }
        Log.i("SettingAlarm",intent.toString())
        // Check if there's an app that can handle this intent
        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        } else {
            Log.e("SettingAlarm","No clock app found.")
            Toast.makeText(context, "No clock app found", Toast.LENGTH_SHORT).show()
        }
    } catch (e: Exception) {
        Log.e("SettingAlarm","Error setting alarm")
        Toast.makeText(context, "Error setting alarm: ${e.message}", Toast.LENGTH_SHORT).show()
    }
}