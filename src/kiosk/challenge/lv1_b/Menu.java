package kiosk.challenge.lv1_b;

import java.util.ArrayList;
import java.util.List;


public class Menu {

    private final List<MenuItem> menuItemList;
    private final String categoryName;

    public Menu(String categoryName) {
        this.categoryName = categoryName;
        this.menuItemList = new ArrayList<>();
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItemList.add(menuItem);
    }
}
