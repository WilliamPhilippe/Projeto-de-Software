package com.company;

import java.util.Stack;

public class Main {

    private static Working company = new Working(true);
    static Stack<Working> undoStack = new Stack<>();
    static Stack<Working> redoStack = new Stack<>();
    static boolean flagUndo = true, flagRedo = true;

    public static void main(String[] args) {

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
                    undoStack.push(Undo.undoWorking(company));
                    company.addEmployee();
                    break;
                case 2:
                    undoStack.push(Undo.undoWorking(company));
                    company.removeEmployee();
                    break;
                case 3:
                    undoStack.push(Undo.undoWorking(company));
                    company.addTimeCard();
                    break;
                case 4:
                    undoStack.push(Undo.undoWorking(company));
                    company.addSells();
                    break;
                case 5:
                    undoStack.push(Undo.undoWorking(company));
                    company.addServiceFee();
                    break;
                case 6:
                    undoStack.push(Undo.undoWorking(company));
                    Edit.edition(company);
                    break;
                case 7:
                    undoStack.push(Undo.undoWorking(company));
                    company.runPayment();
                    break;
                case 8:
                    if(undoStack.empty()) System.out.println("Nao ha alteracoes a serem desfeitas.");
                    else{
                        redoStack.push(Undo.undoWorking(company));
                        company = undoStack.pop();
                        System.out.println("Alteracao desfeita.");
                        flagUndo = false;
                        flagRedo = false;
                    }
                    break;
                case 9:
                    undoStack.push(Undo.undoWorking(company));
                    if (redoStack.empty()) System.out.println("Nao ha alteracoes a serem refeitas.");
                    else{
                        company = redoStack.pop();
                        flagRedo = false;
                    }
                    break;
                case 10:
                    undoStack.push(Undo.undoWorking(company));
                    company.paymentCalendar();
                    break;
                case 11:
                    undoStack.push(Undo.undoWorking(company));
                    company.newPaymentCalendar();
                    break;
                case 0:
                    return;
            }
//
            if (flagRedo){
                redoStack.clear();
            }
            else flagRedo = true;

            try { Thread.sleep(2000); }
            catch (InterruptedException e){ e.getMessage(); }
        }

    }
}
