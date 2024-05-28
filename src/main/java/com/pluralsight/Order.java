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

    public Order() {
        this.orderId = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        this.items = new ArrayList<>();
        this.totalCost = 0.0;
    }

    public void addItem(Item item) {
        this.items.add(item);
        this.totalCost += item.calculateCost();
    }

    public double calculateTotal() {
        return this.totalCost;
    }

    /* public void generateReceipt() {
         String receiptPath = "receipts/" + this.orderId + ".txt";
         try (FileWriter file = new FileWriter(receiptPath)) {
             file.write("Order ID: " + this.orderId + "\n");
             file.write("Items:\n");
             for (Item item : items) {
                 file.write(item + "\n");
             }
             file.write("Total Cost: $" + String.format("%.2f", this.totalCost) + "\n");
             System.out.println("Receipt saved to " + receiptPath);
         } catch (IOException e) {
             System.out.println("something went wrong.");
             e.printStackTrace();
         } */
    public void generateReceipt() {
        String receiptDirectory = "receipts";
        String receiptPath = receiptDirectory + "/" + this.orderId + ".txt";

        // Ensure the "receipts" directory exists
        File receiptsDir = new File(receiptDirectory);
        if (!receiptsDir.exists()) {
            if (!receiptsDir.mkdir()) {
                System.out.println("Failed to create receipts directory.");
                return;
            }
        }

        try (FileWriter file = new FileWriter(receiptPath)) {
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

