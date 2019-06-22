package com.company;

import com.ExceptionsOwn.EqualsTypeExcepion;
import com.ExceptionsOwn.SearchFailureException;
import com.payment.data.Commissioned;
import com.payment.data.Employees;
import com.payment.data.Hourly;
import com.payment.data.Salaried;

import java.util.ArrayList;

public class Edit {

    public static void edition(Working company){
        System.out.println("Selecione o empregado.");
        Employees emp;
        try {
            emp = Tools.search(company.getArrayList());
        }
        catch (SearchFailureException e){
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("\nO que deseja alterar?\n" +
                "1 - Nome.\n" +
                "2 - Endereco.\n" +
                "3 - Tipo.\n" +
                "4 - Recebimento do pagamento.\n" +
                "5 - Cadastrar/Descadastrar do sindicato.\n" +
                "6 - Taxa mensal sindical.\n");

        int option = Tools.selectOption(1, 6);

        switch (option){
            case 1:
                emp.setName();
                break;
            case 2:
                emp.setAddress();
                break;
            case 3:
                changeType(emp, company.getArrayList());
                break;
            case 4:
                setPaymentDelivery(emp);
                break;
            case 5:
                setSyndicate(emp, company);
                break;
            case 6:
                setSyndicateMonthlyFee(emp);
                break;
        }

    }

    private static void changeType(Employees emp, ArrayList<Employees> employees){
        System.out.println("Este funcionario eh do tipo " + emp.getType());

        while (true) {
            System.out.println("Qual o novo tipo?\n" +
                    "1 - Assalariado.\n" +
                    "2 - Comissionado.\n" +
                    "3 - Horista");

            int option = Tools.selectOption(1, 3);
            Employees newEmp = null;

            try {

                if (option == 1) {
                    if (emp.getType().equals("salaried")) throw new EqualsTypeExcepion("assalariado.");

                    newEmp = new Salaried();
                    newEmp.setName(emp.getName());
                    newEmp.setType("salaried");
                    newEmp.setSalary();
                    newEmp.setEmployeeStatus(true);
                    newEmp.setEmployeeNumber(emp.getEmployeeNumber());
                    newEmp.setPaymentPeriod("monthly");
                    newEmp.setDayOfPayment(0);
                    newEmp.setPaymentDelivery("deposit");
                    newEmp.setAddress(emp.getAddressNumber(), emp.getAddressStreet(), emp.getAddressCity(), emp.getAddressState());
                }
                if (option == 2) {
                    if (emp.getType().equals("commissioned")) throw new EqualsTypeExcepion("comissionado.");

                    newEmp = new Commissioned();
                    newEmp.setName(emp.getName());
                    newEmp.setType("commissioned");
                    newEmp.setSalary();
                    ((Commissioned) newEmp).setCommissionFee();
                    newEmp.setEmployeeStatus(true);
                    newEmp.setEmployeeNumber(emp.getEmployeeNumber());
                    newEmp.setPaymentPeriod("twoweekly");
                    newEmp.setDayOfPayment(6);
                    newEmp.setPaymentDelivery("deposit");
                    newEmp.setAddress(emp.getAddressNumber(), emp.getAddressStreet(), emp.getAddressCity(), emp.getAddressState());
                }
                if (option == 3) {
                    if (emp.getType().equals("hourly")) throw new EqualsTypeExcepion("horista.");

                    newEmp = new Hourly();
                    newEmp.setName(emp.getName());
                    newEmp.setType("hourly");
                    ((Hourly) newEmp).setHourlyFee();
                    newEmp.setEmployeeStatus(true);
                    newEmp.setEmployeeNumber(emp.getEmployeeNumber());
                    newEmp.setPaymentPeriod("weekly");
                    newEmp.setDayOfPayment(6);
                    newEmp.setPaymentDelivery("deposit");
                    newEmp.setAddress(emp.getAddressNumber(), emp.getAddressStreet(), emp.getAddressCity(), emp.getAddressState());
                }

                int index = employees.indexOf(emp);
                employees.set(index, newEmp);

                System.out.println("Empregado modificado com sucesso.\n" + employees.get(index).toString());
                break;
            }
            catch (EqualsTypeExcepion e) {
                System.out.println("Este funcionario ja eh um " + e.getMessage());
                System.out.println("Escolha um tipo diferente.");
            }
            catch (NullPointerException e){
                System.out.println(e.getMessage());
                System.out.println("Tente novamente.");
            }
        }

    }

    private static void setSyndicate(Employees emp, Working company){
        if(emp.getSyndicateIs()){
            System.out.println("O funcionario sera removido do sindicato.\n" +
                    "1 - Confirmar | 0 - Cancelar");
            int option = Tools.selectOption(0, 1);
            if (option == 0){
                System.out.println("Operacao cancelada.");
                return;
            }

            emp.setSyndicateIs(false);
            emp.setSyndicateMonthlyFee(0);
            emp.setSyndicateNumber(0);
            System.out.println("Descadastrado.\n" +
                    "Se o funcionario ainda devia algo ao sindicato sera abatido do proximo pagamento.");
        }
        else{
            company.incrementSyndicateNumber(1);

            emp.setSyndicateNumber(company.getSyndicateNumbers());
            emp.setSyndicateMonthlyFee();
            emp.setSyndicateIs(true);

            System.out.println("Cadastrado no sindicato.\n" +
                    "Numero sindical: " + company.getSyndicateNumbers());
        }
    }

    private static void setPaymentDelivery(Employees emp){
        System.out.println("O funcionario vai receber por\n" +
                "1 - Deposito bancario.\n" +
                "2 - Cheque em maos.\n" +
                "3 - Cheque por correios.\n");

        int option = Tools.selectOption(1, 3);

        if (option == 1) emp.setPaymentDelivery("deposit");
        if (option == 2) emp.setPaymentDelivery("hands");
        if (option == 3) emp.setPaymentDelivery("mail");

        System.out.println("Recebimento de pagamento alterado.");
    }

    private static void setSyndicateMonthlyFee(Employees emp){
        System.out.println("Digite a taxa sindical mensal. Ex: 133,12");
        emp.setSyndicateMonthlyFee(Tools.readDouble("Ex: 123,12"));
        System.out.println("Taxa sindical mensal alterada.");
    }

}
