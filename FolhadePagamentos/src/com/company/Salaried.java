package com.company;

import java.util.Scanner;

public class Salaried implements Employees {

    private int employeeNumber;
    private String name;
    private String type;

    // SYNDICATE
    private int syndicateNumber;
    private boolean syndicateIs;
    private double syndicateFee;

    // PAYMENT
    private String paymentMethod;           // monthly - weekly - twoweekly
    private int dayOfPayment;               // se for 0, eh o ultimo dia do mes | seg 1 sex 5
    private double salaryMonthly;

    // ADDRESS
    private String addressStreet;
    private int addressNumber;
    private String addressCity;
    private String addressState;

    public Salaried() {
    }

    public int getEmployeeNumber() {
        return this.employeeNumber;
    }

    public String getName() {
        return this.name;
    }

    public void getAddress() {
        System.out.println("Rua: " + this.addressStreet);
        System.out.println("Numero: " + this.addressNumber);
        System.out.println(this.addressCity + " / " + this.addressState);
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
        this.syndicateNumber = number;
    }

    public void setSyndicateIs(boolean is) {
        this.syndicateIs = is;
    }

    public void setSyndicateFee(double fee) {

        if(syndicateIs) {
            System.out.println("A taxa sindical atual eh de R$ " + this.syndicateFee + "a cada pagamento.");
            System.out.println("Digite a nova taxa sindical.");
            Scanner input = new Scanner(System.in);
            this.syndicateFee = input.nextInt();
            System.out.println("A taxa sindical foi alterada.");
        }
        else{
            System.out.println("O empregado nao pertence a um sindicato. Cadastre-o para adicionar uma taxa.");
        }

    }

    public void setDiscout(int discout) {

    }

    public void removeEmployee(int employeeNumber) {

    }

    public void processPayment() {

    }
}
