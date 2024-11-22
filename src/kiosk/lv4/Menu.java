package kiosk.lv4;

import kiosk.lv4.menus.MenuItem;
import kiosk.lv4.menus.burger.*;
import kiosk.lv4.menus.dessert.Dessert;
import kiosk.lv4.menus.dessert.Fries;
import kiosk.lv4.menus.dessert.IceCream;
import kiosk.lv4.menus.dessert.OnionRing;
import kiosk.lv4.menus.drink.Coffee;
import kiosk.lv4.menus.drink.Cola;
import kiosk.lv4.menus.drink.Drink;
import kiosk.lv4.menus.drink.Sprite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Menu {

    private final List<MenuItem> menuItems = new ArrayList<>();


    public Menu() {
        menuItems.add(new SmokeShack());
        menuItems.add(new CheeseBurger());
        menuItems.add(new ShackBurger());
        menuItems.add(new HamBurger());

        menuItems.add(new Fries());
        menuItems.add(new IceCream());
        menuItems.add(new OnionRing());

        menuItems.add(new Cola());
        menuItems.add(new Sprite());
        menuItems.add(new Coffee());
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void printSequentialList() {
        menuItems.stream()
                .forEach(menu -> System.out.println("menu : " + menu));
    }


}
