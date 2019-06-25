package com.company;

import com.payment.data.Employees;

import java.util.ArrayList;


public class CalendarPayment {

    ArrayList<CalendarSet> calendar;

    public CalendarPayment(){
        calendar = new ArrayList<>();
    }

    public void newDate(){
        System.out.println("Voce quer criar uma agenda\n" +
                "1 - Semanal\n" +
                "2 - Bisemanal\n" +
                "3 - Mensal\n");

        int option = Tools.selectOption(1, 3);
        int day = 0;
        String period = null;

        if(option == 1 || option == 2){
            System.out.println("Escolha o dia. (1) Domingo até (7) Sabado");
            day = Tools.selectOption(1, 7);

            period = (option == 1) ? "weekly" : "twoweekly";
        }
        else{
            System.out.println("Digite o dia. 1 - 31 ou 0 para o ultimo dia util.");
            day = Tools.selectOption(0, 31);

            period = "monthly";
        }

        CalendarSet date =  new CalendarSet(period, day);
        calendar.add(date);
        System.out.println("Agenda criada: " + date.toString());
    }

    public void selectDate(Employees employees){

        int index = 0;

        System.out.println("Lista de agendas disponiveis: ");
        for (CalendarSet date : calendar){
            System.out.println( (++index) + " - " + date.toString());
        }

        if(calendar.isEmpty()){
            System.out.println("Ainda nao ha agendas disponiveis.\n" +
                    "Crie uma no menu principal.");
            return;
        }

        System.out.println("Qual agenda voce quer? (1-" + index + ")");
        index = Tools.selectOption(1, index);

        calendar.get(index - 1).changeEmployee(employees);
        System.out.println("Alterado.");
    }
}
