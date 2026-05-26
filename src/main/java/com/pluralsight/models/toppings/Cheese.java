package com.pluralsight.models.toppings;

import com.pluralsight.enums.SandwichSize;

public class Cheese extends PremiumTopping{

    public Cheese(String name) {
        super(name);
    }

    public double getPrice(SandwichSize sandwichSize) {
        return 0;
    }
}
