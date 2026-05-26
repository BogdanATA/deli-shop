package com.pluralsight.models.toppings;

import com.pluralsight.enums.SandwichSize;

public class Meat extends PremiumTopping{

    public Meat(String name) {
        super(name);
    }

    public double getPrice(SandwichSize sandwichSize) {
        return 0;
    }
}
