package com.pluralsight.enums;

public enum CheeseType {
    AMERICAN("American"), PROVOLONE("Provolone"), CHEDDAR("Cheddar"), SWISS("Swiss");

    private final String displayName;

    CheeseType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}