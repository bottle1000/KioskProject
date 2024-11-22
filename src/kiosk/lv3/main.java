package kiosk.lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    public static final String DELIMITER = " | ";

    public static void main(String[] args) {

        List<MenuItem> menuItems = new ArrayList<>();

        MenuItem shackBurger = new MenuItem("shackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        menuItems.add(shackBurger);

        MenuItem smokeBurger = new MenuItem("SmokeBurger", 8900, "베이컨, 체리 페퍼에 쉑소스가가 토핑된 치즈버거");
        menuItems.add(smokeBurger);

        MenuItem cheeseBurger = new MenuItem("CheeseBurger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        menuItems.add(cheeseBurger);

        MenuItem hamburger = new MenuItem("HamBurger", 5400, "비프패티를 기반으로 야채가 들어간 버거");
        menuItems.add(hamburger);

        Kiosk kiosk = new Kiosk(menuItems);
        kiosk.start();
    }
}
