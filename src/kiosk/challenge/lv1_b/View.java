package kiosk.challenge.lv1_b;

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

    public void printSelectedItem(List<Menu> menuList, int menuListIndex, int itemListIndex) {
        MenuItem menuItem = menuList.get(menuListIndex - 1).getMenuItemList().get(itemListIndex - 1);
        System.out.println("선택한 메뉴 : " + menuItem.getName() + "  | W " + menuItem.getPrice() + " | " + menuItem.getExplain());
    }


    public MenuItem printAskAddToCart(List<Menu> menuList, int menuListIndex, int itemListIndex) {
        MenuItem menuItem = menuList.get(menuListIndex - 1).getMenuItemList().get(itemListIndex - 1);
        System.out.println("\"" + menuItem.getName() + "  | W " + menuItem.getPrice() + " | " + menuItem.getExplain() + "\"");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인     2. 취소");
        return menuItem;
    }

    public void printConfirmAddToCart(MenuItem menuItem) {
        String itemName = menuItem.getName();
        System.out.println(itemName + "가(이) 장바구니에 추가되었습니다.");
    }

    public void displayChoiceMenus() {
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
    }

    public void printOrderMenu(List<Menu> menuList) {
        OrderMenu[] values = OrderMenu.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println((menuList.size() + (i+1))+ ". " + values[i] + "     | " + values[i].getDescription());
        }
    }

    public void printAskOrder() {
        System.out.println("아래와 같이 주문 하시겠습니까?");
    }

    public void printCartList(CartManager cartManager) {
        System.out.println("[ Orders ]");
        List<CartItem> cartItemList = cartManager.getCartItemList();
        for (CartItem cartItem : cartItemList) {
            System.out.println(cartItem.getItemName() + "  | W " + cartItem.getPrice() + " | " + cartItem.getQuantity() );
        }
    }

    public void printTotalPrice(CartManager cartManager) {
        System.out.println("[ Total ]");
        System.out.println("W " + cartManager.calculateTotalPrice());
    }

    public void printChoiceConfirmOrder() {
        System.out.println("1. 주문     2. 메뉴판");
    }

    public void printCompleteOrderAndTotalPrice(CartManager cartManager) {
        System.out.println("주문이 완료되었습니다. 금액은 W " + cartManager.calculateTotalPrice() + " 입니다.");
    }

}
