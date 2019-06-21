package com.company;

import com.ExceptionsOwn.SearchFailureException;
import com.payment.data.Commissioned;
import com.payment.data.Employees;
import com.payment.data.Hourly;
import com.payment.data.Salaried;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

public class Working {

    private ArrayList<Employees> employees;
    private int employeeNumbers = 0;
    private int syndicateNumbers = 0;
    private int option = 0;
    Scanner input = new Scanner(System.in);

    Working(){
        employees = new ArrayList<>();
        employees.add(null);
    }

    void addEmployee(){
        System.out.println("Que tipo de funcionario quer adicionar?\n" +
                "1 - Assalariado.\n" +
                "2 - Comissionado.\n" +
                "3 - Horista.");

        option = Tools.selectOption(1, 3);

        if (option == 1){
            employeeNumbers++;
            Salaried salaried = new Salaried(input, employeeNumbers);

            employees.add(salaried);
        }
        if (option == 2){
            employeeNumbers++;
            Commissioned commissioned = new Commissioned(input, employeeNumbers);

            employees.add(commissioned);
        }
        if (option == 3){
            employeeNumbers++;
            Hourly hourly = new Hourly(input, employeeNumbers);

            employees.add(hourly);
        }

        System.out.println("Funcionario criado.\n" +
                employees.get(employeeNumbers).toString());
    }

    void removeEmployee(){

        Employees emp;
        try {
            emp = Tools.search(employees);
        }
        catch (SearchFailureException e){
            System.out.println(e.getMessage());
            return;
        }

        employees.remove(emp);
        System.out.println("Funcionario removido.");
    }

    void addTimeCard(){
        System.out.println("Inicialmente selecione o funcionario.");
        Employees emp = Tools.search(employees);

        if(emp instanceof Hourly) TimeCard.setTimeCard((Hourly) emp);
        else System.out.println("O funcionario nao e horista.");
    }

    void addSells(){}

    void addServiceFee(){}

    void changeDetails(){}

    void runPayment(){}

    void undo(){}

    void redo(){}

    void paymentCalendar(){}

    void newPaymentCalendar(){}

}
