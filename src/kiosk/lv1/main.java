package kiosk.lv1;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("[SHAKESHAKE MENU]");
            System.out.println("1. shackBurger  | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
            System.out.println("2. SmokeBurger  | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가가 토핑된 치즈버거");
            System.out.println("3. CheeseBurger | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
            System.out.println("4. HamBurger    | W 5.4 | 비프패티를 기반으로 야채가 들어간 버거");
            System.out.println("0. 종료          | 종료");

            int choice = scanner.nextInt();
            scanner.nextLine(); //개행제거

            if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}
