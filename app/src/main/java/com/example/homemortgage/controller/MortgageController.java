package com.example.homemortgage.controller;

import com.example.homemortgage.model.MortgageModel;
import com.example.homemortgage.view.SecondActivity;

import java.util.ArrayList;

public class MortgageController {

    private SecondActivity view;
    private MortgageModel model;

    public MortgageController() {
        model = new MortgageModel(100000, 0.05,10);
        view = new SecondActivity();
    }

    public void getMonthly(){
        double monthly = model.calcMonthlyPmt();
        System.out.println("Period  Principal   Interest    Payment     Balance");
    }

    public void getValuesByRow(){

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
            view.addToTable(valuesList);
        //}



    }


}
