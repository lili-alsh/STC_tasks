package VendingMachine;

public enum Drink {
    TEA("Чай", 100, 1), COFEE ("Кофе", 100, 2), CACAO ("Какао", 150,3),
    COLA ("Кока-кола", 200,4), FANTA ("Фанта", 200, 5);

    private String title;
    private int price;
    private int button;

    Drink(String title, int price, int button) {
        this.title = title;
        this.price = price;
        this.button = button;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public int getButton() {
        return button;
    }
}
