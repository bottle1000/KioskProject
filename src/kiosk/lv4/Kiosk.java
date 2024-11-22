package kiosk.lv4;

import kiosk.lv4.menus.MenuItem;
import kiosk.lv4.menus.burger.Burger;
import kiosk.lv4.menus.dessert.Dessert;
import kiosk.lv4.menus.drink.Drink;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static kiosk.lv3.main.DELIMITER;

public class Kiosk {

    private List<MenuItem> menuItems;

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("[ MAIN MENU ]");
            MenuCategory.printMenuCategory();
            System.out.println("0. 종료   " + DELIMITER + "종료");

            int categoryChoiceNo = scanner.nextInt();

            switch (categoryChoiceNo) {
                case 1:
                    System.out.println("[ BURGERS MENU ]");
                    List<Burger> burgers =menuItems.stream()
                            .filter(menu -> menu instanceof Burger)
                            .map(menu -> (Burger)menu)
                            .toList();
                    printBurgerMenu(burgers);
                    selectMenuOption(scanner, burgers);

                    break;

                case 2:
                    System.out.println("[ DRINKS MENU ]");
                    List<Drink> drinks =menuItems.stream()
                            .filter(menu -> menu instanceof Drink)
                            .map(menu -> (Drink)menu)
                            .toList();
                    printDrinkMenu(drinks);
                    selectMenuOption(scanner,drinks);

                    break;
                case 3:
                    System.out.println("[ DESSERT MENU ]");
                    List<Dessert> desserts = menuItems.stream()
                            .filter(menu -> menu instanceof Dessert)
                            .map(menu -> (Dessert)menu)
                            .toList();
                    printDessertMenu(desserts);
                    selectMenuOption(scanner,desserts);
                    break;
                case 0:
                    System.out.println("시스템을 종료합니다.");
                    return;
            }

        }
    }

    private void selectMenuOption(Scanner scanner, List<? extends MenuItem> menuItems) {
        System.out.println("0. 종료 "+ DELIMITER + " 종료");
        System.out.print("번호를 선택해주세요. : ");
        int Choice = scanner.nextInt();
        scanner.nextLine(); //개행제거

        if (Choice == 0) {
            System.out.println("프로그램을 종료합니다");
            return;
        }

        // switch문을 사용 안하고 if-else 문을 사용한 이유 : System.out.println 부분 코드가 너무 중복되어서 입니다.
        if (Choice > 0 && Choice <= menuItems.size()) {
            MenuItem menuItem = menuItems.get(Choice - 1); //코드가 길어져서 가독성이 떨어지고 중복되는거라 변수로 따로 빼줬습니다.
            System.out.println("선택하신 메뉴 : [이름: " + menuItem.getName() +", 가격: " + menuItem.getPrice()
                    +", 설명: " + menuItem.getExplain()+"]");
        } else {
            System.out.println("잘못된 선택입니다! 다시 시도해주세요");
        }
    }

    /**
     *  BURGER 카테고리를 선택 시 BURGER 메뉴들을 보여주는 메서드
     *  메뉴들이 통합적으로 들어있는 리스트에서 특정한(BURGER) 타입만 꺼내도록 만들었습니다.
     */
    private void printBurgerMenu(List<Burger> burgers) {
        for (int i = 0; i < burgers.size(); i++) {
            System.out.println((i+1)+ "." + burgers.get(i).getName() + DELIMITER + burgers.get(i).getPrice()
                    + DELIMITER + burgers.get(i).getExplain());
        }
    }

    private void printDrinkMenu(List<Drink> drinks) {
        for (int i = 0; i < drinks.size(); i++) {
            System.out.println((i+1)+ "." + drinks.get(i).getName() + DELIMITER + drinks.get(i).getPrice()
                    + DELIMITER + drinks.get(i).getExplain());
        }
    }

    private void printDessertMenu(List<Dessert> desserts) {
        for (int i = 0; i < desserts.size(); i++) {
            System.out.println((i+1)+ "." + desserts.get(i).getName() + DELIMITER + desserts.get(i).getPrice()
                    + DELIMITER + desserts.get(i).getExplain());
        }
    }

}
