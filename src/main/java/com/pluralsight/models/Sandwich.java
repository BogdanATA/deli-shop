package com.pluralsight.models;

import com.pluralsight.enums.BreadType;
import com.pluralsight.enums.SandwichSize;
import com.pluralsight.models.toppings.Topping;

import java.util.ArrayList;
import java.util.List;

public abstract class Sandwich implements IPriceable{
    private BreadType breadType;
    private SandwichSize sandwhichSize;
    private boolean isToasted;
    private List<Topping> toppings;

    public Sandwich(BreadType breadType, SandwichSize sandwhichSize) {
        this.breadType = breadType;
        this.sandwhichSize = sandwhichSize;
        this.isToasted = false;
        this.toppings = new ArrayList<>();
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public SandwichSize getSandwhichSize() {
        return sandwhichSize;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double getPrice() {
        return 0;
    }
}
