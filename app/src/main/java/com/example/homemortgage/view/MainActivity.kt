package com.example.homemortgage.view

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.homemortgage.R


/**
 * Inti Espejo
 * James Jang
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bar = getSupportActionBar()

        if (bar != null) {
            bar.setTitle("Mortgage Calculator")
        }

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        val colorDrawable = ColorDrawable(Color.parseColor("#05619F"))

        // Set BackgroundDrawable
        bar!!.setBackgroundDrawable(colorDrawable)


        // calculate button
        val calc = findViewById<Button>(R.id.calcButton)

        calc.setEnabled(false)
        calc.setClickable(false)

        // input text fields
        val period = findViewById<EditText>(R.id.periodEditText)
        val rate = findViewById<EditText>(R.id.rateEditText)
        val amount = findViewById<EditText>(R.id.amountEditText)
        val principal = findViewById<EditText>(R.id.principalEditText)

        // sends user input data to second activity
        //val intent = Intent(this, SecondActivity::class.java)
        //intent.putExtra("amount")
        //startActivity(intent)
        //var intent = Intent(this, SecondActivity::class.java)
        //var model = MortgageModel(100.0, 2.0, 2);
        //intent.putExtra("MortgageModel", model)
        //intent.putExtra("MortgageModel", model)

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
                val intent = Intent(this, SecondActivity::class.java)

                // sends user input data to second activity
                //val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("loanAmount", amount.getText().toString())
                intent.putExtra("loanRate", rate.getText().toString())
                intent.putExtra("loanPdYrs", period.getText().toString())

                startActivity(intent)
        }
    }
}