package com.payment.data;

import com.company.Tools;

public class Hourly extends Employees {



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
        this.percentSalary = fee;
    }

    public void setHourlyFee(){
        System.out.println("Insira o custo da hora do funcionario.");
        System.out.println("Exemplo:  123,41");

        setHourlyFee( Tools.readDouble("Ex: 123,56") );
        System.out.println("Taxa alterada.");
    }

    public void setHourPayment(double hours){
        if (hours <= 8){
            this.salary += hours * this.percentSalary;
        }
        else{
            this.salary += (8 * this.percentSalary) + (hours - 8.0)*this.percentSalary *1.5;
        }
    }

    public void setHourPayment(double hours, int x){ this.salary = hours; }

    public double getHourlyFee(){ return percentSalary; }

    public double getHourPayment(){ return salary; }

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

        System.out.println("Salario bruto por horas trabalhadas: " + this.salary);
        System.out.println("Discontos: -" + super.getDiscount());
        if(super.getSyndicateIs()) {
            System.out.println("Taxas de servico: -" + super.getSyndicateFee());
            System.out.println("Taxa Mensal do sindicato (proporcional): -" + mFee);
        }
        System.out.println("Recebimentos liquidos: " + (this.salary - (pDiscount + mFee)) );

        super.printPaymentDelivery();

        System.out.println("Pagamento processado.\n");

        super.nullFee();
        this.salary = 0;

        try { Thread.sleep(1500); }
        catch (InterruptedException e){ e.getMessage(); }
    }

    public void setOwnCopy(Employees employee){
        this.setHourlyFee(((Hourly) employee).getHourlyFee());
        this.setHourPayment( ((Hourly) employee).getHourPayment(), 1 );
    }

    public Employees getNovoOfClass() { return new Hourly();}

}
