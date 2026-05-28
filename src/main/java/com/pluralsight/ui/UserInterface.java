package com.pluralsight.ui;

import com.pluralsight.enums.*;
import com.pluralsight.models.Chips;
import com.pluralsight.models.Drink;
import com.pluralsight.models.Order;
import com.pluralsight.models.Sandwich;
import com.pluralsight.models.toppings.*;
import com.pluralsight.services.FileManager;

import java.util.Scanner;


public class UserInterface {
    private static final String CYAN = "\u001B[36m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RESET = "\u001B[0m";

    private Scanner scanner;
    private Order order;

    public UserInterface(){
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the home screen and handles navigation to a new order or exit
     */
    public void displayHomeScreen() {
        boolean running = true;
        while (running) {
            System.out.println("\n" + CYAN + "=== Welcome to Bog's Bites ===" + RESET);
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
                default -> System.out.println(YELLOW + "Invalid choice." + RESET);
            }
        }
        scanner.close();
    }

    /**
     * Displays the order screen and handles adding items, checkout, and cancellation
     */
    private void displayOrderScreen() {
        boolean running = true;
        while (running) {
            System.out.println("\n" + CYAN + "=== Your Current Order ===" + RESET);
            System.out.println(order);
            System.out.println("\n" + CYAN + "=== Order ===" + RESET);
            System.out.println("1. Add Sandwich");
            System.out.println("2. Add Drink");
            System.out.println("3. Add Chips");
            System.out.println("4. Checkout");
            System.out.println("5. Remove Item");
            System.out.println("0. Cancel Order");

            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> {
                    Sandwich sandwich = processAddSandwich();
                    order.addItem(sandwich);
                }
                case 2 -> {
                    Drink drink = processAddDrink();
                    if (drink != null) {
                        order.addItem(drink);
                    }
                }
                case 3 -> {
                    Chips chips = processAddChips();
                    if (chips != null) {
                        order.addItem(chips);
                    }
                }
                case 4 -> {
                    if (order.getItems().isEmpty()){
                        System.out.println(YELLOW + "\nYou must add atleast one item before checking out" + RESET);
                    } else {
                        running = displayCheckoutScreen();
                    }
                }
                case 5 -> removeItemFromOrder();
                case 0 -> {
                    System.out.println("Order Cancelled");
                    running = false;
                }
                default -> System.out.println(YELLOW + "Invalid Input" + RESET);
            }
        }
    }

    /*---------------------------------------------------------------
     *                       SANDWICH
     * --------------------------------------------------------------*/

    /**
     * Guides the user through building a sandwich and returns the completed sandwich
     *
     * @return The fully completed Sandwich
     */
    private Sandwich processAddSandwich() {
        BreadType breadType = selectBreadType();

        SandwichSize sandwichSize = selectSandwichSize();

        Sandwich sandwich = new Sandwich(breadType, sandwichSize);
        //Meat
        int meatCount = 0;
        while (meatCount < 2) {
            MeatType meatType = selectMeat();
            if (meatType == null) break;
            sandwich.addTopping(new Meat(meatType));
            meatCount++;
            if (meatCount == 2) {
                System.out.println(YELLOW + "\nMax of 2 Meats reached!" + RESET);
            }
        }
        //Cheese
        int cheeseCount= 0;
        while (cheeseCount < 2) {
            CheeseType cheeseType = selectCheese();
            if (cheeseType == null) break;
            sandwich.addTopping(new Cheese(cheeseType));
            cheeseCount++;
            if (cheeseCount == 2) {
                System.out.println(YELLOW + "\nMax of 2 Cheeses reached!" + RESET);
            }
        }
        //Toppings
        int toppingCount = 0;
        while (toppingCount < 6) {
            RegularToppingType toppingType = selectRegularToppings();
            if (toppingType == null) break;
            sandwich.addTopping(new RegularTopping(toppingType));
            toppingCount++;
            if (toppingCount == 6) {
                System.out.println(YELLOW + "\nMax of 6 Toppings reached!" + RESET);
            }
        }
        //Sauce
        int sauceCount = 0;
        while (sauceCount < 3) {
            SauceType sauceType = selectSauce();
            if (sauceType == null) break;
            sandwich.addTopping(new Sauce(sauceType));
            sauceCount++;
            if (sauceCount == 3) {
                System.out.println(YELLOW + "\nMax of 3 Sauces reached!" + RESET);
            }
        }
        //Side
        int sideCount = 0;
        while (sideCount < 2) {
            SideType sideType = selectSide();
            if (sideType == null) break;
            sandwich.addTopping(new Side(sideType));
            sideCount++;
            if(sideCount == 2) {
                System.out.println(YELLOW + "\nMax of 2 Sides reached!" + RESET);
            }
        }
        toastSandwich(sandwich);

        return sandwich;
    }

