package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<IPriceable> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addItem(IPriceable item) {
        items.add(item);
    }

    public List<IPriceable> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return items.stream()
                .mapToDouble(item -> item.getPrice())
                .sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (IPriceable item: items) {
            sb.append(item.getName()).append("\n");
        }
        return sb.toString();
    }
}
