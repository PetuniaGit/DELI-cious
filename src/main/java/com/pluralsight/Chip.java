package com.pluralsight;

public class Chip extends Item {
    private static final double CHIP_PRICE = 1.50;

    public Chip(String type) {
        super(type + " Chips");
        this.price = calculateCost();
    }

    @Override
    public double calculateCost() {
        return CHIP_PRICE;
    }

    @Override
    public String toString() {
        return name;
    }
}