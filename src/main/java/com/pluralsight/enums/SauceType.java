package com.pluralsight.enums;

public enum SauceType {
    MAYO("Mayo"), MUSTARD("Mustard"), KETCHUP("Ketchup"), RANCH("Ranch"),
    THOUSAND_ISLANDS("Thousand Islands"), VINAIGRETTE("Vinaigrette");

    private final String displayName;

    SauceType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}