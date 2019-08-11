package com.company;

import com.payment.data.Commissioned;
import com.payment.data.Employees;
import com.payment.data.Hourly;
import com.payment.data.Salaried;

import java.util.ArrayList;
import java.util.Stack;

public class Copy {
    public static Working copyWorking(Working old){
        Working nova = new Working(false);
        nova.setEmployeeNumbers(old.getEmployeeNumbers());
        nova.setSemanadepagamentos(old.getSemanadePagamentos());
        nova.setSyndicateNumbers(old.getSyndicateNumbers());

        nova.setDate(copyData(old.getDate()));
        nova.setArrayList(copyArrayList(old.getArrayList()));
        nova.setPaymentsForwards(copyStack(old.getPaymentsForwards()));
        return nova;
    }

    private static CurrentData copyData(CurrentData old){
        CurrentData nova = new CurrentData(old.getOriginalDia(), old.getOriginalMes());
        return nova;
    }

    private static ArrayList<Employees> copyArrayList(ArrayList<Employees> old){
        ArrayList<Employees> novo = new ArrayList<>();

        for(Employees item : old){
            if (item == null){
                novo.add(null);
            }
            else if(item instanceof Hourly){
                novo.add(copyHourly( (Hourly) item ));
            }
            else if(item instanceof Commissioned){
                novo.add(copyCommissioned( (Commissioned) item ));
            }
            else if(item instanceof Salaried){
                novo.add(copySalaried( (Salaried) item ));
            }
            else System.out.println("ERROR IN UNDOARRAYLIST");
        }

        return novo;
    }

    private static Stack<Employees> copyStack(Stack<Employees> old){
        Stack<Employees> nova = new Stack<>();

        for (Employees emp : old){
            if (emp == null){
                nova.push(null);
            }
            else if(emp instanceof Hourly){
                nova.push(copyHourly( (Hourly) emp ));
            }
            else if(emp instanceof Commissioned){
                nova.push(copyCommissioned( (Commissioned) emp ));
            }
            else if(emp instanceof Salaried){
                nova.push(copySalaried( (Salaried) emp ));
            }
            else System.out.println("ERROR IN UNDOSTACK");
        }

        return nova;
    }

    private static Hourly copyHourly(Hourly old){
        Hourly novo = new Hourly();

        novo.setHourlyFee(old.getHourlyFee());
        novo.setHourPayment(old.getHourPayment(), 1);

        copyEmployee(novo, old);
        return novo;
    }

    private static Commissioned copyCommissioned(Commissioned old){
        Commissioned novo = new Commissioned();

        novo.setSells(old.getSells(), 1);
        novo.setCommissionFee(old.getCommissionFee());

        copyEmployee(novo, old);
        return novo;
    }

    private static Salaried copySalaried(Salaried old){
        Salaried novo = new Salaried();

        copyEmployee(novo, old);
        return novo;
    }

    private static void copyEmployee(Employees novo, Employees old){
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
