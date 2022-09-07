package com.example.homemortgage.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Create Mortgage Model class and define methods and return calculations
 */
public class MortgageModel {
    // encapsulate main variables
    private int loanPdYrs;
    private double loanRate;
    private double loanAmount;
    private double principal;

    private double principalPmt;
    private double interestPmt;
    private double monthlyPmt;

    private double downPmt;

    /**
     * Default Constructor
     * @param loanAmount
     * double value representing total loan amount
     * @param loanRate
     * double value representing total loan rate
     * @param loanPdYrs
     * int value representing loan period in years
     * @param downPmt
     * double value representing downpayment
     */
    public MortgageModel(double loanAmount, double loanRate, int loanPdYrs, double downPmt){
        this.loanAmount = loanAmount;
        // convert percentage double to decimal
        this.loanRate = loanRate/100;
        this.loanPdYrs = loanPdYrs;
        this.principal = loanAmount;

        this.principalPmt = 0;
        this.interestPmt = 0;
        this.downPmt = downPmt;
        updateWithDownPmt();
    }

    public void updateWithDownPmt(){
        principal -= downPmt;
        loanAmount-= downPmt;
    }
    /**
     * given loan period in years calculate number of monthly payments
     * @return int value of number of payments
     */
    public int calcNumPayments(){
        return loanPdYrs * 12;
    }

    /**
     *  calculate monthly mortgage payment formula
     *
     * @return double value
     */
    public double calcMonthlyPmt(){
        double monthly = (loanRate/12 * principal) /
                ( 1 - ( Math.pow( (1 + loanRate/12), -calcNumPayments() ) ) );
        BigDecimal bd = new BigDecimal(monthly).setScale(2, RoundingMode.HALF_EVEN);
        monthly = bd.doubleValue();
        return monthly;
    }

    /**
     * Setter method for monthly payment
     * @param monthly
     * double value reprenting monthly payment
     */
    public void setMonthlyPmt(double monthly){
        monthlyPmt = monthly;
    }

    /**
     * Getter method for monthly payment
     * @return double value
     */
    public double getMonthlyPmt(){
        return monthlyPmt;
    }

    /**
     * calculate monthly interest
     */
    public void calcMonthlyInterest(){
        interestPmt = loanAmount * loanRate / 12;
        BigDecimal bd = new BigDecimal(interestPmt).setScale(2, RoundingMode.HALF_EVEN);
        interestPmt = bd.doubleValue();
    }

    /**
     * calculate monthly principal
     */
    public void calcMonthlyPrincipal(){
        calcMonthlyInterest();
        principalPmt = calcMonthlyPmt() - interestPmt;
        BigDecimal bd = new BigDecimal(principalPmt).setScale(2, RoundingMode.HALF_EVEN);
        principalPmt = bd.doubleValue();
    }

    /**
     * Getter for interest payment
     * @return double value
     */
    public double getInterestPmt(){
        return interestPmt;
    }

    /**
     * Getter method principal payment
     * @return double value
     */
    public double getPrincipalPmt(){
        return principalPmt;
    }

    /**
     * updates balance by subtracting principal payment ana returning
     * the updated value
     * @return double value
     */
    public double updateBalance(){
        loanAmount -= principalPmt;
        BigDecimal bd = new BigDecimal(loanAmount).setScale(2, RoundingMode.HALF_DOWN);
        loanAmount = bd.doubleValue();
        return  loanAmount;
    }

    /**
     * Getter method for balance
     * @return double value
     */
    public double getBalance(){
        return loanAmount;
    }
}
