package com.payment.data;

import com.company.Edit;
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

    @Override
    public void runPayment() {
        System.out.println("Processando pagamento de " + super.getName());
        System.out.println("Funcionario horista.");

        double pDiscount = super.getDiscount() + super.getSyndicateFee();
        double mFee = 0;

        if( super.getPaymentPeriod().equals("weekly")){
            mFee += super.getSyndicateMonthlyFee()*0.25;
        }
        if( super.getPaymentPeriod().equals("twoweekly")){
            mFee += super.getSyndicateMonthlyFee()*0.5;
        }
        if( super.getPaymentPeriod().equals("monthly")){
            mFee += super.getSyndicateMonthlyFee();
        }

        System.out.println("Salario bruto por horas trabalhadas: " + this.hourPayment);
        System.out.println("Discontos: -" + super.getDiscount());
        if(super.getSyndicateIs()) {
            System.out.println("Taxas de servico: -" + super.getSyndicateFee());
            System.out.println("Taxa Mensal do sindicato (proporcional): -" + mFee);
        }
        System.out.println("Recebimentos liquidos: " + (this.hourPayment - (pDiscount + mFee)) );
        System.out.println("Pagamento processado.");

        super.nullFee();
        this.hourPayment = 0;

        try { Thread.sleep(1500); }
        catch (InterruptedException e){ e.getMessage(); }
    }
}
