package com.pluralsight;

import java.util.ArrayList;

public class Sandwich extends Item {
    private static final double BASE_PRICES[] = {5.50, 7.00, 8.50};
    private static final double MEAT_PRICES[] = {1.00, 2.00, 3.00};
    private static final double EXTRA_MEAT_PRICES[] = {0.50, 1.00, 1.50};
    private static final double CHEESE_PRICES[] = {0.75, 1.50, 2.25};
    private static final double EXTRA_CHEESE_PRICES[] = {0.30, 0.60, 0.90};

    private int size;  // 4, 8, or 12
    private String bread;
    private ArrayList<String[]> meats;  // [meat, "extra" or "regular"]
    private ArrayList<String[]> cheeses;  // [cheese, "extra" or "regular"]
    private ArrayList<String> toppings;
    private ArrayList<String> sauces;
    private boolean toasted;

    public Sandwich(int size, String bread, ArrayList<String[]> meats, ArrayList<String[]> cheeses, ArrayList<String> toppings, ArrayList<String> sauces, boolean toasted) {
        super(size + "\" Sandwich");
        this.size = size;
        this.bread = bread;
        this.meats = meats;
        this.cheeses = cheeses;
        this.toppings = toppings;
        this.sauces = sauces;
        this.toasted = toasted;
        this.price = calculateCost();
    }
       // Calculates and returns the cost of the sandwich based on its size, meats, and cheeses.
    @Override
    public double calculateCost() {
        double cost = BASE_PRICES[(size / 4) - 1];
        for (String[] meat : meats) {
            cost += MEAT_PRICES[(size / 4) - 1];
            if ("extra".equals(meat[1])) {
                cost += EXTRA_MEAT_PRICES[(size / 4) - 1];
            }
        }
        for (String[] cheese : cheeses) {
            cost += CHEESE_PRICES[(size / 4) - 1];
            if ("extra".equals(cheese[1])) {
                cost += EXTRA_CHEESE_PRICES[(size / 4) - 1];
            }
        }
        return cost;
    }
     // Returns a string representation of the sandwich, including its size, bread type, meats, cheeses, toppings, sauces, and toasting option.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(size).append("\" ").append(bread).append(" Sandwich with meats: ");
        for (String[] meat : meats) {
            sb.append(meat[0]).append(" (").append(meat[1]).append("), ");
        }
        sb.append("cheeses: ");
        for (String[] cheese : cheeses) {
            sb.append(cheese[0]).append(" (").append(cheese[1]).append("), ");
        }
        sb.append("toppings: ").append(String.join(", ", toppings)).append(", ");
        sb.append("sauces: ").append(String.join(", ", sauces)).append(", ");
        sb.append("toasted: ").append(toasted);
        return sb.toString();
    }
}