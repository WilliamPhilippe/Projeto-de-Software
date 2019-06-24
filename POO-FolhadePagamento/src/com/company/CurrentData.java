package com.company;

public class CurrentData {

    private String[] dias = {"Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sabado"};
    private int diaAtual = 1;
    private int mesAtual = 1;
    private int[] month = {31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};

    public CurrentData(){
        int mes, dia;

        System.out.println("Insira a data inicial do sistema.");
        System.out.println("Digite o mes. (1-12)");
        mes = Tools.selectOption(1, 12);
        System.out.println("Digite o dia. (1 - " + (month[mes - 1] - (mes == 1 ? 0 : month[mes - 2])) + ")");
        dia = Tools.selectOption(1, (month[mes - 1] - (mes == 1 ? 0 : month[mes - 2])) );

        this.diaAtual = dia + month[mes - 1];
        this.mesAtual = mes;
    }

    public void nextDay(){
        this.diaAtual ++;
        if( this.diaAtual == (month[mesAtual - 1] + 1) ) mesAtual ++;

       if( this.diaAtual == 366 ){
           this.diaAtual = 1;
           this.mesAtual = 1;
       }
    }

    public String getNameDayOfWeek(){
        if( (this.diaAtual%7) == 0 ) return dias[6];
        else return dias[ (this.diaAtual%7) - 1 ];
    }

    public int getDayOfMonth(){
        return this.diaAtual - month[mesAtual - 1];
    }

    public int getDayOfWeek(){
        return this.diaAtual%7 == 0 ? 7 : this.diaAtual%7;
    }

    public boolean isBusinessDay(){
        return !getNameDayOfWeek().equals("Domingo") && !getNameDayOfWeek().equals("Sabado");
    }

    public boolean isLastDayOfMonth(){
        return this.diaAtual == month[this.mesAtual - 1];
    }
}
