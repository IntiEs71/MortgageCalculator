package com.example.homemortgage.view

import android.annotation.SuppressLint
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
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // calculate button
        val calc = findViewById<Button>(R.id.button)

        // input text fields
        val period = findViewById<Button>(R.id.editTextNumber2)
        val rate = findViewById<Button>(R.id.editTextNumber3)
        val amount = findViewById<Button>(R.id.editTextNumber4)
        val principal = findViewById<Button>(R.id.editTextNumber5)

        val period2 = period.text.toString().toIntOrNull()
        val rate2 = rate.text.toString().toIntOrNull()
        val amount2 = amount.text.toString().toIntOrNull()
        val principal2 = principal.text.toString().toIntOrNull()

        if (period2 != null) {
            calc.setOnClickListener {
                val intent = Intent(this, com.example.homemortgage.SecondActivity::class.java)
                startActivity(intent)
            }
        }
        else {
            // NOT A NUMBER
            System.out.println("Please enter a valid number");
        }

        if (rate2 != null) {
            calc.setOnClickListener {
                val intent = Intent(this, com.example.homemortgage.SecondActivity::class.java)
                startActivity(intent)
            }
        }
        else {
            // NOT A NUMBER
            System.out.println("Please enter a valid number");
        }

        if (amount2 != null) {
            calc.setOnClickListener {
                val intent = Intent(this, com.example.homemortgage.SecondActivity::class.java)
                startActivity(intent)
            }
        }
        else {
            // NOT A NUMBER
            System.out.println("Please enter a valid number");
        }

        if (principal2 != null) {
            calc.setOnClickListener {
                val intent = Intent(this, com.example.homemortgage.SecondActivity::class.java)
                startActivity(intent)
            }
        }
        else {
            // NOT A NUMBER
            System.out.println("Please enter a valid number");
        }
    }
}