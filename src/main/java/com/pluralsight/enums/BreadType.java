package com.pluralsight.enums;

public enum BreadType {
    WHITE("White"), WHEAT("Wheat"), RYE("Rye"), WRAP("Wrap");

    private final String displayName;

    BreadType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}