package com.pluralsight.enums;

public enum RegularToppingType {
    LETTUCE("Lettuce"), PEPPERS("Peppers"), ONIONS("Onions"), TOMATOES("Tomatoes"),
    JALAPENOS("Jalapenos"), CUCUMBERS("Cucumbers"), PICKLES("Pickles"),
    GUACAMOLE("Guacamole"), MUSHROOMS("Mushrooms");

    private final String displayName;

    RegularToppingType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}