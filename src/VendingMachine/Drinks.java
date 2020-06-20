package VendingMachine;

public class Drinks {
    private String drink;
    private int price;
    private byte button;

    public Drinks(String drink, int price, byte button) {
        this.drink = drink;
        this.price = price;
        this.button=button;
    }

    public String getDrink() {
        return drink;
    }

    public int getPrice() {
        return price;
    }

    public byte getButton() {
        return button;
    }
}
