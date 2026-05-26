package com.pluralsight.models.toppings;

import com.pluralsight.enums.SandwichSize;

public class Side extends Topping{

    public Side(String name) {
        super(name);
    }

    @Override
    public double getPrice(SandwichSize sandwichSize) {
        return 0;
    }
}
