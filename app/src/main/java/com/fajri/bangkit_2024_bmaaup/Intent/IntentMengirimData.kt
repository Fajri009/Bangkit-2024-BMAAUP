package com.fajri.bangkit_2024_bmaaup.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.fajri.bangkit_2024_bmaaup.R

class IntentMengirimData : AppCompatActivity() {
    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_mengirim_data)

        val tvDataReceived: TextView = findViewById(R.id.tv_data_received)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)

        val text = "Name : $name, Your Age : $age"
        tvDataReceived.text = text
    }
}