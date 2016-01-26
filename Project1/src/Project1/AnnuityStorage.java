/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project1;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Class: AnnuityStorage
 * File: AnnuityStorage.java 
 * Description: Stores and calculates annuity data
 *
 * @author: Kevin Manning
 * Environment: PC, Windows 10, jdk8.0, NetBeans 8.1
 * Date: 1/25/2016
 * @version 1.0 History Log: 1/25/16 - Built base class structure
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class AnnuityStorage
{

    //Declarations for class variables
    private double dblPayment;
    private double dblRate;
    private int intN;
    private int intYears;
    private double dblBalance;
    private double dblTotal;
    private double dblInterest;

    //Constructor for class, fills and calculates all values in class
    public AnnuityStorage(double dblPayment, double dblRate, int intN, int intYears)
    {
        final short PERCENT = 100;
        this.dblPayment = dblPayment;
        this.dblRate = dblRate / PERCENT;
        this.intN = intN;
        this.intYears = intYears;

        setDblBalance();
        setDblTotal();
        setDblInterest();
    }

    //Default constructor to prevent null instantiation
    public AnnuityStorage()
    {
        this.dblPayment = 0.0;
        this.dblRate = 0.0;
        this.intN = 0;
        this.intYears = 0;

        setDblBalance();
        setDblTotal();
        setDblInterest();
    }

    //Calcualtes the balance after a given time
    private void setDblBalance()
    {
        final short BASE_VALUE = 1;
        double dblPeriodicRate = dblRate / intN;
        this.dblBalance = dblPayment
                * ((Math.pow((BASE_VALUE + dblPeriodicRate), (intN * intYears))
                - BASE_VALUE) / dblPeriodicRate);
    }

    //Calculates how much was made in base payments
    private void setDblTotal()
    {
        this.dblTotal = dblPayment * intN * intYears;
    }

    //Calculates the interest earned
    private void setDblInterest()
    {
        this.dblInterest = dblBalance - dblTotal;
    }

    //Generic Getters from this point forward
    public double getDblPayment()
    {
        return dblPayment;
    }

    public double getDblRate()
    {
        return dblRate;
    }

    public int getIntN()
    {
        return intN;
    }

    public int getIntYears()
    {
        return intYears;
    }

    public double getDblBalance()
    {
        return dblBalance;
    }

    public double getDblTotal()
    {
        return dblTotal;
    }

    public double getDblInterest()
    {
        return dblInterest;
    }

}//end class
