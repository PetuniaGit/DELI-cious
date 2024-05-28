package com.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Order {
    private String orderId;
    public ArrayList<Item> items;
    private double totalCost;
      // Constructor for creating a new order with a unique order ID, an empty list of items,
      //  and a total cost of 0.0.
    public Order() {
        this.orderId = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        this.items = new ArrayList<>();
        this.totalCost = 0.0;
    }
     // Adds an item to the order and updates the total cost accordingly.
    public void addItem(Item item) {
        this.items.add(item);
        this.totalCost += item.calculateCost();
    }
     // Calculates and returns the total cost of the order.
    public double calculateTotal() {
        return this.totalCost;
    }


    // Generates a receipt for the order and saves it to a file.
    public void generateReceipt() {
        String receiptDirectory = "receipts";
        String receiptPath = receiptDirectory + "/" + this.orderId + ".txt";

        // Ensure the "receipts" directory exists; create it if it doesn't
        File receiptsDir = new File(receiptDirectory);
        if (!receiptsDir.exists()) {
            if (!receiptsDir.mkdir()) {
                System.out.println("Failed to create receipts directory.");
                return;
            }
        }

        try (FileWriter file = new FileWriter(receiptPath)) {
            // Write order details to the receipt file
            file.write("Order ID: " + this.orderId + "\n");
            file.write("Items:\n");
            for (Item item : items) {
                file.write(item + "\n");
            }
            file.write("Total Cost: $" + String.format("%.2f", this.totalCost) + "\n");
            System.out.println("Receipt saved to " + receiptPath);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the receipt.");
            e.printStackTrace();
        }
    }
}

