import java.util.Scanner;

/**
 * GroceryManager is a simple program for managing a grocery inventory
 * using parallel arrays. This class includes functionality for displaying
 * the inventory (Task 1), restocking items (Task 2), and a user menu
 * for interacting with the system (Task 3).
 *
 * <p>This class was completed collaboratively by the team members
 * for CS3354 Assignment 1.</p>
 */
public class GroceryManager {

    /**
     * Prints all non-empty inventory items from the given parallel arrays.
     * A slot is considered "non-empty" if {@code names[i] != null}.
     *
     * @param names  an array of item names (null means empty slot)
     * @param prices an array of item prices for each corresponding name
     * @param stocks an array representing stock count for each item
     */
    public static void printInventory(String[] names, double[] prices, int[] stocks) {
        System.out.println("=== Current Inventory ===");

        boolean hasItems = false; // To check if any item prints

        for (int i = 0; i < names.length; i++) {
            // Only print items where the name is not null
            if (names[i] != null) {
                hasItems = true;

                // Example format:
                // 0: Apples - $1.50 (Stock: 10)
                System.out.printf(
                        "%d: %s - $%.2f (Stock: %d)%n",
                        i, names[i], prices[i], stocks[i]
                );
            }
        }

        if (!hasItems) {
            System.out.println("Inventory is empty.");
        }
    }

    /**
     * Restocks an item by searching for its name and increasing its stock.
     * If the item is not found after scanning the entire array,
     * prints "Item not found."
     *
     * @param names  array of item names (null means empty slot)
     * @param stocks array of stock counts corresponding to item names
     * @param target the item name to search for
     * @param amount the amount to add to the item's stock
     */
    public static void restockItem(String[] names, int[] stocks, String target, int amount) {
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null && names[i].equalsIgnoreCase(target)) {
                stocks[i] += amount;
                System.out.println("Restocked " + target + " by " + amount + ".");
                return;
            }
        }

        System.out.println("Item not found.");
    }

    /**
     * Main method that creates the inventory arrays and provides a menu
     * for the user to view and restock items.
     * <p>
     * Menu:
     * <ul>
     *     <li>1 - View inventory</li>
     *     <li>2 - Restock an item</li>
     *     <li>3 - Exit the program</li>
     * </ul>
     */
    public static void main(String[] args) {
        // Create the arrays required for the assignment
        String[] itemNames = new String[10];
        double[] itemPrices = new double[10];
        int[] itemStocks = new int[10];

        // Add sample data to verify output
        itemNames[0] = "Apples";
        itemPrices[0] = 1.50;
        itemStocks[0] = 10;

        itemNames[1] = "Bread";
        itemPrices[1] = 2.75;
        itemStocks[1] = 5;

        itemNames[2] = "Milk";
        itemPrices[2] = 3.20;
        itemStocks[2] = 12;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Grocery Manager Menu ===");
            System.out.println("1. View Inventory");
            System.out.println("2. Restock Item");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                // View inventory
                printInventory(itemNames, itemPrices, itemStocks);

            } else if (choice.equals("2")) {
                // Restock item
                System.out.print("Enter the item name to restock: ");
                String target = scanner.nextLine().trim();

                System.out.print("Enter the amount to add: ");
                int amount;
                try {
                    amount = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount. Please enter a whole number.");
                    continue;
                }

                if (amount <= 0) {
                    System.out.println("Amount must be positive.");
                    continue;
                }

                restockItem(itemNames, itemStocks, target, amount);

            } else if (choice.equals("3")) {
                System.out.println("Exiting Grocery Manager. Goodbye!");
                break;

            } else {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }

        scanner.close();
    }
}