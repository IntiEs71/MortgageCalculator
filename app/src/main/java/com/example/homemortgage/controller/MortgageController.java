package com.example.homemortgage.controller;

import com.example.homemortgage.model.MortgageModel;
import com.example.homemortgage.view.SecondActivity;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Controller class contains view and model and getter for schedule
 */
public class MortgageController {

    private MortgageModel model;
    private SecondActivity view;

    /**
     * Default Constructor
     * @param model
     * MortgageModel object
     * @param view
     * SecondActivity object
     */
    public MortgageController(MortgageModel model, SecondActivity view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Getter for monthly schedule
     * @return an ArrayList of String arrays containing values that is called in view
     */
    public ArrayList<String[] > getMonthlySchedule() {

        ArrayList<String[]> valuesList = new ArrayList<String[]>();

        int pdLength = model.calcNumPayments();

        String[] headers = {"Month", "Principal", "Interest", "Total Paid", "Balance"};
        valuesList.add(headers);

        DecimalFormat df = new DecimalFormat("0.00");

        for (int i = 0; i < pdLength; i++) {

            double monthlyPmt = model.calcMonthlyPmt();

            // calculations
            model.calcMonthlyInterest();
            model.calcMonthlyPrincipal();

            double monthlyInterest = model.getInterestPmt();
            double monthlyPrincipal = model.getPrincipalPmt();
            double balance = 0;

            if(i == pdLength-1){
                monthlyPrincipal = model.getBalance() - model.getInterestPmt();
                monthlyPmt = monthlyInterest + monthlyPrincipal;
            }
            else {
                balance = model.updateBalance();
            }

            // add values to array
            String[] values = {df.format(pdLength),
                    "$"+df.format(monthlyPrincipal),
                    "$"+df.format(monthlyInterest),
                    "$"+df.format(monthlyPmt),
                    "$"+df.format(balance)
            };
            // add array to list
            valuesList.add(values);
        }
        // return list of arrays
        return valuesList;
    }
}
