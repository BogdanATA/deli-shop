package com.pluralsight.enums;

public enum ChipType {
    LAYS_PLAIN("Lays Plain"), SUN_CHIPS_CHEDDAR("Sun Chips Cheddar"), SUN_CHIPS_SALSA("Sun Chips Salsa");

    private final String displayName;

    ChipType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}