package kiosk.challenge.lv1_b;

public class CartItem {
    private String itemName;
    private int price;
    private int quantity;

    public CartItem(String itemName, int price) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = 1;
    }

    public String getItemName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void incrementQuantity() {
        quantity++;
    }

}
