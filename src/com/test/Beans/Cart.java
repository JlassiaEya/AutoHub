package com.test.Beans;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Article> items;
    private int userId;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Article item) {
        if (item != null) {
            items.add(item);
        }
    }

    public void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        }
    }

    public List<Article> getItems() {
        return items;
    }

    public double getTotal() {
        double total = 0;
        for (Article item : items) {
            total += item.getPrix() * item.getQteStock();
        }
        return total;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public int getUserId() {
        return userId;
    }
}
