package com.pluralsight.ui;

import com.pluralsight.enums.BreadType;
import com.pluralsight.enums.MeatType;
import com.pluralsight.enums.SandwichSize;
import com.pluralsight.models.Order;
import com.pluralsight.models.Sandwich;
import com.pluralsight.models.toppings.Meat;

import java.util.Scanner;


public class UserInterface {
    private Scanner scanner;
    private Order order;

    public UserInterface(){
        this.scanner = new Scanner(System.in);
    }

    public void displayHomeScreen() {
        boolean running = true;
        while (running) {
            System.out.println("=== Welcome to Bog's Bites ===");
            System.out.println("1. New Order");
            System.out.println("0. Exit");

            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> {
                    this.order = new Order();
                    displayOrderScreen();
                }
                case 0 -> {
                    System.out.println("GoodBye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    public void displayOrderScreen() {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Order ===");
            System.out.println("1. Add Sandwich");
            System.out.println("2. Add Drink");
            System.out.println("3. Add Chips");
            System.out.println("4. Checkout");
            System.out.println("0. Cancel Order");

            int choice = readInt("Enter your choice");

            switch (choice) {
                case 1 -> System.out.println("Add Sandwich");
                case 2 -> System.out.println("Add Drink");
                case 3 -> System.out.println("Add Chips");
                case 4 -> System.out.println("Checkout");
                case 0 -> {
                    System.out.println("Order Cancelled");
                    running = false;
                }
                default -> System.out.println("Invalid Input");
            }
        }
    }

    public Sandwich processAddSandwich() {}

    public SandwichSize selectSandwichSize() {
        while (true) {
            System.out.println("\n=== Bread Type ===");
            System.out.println("1. 4 Inch");
            System.out.println("2. 8 Inch");
            System.out.println("3. 12 Inch");
            System.out.println("0. Go Back");

            int choice = readInt("Please select your bread type: ");

            switch (choice) {
                case 1 -> {
                    return SandwichSize.FOUR;
                }
                case 2 -> {
                    return SandwichSize.EIGHT;
                }
                case 3 -> {
                    return SandwichSize.TWELVE;
                }
                case 0 -> {
                    System.out.println("Going back to Sandwich Maker");
                    return null;
                }
                default -> System.out.println("Invalid Choice");
            }
        }
    }

    public BreadType selectBreadType() {
        while (true) {
            System.out.println("\n=== Bread Type ===");
            System.out.println("1. White (recommended)");
            System.out.println("2. Wheat");
            System.out.println("3. Rye");
            System.out.println("4. Wrap");
            System.out.println("0. Go Back");

            int choice = readInt("Please select your bread type: ");

            switch (choice) {
                case 1 -> {
                    return BreadType.WHITE;
                }
                case 2 -> {
                    return BreadType.WHEAT;
                }
                case 3 -> {
                    return BreadType.RYE;
                }
                case 4 -> {
                    return BreadType.WRAP;
                }
                case 0 -> {
                    System.out.println("Going back to Sandwich Maker");
                    return null;
                }
                default -> System.out.println("Invalid Choice");
            }
        }
    }

    public MeatType selectMeat() {
        while (true) {
            System.out.println("\n=== Meat Selection ===");
            System.out.println("1. Steak");
            System.out.println("2. Ham");
            System.out.println("3. Salami");
            System.out.println("4. Roast Beef");
            System.out.println("5. Chicken");
            System.out.println("6. Bacon");
            System.out.println("0. Go Back");

            int choice = readInt("Select your meat: ");

            switch (choice) {
                case 1 -> {
                    return MeatType.STEAK;
                }
                case 2 -> {
                    return MeatType.HAM;
                }
                case 3 -> {
                    return MeatType.SALAMI;
                }
                case 4 -> {
                    return MeatType.ROAST_BEEF;
                }
                case 5 -> {
                    return MeatType.CHICKEN;
                }
                case 6 -> {
                    return MeatType.BACON;
                }
                case 0 -> {
                    System.out.println("Going back to Sandwich Maker");
                    return null;
                }
                default -> System.out.println("Invalid Choice");
            }
        }
    }


    /*---------------------------------------------------------------
     *                       Helper Methods
     * --------------------------------------------------------------*/
    private String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private int readInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(readString(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a whole number.");
            }
        }
    }

    private double readDouble(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(readString(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number");
            }
        }
    }

    private void displayOrder() {

    }
}
