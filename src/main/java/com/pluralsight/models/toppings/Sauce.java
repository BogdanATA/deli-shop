package com.pluralsight.models.toppings;

import com.pluralsight.enums.SandwichSize;

public class Sauce extends Topping{

    public Sauce(String name) {
        super(name);
    }

    @Override
    public double getPrice(SandwichSize sandwichSize) {
        return 0;
    }
}
