package kiosk.challenge.lv2;

public enum DiscountInfo {
    COMMON("일반",0),
    SOLIDER("군인", 50),
    STUDENT("학생", 30),
    MERIT("유공자", 90);

    private final String occupation;
    private final int discountPercent;

    DiscountInfo(String occupation, int discountPercent) {
        this.occupation = occupation;
        this.discountPercent = discountPercent;
    }

    public String getOccupation() {
        return occupation;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }


    public void printDiscountInfo() {
        System.out.println("할인 정보를 입력해주세요.");
        DiscountInfo[] values = DiscountInfo.values();
        for (int i = 1; i <= values.length; i++) {
            System.out.println(i+". " + values[i].getOccupation() + "    : " + values[i].getDiscountPercent() + "%");
        }
    }
}
