package com.company;

import java.util.Scanner;

public class Salaried implements Employees {

    private int employeeNumber;
    private String name;
    private String address;
    private String type;
    private int syndicateNumber;
    private boolean syndicateIs;

    // PAYMENT
    private String paymentMethod;           // monthly - weekly - twoweekly
    private int dayOfPayment;               // se for 0, eh o ultimo dia do mes | seg 1 sex 5
    private int salaryMonthly;

    public Salaried() {
    }

    public int getEmployeeNumber() {
        return this.employeeNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getType() {
        return this.type;
    }

    public int getSyndicateNumber() {
        return this.syndicateNumber;
    }

    public boolean getSyndicateIs() {
        return this.syndicateIs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public void setPaymentMethod() {
        System.out.println("Você quer receber:");
        System.out.println("1 - Mensalmente.");
        System.out.println("2 - Semanalmente.");
        System.out.println("3 - Bi-semanalmente.");

        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        switch (option){
            case 1:
                System.out.println("Em que dia do mes quer receber?");
                System.out.println("Digite 0 para ultimo dia do mes.");
                this.dayOfPayment = input.nextInt();
                paymentMethod = "monthly";
                break;
            case 2:
                System.out.println("Em que dia da semana quer receber?");
                System.out.println("1-Seg | 2-Ter | 3-Qua | 4-Qui | 5-Sex");
                this.dayOfPayment = input.nextInt();
                paymentMethod = "weekly";
                break;
            case 3:
                System.out.println("Em que dia da semana quer receber?");
                System.out.println("1-Seg | 2-Ter | 3-Qua | 4-Qui | 5-Sex");
                this.dayOfPayment = input.nextInt();
                paymentMethod = "twoweekly";
                break;
            default:
                System.out.println("Opcao invalida.");
        }

        System.out.println("Agenda de pagamento alterada.");
    }

    public void setSyndicateNumber(int number) {

    }

    public void setSyndicateIs(boolean is) {

    }

    public void setSyndicateFee(int fee) {

    }

    public void setDiscout(int discout) {

    }

    public void removeEmployee(int employeeNumber) {

    }

    public void processPayment() {

    }
}
