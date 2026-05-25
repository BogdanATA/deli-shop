package com.pluralsight.models;

import java.util.List;

public class Order {
    private List<IPriceable> items;

    public Order(List<IPriceable> items) {
        this.items = items;
    }

    public void addItem(IPriceable item) {
        items.add(item);
    }
}
