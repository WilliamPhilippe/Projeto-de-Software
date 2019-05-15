package com.company;

import java.util.Scanner;

public class Menu {

    Working company = new Working();

    public boolean runMenu(){

        System.out.println("O que deseja fazer?");
        System.out.println("1 - Adicionar um empregado.");
        System.out.println("2 - Remover um empregado.");
        System.out.println("3 - Lancar um cartao de ponto.");
        System.out.println("4 - Lancar resultado de vendas.");
        System.out.println("5 - Lancar uma taxa de servico.");
        System.out.println("6 - Alterar detalhes de um empregado.");
        System.out.println("7 - Rodar folha de pagamento.");
        System.out.println("8 - Agenda de pagamento.");
        System.out.println("9 - Criar nova agenda de pagamentos.");
        System.out.println("10 - Definir taxa sindical.");
        System.out.println("11 - Refazer.");
        System.out.println("12 - Desfazer.");
        System.out.println("0 - Encerrar sistema.");

        Scanner input = new Scanner(System.in);
        int option = input.nextInt(); input.nextLine();

        switch (option){
            case 1:
                company.addEmployee();
                break;
            case 2:
                company.removeEmployee();
                break;
            case 3:
                company.addTimecard();
                break;
            case 4:
                company.addSales();
                break;
            case 5:
                company.addFeeService();
                break;
            case 6:
                company.changeEmployeeDetails();
                break;
            case 7:
                company.runPayments();
                break;
            case 8:
                company.setPayment();
                break;
            case 9:
                company.newPaymentCalendar();
                break;
            case 10:
                company.setSyndicateFee();
                break;
            case 11:
                company.redo();
                break;
            case 12:
                company.undo();
                break;
        }

        System.out.println();
        System.out.println();
        return (option != 0);
    }


}
