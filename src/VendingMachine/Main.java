package VendingMachine;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String [] names={"Чай", "Кофе", "Какао", "Coca-cola","Fanta"};
        int [] prices = {100, 100, 150, 200, 150};
        byte [] buttons={1, 2, 3, 4, 5};
        Drinks [] drinks=new Drinks[names.length];
        for (int i = 0; i <drinks.length ; i++) {
            drinks[i]=new Drinks(names[i],prices[i],buttons[i]);
        }
        Arrays.sort(prices);
        Arrays.sort(buttons);
        byte button=0;
        int money=0;
        String str="";
        boolean isEnd=true;
        Scanner scan=new Scanner(System.in);
        while (true) {
            System.out.println("Введите депозит");
            try {
               money=Integer.parseInt(scan.next());
               if (money<prices[0]) {
                   System.out.println("Недостаточно средств");
               } else {
                   break;
               }
            } catch (NumberFormatException e) {
                System.out.println("Недопустимый ввод. Повторите.");
            }
        }
        condition:
        while (true) {
            System.out.println("Выберите напиток (указать номер кнопки):");
            System.out.println("Чай - Кнопка 1, Кофе - Кнопка 2, Какао - Кнопка 3, " +
                    "Coca-cola - Кнопка 4, Fanta - Кнопка 5");
            try {
                button=scan.nextByte();
                for (Drinks drink:drinks) {
                    if (button==drink.getButton()) {
                        System.out.printf("Получите %s", drink.getDrink());
                        System.out.println();
                        money-=drink.getPrice();
                        if (money>=prices[0]){
                            isEnd=true;
                            while (isEnd) {
                                System.out.println("Что-нибудь еще?");
                                System.out.println("ДА НЕТ");
                                str=scan.next();
                                if (str.equals("НЕТ")) {
                                    if (money>0){
                                        System.out.printf("Получите сдачу %d",money);
                                        System.out.println();
                                    }
                                    break condition;
                                } else if (str.equals("ДА")){
                                   isEnd=false;
                                } else  {
                                    System.out.println("Повторите ввод");
                                }
                            }
                        } else {
                            break condition;
                        }
                    } else if (button>buttons[buttons.length-1] || button<buttons[0]) {
                        System.out.println("Такого напитка нет в списке");
                        continue condition;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода. Повторите.");
            }
        }
    }
}
