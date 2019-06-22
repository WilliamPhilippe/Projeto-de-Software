package com.company;

import com.ExceptionsOwn.InvalidOptionExcepetion;
import com.ExceptionsOwn.SearchFailureException;
import com.payment.data.Employees;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Tools {

    public static Employees search(ArrayList<Employees> employees){
        System.out.println("Voce deseja fazer uma busca por (1) nome ou (2) numero do funcionario? ");
        int option = selectOption(1, 2);
        Scanner input = new Scanner(System.in);

        if(option == 1){

            while (true) {
                System.out.println("Digite o nome do funcionario corretamente.");
                String name = input.nextLine();

                for (Employees item : employees) {
                    if (item != null && item.getName().equals(name)){
                        System.out.println("Funcionario encontrado.\n" + item.toString());
                        return item;
                    }
                }

                System.out.println("Funcionario nao encontrado ou nao existe. Deseja tentar novamente? (1) Sim (0) Nao.");

                option = selectOption(0, 1);
                if (option == 0) throw new SearchFailureException();
            }

        }
        if (option == 2){

            while (true) {
                System.out.println("Digite o numero do funcionario.");
                option = selectOption(0);

                for (Employees item : employees) {
                    if (item != null && item.getEmployeeNumber() == option){
                        System.out.println("Funcionario encontrado.\n" + item.toString());
                        return item;
                    }
                }

                System.out.println("Funcionario nao encontrado ou nao existe. Deseja tentar novamente? (1) Sim (0) Nao.");

                option = selectOption(0, 1);
                if (option == 0) throw new SearchFailureException();
            }
        }

        throw new SearchFailureException();
    }

    public static int selectOption(int a, int b){
        Scanner input = new Scanner(System.in);

        while (true){
            try{
                int option = input.nextInt();
                if(option < a || option > b) throw new InvalidOptionExcepetion("Insira um numero entre " + a + " e " + b);
                return option;
            }
            catch (InputMismatchException e){
                System.out.println("Entrada invalida. Digite um inteiro.");
            }
            catch (InvalidOptionExcepetion e){
                System.out.println(e.getMessage());
            }
            finally { input.nextLine(); }
        }
    }

    public static int selectOption(int a){
        Scanner input = new Scanner(System.in);

        while (true){
            try{
                int option = input.nextInt();
                if(option <= a) throw new InvalidOptionExcepetion("Insira um numero maior que " + a);
                return option;
            }
            catch (InputMismatchException e){
                System.out.println("Entrada invalida. Digite um inteiro.");
            }
            catch (InvalidOptionExcepetion e){
                System.out.println(e.getMessage());
            }
            finally { input.nextLine(); }
        }
    }

    public static double readDouble(String s){
        Scanner input = new Scanner(System.in);

        while (true){
            try {
                double number = input.nextDouble();
                input.nextLine();
                return number;
            }
            catch (InputMismatchException e){
                System.out.println("Entrada invalida. Tente novamente. " + s);
                input.nextLine();
            }
        }
    }

    public static int readInteger(String s){
        Scanner input = new Scanner(System.in);

        while (true){
            try {
                int number = input.nextInt();
                input.nextLine();
                return number;
            }
            catch (InputMismatchException e){
                System.out.println("Entrada invalida. Tente novamente. " + s);
                input.nextLine();
            }
        }
    }

}
