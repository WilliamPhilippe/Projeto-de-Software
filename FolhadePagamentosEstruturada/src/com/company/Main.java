package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    static int employeesNumber = 0;
    static int aNTemployeesNumber = 0;

    static int syndicateNumber = 0;
    static int aNTsyndicateNumber = 0;
    static final int maxSize = 100;
    static final int maxDays = 100;
    static int cD = 1;
    static boolean semanadepagamento = false;

    static int[] enV = new int[maxSize];
    static int[] snV = new int[maxSize];

    static String[][] names = new String[maxDays][maxSize];
    static String[][] types = new String[maxDays][maxSize];           // salaried or hourly or commissioned
    static boolean[][] employeeStatus = new boolean[maxDays][maxSize];

    // SYNDICATE
    static int[][] syndicateNumbers =  new int[maxDays][maxSize];
    static boolean[][] syndicateIs = new boolean[maxDays][maxSize];
    static double[][] syndicateFee = new double[maxDays][maxSize];
    static double[][] syndicateMonthlyFee = new double[maxDays][maxSize];

    // PAYMENT
    static String[][] paymentMethod = new String[maxDays][maxSize];           // monthly - weekly - twoweekly
    static int[][] dayOfPayment = new int[maxDays][maxSize];                  // se for 0, eh o ultimo dia do mes | seg 2 sex 6
    static double[][] salary = new double[maxDays][maxSize];
    static double[][] hourFee = new double[maxDays][maxSize];
    static double[][] sells = new double[maxDays][maxSize];
    static double[][] commission = new double[maxDays][maxSize];
    static double[][] discount = new double[maxDays][maxSize];
    static String[][] paymentDelivery = new String[maxDays][maxSize];         // hands, mail, deposit

    // ADDRESS
    static String[][] addressStreet = new String[maxDays][maxSize];
    static int[][] addressNumber = new int[maxDays][maxSize];
    static String[][] addressCity = new String[maxDays][maxSize];
    static int last = 0;

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("ATENCAO: \n" +
                "Todo valor fracionario deve ser digitado com virgula.\n" +
                "Preste atencao as instrucoes em cada passo.\n" +
                "Todos os meses possuem 30 dias.\n" +
                "O programa comeca em um domingo, dia 1.\n");
        try { Thread.sleep (2000); } catch (InterruptedException ex) {}

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
            System.out.println("10 - Refazer.");
            System.out.println("11 - Desfazer.");
            System.out.println("0 - Encerrar sistema.");

            System.out.println("Dia atual: " + cD);
            int option = input.nextInt(); input.nextLine();
            if(option != 10) last = option;


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
                    setPayment();
                    break;
                case 10:
                    redo(last);
                    break;
                case 11:
                    undo();
                    break;
            }

            if(option == 0) break;

            try { Thread.sleep (2000); } catch (InterruptedException ex) {}
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
            types[cD][employeesNumber] = "salaried";

            System.out.println("Digite o salario mensal do funcionario.");
            setSalary(employeesNumber, input.nextDouble()); input.nextLine();
            setEmployeeStatus(employeesNumber, true);
            paymentMethod[cD][employeesNumber] = "monthly";
            paymentDelivery[cD][employeesNumber] = "deposit";

            System.out.println("Numero do empregado: " + employeesNumber);
            System.out.println("Adicionado.");
        }
        if(option == 2){
            types[cD][employeesNumber] = "commissioned";

            System.out.println("Digite o salario mensal do funcionario.");
            setSalary(employeesNumber, input.nextDouble()); input.nextLine();
            System.out.println("Qual a comissao desse funcionario?");
            System.out.println("Ex: 0,02 para 2% de comissao.");
            setCommission(employeesNumber, input.nextDouble()); input.nextLine();
            paymentMethod[cD][employeesNumber] = "twoweekly";
            dayOfPayment[cD][employeesNumber] = 6;
            setEmployeeStatus(employeesNumber, true);
            paymentDelivery[cD][employeesNumber] = "deposit";

            System.out.println("Numero do empregado: " + employeesNumber);
            System.out.println("Adicionado.");
        }
        if(option == 3){
            types[cD][employeesNumber] = "hourly";

            System.out.println("Digite o pagamento por hora do funcionário Ex: 12,34.");
            hourFee[cD][employeesNumber] = input.nextDouble(); input.nextLine();
            setEmployeeStatus(employeesNumber, true);
            paymentMethod[cD][employeesNumber] = "weekly";
            paymentDelivery[cD][employeesNumber] = "deposit";
            dayOfPayment[cD][employeesNumber] = 6;

            System.out.println("Numero do empregado: " + employeesNumber);
            System.out.println("Adicionado.");
        }
    }

    public static void removeEmployee(){
        int employee = searchEmployee();
        if (employee != 0){
            setEmployeeStatus(employee, false);
            System.out.println("Empregado removido.");
        }
    }

    public static void addTimecard(){
        System.out.println("Primeiro selecione o empregado.");
        int employee = searchEmployee();
        if (employee == 0){ return; }
        if(types[cD][employee].intern() != "hourly"){
            System.out.println("Funcionario nao e horista.");
            return;
        }

        if(employeeStatus[cD][employee] == false){
            System.out.println("Funcionario ja demitido.");
            return;
        }

        System.out.println("Atencao, o horario de entrada deve ser inferior ao de saida.\n" +
                "Formato 24 horas.\n");
        System.out.println("Digite a hora de entrada no formato HH:mm:ss");
        String hIn = input.nextLine();
        System.out.println("Digite a hora de saida no formato: HH:mm:ss");
        String hOut = input.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        double diff = 0;
        try {
            Date horaIni = sdf.parse(hIn);
            Date horaFim = sdf.parse(hOut);

            long horaI = horaIni.getTime();
            long horaF = horaFim.getTime();

            diff = (double) (horaF - horaI)/(1000*60*60);
        }
        catch(Exception ex){
            System.out.println("Ocorreu um erro ao calcular as horas.");
        }

        double s = 0;

        if(diff < 0) {
            System.out.println("Hora inicial maior que hora final.");
            return;
        }
        else if(diff > 8){
            s = 8*hourFee[cD][employee] + (diff - 8)*hourFee[cD][employee]*1.5;
        }
        else{
            s = diff * hourFee[cD][employee];
        }

        salary[cD][employee] += s;
        System.out.println("Pagamento adicionado. RS: " + s);

    }

    public static void addSales(){
        System.out.println("Primeiro selecione o empregado.");
        int employee = searchEmployee();
        if (employee == 0){ return; }
        if(types[cD][employee].intern() != "commissioned"){
            System.out.println("Funcionario nao e comissionado.");
            return;
        }

        if(employeeStatus[cD][employee] == false){
            System.out.println("Funcionario ja demitido.");
            return;
        }

        double vendas = 0;
        System.out.println("Digite o valor das vendas. Ex: 1512,02");
        vendas = input.nextDouble(); input.nextLine();

        sells[cD][employee] += vendas * commission[cD][employee];
        System.out.println("Total de RS " + (vendas * commission[cD][employee]) +
                " adicionados.");
    }

    public static void addFeeService(){
        System.out.println("Primeiro selecione o empregado.");
        int employee = searchEmployee();
        if (employee == 0){ return; }
        if(employeeStatus[cD][employee] == false){
            System.out.println("Funcionario ja demitido.");
            return;
        }

        double deducao = 0;
        System.out.println("Digite o valor a ser descontado do salario do empregado. Ex: 12,31");
        deducao = input.nextDouble(); input.nextLine();

        discount[cD][employee] -= deducao;
        System.out.println("Valor descontado.");
    }

    public static void changeEmployeesDetails(){
        System.out.println("Primeiro selecione o empregado.");
        int employee = searchEmployee();
        if (employee == 0){ return; }
        if(employeeStatus[cD][employee] == false){
            System.out.println("Funcionario ja demitido.");
            return;
        }

        System.out.println("O que voce quer alterar?\n" +
                "1 - Nome\n" +
                "2 - Endereco\n" +
                "3 - Tipo\n" +
                "4 - Metodo de pagamento\n" +
                "5 - Cadastrar/Descadastrar do sindicato\n");

        int option = input.nextInt(); input.nextLine();

        switch (option){
            case 1:
                System.out.println("Digite o novo nome: ");
                setName(employee, input.nextLine());
                break;
            case 2:
                setAddres(employee);
                break;
            case 3:
                changeType(employee);
                break;
            case 4:
                setPaymentMethod(employee);
                break;
            case 5:
                setSyndicate(employee);
                break;
            default:
                System.out.println("opcao invalida");
                return;
        }

        System.out.println("Mudancas finalizadas.");
    }

    public static void setPaymentMethod(int index){
        System.out.println("Voce deseja alterar o pagamento para: \n" +
                "1 - Cheque\n" +
                "2 - Deposito\n" +
                "3 - Em maos\n");
        int option = input.nextInt(); input.nextLine();

        switch (option){
            case 1:
                paymentDelivery[cD][index] = "mail";
                break;
            case 2:
                paymentDelivery[cD][index] = "deposit";
                break;
            case 3:
                paymentDelivery[cD][index] = "hands";
                break;
            case 4:
                System.out.println("Opcao invalida");
                return;
        }

        System.out.println("Metodo alterado.");
    }

    public static void runPayments(){
        /* Todo:
         * Dia 30 rodar taxas mensais do sindicato.
         * Verificar se há taxas do sindicato a ser deduzidas.
         * Verificar deducoes de cada funcionario.
         * Usar resto de 7 e 30 para os dias.
         * To-do mes tem trinta dias.
         */

        int diadaSemana = cD % 7;
        int diadoMes = cD % 30;
        boolean diaUtil = false;
        boolean ultDiaUtil = false;

        //E dia util?
        if( diadaSemana > 1 ){
            diaUtil = true;
            if(diadoMes == 0 || (diadoMes == 29 && diadaSemana == 6)
                    || (diadoMes == 28 && diadaSemana == 6) )
            {
                ultDiaUtil = true;
            }
        }

        // pagamentos semanais

        for(int i = 1; i < maxSize; i++){
            if(employeeStatus[cD][i] == false){ continue; }

            if(paymentMethod[cD][i] != null && paymentMethod[cD][i] == "weekly" && dayOfPayment[cD][i] == diadaSemana){
                if(types[cD][i].intern() == "salaried"){
                    System.out.println("Funcionario " + names[cD][i] + "\n" +
                            "Pagamento referente a uma semana de trabalho.\n" +
                            "Total: RS " + (salary[cD][i]/4 - discount[cD][i]));

                    System.out.println("Discontado: RS " + discount[cD][i]);

                    if(diadoMes > 23 ) System.out.println("Taxa sindical a ser paga: " +
                            syndicateMonthlyFee[cD][i]);

                    printDelivery(i);

                    discount[cD][i] = 0;
                }
                else if(types[cD][i].intern() == "commissioned"){
                    System.out.println("Funcionario " + names[cD][i] + "\n" +
                            "Pagamento referente a uma semana de trabalho.\n");

                    System.out.println("Salario referente: RS " + salary[cD][i]/4 +
                            "Vendas: RS " + sells[cD][i] + "\n" +
                            "Disconto: RS " + discount[cD][i] + "\n" +
                            "Total a receber: RS " + (salary[cD][i]/4 + sells[cD][i] - discount[cD][i]));

                    if(diadoMes > 23 ) System.out.println("Taxa sindical a ser paga: " +
                            syndicateMonthlyFee[cD][i]);

                    printDelivery(i);

                    sells[cD][i] = 0;
                    discount[cD][i] = 0;
                }
                else if(types[cD][i].intern() == "hourly"){
                    System.out.println("Funcionario " + names[cD][i] + "\n" +
                            "Pagamento referente a uma semana de trabalho.\n");

                    System.out.println("Salario da semana: RS " + salary[cD][i] + "\n" +
                            "Discontado: RS " + discount[cD][i] + "\n" +
                            "Total a receber: RS " + (salary[cD][i] - discount[cD][i]) );

                    if(diadoMes > 23 ) System.out.println("Taxa sindical a ser paga: " +
                            syndicateMonthlyFee[cD][i]);

                    printDelivery(i);

                    salary[cD][i] = 0;
                    discount[cD][i] = 0;
                }
                else System.out.println("ERRRRRROOOOO de tipo");
            }
        }

        // pagamentos bisemanais

        if(semanadepagamento){
            for(int i = 1; i < maxSize; i++){
                if(employeeStatus[cD][i] == false){ continue; }

                if(paymentMethod[cD][i] != null && paymentMethod[cD][i] == "twoweekly" && dayOfPayment[cD][i] == diadaSemana){
                    if(types[cD][i].intern() == "salaried"){
                        System.out.println("Funcionario " + names[cD][i] + "\n" +
                                "Pagamento referente a duas semanas de trabalho.\n" +
                                "Total: RS " + (salary[cD][i]/2 - discount[cD][i]) );

                        System.out.println("Discontado: RS " + discount[cD][i]);

                        if(diadoMes > 15 ) System.out.println("Taxa sindical a ser paga: " +
                                syndicateMonthlyFee[cD][i]);

                        printDelivery(i);

                        discount[cD][i] = 0;
                    }
                    else if(types[cD][i].intern() == "commissioned"){
                        System.out.println("Funcionario " + names[cD][i] + "\n" +
                                "Pagamento referente a duas semanas de trabalho.\n");

                        System.out.println("Salario referente: RS " + salary[cD][i]/2 +
                                "Vendas: RS " + sells[cD][i] + "\n" +
                                "Disconto: RS " + discount[cD][i] + "\n" +
                                "Total a receber: RS " + (salary[cD][i]/2 + sells[cD][i] - discount[cD][i]));

                        if(diadoMes > 15 ) System.out.println("Taxa sindical a ser paga: " +
                                syndicateMonthlyFee[cD][i]);

                        printDelivery(i);

                        sells[cD][i] = 0;
                        discount[cD][i] = 0;
                    }
                    else if(types[cD][i].intern() == "hourly"){
                        System.out.println("Funcionario " + names[cD][i] + "\n" +
                                "Pagamento referente a duas semanas de trabalho.\n");

                        System.out.println("Salario das semanas: RS " + salary[cD][i] + "\n" +
                                "Discontado: RS " + discount[cD][i] + "\n" +
                                "Total a receber: RS " + (salary[cD][i] - discount[cD][i]) );

                        if(diadoMes > 15 ) System.out.println("Taxa sindical a ser paga: " +
                                syndicateMonthlyFee[cD][i]);

                        printDelivery(i);

                        salary[cD][i] = 0;
                        discount[cD][i] = 0;
                    }
                    else System.out.println("ERRRRRROOOOO de tipo");
                }
            }
        }
        else{
            semanadepagamento = true;
        }

        // pagamentos mensais
        for(int i = 1; i < maxSize; i++){
            if(employeeStatus[cD][i] == false){ continue; }

            if(paymentMethod[cD][i] != null && paymentMethod[cD][i] == "monthly" && dayOfPayment[cD][i] == diadoMes){
                if(types[cD][i].intern() == "salaried"){
                    System.out.println("Funcionario " + names[cD][i] + "\n" +
                            "Pagamento referente a um mes de trabalho.\n" +
                            "Total: RS " + (salary[cD][i] - discount[cD][i]) );

                    System.out.println("Discontado: RS " + discount[cD][i]);

                    System.out.println("Taxa sindical a ser paga: " +
                            syndicateMonthlyFee[cD][i]);

                    printDelivery(i);

                    discount[cD][i] = 0;
                }
                else if(types[cD][i].intern() == "commissioned"){
                    System.out.println("Funcionario " + names[cD][i] + "\n" +
                            "Pagamento referente a um mes de trabalho.\n");

                    System.out.println("Salario referente: RS " + salary[cD][i] +
                            "Vendas: RS " + sells[cD][i] + "\n" +
                            "Disconto: RS " + discount[cD][i] + "\n" +
                            "Total a receber: RS " + (salary[cD][i] + sells[cD][i] - discount[cD][i]));

                    System.out.println("Taxa sindical a ser paga: " +
                            syndicateMonthlyFee[cD][i]);

                    printDelivery(i);

                    sells[cD][i] = 0;
                    discount[cD][i] = 0;
                }
                else if(types[cD][i].intern() == "hourly"){
                    System.out.println("Funcionario " + names[cD][i] + "\n" +
                            "Pagamento referente a um mes de trabalho.\n");

                    System.out.println("Salario da semana: RS " + salary[cD][i] + "\n" +
                            "Discontado: RS " + discount[cD][i] + "\n" +
                            "Total a receber: RS " + (salary[cD][i] - discount[cD][i]) );

                     System.out.println("Taxa sindical a ser paga: " +
                            syndicateMonthlyFee[cD][i]);

                    printDelivery(i);

                    salary[cD][i] = 0;
                    discount[cD][i] = 0;
                }
                else System.out.println("ERRRRRROOOOO de tipo");
            }
        }

        copy();

        System.out.println("\n\nPagamentos efetuados. \nDia avancado.");
    }

    public static void setPayment(){
        System.out.println("Primeiro selecione o empregado.");
        int employee = searchEmployee();
        if (employee == 0){ return; }
        if(!employeeStatus[cD][employee]){
            System.out.println("Funcionario ja demitido.");
            return;
        }

        System.out.println("Esse funcionario vai receber: \n" +
                "1 - Semanalmente\n" +
                "2 - Bi-semanalmente\n" +
                "3 - Mensalmente\n");

        int option = input.nextInt(); input.nextLine();

        if (option == 1){
            paymentMethod[cD][employee] = "weekly";

            System.out.println("Qual dia?\n" +
                    "2-SEG 3-TER 4-QUA 5-QUI 6-SEX");
            option = input.nextInt(); input.nextLine();

            dayOfPayment[cD][employee] = option;
        }
        else if(option == 2){
            paymentMethod[cD][employee] = "twoweekly";

            System.out.println("Qual dia?\n" +
                    "2-SEG 3-TER 4-QUA 5-QUI 6-SEX");
            option = input.nextInt(); input.nextLine();

            dayOfPayment[cD][employee] = option;
        }
        else if(option == 3){
            paymentMethod[cD][employee] = "monthly";

            System.out.println("Qual dia? 0 para o ultimo dia ate dia 29.");
            option = input.nextInt(); input.nextLine();
            dayOfPayment[cD][employee] = option;
        }

        System.out.println("Agenda de pagamento alterada.");
    }

    public static void setSyndicate(int index){
        syndicateNumber++;
        syndicateIs[cD][index] = true;
        syndicateNumbers[cD][index] = syndicateNumber;

        System.out.println("Adicione a taxa mensal sindical. Ex: 1234,56");
        syndicateMonthlyFee[cD][index] = input.nextDouble(); input.nextLine();

        System.out.println("Adicionado ao sindicato.\n" +
                "ID Sindical: " + syndicateNumber);
    }

    public static void redo(int option){
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
                setPayment();
                break;
            case 10:
                break;
            case 11:
                undo();
                break;
        }
    }

    public static void undo(){
        cD--;
        syndicateNumber = snV[cD];
        employeesNumber = enV[cD];
        System.out.println("Desfeito.");
    }

    public static void setName(int index, String name){
        names[cD][index] = name;
    }

    public static void setAddres(int index){
        System.out.println("Definir endereço.");
        System.out.println("Rua: ");
        addressStreet[cD][index] = input.nextLine();
        System.out.println("Numero: ");
        addressNumber[cD][index] = input.nextInt(); input.nextLine();
        System.out.println("Cidade: ");
        addressCity[cD][index] = input.nextLine();

        System.out.println();
        System.out.println("Endereco definido.");
    }

    public static void setSalary(int index, double salaryX){
        salary[cD][index] = salaryX;
    }

    public static void setEmployeeStatus(int index, boolean bool){
        employeeStatus[cD][index] = bool;
    }

    public static void setCommission(int index, double commissionX){
        commission[cD][index] = commissionX;
    }

    public static int searchEmployee(){
        System.out.println("Voce deseja selecionar o empregado por (1) nome ou por (2) numero?");
        int option = input.nextInt(); input.nextLine();
        if(option == 1){
            System.out.println("Digite o nome completo: ");
            String tempName = input.nextLine();
            for(int i = 1; i < 100; i++){
                if(names[cD][i] != null && names[cD][i].intern() == tempName.intern()) return i;
            }
            System.out.println("Nao encontrado. Nao existe ou nome errado.");
            return 0;
        }
        else if(option == 2) {
            System.out.println("Digite o numero: ");
            int n = input.nextInt();
            input.nextLine();
            if (!employeeStatus[cD][n]) {
                System.out.println("Usuario nao encontrado.");
                return 0;
            } else {
                System.out.println("Funcionaio: " + names[cD][n]);
                return n;
            }
        }
        else System.out.println("Opcao invalida.");
        return 0;
    }

    public static void changeType(int index){
        System.out.println("Qual o novo tipo do funcionario?\n" +
                "1 - Assalariado\n" +
                "2 - Commissionado\n" +
                "3 - Horista\n");

        int option = input.nextInt(); input.nextLine();

        if(option == 1){
            System.out.println("Digite o novo salario mensal do empregado. Ex: 123,45");
            setSalary(index, input.nextDouble()); input.nextLine();

            types[cD][index] = "salaried";
            paymentMethod[cD][index] = "monthly";
            System.out.println("Tipo alterado para assalariado.");
        }
        else if(option == 2){
            types[cD][index] = "commissioned";
            System.out.println("Qual a comissao desse funcionario?");
            System.out.println("Ex: 0,02 para 2% de comissao.");
            setCommission(index, input.nextDouble()); input.nextLine();
            paymentMethod[cD][index] = "twoweekly";
            dayOfPayment[cD][index] = 6;

            System.out.println("Tipo alterado para comissionado.");
        }
        else if(option == 3){
            types[cD][index] = "hourly";

            System.out.println("Digite o pagamento por hora do funcionário Ex: 12,34.");
            hourFee[cD][index] = input.nextDouble(); input.nextLine();
            paymentMethod[cD][index] = "weekly";
            paymentDelivery[cD][index] = "deposit";
            dayOfPayment[cD][index] = 6;

            System.out.println("Tipo alterado para horista.");
        }
        else System.out.println("Opcao invalida.");
    }

    public static void printDelivery(int index){
        if(paymentDelivery[cD][index] == "mail"){
            System.out.println("O cheque foi enviado pelos correios.");
        }
        else if(paymentDelivery[cD][index] == "hands"){
            System.out.println("Pagamento sera feito em maos no RH.");
        }
        else if(paymentDelivery[cD][index] == "deposit"){
            System.out.println("Pagamento ja foi depositado na conta do funcionario.");
        }
        else System.out.println("ERRRO EM PRINTDELIVERY");
    }

    public static void copy(){

        snV[cD] = syndicateNumber;
        enV[cD] = employeesNumber;

        cD++;
        for(int i = 1; i <= employeesNumber; i++){
            names[cD][i] = names[cD - 1][i].intern();
            types[cD][i] = types[cD - 1][i].intern();
            paymentMethod[cD][i] = paymentMethod[cD - 1][i].intern();
            paymentDelivery[cD][i] = paymentDelivery[cD - 1][i].intern();
            addressCity[cD][i] = addressCity[cD - 1][i].intern();
            addressStreet[cD][i] = addressStreet[cD - 1][i].intern();

            employeeStatus[cD][i] = employeeStatus[cD - 1][i];
            syndicateNumbers[cD][i] = syndicateNumbers[cD - 1][i];
            syndicateIs[cD][i] = syndicateIs[cD - 1][i];
            syndicateFee[cD][i] = syndicateFee[cD - 1][i];
            syndicateMonthlyFee[cD][i] = syndicateMonthlyFee[cD - 1][i];
            dayOfPayment[cD][i] = dayOfPayment[cD - 1][i];
            salary[cD][i] = salary[cD - 1][i];
            hourFee[cD][i] = hourFee[cD - 1][i];
            sells[cD][i] = sells[cD - 1][i];
            commission[cD][i] = commission[cD - 1][i];
            discount[cD][i] = discount[cD - 1][i];
            addressNumber[cD][i] = addressNumber[cD - 1][i];
        }
    }

}
