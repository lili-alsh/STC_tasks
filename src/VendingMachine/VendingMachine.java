package VendingMachine;

import java.util.Scanner;

import static VendingMachine.Drink.*;

public class VendingMachine {
    public int money;
    final int MIN_PRICE=TEA.getPrice();
    Scanner scan=new Scanner(System.in);

    public boolean addMoney (int money) {
        if (money<MIN_PRICE) {
            System.out.println("Недостаточно средств");
            return false;
        } else{
            this.money=money;
            return true;
        }
    }

    public Drink getOrder (){
        Drink [] drinks={TEA,COFEE,CACAO,COLA,FANTA};
        Drink selectedDrink=TEA;
        int button=0;
        boolean noDrink=true;
        do {
            try {
                System.out.println("Выберите напиток:");
                for (Drink drink:drinks) {
                    System.out.println(drink.getTitle() +" кнопка  "+ drink.getButton());
                }
                button=Integer.parseInt(scan.next());
                for (Drink drink:drinks) {
                    if (button==drink.getButton()) {
                        selectedDrink=drink;
                        noDrink=false;
                        break;
                    }
                }
                if (noDrink) {
                    System.out.println("Такого напитка нет");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода. Повторите.");
            }
        }
        while (noDrink);
      return selectedDrink;
    }

    public String takeDrink(Drink drink) {
        String str="";
        if (money>=drink.getPrice()) {

            while (!str.equals("ДА") && !str.equals("НЕТ")) {
                System.out.println("Что-нибудь еще?");
                System.out.println("ДА НЕТ");
                str=scan.next();
            }
            money-=drink.getPrice();
            System.out.printf("Получите %s", drink.getTitle());
            System.out.println();

            if (str.equals("НЕТ")) {
                System.out.printf("Получите сдачу %d",money);
                System.out.println();
                return "НЕТ";
            } else  {
                return "ДА";
            }
        } else {
            if ((money+drink.getPrice())>0) {
                System.out.printf("Получите сдачу %d",money+drink.getPrice());
                System.out.println();
            }
            return "Недостаточно средств";
        }
    }
}
