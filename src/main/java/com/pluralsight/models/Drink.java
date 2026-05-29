package com.pluralsight.models;

import com.pluralsight.enums.DrinkFlavor;
import com.pluralsight.enums.DrinkSize;

public class Drink implements IPriceable{
    private DrinkFlavor flavor;
    private DrinkSize drinkSize;

    public Drink(DrinkFlavor flavor, DrinkSize drinkSize) {
        this.flavor = flavor;
        this.drinkSize = drinkSize;
    }

    public DrinkFlavor getFlavor() {
        return flavor;
    }

    public DrinkSize getDrinkSize() {
        return drinkSize;
    }

    /**
     * Returns a simple display name of this drink to print out under current order
     *
     * @return the name as a String
     */
    @Override
    public String getName() {
        return flavor + " - " + drinkSize;
    }

    @Override
    public double getPrice() {
        double drinkCost = 0;
        switch (drinkSize) {
            case SMALL -> drinkCost = 2.00;
            case MEDIUM -> drinkCost = 2.50;
            case LARGE -> drinkCost = 3.00;
        }
        return drinkCost;
    }

    @Override
    public String toString() {
        return flavor + " (" + drinkSize + ") - $" + String.format("%.2f", getPrice());
    }
}
