package VendingMachine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        VendingMachine vm=new VendingMachine();

        String choice="";
        int money=0;

        Scanner scan=new Scanner(System.in);
        while (true) {
            System.out.println("Введите депозит");
            try {
               money=Integer.parseInt(scan.next());
               if (vm.addMoney(money)) break;
            } catch (NumberFormatException e) {
                System.out.println("Недопустимый ввод. Повторите.");
            }
        }

        do {
            Drink drink=vm.getOrder();
            choice=vm.takeDrink(drink);
        }
        while (!choice.equals("НЕТ") && !choice.equals("Недостаточно средств"));
    }
}
