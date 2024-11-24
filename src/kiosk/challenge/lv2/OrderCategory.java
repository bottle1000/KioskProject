package kiosk.challenge.lv2;

public enum OrderCategory {
    ORDER("장바구니를 확인 후 주문합니다."),
    CANCEL("진행중인 주문을 취소합니다.");

    private final String description;

    OrderCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void printOrderCategory(int startIndex) {
        OrderCategory[] values = OrderCategory.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println((startIndex + i)+ ". " + values[i] + "     | " + values[i].getDescription());
        }

    }
}
