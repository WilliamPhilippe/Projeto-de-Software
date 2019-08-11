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

        for (Employees emp : old){
            if (emp == null){
                novo.add(null);
            }
            else{
                novo.add(copyEmployee(emp));
            }
        }

        return novo;
    }

    private static Stack<Employees> copyStack(Stack<Employees> old){
        Stack<Employees> nova = new Stack<>();

        for (Employees emp : old){
            if (emp == null){
                nova.push(null);
            }
            else{
                nova.push(copyEmployee(emp));
            }
        }

        return nova;
    }

    private static Employees copyEmployee(Employees old){
        Employees novo = old.getNovoOfClass();

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

        novo.setOwnCopy(old);

        novo.setAddress(old.getAddressNumber(), old.getAddressStreet(), old.getAddressCity(), old.getAddressState());

        return novo;
    }
}
