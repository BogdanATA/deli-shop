package com.pluralsight.ui;

import com.pluralsight.enums.*;
import com.pluralsight.models.Order;
import com.pluralsight.models.Sandwich;
import com.pluralsight.models.toppings.*;

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

    private void displayOrderScreen() {
        boolean running = true;
        while (running) {
            System.out.println(order);
            System.out.println("\n=== Order ===");
            System.out.println("1. Add Sandwich");
            System.out.println("2. Add Drink");
            System.out.println("3. Add Chips");
            System.out.println("4. Checkout");
            System.out.println("0. Cancel Order");

            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> {
                    Sandwich sandwich = processAddSandwich();
                    order.addItem(sandwich);
                }
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

    private Sandwich processAddSandwich() {
        BreadType breadType = selectBreadType();

        SandwichSize sandwichSize = selectSandwichSize();

        Sandwich sandwich = new Sandwich(breadType, sandwichSize);
        //Meat
        int meatCount = 0;
        while (meatCount < 3) {
            MeatType meatType = selectMeat();
            if (meatType == null) break;
            sandwich.addTopping(new Meat(meatType));
            meatCount++;
        }
        //Cheese
        int cheeseCount= 0;
        while (cheeseCount < 3) {
            CheeseType cheeseType = selectCheese();
            if (cheeseType == null) break;
            sandwich.addTopping(new Cheese(cheeseType));
            cheeseCount++;
        }
        //Toppings
        int toppingCount = 0;
        while (toppingCount < 6) {
            RegularToppingType toppingType = selectRegularToppings();
            if (toppingType == null) break;
            sandwich.addTopping(new RegularTopping(toppingType));
            toppingCount++;
        }
        //Sauce
        int sauceCount = 0;
        while (sauceCount < 3) {
            SauceType sauceType = selectSauce();
            if (sauceType == null) break;
            sandwich.addTopping(new Sauce(sauceType));
            sauceCount++;
        }
        //Side
        int sideCount = 0;
        while (sideCount < 2) {
            SideType sideType = selectSide();
            if (sideType == null) break;
            sandwich.addTopping(new Side(sideType));
            sideCount++;
        }
        toastSandwich(sandwich);

        return sandwich;
    }

    private BreadType selectBreadType() {
        while (true) {
            System.out.println("\n=== Bread Type ===");
            System.out.println("1. White (recommended)");
            System.out.println("2. Wheat");
            System.out.println("3. Rye");
            System.out.println("4. Wrap");

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
                default -> System.out.println("Invalid Choice");
            }
        }
    }

    private SandwichSize selectSandwichSize() {
        while (true) {
            System.out.println("\n=== Bread Type ===");
            System.out.println("1. 4 Inch");
            System.out.println("2. 8 Inch");
            System.out.println("3. 12 Inch");

            int choice = readInt("Please select your sandwich size: ");

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
                default -> System.out.println("Invalid Choice");
            }
        }
    }

    private MeatType selectMeat() {
        while (true) {
            System.out.println("\n=== Meat Selection ===");
            System.out.println("1. Steak");
            System.out.println("2. Ham");
            System.out.println("3. Salami");
            System.out.println("4. Roast Beef");
            System.out.println("5. Chicken");
            System.out.println("6. Bacon");
            System.out.println("0. Done");

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
                    return null;
                }
                default -> System.out.println("Invalid Choice");
            }
        }
    }

    private CheeseType selectCheese() {
        while (true) {
            System.out.println("\n=== Cheese Selection ===");
            System.out.println("1. American");
            System.out.println("2. Provolone");
            System.out.println("3. Cheddar");
            System.out.println("4. Swiss");
            System.out.println("0. Done");

            int choice = readInt("Select your Cheese: ");

            switch (choice) {
                case 1 -> {
                    return CheeseType.AMERICAN;
                }
                case 2 -> {
                    return CheeseType.PROVOLONE;
                }
                case 3 -> {
                    return CheeseType.CHEDDAR;
                }
                case 4 -> {
                    return CheeseType.SWISS;
                }
                case 0 -> {
                    return null;
                }
                default -> System.out.println("Invalid Choice");
            }
        }
    }

    private RegularToppingType selectRegularToppings() {
        while (true) {
            System.out.println("\n=== Topping Selection ===");
            System.out.println("1. Lettuce");
            System.out.println("2. Peppers");
            System.out.println("3. Onions");
            System.out.println("4. Tomatoes");
            System.out.println("5. Jalapenos");
            System.out.println("6. Cucumbers");
            System.out.println("7. Pickles");
            System.out.println("8. Guacamole");
            System.out.println("9. Mushrooms");
            System.out.println("0. Done");

            int choice = readInt("Select your toppings: ");

            switch (choice) {
                case 1 -> {
                    return RegularToppingType.LETTUCE;
                }
                case 2 -> {
                    return RegularToppingType.PEPPERS;
                }
                case 3 -> {
                    return RegularToppingType.ONIONS;
                }
                case 4 -> {
                    return RegularToppingType.TOMATOES;
                }
                case 5 -> {
                    return RegularToppingType.JALAPENOS;
                }
                case 6 -> {
                    return RegularToppingType.CUCUMBERS;
                }
                case 7 -> {
                    return RegularToppingType.PICKLES;
                }
                case 8 -> {
                    return RegularToppingType.GUACAMOLE;
                }
                case 9 -> {
                    return RegularToppingType.MUSHROOMS;
                }
                case 0 -> {
                    return null;
                }
                default -> System.out.println("Invalid Choice");
            }
        }
    }

    private SauceType selectSauce() {
        while (true) {
            System.out.println("\n=== Sauce Selection ===");
            System.out.println("1. Mayo");
            System.out.println("2. Mustard");
            System.out.println("3. Ketchup");
            System.out.println("4. Ranch");
            System.out.println("5. Thousand Islands");
            System.out.println("6. Vinaigrette");
            System.out.println("0. Done");

            int choice = readInt("Select your sauce: ");

            switch (choice) {
                case 1 -> {
                    return SauceType.MAYO;
                }
                case 2 -> {
                    return SauceType.MUSTARD;
                }
                case 3 -> {
                    return SauceType.KETCHUP;
                }
                case 4 -> {
                    return SauceType.RANCH;
                }
                case 5 -> {
                    return SauceType.THOUSAND_ISLANDS;
                }
                case 6 -> {
                    return SauceType.VINAIGRETTE;
                }
                case 0 -> {
                    return null;
                }
                default -> System.out.println("Invalid Choice");
            }
        }
    }

    private SideType selectSide() {
        while (true) {
            System.out.println("\n=== Side Selection ===");
            System.out.println("1. Au Jus");
            System.out.println("2. Sauce");
            System.out.println("0. Done");

            int choice = readInt("Select your side: ");

            switch (choice) {
                case 1 -> {
                    return SideType.AU_JUS;
                }
                case 2 -> {
                    return SideType.SAUCE;
                }
                case 0 -> {
                    return null;
                }
                default -> System.out.println("Invalid Choice");
            }
        }
    }

    private void toastSandwich(Sandwich sandwich) {
        System.out.println("\n=== Toast Sandwich ===");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int choice = readInt("Would you like the bread toasted?: ");

        if (choice == 1) {
            sandwich.setToasted(true);
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

    private void displayOrder(Order order) {

    }
}
