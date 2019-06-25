package com.company;

import com.payment.data.Employees;

public class CalendarSet {

    String period = null;
    int day = 0;

    CalendarSet(String period, int day){
        this.period = period;
        this.day = day;
    }

    public void changeEmployee(Employees employees){
        employees.setPaymentPeriod(this.period);
        employees.setDayOfPayment(this.day);
    }

    public String toString(){
        String value = null;

        if(period.equals("monthly")) {
            value = "mensal " + this.day;
        }
        else{

            switch (day){
                case 1:
                    value = "domingo";
                    break;
                case 2:
                    value = "segunda";
                    break;
                case 3:
                    value = "terca";
                    break;
                case 4:
                    value = "quarta";
                    break;
                case 5:
                    value = "quinta";
                    break;
                case 6:
                    value = "sexta";
                    break;
                case 7:
                    value = "sabado";
                    break;
            }

            if(this.period.equals("twoweekly")){
                value = "semanal 2 " + value;
            }
            if(this.period.equals("weekly")){
                value = "semanal 1 " + value;
            }

        }

        return value;
    }

}
