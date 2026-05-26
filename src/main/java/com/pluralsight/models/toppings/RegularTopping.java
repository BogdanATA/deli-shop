package com.pluralsight.models.toppings;

import com.pluralsight.enums.SandwichSize;

public class RegularTopping extends Topping{

    public RegularTopping(String name) {
        super(name);
    }

    @Override
    public double getPrice(SandwichSize sandwichSize) {
        return 0;
    }
}
