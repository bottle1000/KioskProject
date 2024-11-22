package kiosk.challenge.lv1;

import kiosk.challenge.lv1.menus.MenuItem;
import kiosk.challenge.lv1.menus.burger.CheeseBurger;
import kiosk.challenge.lv1.menus.burger.HamBurger;
import kiosk.challenge.lv1.menus.burger.ShackBurger;
import kiosk.challenge.lv1.menus.burger.SmokeShack;
import kiosk.challenge.lv1.menus.dessert.Fries;
import kiosk.challenge.lv1.menus.dessert.IceCream;
import kiosk.challenge.lv1.menus.dessert.OnionRing;
import kiosk.challenge.lv1.menus.drink.Coffee;
import kiosk.challenge.lv1.menus.drink.Cola;
import kiosk.challenge.lv1.menus.drink.Sprite;

import java.util.ArrayList;
import java.util.List;

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
