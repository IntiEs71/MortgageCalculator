package com.example.homemortgage.model;

// Create Mortgage Model class and define methods and return calculations
public class MortgageModel {
    // encapsulate main variables
    private int loanPd;
    private double loanRate;
    private double loanAmount;
    private double principalPaid;

    // Default Constructor
    public MortgageModel(int loanPd, double loanRate,
                         double loanAmount, double principalPaid){
        this.loanPd = loanPd;
        this.loanRate = loanRate;
        this.loanAmount = loanAmount;
        this.principalPaid = principalPaid;
    }

    // calculate monthly mortgage payment formula
    // M = P ( r ( 1 + r ) ^ n ) / ( ( 1 + r ^ n ) - 1 )
    // M: total monthly mortgage payment
    // P: the principal loan amount
    // r: your monthly interest rate
    // n: number of payments over the loan's lifetime, months * years
    public double getMortgagePayment(double mortgage, double principal,
                                  double rate, int numPayments){
        double monthly = 0;
        monthly = principal * (rate * Math.pow((1 + rate), numPayments) )
        / ( Math.pow((1 + rate), numPayments) - 1);

        return monthly;
    }





}
