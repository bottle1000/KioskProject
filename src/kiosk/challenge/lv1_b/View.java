package kiosk.challenge.lv2_b;

import kiosk.challenge.lv2_b.cart.CartItem;
import kiosk.challenge.lv2_b.cart.CartManager;

import java.util.List;
import java.util.Scanner;

import static kiosk.essential.lv3.main.DELIMITER;

public class View {

    private final Scanner scanner = new Scanner(System.in);

    //사용자 콘솔 입력
    public int getUserInput() {
        int inputNum = scanner.nextInt();
        scanner.nextLine();
        return inputNum;
    }

    /**
     * main 클래스에서 kiosk를 처음 호출하면 콘솔에서 제일 처음 나타나는 메인 메뉴
     */
    public void printMainMenu(List<Menu> menuList) {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menuList.size(); i++) {
            System.out.println((i + 1) + ". " + menuList.get(i).getCategoryName());
        }
        System.out.println("0. 종료   " + DELIMITER + "종료");
    }

// ----

    /**
     * 메뉴에서 번호를 선택하여 음식들을 순번대로 보여주는 메서드
     * @param menuList
     * @param index menuList에서 원하는 요소를 꺼내기 위해서
     */
    public void printMenuItemList(List<Menu> menuList, int index) {
        Menu selectMenu = menuList.get(index - 1);
        System.out.println("[ " + selectMenu.getCategoryName() + " ]");
        List<MenuItem> menuItemList = selectMenu.getMenuItemList();

        int count = 1;
        for (MenuItem menuItem : menuItemList) {
            System.out.println(count + ". " + menuItem.getName() + "  | W " + menuItem.getPrice() + " | " + menuItem.getExplain() );
            count++;
        }
        System.out.println("0. 뒤로가기");
    }

    // 메뉴 선택 및 장바구니 추가 관련 처리
    public void printSelectItem(List<Menu> menuList, int mainChoice, int subChoice) {
        // 메인 메뉴와 서브 메뉴 선택
        Menu selectMenu = menuList.get(mainChoice - 1);

        // 서브 메뉴 아이템 유효성 검사
        if (subChoice > 0 && subChoice <= selectMenu.getMenuItemList().size()) {
            MenuItem menuItem = selectMenu.getMenuItemList().get(subChoice - 1);
            printSelectItem(menuItem);
            printConfirmOrder();  // 추가 확인 여부
        } else {
            System.out.println("잘못된 선택입니다! 다시 시도해주세요.");
        }
    }
    // 메뉴 항목 선택 후 추가 여부 확인 출력
    public void printSelectItem(MenuItem menuItem) {
        System.out.println("\"" + menuItem.getName() + "\"");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
    }

    // 확인 및 취소 선택 출력
    public void printConfirmOrder() {
        System.out.println("1. 확인     2. 취소");
    }

    public void printCart(List<CartItem> cartItemList){
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println("[ Orders ]");
        for (CartItem cartItem : cartItemList) {
            System.out.println(cartItem.getItemName() + "  | " + cartItem.getPrice() + " | " + cartItem.getQuantity());
        }
    }

    public void printTotalPrice(CartManager cartManager) {
        System.out.println("[ Total ]");
        System.out.println("W " + cartManager.calculateTotalPrice());
    }

    public void printMenus(List<Menu> menuList) {
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라주세요.");
        printMainMenu(menuList);
        System.out.println("[ ORDER MENU ]");
        OrderMenu[] values = OrderMenu.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println((menuList.size() + (i+1))+ ". " + values[i] + "     | " + values[i].getDescription());
        }
    }


    public void showOrderOptions(CartManager cartManager) {
        System.out.println("1. 주문        2. 메뉴판");
        int userInput = getUserInput();
        switch (userInput) {
            case 1:
                System.out.println("주문이 완료되었습니다. 금액은 W " + cartManager.calculateTotalPrice() + "입니다.");
                cartManager.clearCart();
                break;
            case 2:
                System.out.println("메뉴를 추가하시겠습니까?");
        }
    }

}
