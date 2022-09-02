package com.example.homemortgage.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.homemortgage.R
import android.text.TextWatcher
import android.text.Editable


/**
 * Inti Espejo
 * James Jang
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // calculate button
        val calc = findViewById<Button>(R.id.button)

        calc.setEnabled(false)
        calc.setClickable(false)

        // input text fields
        val period = findViewById<EditText>(R.id.editTextNumber2)
        val rate = findViewById<EditText>(R.id.editTextNumber3)
        val amount = findViewById<EditText>(R.id.editTextNumber4)
        val principal = findViewById<EditText>(R.id.editTextNumber5)

        //period.getText().toString().isEmpty()
        //TextUtils.isEmpty(period.getText().toString())

        //Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show()

        period.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        if (period.getText().toString() == "") {
            calc.setEnabled(false)
            calc.setClickable(false)
        }
        else if (rate.getText().toString() == "") {
            calc.setEnabled(false)
            calc.setClickable(false)
        }
        else if (amount.getText().toString() == "") {
            calc.setEnabled(false)
            calc.setClickable(false)
        }
        else if (principal.getText().toString() == "") {
            calc.setEnabled(false)
            calc.setClickable(false)
        }
        else {
            // All number fields have been entered
            calc.setEnabled(true)
            calc.setClickable(true)

            calc.setOnClickListener {
                val intent = Intent(this, com.example.homemortgage.SecondActivity::class.java)
                startActivity(intent)
            }
        }
    }
}