package kiosk.lv2;

import java.util.ArrayList;

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

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }
}
