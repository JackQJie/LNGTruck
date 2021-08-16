package com.sxhxly.lngtruck.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.sxhxly.lngtruck.App
import com.sxhxly.lngtruck.R
import com.sxhxly.lngtruck.ui.weather.WeatherActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val weather = findViewById<TextView>(R.id.tv_weather)
        weather.setOnClickListener {
            val intent = Intent(App.context,WeatherActivity::class.java)
            startActivity(intent)
        }

    }
}