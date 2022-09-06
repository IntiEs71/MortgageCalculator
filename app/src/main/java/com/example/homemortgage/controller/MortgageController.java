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

    public void getMonthly(){

        System.out.println("Period  Principal   Interest    Payment     Balance");
    }

    public ArrayList<String> getRow(){

        ArrayList<String> valuesList = new ArrayList<String>();

        int pdLength = model.calcNumPayments();

        double monthlyPmt = model.calcMonthlyPmt();

        // calculations
        model.calcMonthlyInterest();
        model.calcMonthlyPrincipal();

        double monthlyInterest = model.getInterestPmt();
        double monthlyPrincipal = model.getPrincipalPmt();

        double balance = model.updateBalance();

        //for(int i = 1; i <= pdLength; i++){

            // add values to list
            valuesList.add( Integer.toString(pdLength) );
            valuesList.add( Double.toString(monthlyPrincipal) );
            valuesList.add( Double.toString(monthlyInterest) );
            valuesList.add( Double.toString(monthlyPmt) );
            valuesList.add( Double.toString(model.updateBalance()) );

            // call view method to add list
            return valuesList;

            //}



    }


}
