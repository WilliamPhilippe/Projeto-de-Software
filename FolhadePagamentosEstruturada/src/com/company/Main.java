package com.company;

import java.util.Scanner;

public class Main {

    static int employeesNumber = 0;
    static int syndicatNumber = 0;
    static final int maxSize = 100;
    static int currentDay = 1;


    static String[] names = new String[100];
    static String[] types = new String[100];           // salaried or hourly or commissioned
    static boolean[] employeeStatus = new boolean[100];

    // SYNDICATE
    static int[] syndicateNumbers =  new int[100];
    static boolean[] syndicateIs = new boolean[100];
    static double[] syndicateFee = new double[100];
    static double[] syndicateMonthlyFee = new double[100];

    // PAYMENT
    static String[] paymentMethod = new String[100];           // monthly - weekly - twoweekly
    static int[] dayOfPayment = new int[100];                  // se for 0, eh o ultimo dia do mes | seg 2 sex 6
    static double[] salary = new double[100];
    static double[] sells = new double[100];
    static double[] commission = new double[100];
    static double[] discount = new double[100];
    static String[] paymentDelivery = new String[100];         // hands, mail, deposit

    // ADDRESS
    static String[] addressStreet = new String[100];
    static int[] addressNumber = new int[100];
    static String[] addressCity = new String[100];

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        while (true){
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Adicionar um empregado.");
            System.out.println("2 - Remover um empregado.");
            System.out.println("3 - Lancar um cartao de ponto.");
            System.out.println("4 - Lancar resultado de vendas.");
            System.out.println("5 - Lancar uma taxa de servico.");
            System.out.println("6 - Alterar detalhes de um empregado.");
            System.out.println("7 - Rodar folha de pagamento.");
            System.out.println("8 - Agenda de pagamento.");
            System.out.println("9 - Criar nova agenda de pagamentos.");
            System.out.println("10 - Definir taxa sindical.");
            System.out.println("11 - Refazer.");
            System.out.println("12 - Desfazer.");
            System.out.println("0 - Encerrar sistema.");


            int option = input.nextInt(); input.nextLine();

            switch (option){
                case 1:
                    addEmployee();
                    break;
                case 2:
                    removeEmployee();
                    break;
                case 3:
                    addTimecard();
                    break;
                case 4:
                    addSales();
                    break;
                case 5:
                    addFeeService();
                    break;
                case 6:
                    changeEmployeesDetails();
                    break;
                case 7:
                    runPayments();
                    break;
                case 8:
                    setPayment();
                    break;
                case 9:
                    newPaymentCalendar();
                    break;
                case 10:
                    setSyndicateFee();
                    break;
                case 11:
                    redo();
                    break;
                case 12:
                    undo();
                    break;
            }

            if(option == 0) break;
        }

    }

    public static void addEmployee(){

        if(employeesNumber >= maxSize - 1){
            System.out.println("Numero maximo de funcionarios atingido.");
            return;
        }
        else employeesNumber++;

        System.out.println("Digite o nome do funcionario: ");
        setName(employeesNumber, input.nextLine());
        setAddres(employeesNumber);

        System.out.println("Qual o tipo do empregado?\n" +
                "1 - Assalariado.\n" +
                "2 - Comissionado.\n" +
                "3 - Horista.\n" +
                "Digite um inteiro: ");

        int option = input.nextInt(); input.nextLine();
        if(option == 1){
            types[employeesNumber] = "salaried";

            System.out.println("Digite o salario mensal do empresario.");
            setSalary(employeesNumber, input.nextDouble()); input.nextLine();
            setEmployeeStatus(employeesNumber, true);
            paymentMethod[employeesNumber] = "monthly";
            paymentDelivery[employeesNumber] = "deposit";

            System.out.println("Numero do empregado: " + employeesNumber);
            System.out.println("Adicionado.");
        }
        if(option == 2){
            types[employeesNumber] = "commissioned";

            System.out.println("Digite o salario mensal do empresario.");
            setSalary(employeesNumber, input.nextDouble()); input.nextLine();
            System.out.println("Qual a comissao desse funcionario?");
            System.out.println("Ex: 0,02 para 2% de comissao.");
            setCommission(employeesNumber, input.nextDouble()); input.nextLine();
            paymentMethod[employeesNumber] = "twoweekly";
            dayOfPayment[employeesNumber] = 6;
            setEmployeeStatus(employeesNumber, true);
            paymentDelivery[employeesNumber] = "deposit";

            System.out.println("Numero do empregado: " + employeesNumber);
            System.out.println("Adicionado.");
        }
        if(option == 3){
            types[employeesNumber] = "hourly";

            System.out.println("Digite o pagamento por hora do funcionário.");
            setSalary(employeesNumber, input.nextDouble()); input.nextLine();
            setEmployeeStatus(employeesNumber, true);
            paymentMethod[employeesNumber] = "weekly";
            paymentDelivery[employeesNumber] = "deposit";
            dayOfPayment[employeesNumber] = 6;

            System.out.println("Numero do empregado: " + employeesNumber);
            System.out.println("Adicionado.");
        }
    }

    public static void removeEmployee(){}

    public static void addTimecard(){}

    public static void addSales(){}

    public static void addFeeService(){}

    public static void changeEmployeesDetails(){

    }

    public static void runPayments(){
        /* Todo:
         * Dia 30 rodar taxas mensais do sindicato.
         * Verificar se há taxas do sindicato a ser deduzidas.
         * Verificar deducoes de cada funcionario.
         * Usar resto de 7 e 30 para os dias.
         * To-do mes tem trinta dias.
         */
    }

    public static void setPayment(){}

    public static void newPaymentCalendar(){}

    public static void setSyndicateFee(){}

    public static void redo(){}

    public static void undo(){}

    public static void setName(int index, String name){
        names[index] = name;
    }

    public static void setAddres(int index){
        System.out.println("Definir endereço.");
        System.out.println("Rua: ");
        addressStreet[index] = input.nextLine();
        System.out.println("Numero: ");
        addressNumber[index] = input.nextInt(); input.nextLine();
        System.out.println("Cidade: ");
        addressCity[index] = input.nextLine();

        System.out.println();
        System.out.println("Endereco definido.");
    }

    public static void setSalary(int index, double salaryX){
        salary[index] = salaryX;
    }

    public static void setEmployeeStatus(int index, boolean bool){
        employeeStatus[index] = bool;
    }

    public static void setCommission(int index, double commissionX){
        commission[index] = commissionX;
    }

}
