package kiosk.challenge.lv2;

import kiosk.challenge.lv2.menus.MenuItem;
import kiosk.challenge.lv2.menus.burger.CheeseBurger;
import kiosk.challenge.lv2.menus.burger.HamBurger;
import kiosk.challenge.lv2.menus.burger.ShackBurger;
import kiosk.challenge.lv2.menus.burger.SmokeShack;
import kiosk.challenge.lv2.menus.dessert.Fries;
import kiosk.challenge.lv2.menus.dessert.IceCream;
import kiosk.challenge.lv2.menus.dessert.OnionRing;
import kiosk.challenge.lv2.menus.drink.Coffee;
import kiosk.challenge.lv2.menus.drink.Cola;
import kiosk.challenge.lv2.menus.drink.Sprite;

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
