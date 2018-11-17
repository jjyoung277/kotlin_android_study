//commit test ¡÷ºÆ
package com.example.bmicalculator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()

        button.setOnClickListener {
            saveData(height.text.toString().toInt(), weight.text.toString().toInt())
            startActivity<ResultActivity>(
                "weight" to weight.text.toString(),
                "height" to height.text.toString()
            )
        }
    }

    private fun saveData(h: Int, w: Int) {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()

        editor.putInt("KEY_HEIGHT", h)
            .putInt("KEY_WEIGHT", w)
            .apply()
    }

    private fun loadData() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val h = pref.getInt("KEY_HEIGHT", 0)
        val w = pref.getInt("KEY_WEIGHT", 0)

        if(h != 0 && w != 0) {
            height.setText(h.toString())
            weight.setText(w.toString())
        }
    }
}
