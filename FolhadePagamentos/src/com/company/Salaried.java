package com.company;

import java.util.Scanner;

public class Salaried {

    private int employeeNumber;
    private String name;
    private String type = "salaried";                    // salaried or hourly or commissioned

    // SYNDICATE
    private int syndicateNumber;
    private boolean syndicateIs = false;
    private double syndicateFee = 0;
    private double sydicateMonthlyFee = 0;


    // PAYMENT
    private String paymentMethod = "monthly";           // monthly - weekly - twoweekly
    private int dayOfPayment = 0;               // se for 0, eh o ultimo dia do mes | seg 1 sex 5
    private double salaryMonthly = 0;
    private double discount = 0;
    private String paymentDelivery = "mail";             // hands, mail, deposit

    // ADDRESS
    private String addressStreet;
    private int addressNumber;
    private String addressCity;
    private String addressState;
    public String addressCountry;

    private Scanner input = new Scanner(System.in);

    public Salaried() { }

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

    public void setAddress() {
        System.out.println("Definir endereço.");
        System.out.println("Rua: ");
        this.addressStreet = input.nextLine();
        System.out.println("Numero: ");
        this.addressNumber = input.nextInt(); input.nextLine();
        System.out.println("Cidade: ");
        this.addressCity = input.nextLine();
        System.out.println("Estado: ");
        this.addressState = input.nextLine();
        System.out.println("Pais: ");
        this.addressCountry = input.nextLine();

        System.out.println();
        System.out.println("Endereco definido.");
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

        input.nextLine();
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
            System.out.println("A taxa sindical atual eh de R$ " + this.syndicateFee + "para o proximo pagamento.");
            System.out.println("Digite a nova taxa sindical.");
            this.syndicateFee = input.nextInt(); input.nextLine();
            System.out.println("A taxa sindical foi alterada.");
        }
        else{
            System.out.println("O empregado nao pertence a um sindicato. Cadastre-o para adicionar uma taxa.");
        }
    }

    public void setSyndicateMonthlyFee(double fee) {
        // apenas sera descontada no dia 30 do mes

        this.sydicateMonthlyFee = fee;
    }

    public void setDiscout(int discout) {

    }

    public void setSalary(double salary){
        this.salaryMonthly = salary;
    }

    public void processPayment() {

    }

    public String toString(){
        return "Nome: " + this.name + " Number: " + this.employeeNumber;
    }
}
