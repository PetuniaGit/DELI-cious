package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApplication {
    private Order currentOrder;

    public static void main(String[] args) {
        MainApplication app = new MainApplication();
        app.start();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            String choice = scanner.nextLine();
            if ("1".equals(choice)) {
                newOrder(scanner);
            } else if ("0".equals(choice)) {
                break;
            }
        }
        scanner.close();
    }

    private void newOrder(Scanner scanner) {
        currentOrder = new Order();
        while (true) {
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            String choice = scanner.nextLine();
            if ("1".equals(choice)) {
                addSandwich(scanner);
            } else if ("2".equals(choice)) {
                addDrink(scanner);
            } else if ("3".equals(choice)) {
                addChips(scanner);
            } else if ("4".equals(choice)) {
                checkout(scanner);
                break;
            } else if ("0".equals(choice)) {
                cancelOrder();
                break;
            }
        }
    }

    private void addSandwich(Scanner scanner) {
        System.out.print("Select size (4, 8, 12): ");
        int size = Integer.parseInt(scanner.nextLine());
        System.out.print("Select bread (white, wheat, rye, wrap): ");
        String bread = scanner.nextLine();


        ArrayList<String[]> meats = new ArrayList<>();
        while (true) {
            System.out.print("Add meat (steak, ham, salami, roast beef, chicken, bacon, none to stop): ");
            String meat = scanner.nextLine();
            if ("none".equals(meat)) break;
            System.out.print("Extra meat? (yes or no): ");
            String extra = scanner.nextLine();
            if ("yes".equals(extra)) {
                meats.add(new String[]{meat, "extra"});
            } else {
                meats.add(new String[]{meat, "regular"});
            }
        }

        ArrayList<String[]> cheeses = new ArrayList<>();
        while (true) {
            System.out.print("Add cheese (american, provolone, cheddar, swiss, none to stop): ");
            String cheese = scanner.nextLine();
            if ("none".equals(cheese)) break;
            System.out.print("Extra cheese? (yes or no): ");
            String extra = scanner.nextLine();
            cheeses.add(new String[]{cheese, "yes".equals(extra) ? "extra" : "regular"});
        }

        ArrayList<String> toppings = new ArrayList<>();
        while (true) {
            System.out.print("Add topping (lettuce, peppers, onions, tomatoes, jalapenos, cucumbers, pickles, guacamole, mushrooms, none to stop): ");
            String topping = scanner.nextLine();
            if ("none".equals(topping)) break;
            toppings.add(topping);
        }

        ArrayList<String> sauces = new ArrayList<>();
        while (true) {
            System.out.print("Add sauce (mayo, mustard, ketchup, ranch, thousand islands, vinaigrette, none to stop): ");
            String sauce = scanner.nextLine();
            if ("none".equals(sauce)) break;
            sauces.add(sauce);
        }

        System.out.print("Would you like the sandwich toasted? (yes or no): ");
        boolean toasted = "yes".equals(scanner.nextLine());

        Sandwich sandwich = new Sandwich(size, bread, meats, cheeses, toppings, sauces, toasted);
        currentOrder.addItem(sandwich);
    }

    private void addDrink(Scanner scanner) {
        System.out.print("Select drink size (small, medium, large): ");
        String size = scanner.nextLine();
        System.out.print("Select drink flavor: ");
        String flavor = scanner.nextLine();
        Drink drink = new Drink(size, flavor);
        currentOrder.addItem(drink);
    }

    private void addChips(Scanner scanner) {
        System.out.print("Select chip type: ");
        String type = scanner.nextLine();
        Chip chip = new Chip(type);
        currentOrder.addItem(chip);
    }

    private void checkout(Scanner scanner) {
        System.out.println("Order Details:");
        for (Item item : currentOrder.items) {
            System.out.println(item);
        }
        System.out.println("Total Cost: $" + String.format("%.2f", currentOrder.calculateTotal()));
        System.out.print("Confirm order? (yes or no): ");
        if ("yes".equals(scanner.nextLine())) {
            currentOrder.generateReceipt();
            System.out.println("Order confirmed and receipt generated.");
        } else {
            System.out.println("Order canceled.");
        }
    }

    private void cancelOrder() {
        System.out.println("Order has been canceled.");
        currentOrder = null;
    }
}

