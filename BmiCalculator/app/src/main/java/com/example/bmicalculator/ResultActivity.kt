package com.example.bmicalculator

import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*
import org.jetbrains.anko.toast

class ResultActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val intent = intent
        val w = intent.getStringExtra("weight").toInt()
        val h = intent.getStringExtra("height").toInt()

        var bmi = w / Math.pow(h / 100.0, 2.0)

        when {
            bmi >= 35 -> textResult.text = "고도비만"
            bmi >= 30 -> textResult.text = "2단계 비만"
            bmi >= 25 -> textResult.text = "1단계 비만"
            bmi >= 23 -> textResult.text = "과제충"
            bmi >= 18.5 -> textResult.text = "정상"
            else -> textResult.text = "저체중"
        }

        when{
            bmi >= 23 ->
                imageView2.setImageResource(
                    R.drawable.ic_adb_black_24dp
                )
            bmi >= 18.5 ->
                imageView2.setImageResource(R.drawable.ic_accessibility_black_24dp)
            else ->
                imageView2.setImageResource(R.drawable.ic_add_alarm_black_24dp)
        }

        toast("$bmi")
    }
}