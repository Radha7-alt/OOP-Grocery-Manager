import java.util.Scanner;

/**
 * GroceryManager is a simple grocery management system
 * that uses parallel arrays to manage item names,
 * prices, and stock quantities.
 */
public class GroceryManager {

    public static void printInventory(String[] names, double[] prices, int[] stocks) {
        System.out.println("=== Current Inventory ===");

        boolean hasItems = false;

        for (int i = 0; i < names.length; i++) {
            if (names[i] != null) {
                hasItems = true;
                System.out.printf("%d: %s - $%.2f (Stock: %d)%n",
                        i, names[i], prices[i], stocks[i]);
            }
        }

        if (!hasItems) {
            System.out.println("Inventory is empty.");
        }
    }

    public static void restockItem(String[] names, int[] stocks, String target, int amount) {
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null && names[i].equalsIgnoreCase(target)) {
                stocks[i] += amount;
                System.out.println("Item restocked successfully!");
                return;
            }
        }

        System.out.println("Item not found.");
    }

    public static void main(String[] args) {

        String[] itemNames = new String[10];
        double[] itemPrices = new double[10];
        int[] itemStocks = new int[10];

        // Sample data
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
            System.out.println("\n--- Grocery Management System ---");
            System.out.println("1. View Inventory");
            System.out.println("2. Restock Item");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {

                printInventory(itemNames, itemPrices, itemStocks);

            } else if (choice.equals("2")) {

                System.out.print("Enter item name to restock: ");
                String target = scanner.nextLine();

                System.out.print("Enter amount to add: ");
                int amount = Integer.parseInt(scanner.nextLine());

                restockItem(itemNames, itemStocks, target, amount);

            } else if (choice.equals("3")) {

                System.out.println("Exiting program. Goodbye!");
                break;

            } else {

                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}