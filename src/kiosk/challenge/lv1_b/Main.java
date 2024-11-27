package kiosk.challenge.lv1_b;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String DELIMITER = " | ";

    public static void main(String[] args) {
        Menu burger = new Menu("BURGER");
        burger.addMenuItem(new MenuItem("ShackBurger", 6900,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burger.addMenuItem(new MenuItem("SmokeShack", 8900,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burger.addMenuItem(new MenuItem("Cheeseburger", 6900,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burger.addMenuItem(new MenuItem("Hamburger", 5400,"비프패티를 기반으로 야채가 들어간 기본버거"));

        Menu drink = new Menu("DRINK");
        drink.addMenuItem(new MenuItem("Cola", 1200, "콜라"));
        drink.addMenuItem(new MenuItem("coffee", 2500, "커피"));
        drink.addMenuItem(new MenuItem("Sprite", 1500, "스프라이트"));

        Menu dessert = new Menu("DESSERT");
        dessert.addMenuItem(new MenuItem("OnionRing", 3500, "어니언링"));
        dessert.addMenuItem(new MenuItem("IceCream", 1500, "아이스크림"));

        // 메뉴 리스트
        List<Menu> menuList = new ArrayList<>();
        menuList.add(burger);
        menuList.add(drink);
        menuList.add(dessert);

        View view = new View();
        CartManager cartManager = new CartManager();

        Kiosk kiosk = new Kiosk(view, menuList, cartManager);
        kiosk.start();
    }
}
