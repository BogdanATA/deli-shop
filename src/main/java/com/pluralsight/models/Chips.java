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

    @Override
    public String getName() {
        return chipType.toString();
    }

    @Override
    public String toString() {
        return chipType + " Chips - $" + String.format("%.2f", getPrice());
    }
}