    /**
     * Prompts the user to select a bread type and returns their choice
     *
     * @return The selected BreadType
     */
    private BreadType selectBreadType() {
        while (true) {
            System.out.println("\n" + CYAN + "=== Bread Type ===" + RESET);
            System.out.println("1. White (recommended)");
            System.out.println("2. Wheat");
            System.out.println("3. Rye");
            System.out.println("4. Wrap");

            int choice = readInt("Please select your bread type: ");

            switch (choice) {
                case 1 -> { return BreadType.WHITE; }
                case 2 -> { return BreadType.WHEAT; }
                case 3 -> { return BreadType.RYE; }
                case 4 -> { return BreadType.WRAP; }
                default -> System.out.println(YELLOW + "Invalid Choice" + RESET);
            }
        }
    }

    /**
     * Prompts the user to select a sandwich size and returns their choice
     *
     * @return The selected SandwichSize
     */
    private SandwichSize selectSandwichSize() {
        while (true) {
            System.out.println("\n" + CYAN + "=== Sandwich Size ===" + RESET);
            System.out.println("1. 4 Inch");
            System.out.println("2. 8 Inch");
            System.out.println("3. 12 Inch");

            int choice = readInt("Please select your sandwich size: ");

            switch (choice) {
                case 1 -> { return SandwichSize.FOUR; }
                case 2 -> { return SandwichSize.EIGHT; }
                case 3 -> { return SandwichSize.TWELVE; }
                default -> System.out.println(YELLOW + "Invalid Choice" + RESET);
            }
        }
    }

    /**
     * Prompts the user to select a meat topping and returns their choice
     *
     * @return The selected MeatType, or null if the user is done adding meat
     */
    private MeatType selectMeat() {
        while (true) {
            System.out.println("\n" + CYAN + "=== Meat Selection ===" + RESET);
            System.out.println(YELLOW + "Maximum of 2 Meats" + RESET);
            System.out.println("1. Steak");
            System.out.println("2. Ham");
            System.out.println("3. Salami");
            System.out.println("4. Roast Beef");
            System.out.println("5. Chicken");
            System.out.println("6. Bacon");
            System.out.println("0. Done");

            int choice = readInt("Select your meat: ");

            switch (choice) {
                case 1 -> { return MeatType.STEAK; }
                case 2 -> { return MeatType.HAM; }
                case 3 -> { return MeatType.SALAMI; }
                case 4 -> { return MeatType.ROAST_BEEF; }
                case 5 -> { return MeatType.CHICKEN; }
                case 6 -> { return MeatType.BACON; }
                case 0 -> { return null; }
                default -> System.out.println(YELLOW + "Invalid Choice" + RESET);
            }
        }
    }

    /**
     * Prompts the user to select a cheese topping and returns their choice
     *
     * @return The selected CheeseType, or null if the user is done adding cheese
     */
    private CheeseType selectCheese() {
        while (true) {
            System.out.println("\n" + CYAN + "=== Cheese Selection ===" + RESET);
            System.out.println(YELLOW + "Maximum of 2 Cheeses" + RESET);
            System.out.println("1. American");
            System.out.println("2. Provolone");
            System.out.println("3. Cheddar");
            System.out.println("4. Swiss");
            System.out.println("0. Done");

            int choice = readInt("Select your Cheese: ");

            switch (choice) {
                case 1 -> { return CheeseType.AMERICAN; }
                case 2 -> { return CheeseType.PROVOLONE; }
                case 3 -> { return CheeseType.CHEDDAR; }
                case 4 -> { return CheeseType.SWISS; }
                case 0 -> { return null; }
                default -> System.out.println(YELLOW + "Invalid Choice" + RESET);
            }
        }
    }

