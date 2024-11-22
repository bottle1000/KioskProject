package kiosk.lv3;

import java.util.List;
import java.util.Scanner;

import static kiosk.lv3.main.DELIMITER;

public class Kiosk {

    private List<MenuItem> menuItems;

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
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
