package kiosk.challenge.lv1;

import kiosk.challenge.lv1.menus.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<MenuItem> cart = new ArrayList<>();

    public List<MenuItem> getCart() {
        return cart;
    }

    public void addCart(MenuItem menuItem) {
        cart.add(menuItem);
    }

    public void showCartItems() {
        System.out.println("[ Orders ]");
        for (MenuItem item : cart) {
            System.out.println(item.getName() + " | W " + item.getPrice() + " | " + item.getExplain());
        }
    }

    public void getTotalPrice() {
        int totalPrice = 0;
        System.out.println("[ Total ]");
        for (MenuItem item : cart) {
            totalPrice += item.getPrice();
        }
        System.out.println("W " + totalPrice);
    }
}
