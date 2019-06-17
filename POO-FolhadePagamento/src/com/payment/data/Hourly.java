package com.payment.data;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Hourly extends Employees {

    private double hourlyFee = 0;

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

    public void timeCard(){

    }

    @Override
    public void runPayment(int day) {

    }
}