    /**
     * Prompts the user to select a regular topping and returns their choice
     *
     * @return The selected RegularToppingType, or null if the user is done adding toppings
     */
    private RegularToppingType selectRegularToppings() {
        while (true) {
            System.out.println("\n" + CYAN + "=== Topping Selection ===" + RESET);
            System.out.println(YELLOW + "Maximum of 6 Toppings" + RESET);
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
                case 1 -> { return RegularToppingType.LETTUCE; }
                case 2 -> { return RegularToppingType.PEPPERS; }
                case 3 -> { return RegularToppingType.ONIONS; }
                case 4 -> { return RegularToppingType.TOMATOES; }
                case 5 -> { return RegularToppingType.JALAPENOS; }
                case 6 -> { return RegularToppingType.CUCUMBERS; }
                case 7 -> { return RegularToppingType.PICKLES; }
                case 8 -> { return RegularToppingType.GUACAMOLE; }
                case 9 -> { return RegularToppingType.MUSHROOMS; }
                case 0 -> { return null; }
                default -> System.out.println(YELLOW + "Invalid Choice" + RESET);
            }
        }
    }

    /**
     * Prompts the user to select a sauce and returns their choice
     *
     * @return The selected SauceType, or null if the user is done adding sauce
     */
    private SauceType selectSauce() {
        while (true) {
            System.out.println("\n" + CYAN + "=== Sauce Selection ===" + RESET);
            System.out.println(YELLOW + "Maximum of 3 Sauces" + RESET);
            System.out.println("1. Mayo");
            System.out.println("2. Mustard");
            System.out.println("3. Ketchup");
            System.out.println("4. Ranch");
            System.out.println("5. Thousand Islands");
            System.out.println("6. Vinaigrette");
            System.out.println("0. Done");

            int choice = readInt("Select your sauce: ");

            switch (choice) {
                case 1 -> { return SauceType.MAYO; }
                case 2 -> { return SauceType.MUSTARD; }
                case 3 -> { return SauceType.KETCHUP; }
                case 4 -> { return SauceType.RANCH; }
                case 5 -> { return SauceType.THOUSAND_ISLANDS; }
                case 6 -> { return SauceType.VINAIGRETTE; }
                case 0 -> { return null; }
                default -> System.out.println(YELLOW + "Invalid Choice" + RESET);
            }
        }
    }

    /**
     * Prompts the user to select a side and returns their choice
     *
     * @return The selected SideType, or null if the user is done adding sides
     */
    private SideType selectSide() {
        while (true) {
            System.out.println("\n" + CYAN + "=== Side Selection ===" + RESET);
            System.out.println(YELLOW + "Maximum of 2 Sides" + RESET);
            System.out.println("1. Au Jus");
            System.out.println("2. Sauce");
            System.out.println("0. Done");

            int choice = readInt("Select your side: ");

            switch (choice) {
                case 1 -> { return SideType.AU_JUS; }
                case 2 -> { return SideType.SAUCE; }
                case 0 -> { return null; }
                default -> System.out.println(YELLOW + "Invalid Choice" + RESET);
            }
        }
    }

    /**
     * Prompts the user to choose whether to toast their sandwich
     *
     * @param sandwich The sandwich to toast
     */
    private void toastSandwich(Sandwich sandwich) {
        while (true) {
            System.out.println("\n" + CYAN + "=== Toast Sandwich ===" + RESET);
            System.out.println("1. Yes");
            System.out.println("2. No");

            int choice = readInt("Would you like the bread toasted?: ");

            switch (choice) {
                case 1 -> { sandwich.setToasted(true); return; }
                case 2 -> { return; }
                default -> System.out.println(YELLOW + "Invalid Input" + RESET);
            }
        }
    }

    /*---------------------------------------------------------------
     *                       DRINK
     * --------------------------------------------------------------*/

    /**
     * Guides the user through selecting a drink and returns the completed drink
     *
     * @return The fully configured Drink, or null if the user went back
     */
    private Drink processAddDrink() {
        DrinkFlavor drinkFlavor = selectDrinkFlavor();
        if (drinkFlavor == null) {
            return null;
        }
        DrinkSize drinkSize = selectDrinkSize();
        return new Drink(drinkFlavor, drinkSize);
    }

    /**
     * Prompts the user to select a drink flavor and returns their choice
     *
     * @return The selected DrinkFlavor, or null if the user went back
     */
    private DrinkFlavor selectDrinkFlavor() {
        while (true) {
            System.out.println("\n" + CYAN + "=== Drink Flavor Selection ===" + RESET);
            System.out.println("1. Coke");
            System.out.println("2. Diet Coke");
            System.out.println("3. Sprite");
            System.out.println("0. Go Back");

            int choice = readInt("Select your drink flavor: ");

            switch (choice) {
                case 1 -> { return DrinkFlavor.COKE; }
                case 2 -> { return DrinkFlavor.DIET_COKE; }
                case 3 -> { return DrinkFlavor.SPRITE; }
                case 0 -> { return null; }
                default -> System.out.println(YELLOW + "Invalid Choice" + RESET);
            }
        }
    }

    /**
     * Prompts the user to select a drink size and returns their choice
     *
     * @return The selected DrinkSize
     */
    private DrinkSize selectDrinkSize() {
        while (true) {
            System.out.println("\n" + CYAN + "=== Drink Size Selection ===" + RESET);
            System.out.println("1. Small");
            System.out.println("2. Medium");
            System.out.println("3. Large");

            int choice = readInt("Select your drink size: ");

            switch (choice) {
                case 1 -> { return DrinkSize.SMALL; }
                case 2 -> { return DrinkSize.MEDIUM; }
                case 3 -> { return DrinkSize.LARGE; }
                default -> System.out.println(YELLOW + "Invalid Choice" + RESET);
            }
        }
    }

    /*---------------------------------------------------------------
     *                       CHIPS
     * --------------------------------------------------------------*/

    /**
     * Guides the user through selecting chips and returns the completed chips
     *
     * @return The fully configured Chips, or null if the user went back
     */
    private Chips processAddChips() {
        ChipType chipsType = selectChips();
        if (chipsType == null) return null;
        return new Chips(chipsType);
    }

    /**
     * Prompts the user to select a chip type and returns their choice
     *
     * @return The selected ChipType, or null if the user went back
     */
    private ChipType selectChips() {
        while (true) {
            System.out.println("\n" + CYAN + "=== Chips Selection ===" + RESET);
            System.out.println("1. Lays Plain");
            System.out.println("2. Sun Chips Cheddar");
            System.out.println("3. Sun Chips Salsa");
            System.out.println("0. Go Back");

            int choice = readInt("Select your Chips: ");

            switch (choice) {
                case 1 -> { return ChipType.LAYS_PLAIN; }
                case 2 -> { return ChipType.SUN_CHIPS_CHEDDAR; }
                case 3 -> { return ChipType.SUN_CHIPS_SALSA; }
                case 0 -> { return null; }
                default -> System.out.println(YELLOW + "Invalid Choice" + RESET);
            }
        }
    }

    /**
     * Displays the checkout screen and returns whether the order loop should keep running
     *
     * @return True if the user cancelled and should return to the order screen, false if confirmed
     */
    private boolean displayCheckoutScreen() {
        while (true) {
            System.out.println("\n" + CYAN + "=== Checkout ===" + RESET);
            System.out.println("Order Summary:");
            System.out.println("----------------------------");

            order.getItems().stream()
                    .forEach(item -> System.out.println(item));

            System.out.println("----------------------------");
            System.out.printf("Total: $%.2f%n", order.getTotalPrice());
            System.out.println("----------------------------");

            System.out.println("\n1. Confirm Order");
            System.out.println("0. Cancel Order");

            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> {
                    FileManager.saveReceipt(order);
                    System.out.println("Order confirmed! Receipt saved.");
                    return false;
                }
                case 0 -> {
                    System.out.println("Order cancelled.");
                    return true;
                }
                default -> System.out.println(YELLOW + "Invalid choice." + RESET);
            }
        }
    }

    private void removeItemFromOrder() {
        if (order.getItems().isEmpty()) {
            System.out.println("\nNo items in order");
        }

        System.out.println("\n=== Remove Item ===");
        for (int i = 0; i < order.getItems().size(); i++) {
            System.out.println("[" + (i + 1) + "]" + order.getItems().get(i).getName());
        }
        System.out.println("\nEnter item number to remove or 0 to cancel");
        int choice = readInt("Enter item number to remove: ");

        if (choice == 0) return;

        if (choice < 1 || choice > order.getItems().size()) {
            System.out.println("Invalid choice");
        } else {
            System.out.println("Item Removed");
            order.getItems().remove(choice -1);
        }
    }


    /*---------------------------------------------------------------
     *                       Helper Methods
     * --------------------------------------------------------------*/

    /**
     * Prints a prompt and reads a line of text from the user
     *
     * @param prompt The message to display before reading input
     * @return The trimmed string entered by the user
     */
    private String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    /**
     * Prints a prompt and reads a valid integer from the user, re-prompting on invalid input
     *
     * @param prompt The message to display before reading input
     * @return The integer entered by the user
     */
    private int readInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(readString(prompt));
            } catch (NumberFormatException e) {
                System.out.println(YELLOW + "Invalid input, please enter a whole number." + RESET);
            }
        }
    }
}