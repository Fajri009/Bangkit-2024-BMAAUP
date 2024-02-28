package com.fajri.bangkit_2024_bmaaup.Intent

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.fajri.bangkit_2024_bmaaup.R

class Parcelable : AppCompatActivity() {
    companion object {
        const val EXTRA_PERSON = "extra_person"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable)

        val tvObject: TextView = findViewById(R.id.tv_object_received)

        val person =
            if (Build.VERSION.SDK_INT >= 33) {
                intent.getParcelableExtra(EXTRA_PERSON, Person::class.java)
            } else {
                @Suppress("DEPRECATION")
                intent.getParcelableExtra<Person>(EXTRA_PERSON)
            }

        if (person != null) {
            val text = "Name : ${person.name},\nEmail : ${person.email},\nAge : ${person.age},\nLocation : ${person.city}"
            tvObject.text = text
        }
    }
}