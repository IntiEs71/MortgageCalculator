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

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

import kotlin.jvm.internal.Intrinsics;

public class SecondActivity extends AppCompatActivity {

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_second);

        // set title
        ActionBar bar = this.getSupportActionBar();
        if (bar != null) {
            bar.setTitle("Amortization Schedule");
            // shows back button
            bar.setDisplayHomeAsUpEnabled(true);
        }

        // set model, view, and controller
        MortgageModel model = new MortgageModel(100000.0D, 0.05D, 10);
        SecondActivity view = new SecondActivity();
        MortgageController controller = new MortgageController(model, view);

        TableLayout table = this.findViewById(R.id.table);

        for( int i = 0; i < 2; i++){

            // set views
            TextView period = new TextView(this);
            TextView principal = new TextView(this);
            TextView interest = new TextView(this);
            TextView monthly = new TextView(this);
            TextView balance = new TextView(this);

            // get row
            ArrayList<String> list = controller.getRow();

            // set row
            TableRow row = new TableRow(this);

            // set text
            period.setText(list.get(0));

            period.setPadding(10, 10, 80, 10);

            row.addView(period);

            table.addView(row, (new android.widget.TableLayout.LayoutParams(-2, -2)));

        }

    }

    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        switch(item.getItemId()) {
            case R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
