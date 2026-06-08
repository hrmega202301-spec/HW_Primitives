import java.util.Scanner;

public class Main {

    public static int taxEarningMinusSpends(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15/ 100;
        if (tax >=0){
            return tax;
        } else {
            return 0;
        }
    }

    public static int simplifiedTaxationSystem(int earnings){
        int tax = (earnings / 100) * 6;
        if (tax >=0){
            return tax;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;
        int spendings = 0;
        while(true){
            System.out.println("Выберите операцию и введите ее номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            String input = scanner.nextLine();
            if ("end".equals(input)){
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation){
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода");
                    String dependStr = scanner.nextLine();
                    int depends = Integer.parseInt(dependStr);
                    spendings += depends;
                    break;
                case 3:
                    int taxIncomeMinusSpending = taxEarningMinusSpends(earnings, spendings);
                    int taxIncome = simplifiedTaxationSystem(earnings);
                    if (taxIncomeMinusSpending > taxIncome) {
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Ваш налог составит: " + taxIncome + " рублей");
                        System.out.println("Налог на другой системе: " + taxIncomeMinusSpending + " рублей");
                        System.out.println("Экономия: " + (taxIncomeMinusSpending - taxIncome) + " рублей");
                    } else if (taxIncomeMinusSpending < taxIncome) {
                        System.out.println("Мы советуем вам Доходы минус расходы");
                        System.out.println("Ваш налог составит: " + taxIncomeMinusSpending + " рублей");
                        System.out.println("Налог на другой системе: " + taxIncome + " рублей");
                        System.out.println("Экономия: " + (taxIncome - taxIncomeMinusSpending) + " рублей");
                    } else {
                        System.out.println("Вы можете выбрать любую систему налогообложения");
                        System.out.println("Ваш налог составит: " + taxIncome + " рублей");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
    }
}