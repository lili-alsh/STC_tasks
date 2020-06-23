package VendingMachine;

import java.util.Arrays;
import java.util.Scanner;

public class VendingMachine {
    public double money;
    private Drink[] drinks;

    public VendingMachine(Drink[] drinks) {
        this.drinks = drinks;
    }

    Scanner scan=new Scanner(System.in);

    private double minPrice() {
        double [] drinkPrices=new double[drinks.length];
        for (int i = 0; i <drinks.length ; i++) {
            drinkPrices[i]=drinks[i].getPrice();
        }
        Arrays.sort(drinkPrices);
        return drinkPrices[0];
    }

    /* Add user's money. If money is less than minimal price of drink, it is necessary to repeat input of deposit.
     */
    public void addMoney () {
        while (true) {
            System.out.println("Введите депозит");
            try {
                money=Integer.parseInt(scan.next());
                if (money < minPrice()) {
                    System.out.println("Недостаточно средств");
                } else{
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Недопустимый ввод. Повторите.");
            }
        }
    }

    /* Return button depending. If there's not input button it's required to repeat input.
    Handle exception of incorrect input (ex. words instead of number).
    */
    private int getOrder (){
        int button=0;
        do {
            try {
                System.out.println("Выберите напиток:");
                for (Drink drink:drinks) {
                    System.out.println(drink.getTitle() +" кнопка  "+ drink.getButton());
                }
                button=Integer.parseInt(scan.next());
                for (Drink drink:drinks) {
                    if (button==drink.getButton()) {
                        return button;
                    }
                }
                System.out.println("Такого напитка нет");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода. Повторите.");
            }
        }
        while (true);
    }

    /* Interact with user: give drink, show money balance, offer to repeat order, return money change.
    * */
    public void takeDrink() {
        int button=getOrder();
        String str="";
        for (Drink drink:drinks) {
            if (drink.getButton()==button) {
                if (money>=drink.getPrice()) {
                    money-=drink.getPrice();
                    System.out.printf("Получите %s", drink.getTitle());
                    System.out.println();

                    if (money>=minPrice()){
                        while (!str.equals("ДА") && !str.equals("НЕТ")) {
                            System.out.println("Остаток на счете " + money);
                            System.out.println("Что-нибудь еще?");
                            System.out.println("ДА НЕТ");
                            str=scan.next();
                        }
                        if (str.equals("НЕТ")) {
                            System.out.println("Получите сдачу "+ money);
                            break;
                        } else {
                            System.out.println("Рекурсия");
                            takeDrink();
                        }
                    } else if (money>0){
                        System.out.println("Получите сдачу "+ money);
                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }
}
