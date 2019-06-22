package com.payment.data;

import com.company.Tools;

public class Hourly extends Employees {

    private double hourlyFee = 0;
    private double hourPayment = 0;

    public Hourly(int employeeNumber){
        super.setName();
        super.setType("hourly");
        setHourlyFee();
        super.setEmployeeStatus(true);
        super.setEmployeeNumber(employeeNumber);
        super.setPaymentPeriod("weekly");
        super.setDayOfPayment(6);
        super.setPaymentDelivery("deposit");
        super.setAddress();
    }

    public Hourly(){}

    public void setHourlyFee(double fee){
        this.hourlyFee = fee;
    }

    public void setHourlyFee(){
        System.out.println("Insira o custo da hora do funcionario.");
        System.out.println("Exemplo:  123,41");

        setHourlyFee( Tools.readDouble("Ex: 123,56") );
        System.out.println("Taxa alterada.");
    }

    public void setHourPayment(double hours){
        if (hours <= 8){
            this.hourPayment += hours * this.hourlyFee;
        }
        else{
            this.hourPayment += (8 * this.hourlyFee) + (hours - 8.0)*this.hourlyFee*1.5;
        }
    }

    public double getHourlyFee(){ return hourlyFee; }

    public double getHourPayment(){ return hourPayment; }

    @Override
    public void runPayment(int day) {
        /* Lembrar de zerar
         * - SyndicateFee
         * - Discount
         * - Horas trabalhadas
        */
    }
}
