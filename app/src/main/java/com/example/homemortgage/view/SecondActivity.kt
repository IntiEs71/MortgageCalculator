package com.example.homemortgage.view

import android.app.ActionBar.LayoutParams
import android.os.Bundle
import android.view.MenuItem
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.homemortgage.R


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var bar = getSupportActionBar()

        if (bar != null) {
            bar.setTitle("Amortization Schedule")
            // shows back button
            bar.setDisplayHomeAsUpEnabled(true)
        }

        var months = ArrayList<String>()
        months.add("Month")
        months.add("1")

        val table = findViewById<TableLayout>(R.id.table)

        for (i in months.indices) {
            var row = TableRow(this)
            val t = TextView(this)
            val t2 = TextView(this)

            t.setText(months[i].toString())
            t2.setText(months[i].toString())

            t.setPadding(10, 10, 80, 10)
            t2.setPadding(10, 10, 80, 10)

            row.addView(t)
            row.addView(t2)

            table.addView(row, TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT))
        }

        //table.addView(headers, TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT))
    }

    // makes back button go back to first screen
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}