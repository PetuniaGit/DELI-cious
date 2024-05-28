package com.pluralsight;

public abstract class Item {
    protected String name;
    protected double price;
    //Constructor for creating an item with the specified name.
    public Item(String name) {
        this.name = name;
    }
     //Abstract method to calculate the cost of the item.
    public abstract double calculateCost();

      // Returns a string representation of the item, including its name and price.
    @Override
    public String toString() {
        return name + " - $" + String.format("%.2f", price);
    }
}
