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
            Salaried newSalaried = new Salaried();

            System.out.println("Digite o nome do empregado.");
            newSalaried.setName(input.nextLine());
            newSalaried.setAddress();
            System.out.println("Digite o salario mensal do empregado.");
            newSalaried.setSalary(input.nextDouble()); input.nextLine();
            newSalaried.setEmployeeNumber(++employeesNumbers);

            employees.add(newSalaried);
            System.out.println("Adicionado.");
        }
        else if(option == 2){

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

    }

    public void setPayment(){

    }

    public void newPaymentCalendar(){

    }

    public void redo(){

    }

    public void undo(){
        
    }

}
