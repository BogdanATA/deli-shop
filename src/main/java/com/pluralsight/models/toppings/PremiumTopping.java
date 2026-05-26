package com.pluralsight.models.toppings;

import com.pluralsight.enums.SandwichSize;

public abstract class PremiumTopping extends Topping{
    private boolean isExtra;

    public PremiumTopping(String name) {
        super(name);
    }

    @Override
    public abstract double getPrice(SandwichSize sandwichSize);
}
