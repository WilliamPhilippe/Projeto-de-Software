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

    @Override
    public void runPayment() {
        System.out.println("Processando pagamento de " + super.getName());
        System.out.println("Funcionario assalariado.");

        double pSalary = 0;
        double pDiscount = super.getDiscount() + super.getSyndicateFee();
        double mFee = 0;

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
        System.out.println("Discontos: -" + super.getDiscount());
        if(super.getSyndicateIs()) {
            System.out.println("Taxas de servico: -" + super.getSyndicateFee());
            System.out.println("Taxa Mensal do sindicato (proporcional metade): -" + mFee);
        }
        System.out.println("Recebimentos liquidos: " + (pSalary - (pDiscount + mFee)) );
        System.out.println("Pagamento processado.");

        super.nullFee();

        try { Thread.sleep(1500); }
        catch (InterruptedException e){ e.getMessage(); }
    }
}
