package com.company;

import com.ExceptionsOwn.SearchFailureException;
import com.payment.data.Commissioned;
import com.payment.data.Employees;
import com.payment.data.Hourly;
import com.payment.data.Salaried;

import java.util.ArrayList;
import java.util.Stack;

public class Working {

    private ArrayList<Employees> employees;
    private int employeeNumbers = 0;
    private int syndicateNumbers = 0;
    private int option = 0;
    private CurrentData date;
    private Stack<Employees> paymentsForwards;
    private boolean semanadepagamentos = false;

    Working(boolean flag){
        employees = new ArrayList<>();
        if (flag) date = new CurrentData();
        paymentsForwards = new Stack<>();
    }

    void addEmployee(){
        System.out.println("Que tipo de funcionario quer adicionar?\n" +
                "1 - Assalariado.\n" +
                "2 - Comissionado.\n" +
                "3 - Horista.");

        option = Tools.selectOption(1, 3);

        Employees emp = null;

        if (option == 1){
            employeeNumbers++;
            emp = new Salaried(employeeNumbers);

            employees.add(emp);
        }
        if (option == 2){
            employeeNumbers++;
            emp = new Commissioned(employeeNumbers);

            employees.add(emp);
        }
        if (option == 3){
            employeeNumbers++;
            emp = new Hourly(employeeNumbers);

            employees.add(emp);
        }

        System.out.println("Funcionario criado.\n" +
                emp.toString());
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

        while (employees.remove(null));

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

    void runPayment(){
        boolean businessDay = date.isBusinessDay();

        System.out.println(date.toString());
        if (!businessDay) System.out.println("Hoje nao eh dia util.\n" +
                "Todos os pagamentos de hoje serao processados no proximo dia util.");

        if( businessDay && !paymentsForwards.empty() ){
            System.out.println("Pagamentos dos dias anteriores ainda nao processados:");
            while (!paymentsForwards.empty()){
                paymentsForwards.pop().runPayment();
            }
        }

        for( Employees item : employees ){
            if (item == null) continue;
            if( semanadepagamentos && item.getPaymentPeriod().equals("twoweekly") && item.getDayOfPayment() == date.getDayOfWeek() ){
                if (businessDay) item.runPayment();
                else paymentsForwards.push(item);
            }
            if ( item.getPaymentPeriod().equals("weekly") && item.getDayOfPayment() == date.getDayOfWeek() ){
                if (businessDay) item.runPayment();
                else paymentsForwards.push(item);
            }
            if ( item.getPaymentPeriod().equals("monthly") && item.getDayOfPayment() == date.getDayOfMonth() ){
                if (businessDay) item.runPayment();
                else paymentsForwards.push(item);
            }
            if ( item.getPaymentPeriod().equals("monthly") && item.getDayOfPayment() == 0 && date.isLastDayOfMonth()){
                if (businessDay) item.runPayment();
                else paymentsForwards.push(item);
            }
            if ( item.getPaymentPeriod().equals("monthly") && item.getDayOfPayment() > date.getDayOfMonth() && date.isLastDayOfMonth() ){
                if (businessDay) item.runPayment();
                else paymentsForwards.push(item);
            }
        }

        if (date.getNameDayOfWeek().equals("Domingo")) semanadepagamentos = !semanadepagamentos;
        date.nextDay();
    }

    //Class Methods
    ArrayList<Employees> getArrayList(){ return employees; }

    int getEmployeeNumbers(){ return employeeNumbers; }

    int getSyndicateNumbers(){ return syndicateNumbers; }

    CurrentData getDate(){ return this.date; }

    Stack<Employees> getPaymentsForwards(){ return this.paymentsForwards; }

    boolean getSemanadePagamentos(){ return this.semanadepagamentos; }

    void setArrayList(ArrayList<Employees> employees){ this.employees = employees; }

    void setEmployeeNumbers(int employeeNumbers){ this.employeeNumbers = employeeNumbers; }

    void setSyndicateNumbers(int syndicateNumbers){ this.syndicateNumbers = syndicateNumbers; }

    void setDate(CurrentData date){ this.date = date; }

    void setPaymentsForwards(Stack<Employees> paymentsForwards){ this.paymentsForwards = paymentsForwards; }

    void setSemanadepagamentos(boolean semanadepagamentos){ this.semanadepagamentos = semanadepagamentos; }

    void incrementSyndicateNumber(int up){ this.syndicateNumbers += up; }
}
