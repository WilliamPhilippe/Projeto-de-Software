package com.payment.data;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Salaried extends Employees {

    public Salaried(Scanner input, int employeeNumber){
        super.setName(input);
        super.setType("salaried");
        super.setSalary();
        super.setEmployeeStatus(true);
        super.setEmployeeNumber(employeeNumber);
        super.setPaymentPeriod("monthly");
        super.setDayOfPayment(0);
        super.setPaymentDelivery("deposit");
        super.setAddress(input);
    }

    public Salaried(){}

    @Override
    public void runPayment(int day) {

    }
}
