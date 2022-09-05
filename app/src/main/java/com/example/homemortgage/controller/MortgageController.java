package com.example.homemortgage.controller;

import com.example.homemortgage.model.MortgageModel;
import com.example.homemortgage.view.MainActivity;

public class MortgageController {

    private MainActivity view;
    private MortgageModel model;

    public MortgageController() {
        model = new MortgageModel(100000, 0.05,10);
    }

    public void getMonthly(){
        double monthly = model.calcMonthlyPmt();
        System.out.println("Period  Principal   Interest    Payment     Balance");


    }


}
