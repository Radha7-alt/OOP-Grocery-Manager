/**
 * GroceryManager is a simple program for managing a grocery inventory
 * using parallel arrays. This class currently includes the functionality
 * for displaying the inventory (Task 1).
 *
 * <p>This file was implemented by the Task 1 team member.</p>
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
                System.out.printf("%d: %s - $%.2f (Stock: %d)%n",
                        i, names[i], prices[i], stocks[i]);
            }
        }

        if (!hasItems) {
            System.out.println("Inventory is empty.");
        }
    }

    /**
    * Restocks an item by searching for its name and increasing its stock.
    * If the item is not found after scanning the entire array, prints "Item not found."
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
                return;
            }
        }

        System.out.println("Item not found.");
    }

    /**
     * Temporary main method for testing Task 1 only.
     * The teammate doing Task 3 will replace this with the final menu system.
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

        itemNames[3] = "Milk";
        itemPrices[3] = 3.20;
        itemStocks[3] = 12;

        // Test the Task 1 method
        printInventory(itemNames, itemPrices, itemStocks);

        // Test Task 2
        System.out.println("\n--- Restocking Apples by 5 ---");
        restockItem(itemNames, itemStocks, "Apples", 5);

        // Print inventory again to verify change
        printInventory(itemNames, itemPrices, itemStocks);

        // Item not found case
        System.out.println("\n--- Trying to restock Bananas ---");
        restockItem(itemNames, itemStocks, "Bananas", 3);

    }
}