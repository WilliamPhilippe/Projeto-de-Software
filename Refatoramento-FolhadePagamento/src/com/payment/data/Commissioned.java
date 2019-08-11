package com.payment.data;

import com.company.Tools;

public class Commissioned extends Employees {

    private double commissionFee = 0;
    private double sells = 0;

    public Commissioned(){}

    public Commissioned(int employeeNumber){
        super.setName();
        super.setType("commissioned");
        super.setSalary();
        setCommissionFee();
        super.setEmployeeStatus(true);
        super.setEmployeeNumber(employeeNumber);
        super.setPaymentPeriod("twoweekly");
        super.setDayOfPayment(6);
        super.setPaymentDelivery("deposit");
        super.setAddress();
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

    public void setSells(double sells, int x){ this.sells = sells; }


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

    @Override
    public void runPayment() {
        System.out.println("Processando pagamento de " + super.getName());
        System.out.println("Funcionario comissionado.");

        double pSalary = 0;
        double pDiscount = super.getDiscount() + super.getSyndicateFee();
        double mFee = 0;
        double pSells = this.getSells()*this.commissionFee;

        if( super.getPaymentPeriod().equals("weekly")){
            pSalary = super.getSalary()*0.25;
            mFee += super.getSyndicateMonthlyFee()*0.25;
        }
        if( super.getPaymentPeriod().equals("twoweekly")){
            pSalary = super.getSalary()*0.5;
            mFee += super.getSyndicateMonthlyFee()*0.5;
        }
        if( super.getPaymentPeriod().equals("monthly")){
            pSalary = super.getSalary();
            mFee += super.getSyndicateMonthlyFee();
        }

        System.out.println("Salario bruto: " + pSalary);
        System.out.println("Vendas: " + pSells);
        System.out.println("Discontos: -" + super.getDiscount());
        if(super.getSyndicateIs()) {
            System.out.println("Taxas de servico: -" + super.getSyndicateFee());
            System.out.println("Taxa Mensal do sindicato (proporcional): -" + mFee);
        }
        System.out.println("Recebimentos liquidos: " + (pSalary + pSells - (pDiscount + mFee)) );

        super.printPaymentDelivery();

        System.out.println("Pagamento processado.\n");

        super.nullFee();
        this.sells = 0;

        try { Thread.sleep(1500); }
        catch (InterruptedException e){ e.getMessage(); }
    }
}
