package com.company;

import com.ExceptionsOwn.OutOfPatternException;
import com.payment.data.Hourly;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TimeCard {

    public static void setTimeCard(Hourly employee){
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        System.out.println("Esse empregado trabalhou de um dia para o outro?\n" +
                "Ou seja, iniciou o trabalho no dia X e terminou no dia X+1\n" +
                "1 - Sim || 0 - Nao.");
        int formatWork = Tools.selectOption(0, 1);

        String horaIn, horaOut;
        long horaI, horaO;
        Date horaIniDate, horaFimDate;
        double diff = 0;

        while (true) {
            try {
                System.out.println("Atencao:\n" +
                        "A hora deve estar no formato 24h.\n" +
                        "A entrada deve ser no formato HH:mm:ss");

                System.out.println("Digite a hora de entrada.");
                horaIn = input.nextLine();
                System.out.println("Digite a hora de saida.");
                horaOut = input.nextLine();

                horaIniDate = sdf.parse(horaIn);
                horaFimDate = sdf.parse(horaOut);

                horaI = horaIniDate.getTime();
                horaO = horaFimDate.getTime();

                if(horaO < horaI && formatWork == 0) throw new OutOfPatternException("Hora de saida menor que hora de entrada.");

                break;
            }
            catch (OutOfPatternException e){
                System.out.println(e.getMessage());
                System.out.println("Tente novamente.");

                System.out.println("Esse empregado trabalho de um dia para o outro?\n" +
                        "Ou seja, iniciou o trabalho no dia X e terminou no dia X+1\n" +
                        "1 - Sim || 0 - Nao.");
                formatWork = Tools.selectOption(0, 1);
            }
            catch (Exception e){
                System.out.println("Entrada invalida. Tente novamente.");
            }
        }

        if (formatWork == 1){
            try {
                diff = (double) ( sdf.parse("23:59:59").getTime() - horaI )/(1000*60*60);
                diff += (double) ( horaO - sdf.parse("00:00:00").getTime())/(1000*60*60);
            }
            catch (ParseException e){
                e.getMessage();
                e.getStackTrace();
            }
        }
        if (formatWork == 0){
            diff = (double) (horaO - horaI)/(1000*60*60);
        }

        System.out.println("Horas trabalhadas: " + diff);
        employee.setHourPayment(diff);
        System.out.println("Horas trabalhadas adicionadas.");
    }

}
