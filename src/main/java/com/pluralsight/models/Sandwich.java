package com.pluralsight.models;

import com.pluralsight.enums.BreadType;
import com.pluralsight.enums.SandwichSize;
import com.pluralsight.models.toppings.PremiumTopping;
import com.pluralsight.models.toppings.Topping;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements IPriceable{
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
        if (topping instanceof PremiumTopping premiumTopping) {
            boolean alreadyExists = toppings.stream()
                    .anyMatch(t -> t.getName().equals(topping.getName()));
            if (alreadyExists) {
                premiumTopping.setExtra(true);
            }
        }
        toppings.add(topping);
    }

    public double getPrice() {
        double breadPrice = 0;
        switch(sandwhichSize){
            case FOUR -> breadPrice = 5.50;
            case EIGHT -> breadPrice = 7.00;
            case TWELVE -> breadPrice = 8.50;
        }
        double toppingPrice = toppings.stream()
                .mapToDouble(t -> t.getPrice(sandwhichSize))
                .sum();

        return breadPrice + toppingPrice;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "breadType=" + breadType +
                ", sandwhichSize=" + sandwhichSize +
                ", isToasted=" + isToasted +
                ", toppings=" + toppings +
                '}';
    }
}
