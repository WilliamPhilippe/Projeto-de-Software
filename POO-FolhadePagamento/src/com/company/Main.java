package com.company;

import java.util.Scanner;

public class Main {

    private static Working company = new Working();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int option;

        while (true){
            System.out.println("\n\nO que deseja fazer?");
            System.out.println("1 - Adicionar um empregado.");
            System.out.println("2 - Remover um empregado.");
            System.out.println("3 - Lancar um cartao de ponto.");
            System.out.println("4 - Lancar resultado de vendas.");
            System.out.println("5 - Lancar uma taxa de servico.");
            System.out.println("6 - Alterar detalhes de um empregado.");
            System.out.println("7 - Rodar folha de pagamento.");
            System.out.println("8 - Desfazer.");
            System.out.println("9 - Refazer");
            System.out.println("10 - Agenda de Pagamentos");
            System.out.println("11 - Criar nova agenda de pagamento.");
            System.out.println("0 - Encerrar sistema.");

                option = Tools.selectOption(0, 11);

                switch (option) {
                    case 1:
                        company.addEmployee();
                        break;
                    case 2:
                        company.removeEmployee();
                        break;
                    case 3:
                        company.addTimeCard();
                        break;
                    case 4:
                        company.addSells();
                        break;
                    case 5:
                        company.addServiceFee();
                        break;
                    case 6:
                        company.changeDetails();
                        break;
                    case 7:
                        company.runPayment();
                        break;
                    case 8:
                        company.undo();
                        break;
                    case 9:
                        company.redo();
                        break;
                    case 10:
                        company.paymentCalendar();
                        break;
                    case 11:
                        company.newPaymentCalendar();
                        break;
                    case 0:
                        return;
                }

            try { Thread.sleep(2000); }
            catch (InterruptedException e){ e.getMessage(); }
        }

    }
}
