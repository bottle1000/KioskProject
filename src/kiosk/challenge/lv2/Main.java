package kiosk.challenge.lv2;

import kiosk.challenge.lv2.menus.MenuItem;

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
