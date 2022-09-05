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
        val headers = TableRow(this)

        for (i in months.indices) {
            val t = TextView(this)
            t.setText("uno")
            table.addView(t)
        }

        table.addView(headers, TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT))
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