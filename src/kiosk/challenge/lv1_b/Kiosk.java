package kiosk.challenge.lv1_b;

import java.util.List;

public class Kiosk {

    private final View view;
    private final List<Menu> menuList;
    private final CartManager cartManager;

    public Kiosk(View view, List<Menu> menuList, CartManager cartManager) {
        this.view = view;
        this.menuList = menuList;
        this.cartManager = cartManager;
    }


    public void start() {
        while (true) {
            // 1. MainMenu 출력 및 선택
            int menuChoice = printMenuHandler();

            // 2. Item 출력 및 사용자 선택
            int itemChoice = printItemHandler(menuChoice);

            // 3. 장바구니 출력 및 사용자 선택 저장
            printCartHandler(menuChoice, itemChoice);

            // 4. 주문 출력
            printOrderHandler();

            // 5. 주문 금액 출력
            printPriceHandler();

            // 6. 최종 주문
            printConfirmOrderHandler();

        }
    }

    /**
     * 키오스크가 처음 동작할 때 메인 메뉴를 출력해주는 메서드.
     * 0번을 누르면 프로그램 종료, 화면에 보이지 않는 번호를 클릭시 예외 발생
     * @return menuChoice item에 접근하기 위해 menuChoice를 반환
     */
    private int printMenuHandler() {
        view.printMainMenu(menuList);

        int menuChoice = view.getUserInput();
        if (menuChoice == 0) {
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        }
        if (menuChoice < 1 || menuChoice > menuList.size()) {
            System.out.println("유효하지 않은 입력입니다. 다시 입력해주세요.");
        }

        return menuChoice;
    }


    /**
     * 아이템의 출력과 입력, 예외처리까지 담당하는 메서드
     * @param menuChoice
     */
    private int printItemHandler(int menuChoice) {
        view.printMenuItemList(menuList, menuChoice);
        int itemChoice = view.getUserInput();

        // 유효성 검사 추가: subChoice가 잘못된 경우 처리
        if (itemChoice < 0 || itemChoice > menuList.get(menuChoice - 1).getMenuItemList().size()) {
            System.out.println("잘못된 선택입니다. 다시 시도해주세요.");
        }

        view.printSelectedItem(menuList, menuChoice, itemChoice);
        return itemChoice;
    }

    private void printCartHandler(int menuChoice, int itemChoice) {
        MenuItem selectedItem = view.printAskAddToCart(menuList, menuChoice, itemChoice);

        switch (view.getUserInput()) {
            case 1:
                view.printConfirmAddToCart(selectedItem);
                cartManager.addToCart(selectedItem.getName(), selectedItem.getPrice());
                break;
            case 2:
                System.out.println("취소되었습니다. 메인 화면으로 돌아갑니다.");
            default:
                System.out.println("선택하신 번호는 없는 번호입니다. 메인 화면으로 돌아갑니다.");
        }
    }

    private void printOrderHandler() {
        view.displayChoiceMenus();

        if (cartManager.getCartItemList().isEmpty()) {
            System.out.println("장바구니에 물건이 들어있지 않습니다!");
            return;
        }

        view.printMainMenu(menuList);
        view.printOrderMenu(menuList);

        switch (view.getUserInput()) {
            case 1,2,3 :
                return;
            case 4 :
                view.printAskOrder();
                view.printCartList(cartManager);
                break;
            case 5 :
                System.out.println("주문을 취소합니다.");
        }
    }

    private void printPriceHandler() {
        view.printTotalPrice(cartManager);
    }

    private void printConfirmOrderHandler() {
        view.printChoiceConfirmOrder();
        switch (view.getUserInput()) {
            case 1 :
                view.printCompleteOrderAndTotalPrice(cartManager);
                break;
            case 2:
                System.out.println("메뉴판으로 돌아갑니다.");
        }
    }

}