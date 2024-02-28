package com.fajri.bangkit_2024_bmaaup.Intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.fajri.bangkit_2024_bmaaup.R

class IntentMain : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvResult: TextView
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == NilaiBalikIntent.RESULT_CODE && result.data != null) {
            val selectedValue = result.data?.getIntExtra(NilaiBalikIntent.EXTRA_SELECTED_VALUE, 0)
            tvResult.text = "Hasil : $selectedValue"
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intent_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        val btnMoveWithObject: Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)

        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        val btnMoveForResult: Button = findViewById(R.id.btn_move_for_result)
        btnMoveForResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@IntentMain, ExplicitIntent::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_data -> {
                val moveWithDataIntent = Intent(this, IntentMengirimData::class.java)
                moveWithDataIntent.putExtra(IntentMengirimData.EXTRA_NAME, "DicodingAcademy Boy")
                moveWithDataIntent.putExtra(IntentMengirimData.EXTRA_AGE, 5)
                startActivity(moveWithDataIntent)
            }
            R.id.btn_move_activity_object -> {
                val person = Person(
                    "DicodingAcademy",
                    5,
                    "academy@dicoding.com",
                    "Bandung"
                )

                val moveWithObjectIntent = Intent(this, Parcelable::class.java)
                moveWithObjectIntent.putExtra(Parcelable.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }
            R.id.btn_dial_number -> {
                val phoneNumber = "081210841382"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.btn_move_for_result -> {
                val moveForResultIntent = Intent(this, NilaiBalikIntent::class.java)
                resultLauncher.launch(moveForResultIntent)
            }
        }
    }
}