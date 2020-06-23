package VendingMachine;

public class Main {
    public static void main(String[] args) {

        Drink[] hotDrinks={new HotDrink("Чай", 100, 1),
                new HotDrink("Кофе", 100, 2),
                new HotDrink("Какао", 150, 3)};

        Drink[] coldDrinks={new ColdDrink("Кока-кола", 200, 1),
                new ColdDrink("Фанта", 200, 2),
                new ColdDrink("Квас", 250, 3)};

        VendingMachine vmHotDrink=new VendingMachine(hotDrinks);
        VendingMachine vmColdDrink=new VendingMachine(coldDrinks);

        vmHotDrink.addMoney();
        vmHotDrink.takeDrink();
    }
}
