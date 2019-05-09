package com.company;

import java.util.Scanner;

public class Menu {
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
        System.out.println("10 - Refazer.");
        System.out.println("11 - Desfazer.");
        System.out.println("0 - Encerrar sistema.");

        Scanner input = new Scanner(System.in);
        Integer option = input.nextInt();

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
        }


        System.out.println();
        System.out.println();
        return (option != 0 ? true : false);
    }


}
