package com.pluralsight.enums;

public enum DrinkSize {
    SMALL("Small"), MEDIUM("Medium"), LARGE("Large");

    private final String displayName;

    DrinkSize(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}