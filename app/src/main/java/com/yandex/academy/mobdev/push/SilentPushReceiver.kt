package com.yandex.academy.mobdev.push

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.yandex.metrica.push.YandexMetricaPush

class SilentPushReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val payload = intent.getStringExtra(YandexMetricaPush.EXTRA_PAYLOAD)
        Toast.makeText(context, "SilentPushReceiver: $payload", Toast.LENGTH_LONG).show()
    }
}