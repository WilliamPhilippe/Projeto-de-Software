package com.company;

import java.util.Scanner;

public class Main {

    int employeesNumber = 0;
    int syndicatNumber = 0;
    final int MAX_SIZE = 100;
    int currentDay = 1;


    String[] names = new String[100];
    String[] types = new String[100];           // salaried or hourly or commissioned

    // SYNDICATE
    int[] syndicateNumbers =  new int[100];
    boolean[] syndicateIs = new boolean[100];
    double[] syndicateFee = new double[100];
    double[] syndicateMonthlyFee = new double[100];

    // PAYMENT
    String[] paymentMethod = new String[100];           // monthly - weekly - twoweekly
    int[] dayOfPayment = new int[100];                  // se for 0, eh o ultimo dia do mes | seg 1 sex 5
    double[] salary = new double[100];
    double[] sells = new double[100];
    double[] commission = new double[100];
    double[] discount = new double[100];
    String[] paymentDelivery = new String[100];         // hands, mail, deposit

    // ADDRESS
    String[] addressStreet = new String[100];
    int[] addressNumber = new int[100];
    String[] addressCity = new String[100];

    public static void main(String[] args) {

        while (true){
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
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 11:

                    break;
                case 12:

                    break;
            }

            if(option == 0) break;
        }

    }


}
