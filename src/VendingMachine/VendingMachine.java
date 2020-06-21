package VendingMachine;

import java.util.Scanner;

import static VendingMachine.Drink.*;

public class VendingMachine {
    public int money;
    final int MIN_PRICE=TEA.getPrice();
    Scanner scan=new Scanner(System.in);

    /* Add user's money. Return true and initialise money for further methods if money is more than minimal drink's price.
     */
    public boolean addMoney (int money) {
        if (money<MIN_PRICE) {
            System.out.println("Недостаточно средств");
            return false;
        } else{
            this.money=money;
            return true;
        }
    }

    /* Return selected drink depending on choice of button. If there's not input button it's required to repeat input.
    Handle exception of incorrect input (ex. words instead of number).
    */
    public Drink getOrder (){
        Drink [] drinks={TEA,COFEE,CACAO,COLA,FANTA};
        Drink selectedDrink=TEA;
        int button;
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

    /* Interact with user: give drink, show money balance, offer to repeat order, return money change.
    * */
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
