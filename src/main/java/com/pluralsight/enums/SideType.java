package com.pluralsight.enums;

public enum SideType {
    AU_JUS("Au Jus"), SAUCE("Sauce");

    private final String displayName;

    SideType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}