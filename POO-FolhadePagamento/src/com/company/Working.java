package com.company;

import com.ExceptionsOwn.SearchFailureException;
import com.payment.data.Commissioned;
import com.payment.data.Employees;
import com.payment.data.Hourly;
import com.payment.data.Salaried;

import java.util.ArrayList;

public class Working {

    private ArrayList<Employees> employees;
    private int employeeNumbers = 0;
    private int syndicateNumbers = 0;
    private int option = 0;

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
            Salaried salaried = new Salaried(employeeNumbers);

            employees.add(salaried);
        }
        if (option == 2){
            employeeNumbers++;
            Commissioned commissioned = new Commissioned(employeeNumbers);

            employees.add(commissioned);
        }
        if (option == 3){
            employeeNumbers++;
            Hourly hourly = new Hourly(employeeNumbers);

            employees.add(hourly);
        }

        System.out.println("Funcionario criado.\n" +
                employees.get(employeeNumbers).toString());
    }

    void removeEmployee(){

        System.out.println("Selecione o funcionario.");
        Employees emp;
        try {
            emp = Tools.search(employees);
        }
        catch (SearchFailureException e){
            System.out.println(e.getMessage());
            return;
        }

        int index = employees.indexOf(emp);
        employees.set(index, null);
        System.out.println("Funcionario removido.");
    }

    void addTimeCard(){
        System.out.println("Inicialmente selecione o funcionario.");
        Employees emp;
        try {
            emp = Tools.search(employees);
        }
        catch (SearchFailureException e){
            System.out.println(e.getMessage());
            return;
        }

        if(emp instanceof Hourly) TimeCard.setTimeCard((Hourly) emp);
        else System.out.println("O funcionario nao e horista.");
    }

    void addSells(){
        System.out.println("Inicialmente selecione o funcionario.");
        Employees emp;
        try {
            emp = Tools.search(employees);
        }
        catch (SearchFailureException e){
            System.out.println(e.getMessage());
            return;
        }

        if(emp instanceof Commissioned){
            ((Commissioned) emp).setSells();
        }
        else System.out.println("O funcionario nao eh comissionado.");
    }

    void addServiceFee(){
        System.out.println("Selecione o tipo de taxa.\n" +
                "1 - Taxa Sindical (o empregado precisa pertencer a um sidnicato)\n" +
                "2 - Imposto ou deducao.");
        option = Tools.selectOption(1, 2);

        System.out.println("Selecione o empregado.");
        Employees emp;
        try {
            emp = Tools.search(employees);
        }
        catch (SearchFailureException e){
            System.out.println(e.getMessage());
            return;
        }

        if (option == 1 & !emp.getSyndicateIs()){
            System.out.println("O empregado nao pertence a um sindicato.\n" +
                    "Voce pode alterar isso no menu principal.");

        }
        else if (option == 1 && emp.getSyndicateIs()){
            System.out.println("Digite a taxa de serviço sindical. Ex: 1234,34");
            double fee = Tools.readDouble("Ex: 123,45");
            emp.setSyndicateFee(fee);
        }
        else if (option == 2){
            System.out.println("Digite o disconto ou imposto. Ex: 123,45");
            double fee = Tools.readDouble("Ex: 123,45");
            emp.setDiscount(fee);
        }
    }

    void runPayment(){}

    void undo(){}

    void redo(){}

    void paymentCalendar(){}

    void newPaymentCalendar(){}

    //Class Methods
    ArrayList<Employees> getArrayList(){ return employees; }

    int getEmployeeNumbers(){ return employeeNumbers; }

    int getSyndicateNumbers(){ return syndicateNumbers; }

    void incrementSyndicateNumber(int up){ this.syndicateNumbers += up; }

}
