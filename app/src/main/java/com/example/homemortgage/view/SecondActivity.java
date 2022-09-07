package com.example.homemortgage.view;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.homemortgage.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.homemortgage.controller.MortgageController;
import com.example.homemortgage.model.MortgageModel;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

import kotlin.jvm.internal.Intrinsics;

public class SecondActivity extends AppCompatActivity {

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_second);

        // creates action bar
        ActionBar bar = this.getSupportActionBar();
        if (bar != null) {
            // sets title
            bar.setTitle("Amortization Schedule");
            // enables back button
            bar.setDisplayHomeAsUpEnabled(true);
        }
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#05619F"));

        // Set BackgroundDrawable
        bar.setBackgroundDrawable(colorDrawable);


        double amount2 = 0.00;
        double rate2 = 0.00;

        // receives user input data from MainActivity
        Bundle extras = getIntent().getExtras();
        String amount = extras.getString("loanAmount");
        if (amount.contains(".")) {
            amount2 = Double.parseDouble(amount);
        }
        else {
            amount2 = Integer.parseInt(amount);
        }

        String rate = extras.getString("loanRate");
        if (rate.contains(".")) {
            rate2 = Double.parseDouble(rate);
        }
        else {
            rate2 = Integer.parseInt(rate);
        }

        String pd = extras.getString("loanPdYrs");
        int pd2 = Integer.parseInt(pd);

        double downPayment2 = 0;
        String downPayment = extras.getString("downPmt");
        if (downPayment.contains(".")) {
            downPayment2 = Double.parseDouble(downPayment);
        }
        else {
            downPayment2 = Integer.parseInt(downPayment);
        }

        // set model, view, and controller
        MortgageModel model = new MortgageModel(amount2, rate2, pd2, downPayment2);
        SecondActivity view = new SecondActivity();
        MortgageController controller = new MortgageController(model, view);

        TableLayout table = this.findViewById(R.id.table);

        // get schedule
        ArrayList<String[] > list = controller.getMonthlySchedule();

        System.out.println("Size"+list.size());

        for( int i = 0; i < list.size(); i++){
            // set views
            TextView period = new TextView(this);
            TextView principal = new TextView(this);
            TextView interest = new TextView(this);
            TextView monthly = new TextView(this);
            TextView balance = new TextView(this);

            // set row
            TableRow row = new TableRow(this);

            // set text
            if(i == 0){
                period.setText("Month");
            }
            else{
                period.setText(String.valueOf(i));
            }
            principal.setText(list.get(i)[1]);
            interest.setText(list.get(i)[2]);
            monthly.setText(list.get(i)[3]);
            balance.setText(list.get(i)[4]);

            // set padding
            period.setPadding(10, 10, 40, 10);
            principal.setPadding(10, 10, 40, 10);
            interest.setPadding(10, 10, 40, 10);
            monthly.setPadding(10, 10, 40, 10);
            balance.setPadding(10, 10, 40, 10);

            // changes color of rows
            if (i % 2 == 0) {
                row.setBackgroundColor(Color.parseColor("#e4e8f0"));
            }

            // add views
            row.addView(period);
            row.addView(principal);
            row.addView(interest);
            row.addView(monthly);
            row.addView(balance);

            table.addView(row, (new android.widget.TableLayout.LayoutParams(-2, -2)));

        }

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        switch(item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
