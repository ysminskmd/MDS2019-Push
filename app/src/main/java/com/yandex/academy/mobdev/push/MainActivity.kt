package com.yandex.academy.mobdev.push

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.push.YandexMetricaPush
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val answers = listOf(
        "Android" to "iOS",
        "Rap" to "Rock",
        "Marvel" to "DC",
        "Yandex" to "Yandex"
    )

    private var answerIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstAnswer.setOnClickListener { answer(firstAnswer.text) }
        secondAnswer.setOnClickListener { answer(secondAnswer.text) }

        nextQuestion()

        if (intent.action == YandexMetricaPush.OPEN_DEFAULT_ACTIVITY_ACTION) {
            intent?.getStringExtra(YandexMetricaPush.EXTRA_PAYLOAD)?.let { payload ->
                Toast.makeText(this, "MainActivity: $payload", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun answer(text: CharSequence) {
        YandexMetrica.reportEvent("$text")
        nextQuestion()
    }

    private fun nextQuestion() {
        val answer = answers[answerIndex.coerceAtMost(answers.lastIndex)]
        firstAnswer.text = answer.first
        secondAnswer.text = answer.second
        ++answerIndex
    }
}
