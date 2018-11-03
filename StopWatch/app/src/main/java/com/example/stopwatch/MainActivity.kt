package com.example.stopwatch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    private var time = 0
    private var isRunning = false
    private var timeTask: Timer? = null
    private var lap = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener {
            isRunning = !isRunning

            if(isRunning) {
                start()
            } else {
                pause()
            }
        }

        resetFab.setOnClickListener {
            reset()
        }

        labButton.setOnClickListener {
            recordLapTime()
        }
    }

    private fun reset() {
        pause()
        time = 0
        isRunning = false
        secTextView.text = "0"
        milliTextView.text = "00"
        labLayout.removeAllViews()
    }

    private fun recordLapTime() {
        val lapTime = time
        val textView = TextView(this)
        textView.text = "$lap LAB : ${lapTime / 100}.${lapTime%100}"
        labLayout.addView(textView, 0)
        lap++
    }

    private fun start() {
        fab.setImageResource(R.drawable.ic_pause_black_24dp)

        timeTask = timer(period = 10) {
            time++
            var sec = time/100
            var milli = time % 100

            runOnUiThread{
                secTextView.text = "$sec"
                milliTextView.text = "$milli"
            }
        }
    }

    private fun pause() {
        fab.setImageResource(R.drawable.ic_play_arrow_black_24dp)
        timeTask?.cancel()
    }
}
