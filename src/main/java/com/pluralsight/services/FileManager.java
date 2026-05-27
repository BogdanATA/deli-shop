package com.pluralsight.services;

import com.pluralsight.models.Order;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManager {

    public static void saveReceipt(Order order) {
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss"));
        File file = new File("receipts/" + timestamp + ".txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("BOG'S BITES RECEIPT");
            bw.newLine();
            bw.write("Date: " + timestamp);
            bw.newLine();
            bw.write("----------------------------");
            bw.newLine();

            order.getItems().stream()
                    .forEach(item -> {
                        try {
                            bw.write(item.toString());
                            bw.newLine();
                        } catch (IOException e) {
                            System.out.println("error writing item");
                        }
                    });

            bw.write("----------------------------");
            bw.newLine();
            bw.write("TOTAL: $" + String.format("%.2f", order.getTotalPrice()));
            bw.newLine();
            bw.write("Thank you for visiting Bog's Bites!");

        } catch (IOException e) {
            System.out.println("Error saving receipt");
        }
    }
}
