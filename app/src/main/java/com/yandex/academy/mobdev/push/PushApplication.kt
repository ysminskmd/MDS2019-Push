package com.yandex.academy.mobdev.push

import android.app.Application
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import com.yandex.metrica.push.YandexMetricaPush

class PushApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val builder = YandexMetricaConfig.newConfigBuilder("fb0774e0-14bc-4e3e-b077-3d3ada3d2147")
        YandexMetrica.activate(this, builder.build())
        YandexMetrica.enableActivityAutoTracking(this)

        YandexMetricaPush.init(this)
    }
}