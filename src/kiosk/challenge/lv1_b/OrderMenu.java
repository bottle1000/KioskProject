package kiosk.challenge.lv1_b;

public enum OrderMenu {
    ORDER("장바구니를 확인 후 주문합니다."),
    CANCEL("진행중인 주문을 취소합니다.");

    private final String description;

    OrderMenu(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
