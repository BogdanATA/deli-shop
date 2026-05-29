package com.pluralsight.models;

import com.pluralsight.enums.ChipType;

public class Chips implements IPriceable{
    private ChipType chipType;

    public Chips(ChipType chipType) {
        this.chipType = chipType;
    }

    public ChipType getChipType() {
        return chipType;
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    /**
     * Returns a simple display name of these chips to print out under current order
     *
     * @return the name as a String
     */
    @Override
    public String getName() {
        return chipType + " Chips";
    }

    @Override
    public String toString() {
        return chipType + " Chips - $" + String.format("%.2f", getPrice());
    }
}
