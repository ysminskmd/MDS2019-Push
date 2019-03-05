package com.yandex.academy.mobdev.push

import android.app.Application
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig

class PushApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val builder = YandexMetricaConfig.newConfigBuilder("dc5130b9-bebd-4f1c-bd3f-84eda53b9e48")
        YandexMetrica.activate(this, builder.build())
        YandexMetrica.enableActivityAutoTracking(this)
    }
}