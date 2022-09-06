package com.example.homemortgage.controller;

import com.example.homemortgage.model.MortgageModel;
import com.example.homemortgage.view.SecondActivity;

import java.util.ArrayList;

public class MortgageController {

    private MortgageModel model;
    private SecondActivity view;

    public MortgageController(MortgageModel model, SecondActivity view) {
        this.model = model;
        this.view = view;
    }


    public ArrayList<String[] > getMonthlySchedule() {

        ArrayList<String[]> valuesList = new ArrayList<String[]>();

        int pdLength = model.calcNumPayments();

        String[] headers = {"Month", "Principal", "Interest", "Total Paid", "Balance"};
        valuesList.add(headers);

        for (int i = 1; i <= pdLength; i++) {

            double monthlyPmt = model.calcMonthlyPmt();

            // calculations
            model.calcMonthlyInterest();
            model.calcMonthlyPrincipal();

            double monthlyInterest = model.getInterestPmt();
            double monthlyPrincipal = model.getPrincipalPmt();

            double balance = model.updateBalance();

            // add values to array
            String[] values = {Integer.toString(pdLength),
                    Double.toString(monthlyPrincipal),
                    Double.toString(monthlyInterest),
                    Double.toString(monthlyPmt),
                    Double.toString(balance)
            };
            // add array to list
            valuesList.add(values);
        }
        // return list of arrays
        return valuesList;
    }
}
