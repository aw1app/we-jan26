package com.sl;

import java.util.List;
import java.util.Map;

public class Restaurant {
    private String name;
    private List<String> menuItems;
    private Map<String, Double> prices;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<String> getMenuItems() { return menuItems; }
    public void setMenuItems(List<String> menuItems) { this.menuItems = menuItems; }

    public Map<String, Double> getPrices() { return prices; }
    public void setPrices(Map<String, Double> prices) { this.prices = prices; }
}