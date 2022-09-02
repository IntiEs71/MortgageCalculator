package com.example.homemortgage.view

import androidx.appcompat.app.AppCompatActivity
import com.example.homemortgage.R
import android.text.TextWatcher
import android.text.Editable

import android.widget.Button
import android.content.Intent
import android.os.Bundle
import android.widget.EditText

/**
 * Inti Espejo
 * James Jang
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // calculate button
        val calc = findViewById<Button>(R.id.calcButton)

        calc.setEnabled(false)
        calc.setClickable(false)

        // input text fields
        val period = findViewById<EditText>(R.id.periodEditText)
        val rate = findViewById<EditText>(R.id.rateEditText)
        val amount = findViewById<EditText>(R.id.amountEditText)
        val principal = findViewById<EditText>(R.id.principalEditText)

        period.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (period.getText().toString().isNotEmpty()
                    && rate.getText().toString().isNotEmpty()
                    && amount.getText().toString().isNotEmpty()
                    && principal.getText().toString().isNotEmpty()) {
                    calc.setEnabled(true)
                    calc.setClickable(true)
                }
                else {
                    calc.setEnabled(false)
                    calc.setClickable(false)
                }
            }
        })

        rate.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (period.getText().toString().isNotEmpty()
                    && rate.getText().toString().isNotEmpty()
                    && amount.getText().toString().isNotEmpty()
                    && principal.getText().toString().isNotEmpty()) {
                    calc.setEnabled(true)
                    calc.setClickable(true)
                }
                else {
                    calc.setEnabled(false)
                    calc.setClickable(false)
                }
            }
        })

        amount.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (period.getText().toString().isNotEmpty()
                    && rate.getText().toString().isNotEmpty()
                    && amount.getText().toString().isNotEmpty()
                    && principal.getText().toString().isNotEmpty()) {
                    calc.setEnabled(true)
                    calc.setClickable(true)
                }
                else {
                    calc.setEnabled(false)
                    calc.setClickable(false)
                }
            }
        })

        principal.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (period.getText().toString().isNotEmpty()
                    && rate.getText().toString().isNotEmpty()
                    && amount.getText().toString().isNotEmpty()
                    && principal.getText().toString().isNotEmpty()) {
                    calc.setEnabled(true)
                    calc.setClickable(true)
                }
                else {
                    calc.setEnabled(false)
                    calc.setClickable(false)
                }
            }
        })

        calc.setOnClickListener {
                val intent = Intent(this, com.example.homemortgage.SecondActivity::class.java)
                startActivity(intent)
        }
    }
}