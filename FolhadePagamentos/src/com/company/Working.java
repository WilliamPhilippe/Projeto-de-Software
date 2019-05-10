package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Working {

    private int employeesNumbers = 0;
    private int syndicateNumbers = 0;

    ArrayList<Employees> employees = new ArrayList<>();

    private Scanner input = new Scanner(System.in);

    public void addEmployee(){
        System.out.println("Que tipo de funcionario vai adicionar?");
        System.out.println("1 - Assalariado.");
        System.out.println("2 - Assalariado comissionado.");
        System.out.println("3 - Horista.");

        int option = input.nextInt(); input.nextLine();


        if(option == 1){
            Salaried newEmployee = new Salaried();

            System.out.println("Digite o nome do empregado.");
            newEmployee.setName(input.nextLine());
            newEmployee.setAddress();
            System.out.println("Digite o salario mensal do empregado.");
            newEmployee.setSalary(input.nextDouble()); input.nextLine();
            newEmployee.setEmployeeNumber(++employeesNumbers);

            employees.add(newEmployee);
            System.out.println("Adicionado.");

        }
        else if(option == 2){
            Commissioned newEmployee = new Commissioned();

            System.out.println("Digite o nome do empregado.");
            newEmployee.setName(input.nextLine());
            newEmployee.setAddress();
            System.out.println("Digite o salario mensal do funcionario.");
            newEmployee.setMonthlySalary(input.nextDouble()); input.nextLine();
            System.out.println("Qual a comissao desse funcionario?");
            System.out.println("Ex: 0,02 para 2% de comissao.");
            newEmployee.setCommissionPercentage(input.nextDouble()); input.nextLine();
            newEmployee.setEmployeeNumber(++employeesNumbers);

            employees.add(newEmployee);
            System.out.println("Adicionado.");
        }
        else if(option == 3){


        }
        else System.out.println("Opcao invalida.");
    }

    public void removeEmployee(){

    }

    public void addTimecard(){

    }

    public void addSales(){

    }

    public void addFeeService(){

    }

    public void changeEmployeeDetails(){

    }

    public void runPayments(){
        /* Todo:
         * Dia 30 rodar taxas mensais do sindicato.
         * Verificar se há taxas do sindicato a ser deduzidas.
         * Verificar deducoes de cada funcionario.
         */


    }

    public void setPayment(){

    }

    public void newPaymentCalendar(){

    }

    public void redo(){

    }

    public void undo(){
        
    }

    public void setSyndicateFee(){

    }

}
