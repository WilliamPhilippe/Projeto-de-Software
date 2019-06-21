package com.payment.data;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Hourly extends Employees {

    private double hourlyFee = 0;
    private double hourPayment = 0;

    public Hourly(Scanner input, int employeeNumber){
        super.setName(input);
        super.setType("hourly");
        setHourlyFee(input);
        super.setEmployeeStatus(true);
        super.setEmployeeNumber(employeeNumber);
        super.setPaymentPeriod("weekly");
        super.setDayOfPayment(6);
        super.setPaymentDelivery("deposit");
        super.setAddress(input);
    }

    public Hourly(){}

    public void setHourlyFee(double fee){
        this.hourlyFee = fee;
    }

    public void setHourlyFee(Scanner input){
        System.out.println("Insira o custo da hora do funcionario.");
        System.out.println("Exemplo:  123,41");
        while (true){
            try {
                this.hourlyFee = input.nextDouble(); input.nextLine();
                System.out.println("Taxa alterada.");
                break;
            }
            catch (InputMismatchException e){
                System.out.println("Formato invalido.");
                System.out.println("Formato aceito: 123,42");
                System.out.println("Tente novamente.");
            }
        }
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
