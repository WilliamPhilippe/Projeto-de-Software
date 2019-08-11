package com.company;

import com.ExceptionsOwn.SearchFailureException;
import com.memento.CareTaker;
import com.memento.Memento;
import com.payment.data.Employees;

public class Main {

    private static Working company = new Working(true);
    private static CareTaker careTaker = new CareTaker();
    static boolean flagUndo = true, flagRedo = true;
    static CalendarPayment calendar = new CalendarPayment();

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
                    careTaker.pushUndo(new Memento(company));
                    company.addEmployee();
                    break;
                case 2:
                    careTaker.pushUndo(new Memento(company));
                    company.removeEmployee();
                    break;
                case 3:
                    careTaker.pushUndo(new Memento(company));
                    company.addTimeCard();
                    break;
                case 4:
                    careTaker.pushUndo(new Memento(company));
                    company.addSells();
                    break;
                case 5:
                    careTaker.pushUndo(new Memento(company));
                    company.addServiceFee();
                    break;
                case 6:
                    careTaker.pushUndo(new Memento(company));
                    Edit.edition(company);
                    break;
                case 7:
                    careTaker.pushUndo(new Memento(company));
                    company.runPayment();
                    break;
                case 8:
                    if(careTaker.undoIsEmpty()) System.out.println("Nao ha alteracoes a serem desfeitas.");
                    else{
                        company = careTaker.runUndo(new Memento(company)).getState();
                        System.out.println("Alteracao desfeita.");
                        flagUndo = false;
                        flagRedo = false;
                    }
                    break;
                case 9:
                    if (careTaker.redoIsEmpty()) System.out.println("Nao ha alteracoes a serem refeitas.");
                    else{
                        company = careTaker.runRedo(new Memento(company)).getState();
                        flagRedo = false;
                    }
                    break;
                case 10:
                    System.out.println("Selecione o funcionario.");
                    Employees emp;
                    try {
                        emp = Tools.search(company.getArrayList());
                    }
                    catch (SearchFailureException e){
                        System.out.println(e.getMessage());
                        break;
                    }
                    calendar.selectDate(emp);
                    break;
                case 11:
                    calendar.newDate();
                    break;
                case 0:
                    return;
            }
//
            if (flagRedo){
                careTaker.clearRedo();
            }
            else flagRedo = true;

            try { Thread.sleep(2000); }
            catch (InterruptedException e){ e.getMessage(); }
        }

    }
}
