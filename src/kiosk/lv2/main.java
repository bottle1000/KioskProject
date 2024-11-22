package kiosk.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    private static final String DELIMITER = " | ";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<MenuItem> menuItems = new ArrayList<>();

        MenuItem shackBurger = new MenuItem("shackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        menuItems.add(shackBurger);

        MenuItem smokeBurger = new MenuItem("SmokeBurger", 8900, "베이컨, 체리 페퍼에 쉑소스가가 토핑된 치즈버거");
        menuItems.add(smokeBurger);

        MenuItem cheeseBurger = new MenuItem("CheeseBurger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        menuItems.add(cheeseBurger);

        MenuItem hamburger = new MenuItem("HamBurger", 5400, "비프패티를 기반으로 야채가 들어간 버거");
        menuItems.add(hamburger);

        while (true) {
            System.out.println("[SHAKESHAKE MENU]");

            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println((i+1)+ "." + menuItems.get(i).getName() + DELIMITER + menuItems.get(i).getPrice()
                        + DELIMITER + menuItems.get(i).getExplain());
            }
            System.out.println("0. 종료 "+ DELIMITER + " 종료");

            System.out.print("번호를 선택해주세요. : ");
            int choice = scanner.nextInt();
            scanner.nextLine(); //개행제거

            if (choice == 0) {
                System.out.println("프로그램을 종료합니다");
                return;
            }

            // switch문을 사용 안하고 if-else 문을 사용한 이유 : System.out.println 부분 코드가 너무 중복되어서 입니다.
            if (choice > 0 && choice <= menuItems.size()) {
                MenuItem menuItem = menuItems.get(choice - 1); //코드가 길어져서 가독성이 떨어지고 중복되는거라 변수로 따로 빼줬습니다.
                System.out.println("선택하신 메뉴 : [이름: " + menuItem.getName() +", 가격: " + menuItem.getPrice()
                        +", 설명: " + menuItem.getExplain()+"]");
            } else {
                System.out.println("잘못된 선택입니다! 다시 시도해주세요");
            }





        }
    }
}
