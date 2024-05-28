package com.pluralsight;

public class Chip extends Item {
    private static final double CHIP_PRICE = 1.50;
      // Constructor for creating a chip of the specified type.
    public Chip(String type) {
        super(type + " Chips");
        this.price = calculateCost();
    }
     //Calculates and returns the cost of the chip.
    @Override
    public double calculateCost() {
        return CHIP_PRICE;
    }
     // Returns a string representation of the chip, which is its name.
    @Override
    public String toString() {
        return name;
    }
}