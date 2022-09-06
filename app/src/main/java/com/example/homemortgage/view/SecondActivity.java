package com.example.homemortgage.view;

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

        // receives user input data from MainActivity
        Bundle extras = getIntent().getExtras();
        String amount = extras.getString("amount");



        // set model, view, and controller
        MortgageModel model = new MortgageModel(amount, 0.05D, 10);
        SecondActivity view = new SecondActivity();
        MortgageController controller = new MortgageController(model, view);

        TableLayout table = this.findViewById(R.id.table);

        // get schedule
        ArrayList<String[] > list = controller.getMonthlySchedule();

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
            period.setText(list.get(i)[0]);
            principal.setText(list.get(i)[1]);
            interest.setText(list.get(i)[2]);
            monthly.setText(list.get(i)[3]);
            balance.setText(list.get(i)[4]);

            // set padding
            period.setPadding(10, 10, 50, 10);
            principal.setPadding(10, 10, 50, 10);
            interest.setPadding(10, 10, 50, 10);
            monthly.setPadding(10, 10, 50, 10);
            balance.setPadding(10, 10, 50, 10);

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