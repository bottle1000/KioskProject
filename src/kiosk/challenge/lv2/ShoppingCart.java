package kiosk.challenge.lv2;

import kiosk.challenge.lv2.menus.MenuItem;

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

    public void getDetailTotalPrice() {
        int totalPrice = 0;
        System.out.println("[ Total ]");
        for (MenuItem item : cart) {
            totalPrice += item.getPrice();
        }
        System.out.println("W " + totalPrice);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (MenuItem item : cart) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public int getDiscountPrice(DiscountPolicy discountPolicy) {
        //null 체크
        if (discountPolicy == null) {
            System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            return getTotalPrice();
        }
        return (int)(getTotalPrice() - (getTotalPrice() * (discountPolicy.getDiscountPercent() * 0.01)));
    }
}
