package com.solvd.reddit.task6.menu_placement;

public class MenuItem {
    private String name;
    private int price;

    public MenuItem(String item, int price) {
        this.name = item;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}
