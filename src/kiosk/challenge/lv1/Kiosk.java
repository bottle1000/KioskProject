package kiosk.challenge.lv1;

import kiosk.challenge.lv1.menus.MenuItem;
import kiosk.challenge.lv1.menus.burger.Burger;
import kiosk.challenge.lv1.menus.dessert.Dessert;
import kiosk.challenge.lv1.menus.drink.Drink;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static kiosk.essential.lv3.main.DELIMITER;

public class Kiosk {

    private List<MenuItem> menuItems;

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    ShoppingCart shoppingCart = new ShoppingCart();

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMainMenu();
            int categoryChoiceNo = scanner.nextInt();

            switch (categoryChoiceNo) {
                case 1:
                    System.out.println("[ BURGERS MENU ]");
                    /**
                     *  BURGER 카테고리를 선택 시 BURGER 메뉴들을 보여주는 메서드
                     *  메뉴들이 통합적으로 들어있는 리스트에서 특정한(BURGER) 타입만 꺼내도록 만들었습니다.
                     */
                    List<Burger> burgers =menuItems.stream()
                            .filter(menu -> menu instanceof Burger)
                            .map(menu -> (Burger)menu)
                            .toList();
                    printOptionMenus(burgers);
                    printMenuItemDetails(scanner, burgers);

                    break;

                case 2:
                    System.out.println("[ DRINKS MENU ]");
                    List<Drink> drinks =menuItems.stream()
                            .filter(menu -> menu instanceof Drink)
                            .map(menu -> (Drink)menu)
                            .toList();
                    printOptionMenus(drinks);
                    printMenuItemDetails(scanner,drinks);

                    break;
                case 3:
                    System.out.println("[ DESSERT MENU ]");
                    List<Dessert> desserts = menuItems.stream()
                            .filter(menu -> menu instanceof Dessert)
                            .map(menu -> (Dessert)menu)
                            .toList();
                    printOptionMenus(desserts);
                    printMenuItemDetails(scanner,desserts);
                    break;
                case 0:
                    System.out.println("시스템을 종료합니다.");
                    return;
                default:
                    if (shoppingCart.getCart().isEmpty()) {
                        if (categoryChoiceNo == 4 || categoryChoiceNo == 5) {
                            System.out.println("메뉴를 선택하여 장바구니에 추가해주세요!");
                        }
                    }
            }

        }
    }

    private static void printMainMenu() {
        System.out.println("[ MAIN MENU ]");
        MenuCategory.printMenuCategory();
        System.out.println("0. 종료   " + DELIMITER + "종료");
    }

    private static void printOrderMenu() {
        System.out.println("[ Order Menu ]");
        OrderCategory.printOrderCategory(MenuCategory.values().length + 1);
    }

    /**
     * 구체적인(ex.CheeseBurger)를 선택하면 이름, 가격, 설명을 보여주는 메서드
     * @param scanner 를 매개변수로 받아서 음식들을 고를 수 있게 했다.
     * @param menuItems 는 MenuItem의 자식들만 받을 수 있게 타입 안정성을 위해 사용
     */
    private void printMenuItemDetails(Scanner scanner, List<? extends MenuItem> menuItems) {
        System.out.println("0. 종료 "+ DELIMITER + " 종료");
        System.out.print("번호를 선택해주세요. : ");
        int Choice = scanner.nextInt();
        scanner.nextLine(); //개행제거

        if (Choice == 0) {
            System.out.println("프로그램을 종료합니다");
            return;
        }

        /**
         * 선택한 메뉴의 상세정보를 출력해주는 조건문
         * switch문을 사용 안하고 if-else 문을 사용한 이유 : System.out.println 부분 코드가 너무 중복되어서.
         * menuItems.get(Choice - 1)을 변수명으로 뺀 이유 : 코드가 길어져서 가독성이 떨어지고 중복되는거라 변수로 따로 뺏습니다.
         */
        if (Choice > 0 && Choice <= menuItems.size()) {
            MenuItem menuItem = menuItems.get(Choice - 1);
            System.out.println("선택하신 메뉴 : [이름: " + menuItem.getName() +", 가격: " + menuItem.getPrice()
                    +", 설명: " + menuItem.getExplain()+"]");
            addShoppingCart(scanner, menuItem);
        } else {
            System.out.println("잘못된 선택입니다! 다시 시도해주세요.");
        }
    }

    /**
     * 카테고리에서 선택된 음시들을 나열해주는 메서드
     * @param menuItems 의 각각의 자식들을 파라미터로 받아서 정보를 출력
     */
    private void printOptionMenus(List<? extends MenuItem> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i+1)+ "." + menuItems.get(i).getName() + DELIMITER + menuItems.get(i).getPrice()
                    + DELIMITER + menuItems.get(i).getExplain());
        }
    }

    /**
     * 사용자 입력 처리
     * scanner 쓰는 부분이 많아서 코드상 헷갈리고 가독성이 떨어져서 메서드로 빼냈음.
     * @param scanner
     * @return
     */
    private int getUserInput(Scanner scanner) {
        int inputNum = scanner.nextInt();
        scanner.nextLine();
        return inputNum;
    }

    //기능 분리 : 장바구니 추가
    private void addShoppingCart(Scanner scanner, MenuItem menuItem) {
        System.out.println("위 메뉴를 장바구니에 추가하겠습니까?");
        System.out.println("1. 확인       2. 취소");
        int userInput = getUserInput(scanner);

        if (userInput == 1) {
            shoppingCart.addCart(menuItem);
            System.out.println(menuItem.getName() + "가(이) 장바구니에 추가되었습니다.");
            System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
            reviewAndOrder(scanner);
        } else if (userInput == 2) {
            System.out.println("취소하였습니다. Menu로 되돌아갑니다.");
        } else {
            System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
        }
    }

    // 장바구니가 비어있지 않을 때 주문을 처리하는 로직
    private void reviewAndOrder(Scanner scanner) {
        if (!shoppingCart.getCart().isEmpty()) {
            printMainMenu();
            printOrderMenu();
            int orderChoice = getUserInput(scanner);
            switch (orderChoice) {
                case 4:
                    confirmOrder(scanner);
                    break;
                case 5:
                    System.out.println("취소 되었습니다. 메뉴판으로 돌아갑니다.");
                    break;
            }
        }
    }


    //기능 분리 : 주문 확인
    private void confirmOrder(Scanner scanner) {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        shoppingCart.showCartItems();
        System.out.println();
        shoppingCart.getDetailTotalPrice();

        System.out.println("1. 주문       2. 메뉴판");
        int confirmChoice = getUserInput(scanner);

        if (confirmChoice == 1) {
            System.out.println("주문이 완료되었습니다. 금액은 W " + shoppingCart.getTotalPrice() + " 입니다.");
        } else if (confirmChoice == 2) {
            System.out.println("메뉴판으로 돌아갑니다.");
        } else {
            System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
        }
    }


}
