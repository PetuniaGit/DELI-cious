package com.pluralsight;

public abstract class Item {
    protected String name;
    protected double price;

    public Item(String name) {
        this.name = name;
    }

    public abstract double calculateCost();

    @Override
    public String toString() {
        return name + " - $" + String.format("%.2f", price);
    }
}
