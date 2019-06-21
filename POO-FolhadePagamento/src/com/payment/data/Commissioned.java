package com.payment.data;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Commissioned extends Employees {

    private double commissionFee = 0;
    private double sells = 0;

    public Commissioned(){}

    public Commissioned(Scanner input, int employeeNumber){
        super.setName(input);
        super.setType("commissioned");
        super.setSalary(input);
        setCommissionFee(input);
        super.setEmployeeStatus(true);
        super.setEmployeeNumber(employeeNumber);
        super.setPaymentPeriod("twoweekly");
        super.setDayOfPayment(6);
        super.setPaymentDelivery("deposit");
        super.setAddress(input);
    }

    public void setCommissionFee(Scanner input){
        System.out.println("Digite a comissao de vendas do funcionario.\n" +
                "Exemplo: 0,05 para 5% de comissao.");

        while (true) {
            try {
                setCommissionFee(input.nextDouble());
                input.nextLine();
                System.out.println("Comissao definida.");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida. Tente novamente. Ex: 0,01 para 1%");
            }
        }
    }

    public void setCommissionFee(double commissionFee){ this.commissionFee = commissionFee; }

    public void setSells(Scanner input){
        System.out.println("Digite as vendas deste funcionario.\n" +
                "Exemplo: 1245,12");

        while (true){
            try {
                setSells(input.nextDouble()); input.nextLine();
                System.out.println("Vendas definidas.");
                break;
            }
            catch (InputMismatchException e){
                System.out.println("Entrada invalida. Tente novamente. Ex: 123,12");
            }
        }
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
