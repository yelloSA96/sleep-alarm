package me.thomassuebwicha;


import android.content.Context
import android.content.Intent;
import android.provider.AlarmClock;


fun setAlarm(context: Context, hour: Int, minute: Int, message: String) {
    val intent = Intent(AlarmClock.ACTION_SET_ALARM)
    intent.putExtra(AlarmClock.EXTRA_HOUR, hour)
    intent.putExtra(AlarmClock.EXTRA_MINUTES, minute)
    intent.putExtra(AlarmClock.EXTRA_MESSAGE, message)

    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    }
}