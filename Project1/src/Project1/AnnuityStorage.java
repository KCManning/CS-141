/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project1;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class: AnnuityStorage
* File: AnnuityStorage.java
* Description: Stores and calculates annuity data
* @author: Kevin Manning
* Environment: PC, Windows 10, jdk8.0, NetBeans 8.1
* Date: 1/25/2016
* @version 1.0
* History Log: 1/25/16 - Built base class structure
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class AnnuityStorage
{
    private double dblPayment;
    private int dblRate;
    private int intN;
    private int intYears;
    private double dblBalance;
    private double dblTotal;
    private double dblInterest;

    public AnnuityStorage(double dblPayment, int dblRate, int intN, int intYears)
    {
        this.dblPayment = dblPayment;
        this.dblRate = dblRate;
        this.intN = intN;
        this.intYears = intYears;
    }

    
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

    
    
    }
