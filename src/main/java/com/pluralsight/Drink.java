package com.pluralsight;

public class Drink extends Item {
    private static final double DRINK_PRICES[] = {2.00, 2.50, 3.00};

    private String size;  // small, medium, large
    private String flavor;

    public Drink(String size, String flavor) {
        super(size + " Drink");
        this.size = size;
        this.flavor = flavor;
        this.price = calculateCost();
    }

    @Override
    public double calculateCost() {
        switch (size) {
            case "small":
                return DRINK_PRICES[0];
            case "medium":
                return DRINK_PRICES[1];
            case "large":
                return DRINK_PRICES[2];
            default:
                return 0.0;
        }
    }

    @Override
    public String toString() {
        return size + " " + flavor + " Drink";
    }
}
