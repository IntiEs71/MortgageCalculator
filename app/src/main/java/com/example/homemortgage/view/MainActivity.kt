package com.example.homemortgage.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homemortgage.R
import android.widget.Button
import android.content.Intent

/**
 * Inti Espejo
 * James Jang
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calc = findViewById<Button>(R.id.button)

        val period = editText123.text.toString().toIntOrNull()
        val rate = editText123.text.toString().toIntOrNull()
        val amount = editText123.text.toString().toIntOrNull()
        val principal = editText123.text.toString().toIntOrNull()

        val isInteger = period != null

        calc.setOnClickListener {
            val intent = Intent(this, com.example.homemortgage.SecondActivity::class.java)
            startActivity(intent)
        }
    }
}