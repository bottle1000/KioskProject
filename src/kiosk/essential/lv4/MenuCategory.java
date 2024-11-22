package kiosk.essential.lv4;

// 메뉴 카테고리를 열거형으로 나열
public enum MenuCategory {
    BURGERS, DRINKS, DESERTS;

    /**
     * 카테고리 목록을 보여줍니다.
     * 열거형 상수들을 배열에 넣은 뒤 한 개씩 순차적으로 보여줍니다.
     */
    public static void printMenuCategory() {
        MenuCategory[] values = MenuCategory.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println((i+1) + ". " + values[i]);
        }
    }
}
