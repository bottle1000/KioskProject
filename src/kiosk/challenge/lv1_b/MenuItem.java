package kiosk.challenge.lv1_b;

public class MenuItem {

    private String name;
    private int price;
    private String explain;

    public MenuItem(String name, int price, String explain) {
        this.name = name;
        this.price = price;
        this.explain = explain;
    }

    public String getName() {
        return name;
    }


    public int getPrice() {
        return price;
    }


    public String getExplain() {
        return explain;
    }

    @Override
    public String toString() {
        return name + "   | W " + price + " | " + explain;
    }

}
