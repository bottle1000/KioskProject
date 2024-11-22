package kiosk.essential.lv4;

import kiosk.essential.lv4.menus.MenuItem;
import kiosk.essential.lv4.menus.burger.Burger;
import kiosk.essential.lv4.menus.dessert.Dessert;
import kiosk.essential.lv4.menus.drink.Drink;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static final String DELIMITER = " | ";

    public static void main(String[] args) {


        Menu menuItems = new Menu();
        List<MenuItem> menus = menuItems.getMenuItems();

        Kiosk kiosk = new Kiosk(menus);

        kiosk.start();
    }
}
