package com.company;

import java.util.Scanner;

public class Hourly implements Employees {

    private int employeeNumber;
    private String name;
    private String type = "hourly";                      // salaried or hourly or commissioned

    // SYNDICATE
    private int syndicateNumber;
    private boolean syndicateIs = false;
    private double syndicateFee = 0;
    private double sydicateMonthlyFee = 0;

    // PAYMENT
    private String paymentMethod = "monthly";           // monthly - weekly - twoweekly
    private int dayOfPayment = 5;                       // se for 0, eh o ultimo dia do mes | seg 1 sex 5
    private double salaryWeekly = 0;
    private double hourFee = 0;

    // ADDRESS
    private String addressStreet;
    private int addressNumber;
    private String addressCity;
    private String addressState;
    public String addressCountry;

    private Scanner input = new Scanner(System.in);


    public int getEmployeeNumber() {
        return 0;
    }

    public String getName() {
        return null;
    }

    public void getAddress() {

    }

    public String getType() {
        return null;
    }

    public int getSyndicateNumber() {
        return 0;
    }

    public boolean getSyndicateIs() {
        return false;
    }

    public void setName(String name) {

    }

    public void setAddress() {

    }

    public void setType(String type) {

    }

    public void setEmployeeNumber(int employeeNumber) {

    }

    public void setPaymentMethod() {

    }

    public void setSyndicateNumber(int number) {

    }

    public void setSyndicateIs(boolean is) {

    }

    public void setSyndicateFee(double fee) {

    }

    public void setSyndicateMonthlyFee(double fee) {

    }

    public void setDiscout(int discout) {

    }

    public void processPayment() {

    }
}
