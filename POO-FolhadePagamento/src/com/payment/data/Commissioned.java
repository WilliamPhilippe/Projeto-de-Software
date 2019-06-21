package com.payment.data;

import com.company.Tools;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Commissioned extends Employees {

    private double commissionFee = 0;
    private double sells = 0;

    public Commissioned(){}

    public Commissioned(Scanner input, int employeeNumber){
        super.setName(input);
        super.setType("commissioned");
        super.setSalary();
        setCommissionFee();
        super.setEmployeeStatus(true);
        super.setEmployeeNumber(employeeNumber);
        super.setPaymentPeriod("twoweekly");
        super.setDayOfPayment(6);
        super.setPaymentDelivery("deposit");
        super.setAddress(input);
    }

    public void setCommissionFee(){
        System.out.println("Digite a comissao de vendas do funcionario.\n" +
                "Exemplo: 0,05 para 5% de comissao.");

        setCommissionFee(Tools.readDouble("Ex: 0,05 para 5% de comissao."));
        System.out.println("Comissao definida.");
    }

    public void setCommissionFee(double commissionFee){ this.commissionFee = commissionFee; }

    public void setSells(){
        System.out.println("Digite as vendas deste funcionario.\n" +
                "Exemplo: 1245,12");

        setSells(Tools.readDouble("Ex: 123,12"));
        System.out.println("Vendas definidas.");
    }

    public void setSells(double sells){ this.sells += sells * this.commissionFee; }

    public double getCommissionFee(){ return commissionFee; }

    public double getSells(){ return sells; }

    @Override
    public void runPayment(int day) {
        /* Lembrar de zerar
        * - SyndicateFee
        * - Discount
        * - Vendas
        */

    }
}
