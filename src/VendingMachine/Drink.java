package VendingMachine;

public abstract class Drink {
    protected String title;
    protected double price;
    protected int button;

    public Drink(String title, double price, int button) {
        this.title = title;
        this.price = price;
        this.button = button;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getButton() {
        return button;
    }
}
