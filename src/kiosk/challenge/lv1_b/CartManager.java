package kiosk.challenge.lv1_b;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private final List<CartItem> cartItemList = new ArrayList<>();

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void addToCart(String itemName, int price) {
        for (CartItem cartItem : cartItemList) {
            if (cartItem.getItemName().equals(itemName)) {
                cartItem.incrementQuantity();
                return;
            }
        }
        cartItemList.add(new CartItem(itemName, price));
    }

    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (CartItem cartItem : cartItemList) {
            totalPrice += (cartItem.getPrice() * cartItem.getQuantity());
        }
        return totalPrice;
    }

    public void clearCart() {
        cartItemList.clear();
    }


}
