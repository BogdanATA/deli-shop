package com.pluralsight.enums;

public enum SandwichSize {
    FOUR(4), EIGHT(8), TWELVE(12);

    private final int inches;

    SandwichSize(int inches) {
        this.inches = inches;
    }

    public int getInches() {
        return inches;
    }
}
