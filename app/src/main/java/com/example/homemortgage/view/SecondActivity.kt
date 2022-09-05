package com.example.homemortgage.view

import android.app.ActionBar.LayoutParams
import android.os.Bundle
import android.view.MenuItem
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.homemortgage.R
import com.example.homemortgage.controller.MortgageController


class SecondActivity : AppCompatActivity() {

    lateinit var table: TableLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)




        var bar = getSupportActionBar()

        if (bar != null) {
            bar.setTitle("Amortization Schedule")
            // shows back button
            bar.setDisplayHomeAsUpEnabled(true)
        }

        table = findViewById<TableLayout>(R.id.table)

        val controller = MortgageController()
        //
        controller.getValuesByRow()

    }

    fun addToTable(list: ArrayList<String>): Void? {

        //var headers = TableRow(this)
        // text views for headers
        //val tv1 = TextView(this)
        //val tv2 = TextView(this)
        //val tv3 = TextView(this)
        //val tv4 = TextView(this)
        //val tv5 = TextView(this)

            var row = TableRow(this)

            val pd = TextView(this)
            val principal = TextView(this)
            val interest = TextView(this)
            val monthly = TextView(this)
            val balance = TextView(this)

            pd.setText(list[0])
            //principal.setText(list[1].toString())
            //interest.setText(list[2].toString())
            //monthly.setText(list[3].toString())
            //balance.setText(list[4].toString())

            pd.setPadding(10, 10, 80, 10)
            //principal.setPadding(10, 10, 80, 10)
            //interest.setPadding(10, 10, 80, 10)
            //monthly.setPadding(10, 10, 80, 10)
            //balance.setPadding(10, 10, 80, 10)

            row.addView(pd)
            //row.addView(principal)
            //row.addView(interest)
            //row.addView(monthly)
            //row.addView(balance)

            table.addView(row, TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT))



        return null
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