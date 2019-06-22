package com.payment.data;

public class Salaried extends Employees {

    public Salaried(int employeeNumber){
        super.setName();
        super.setType("salaried");
        super.setSalary();
        super.setEmployeeStatus(true);
        super.setEmployeeNumber(employeeNumber);
        super.setPaymentPeriod("monthly");
        super.setDayOfPayment(0);
        super.setPaymentDelivery("deposit");
        super.setAddress();
    }

    public Salaried(){}

    @Override
    public void runPayment(int day) {

    }
}
