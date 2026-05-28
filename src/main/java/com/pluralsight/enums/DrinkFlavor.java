package com.pluralsight.enums;

public enum DrinkFlavor {
    COKE("Coke"), DIET_COKE("Diet Coke"), SPRITE("Sprite");

    private final String displayName;

    DrinkFlavor(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}