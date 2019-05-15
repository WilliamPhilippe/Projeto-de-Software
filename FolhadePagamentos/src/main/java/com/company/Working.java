package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Working {

    private int employeesNumbers = 0;
    private int syndicateNumbers = 0;

    ArrayList<Hourly> hourlies = new ArrayList<>();
    ArrayList<Commissioned> commissioneds = new ArrayList<>();
    ArrayList<Salaried> salarieds = new ArrayList<>();

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
            newEmployee.setEmployeeNumber( ++employeesNumbers );
            System.out.println("Numero do empregado: " + newEmployee.getEmployeeNumber());

            salarieds.add(newEmployee);
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
            newEmployee.setEmployeeNumber( ++employeesNumbers );
            System.out.println("Numero do empregado: " + newEmployee.getEmployeeNumber());

            commissioneds.add(newEmployee);
            System.out.println("Adicionado.");
        }
        else if(option == 3){
            Hourly newEmployee = new Hourly();

            System.out.println("Digite o nome do empregado: ");
            newEmployee.setName(input.nextLine());
            newEmployee.setAddress();
            System.out.println("Digite a taxa por hora do funcionario.");
            newEmployee.setHourFee(input.nextDouble()); input.nextLine();
            newEmployee.setEmployeeNumber( ++employeesNumbers );
            System.out.println("Numero do empregado: " + newEmployee.getEmployeeNumber());

            hourlies.add(newEmployee);
            System.out.println("Adicionado.");
        }
        else System.out.println("Opcao invalida.");
    }

    public void removeEmployee(){
        System.out.println("Quer fazer a pesquisa por:\n1 - Numero Pessoal.\n2 - Nome Completo.");
        int option = input.nextInt(); input.nextLine();
        int number = -1; String nameSearch = " "; int index = 0;

        if (option == 1){
            System.out.println("Digite o numero do funcionario.");
            number = input.nextInt(); input.nextLine();
        }
        else{
            System.out.println("Digite corretamente o nome completo do funcionario.");
            nameSearch = input.nextLine();
        }

        for (Commissioned c : commissioneds){
            if (option == 1 && number == c.getEmployeeNumber()){
                commissioneds.remove(index);
                number = 0;
                break;
            }
            else if(option == 2 && c.getName().intern() == nameSearch.intern()){
                commissioneds.remove(index);
                number = 0;
                break;
            }
            index++;
        }

        index = 0;
        for (Salaried s : salarieds){
            if (option == 1 && number == s.getEmployeeNumber()){
                salarieds.remove(index);
                number = 0;
                break;
            }
            else if(option == 2 && s.getName().intern() == nameSearch.intern()){
                salarieds.remove(index);
                number = 0;
                break;
            }
            index++;

        }

        index = 0;
        for (Hourly h : hourlies){
            if (option == 1 && number == h.getEmployeeNumber()){
                hourlies.remove(index);
                number = 0;
                break;
            }
            else if(option == 2 && h.getName().intern() == nameSearch.intern()){
                hourlies.remove(index);
                number = 0;
                break;
            }
            index++;
        }

        if(number != 0) System.out.println("Funcionario nao encontrado. ");
        else System.out.println("Removido.");

    }

    public void addTimecard(){

    }

    public void addSales(){
        System.out.println("Aviso: Para adicionar vendas, o funcionario precisa ser um comissionado.");
        System.out.println("Quer fazer a pesquisa por:\n1 - Numero Pessoal.\n2 - Nome Completo.");
        int option = input.nextInt(); input.nextLine();
        int number = -1; String nameSearch = " ";

        if (option == 1){
            System.out.println("Digite o numero do funcionario.");
            number = input.nextInt(); input.nextLine();
        }
        else{
            System.out.println("Digite corretamente o nome completo do funcionario.");
            nameSearch = input.nextLine();
        }

        for (Commissioned c : commissioneds){
            if (option == 1 && number == c.getEmployeeNumber()){
                System.out.println("Insira as vendas de " + c.getName());
                c.setSells(input.nextDouble()); input.nextLine();
                number = 0;
                break;
            }
            else if(option == 2 && c.getName().intern() == nameSearch.intern()){
                System.out.println("Insira as vendas de " + c.getName());
                c.setSells(input.nextDouble()); input.nextLine();
                number = 0;
                break;
            }
        }

        if (number != 0) System.out.println("Usuario nao encontrado.");
        else System.out.println("Vendas inseridas.");
    }

    public void addFeeService(){
        System.out.println("Quer fazer a pesquisa por:\n1 - Numero Pessoal.\n2 - Nome Completo.");
        int option = input.nextInt(); input.nextLine();
        int number = -1; String nameSearch = " ";

        if (option == 1){
            System.out.println("Digite o numero do funcionario.");
            number = input.nextInt(); input.nextLine();
        }
        else{
            System.out.println("Digite corretamente o nome completo do funcionario.");
            nameSearch = input.nextLine();
        }

        for (Commissioned c : commissioneds){
            if (option == 1 && number == c.getEmployeeNumber()){
                System.out.println("Digite o valor a ser descontado de " + c.getName());
                c.setDiscout(input.nextDouble()); input.nextLine();
                number = 0; break;
            }
            else if(option == 2 && c.getName().intern() == nameSearch.intern()){
                System.out.println("Digite o valor a ser descontado de " + c.getName());
                c.setDiscout(input.nextDouble()); input.nextLine();
                number = 0; break;
            }
        }

        for (Salaried s : salarieds){
            if (option == 1 && number == s.getEmployeeNumber()){
                System.out.println("Digite o valor a ser descontado de " + s.getName());
                s.setDiscout(input.nextDouble()); input.nextLine();
                number = 0; break;
            }
            else if(option == 2 && s.getName().intern() == nameSearch.intern()){
                System.out.println("Digite o valor a ser descontado de " + s.getName());
                s.setDiscout(input.nextDouble()); input.nextLine();
                number = 0; break;
            }
        }

        for (Hourly h : hourlies){
            if (option == 1 && number == h.getEmployeeNumber()){
                System.out.println("Digite o valor a ser descontado de " + h.getName());
                h.setDiscout(input.nextDouble()); input.nextLine();
                number = 0; break;
            }
            else if(option == 2 && h.getName().intern() == nameSearch.intern()){
                System.out.println("Digite o valor a ser descontado de " + h.getName());
                h.setDiscout(input.nextDouble()); input.nextLine();
                number = 0; break;
            }
        }

        if (number != 0) System.out.println("Usuario nao encontrado.");
        else System.out.println("Discontos inseridos.");
    }

    public void changeEmployeeDetails(){
        System.out.println("Quer fazer a pesquisa por:\n1 - Numero Pessoal.\n2 - Nome Completo.");
        int option = input.nextInt(); input.nextLine();
        int number = -1; String nameSearch = " ";

        if (option == 1){
            System.out.println("Digite o numero do funcionario.");
            number = input.nextInt(); input.nextLine();
        }
        else{
            System.out.println("Digite corretamente o nome completo do funcionario.");
            nameSearch = input.nextLine();
        }

//        System.out.println("O que voce deseja mudar?\n" +
//                "1 - Nome.\n" +
//                "2 - Endereco.\n" +
//                "3 - Tipo.\n" +
//                "4 - Metodo de pagamento.\n" +
//                "5 - Colocar ou retirar do sindicato.\n" +
//                "6 - Taxa sindical.");
//        int select = input.nextInt(); input.nextLine();

        

        switch (select) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                System.out.println("Opcao invalida.");
        }
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

    public void setSyndicateFee(){

    }

    public void redo(){

    }

    public void undo(){

    }

}
