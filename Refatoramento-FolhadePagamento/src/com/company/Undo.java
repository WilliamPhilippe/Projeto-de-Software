package com.company;

import com.payment.data.Commissioned;
import com.payment.data.Employees;
import com.payment.data.Hourly;
import com.payment.data.Salaried;

import java.util.ArrayList;
import java.util.Stack;

public class Undo {
    public static Working undoWorking(Working old){
        Working nova = new Working(false);
        nova.setEmployeeNumbers(old.getEmployeeNumbers());
        nova.setSemanadepagamentos(old.getSemanadePagamentos());
        nova.setSyndicateNumbers(old.getSyndicateNumbers());

        nova.setDate(undoDate(old.getDate()));
        nova.setArrayList(undoArrayList(old.getArrayList()));
        nova.setPaymentsForwards(undoStack(old.getPaymentsForwards()));
        return nova;
    }

    private static CurrentData undoDate(CurrentData old){
        CurrentData nova = new CurrentData(old.getOriginalDia(), old.getOriginalMes());
        return nova;
    }

    private static ArrayList<Employees> undoArrayList(ArrayList<Employees> old){
        ArrayList<Employees> novo = new ArrayList<>();

        for(Employees item : old){
            if (item == null){
                novo.add(null);
            }
            else if(item instanceof Hourly){
                novo.add(undoHourly( (Hourly) item ));
            }
            else if(item instanceof Commissioned){
                novo.add(undoCommissioned( (Commissioned) item ));
            }
            else if(item instanceof Salaried){
                novo.add(undoSalaried( (Salaried) item ));
            }
            else System.out.println("ERROR IN UNDOARRAYLIST");
        }

        return novo;
    }

    private static Stack<Employees> undoStack(Stack<Employees> old){
        Stack<Employees> nova = new Stack<>();

        for (Employees emp : old){
            if (emp == null){
                nova.push(null);
            }
            else if(emp instanceof Hourly){
                nova.push(undoHourly( (Hourly) emp ));
            }
            else if(emp instanceof Commissioned){
                nova.push(undoCommissioned( (Commissioned) emp ));
            }
            else if(emp instanceof Salaried){
                nova.push(undoSalaried( (Salaried) emp ));
            }
            else System.out.println("ERROR IN UNDOSTACK");
        }

        return nova;
    }

    private static Hourly undoHourly(Hourly old){
        Hourly novo = new Hourly();

        novo.setHourlyFee(old.getHourlyFee());
        novo.setHourPayment(old.getHourPayment(), 1);

        undoEmployee(novo, old);
        return novo;
    }

    private static Commissioned undoCommissioned(Commissioned old){
        Commissioned novo = new Commissioned();

        novo.setSells(old.getSells(), 1);
        novo.setCommissionFee(old.getCommissionFee());

        undoEmployee(novo, old);
        return novo;
    }

    private static Salaried undoSalaried(Salaried old){
        Salaried novo = new Salaried();

        undoEmployee(novo, old);
        return novo;
    }

    private static void undoEmployee(Employees novo, Employees old){
        novo.setName(old.getName());
        novo.setEmployeeNumber(old.getEmployeeNumber());
        novo.setEmployeeStatus(old.getEmployeeStatus());
        novo.setType(old.getType());

        novo.setSyndicateMonthlyFee(old.getSyndicateMonthlyFee());
        novo.setSyndicateIs(old.getSyndicateIs());
        novo.setSyndicateNumber(old.getSyndicateNumber());
        novo.setSyndicateFee(old.getSyndicateFee(), 1);

        novo.setPaymentDelivery(old.getPaymentDelivery());
        novo.setPaymentPeriod(old.getPaymentPeriod());
        novo.setDayOfPayment(old.getDayOfPayment());
        novo.setDiscount(old.getDiscount(), 1);
        novo.setSalary(old.getSalary());

        novo.setAddress(old.getAddressNumber(), old.getAddressStreet(), old.getAddressCity(), old.getAddressState());
    }
}
