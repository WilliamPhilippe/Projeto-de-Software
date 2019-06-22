package com.payment.data;

import com.company.Tools;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Employees {

    //employee's data
    private int employeeNumber = 0;
    private String name = null;
    private String type = null;                // salaried or hourly or commissioned
    private boolean employeeStatus = false;

    //syndicate data
    private int syndicateNumber = 0;
    private boolean syndicateIs = false;
    private double syndicateFee = 0;
    private double syndicateMonthlyFee = 0;

    //payment data
    private String paymentPeriod = null;       // monthly - weekly - twoweekly
    private int dayOfPayment = 0;              // monthly last day "0", dom 1 sab 7
    private double salary = 0;
    private double discount = 0;
    private String paymentDelivery = null;     // hands, mail, doposit

    //address
    private int addressNumber = 0;
    private String addressStreet = null;
    private String addressCity = null;
    private String addressState = null;

    public String getName(){ return name; }

    public String getType(){ return type; }

    public int getEmployeeNumber(){ return employeeNumber; }

    public boolean getEmployeeStatus(){ return employeeStatus; }

    public int getSyndicateNumber(){ return syndicateNumber; }

    public boolean getSyndicateIs(){ return syndicateIs; }

    public double getSyndicateFee(){ return syndicateFee; }

    public double getSyndicateMonthlyFee(){ return syndicateMonthlyFee; }

    public String getPaymentPeriod(){ return paymentPeriod; }

    public int getDayOfPayment(){ return dayOfPayment; }

    public double getSalary(){ return salary; }

    public double getDiscount(){ return discount; }

    public String getPaymentDelivery(){ return paymentDelivery; }

    public void getAddress(){
        System.out.println("Rua: " + addressStreet);
        System.out.println("Numero: " + addressNumber);
        System.out.println(addressCity + " | " + addressState);
    }

    public void setName(Scanner input){
        System.out.println("Digite o nome do funcionario.");
        this.name = input.nextLine();
        System.out.println("Nome modificado.");
    }

    public void setName(String name){ this.name = name; }

    public void setType(String type){ this.type = type; }

    public void setEmployeeStatus(boolean status){ this.employeeStatus = status; }

    public void setEmployeeNumber(int number){ this.employeeNumber = number; }

    public void setSyndicateNumber(int number){ this.syndicateNumber = number; }

    public void setSyndicateIs(boolean is){ this.syndicateIs = is; }

    public void setSyndicateFee(double fee){ this.syndicateFee += fee; }

    public void setSyndicateMonthlyFee(double fee){ this.syndicateMonthlyFee = fee; }

    public void setPaymentPeriod(String period){ this.paymentPeriod = period; }

    public void setDayOfPayment(int day){ this.dayOfPayment = day; }

    public void setSalary(double salary) { this.salary = salary; }

    public void setSalary(){
        System.out.println("Digite o salario mensal do funcionario.\n" +
                "Exemplo: 1235,67");

        setSalary(Tools.readDouble("Ex: 123,56"));
        System.out.println("Salario definido.");
    }

    public void setDiscount(double discount){ this.discount += discount; }

    public void setPaymentDelivery(String delivery){ this.paymentDelivery = delivery; }

    public void setAddress(Scanner input){
        System.out.println("Definir endereço: ");

        System.out.println("Numero: ");
        this.addressNumber = Tools.readInteger("O numero precisa ser um inteiro.");

        System.out.println("Digite o nome da rua: ");
        this.addressStreet = input.nextLine();

        System.out.println("Digite a cidade: ");
        this.addressCity = input.nextLine();

        System.out.println("Digite o estado: ");
        this.addressState = input.nextLine();
    }

    public String toString(){
        return "Nome: " + this.getName() + "\nNumero: " + this.getEmployeeNumber();
    }

    public abstract void runPayment(int day);

}
