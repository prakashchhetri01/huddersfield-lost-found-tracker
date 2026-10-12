import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.Scanner;
import java.util.Date;  // date class to display current date and time

public class HuddersfieldLostFoundTracker {
                                                                         // Collections to store lost item data
    private static ArrayList<String> items = new ArrayList<>();          // List of all item entries
    private static HashMap<String, String> itemDetails = new HashMap<>(); // Map item name to entry
    private static HashSet<String> uniqueItems = new HashSet<>();       // Set for quick lookup by name
    private static Stack<String> recentItems = new Stack<>();           // Stack for ordering
    private static Scanner scanner = new Scanner(System.in);            // user input

    public static void main(String[] args) {
        System.out.println("=== Welcome to the Huddersfield Bus Station Lost&Found Inquiry Service🔍 ===");
        displayMainMenu();
    }

    private static void displayMainMenu() {          //loop for main menu
        while (true) {
            System.out.println("\n Enter option between 1 to 5 ");
            System.out.println("1. Report lost item");
            System.out.println("2. View all items");
            System.out.println("3. Search items");
            System.out.println("4. Mark item as found");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");

            String choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "1": reportItem(); break;
                case "2": viewItems(); break;
                case "3": searchItems(); break;
                case "4": markAsFound(); break;
                case "5": exitSystem(); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void reportItem() {    //reporting a new lost item
        System.out.print("\nEnter item name: ");
        String name = simpleFormatString(scanner.nextLine());

        if (name.isEmpty()) {
            System.out.println("Item name cannot be empty.");
            return;
        }
        if (uniqueItems.contains(name.toLowerCase())) {
            System.out.println("An item with this name is already registered.");
            return;
        }

        System.out.print("Enter location lost or last seen: ");
        String location = simpleFormatString(scanner.nextLine());

          // creating entry with item name, location and time
        String entry = name.toUpperCase() + " | Location: " + location + " | Reported: " + new Date();

        items.add(entry);    // storing items inside the collections
        recentItems.push(entry);
        uniqueItems.add(name.toLowerCase());
        itemDetails.put(name.toLowerCase(), entry);

        System.out.println("\nItem registered successfully!");
    }

    private static void viewItems() {      // view all reported items in order
        System.out.println("\n=== Lost items (Newest First) ===");
        if (recentItems.isEmpty()) {
            System.out.println("No items reported yet.");
        } else {
            for (int i = recentItems.size() - 1; i >= 0; i--) {
                System.out.println(recentItems.get(i));
            }
        }
    }
    private static void searchItems() {    //search for items
        System.out.print("\nEnter search keyword: ");
        String keyword = simpleFormatString(scanner.nextLine()).toLowerCase();

        System.out.println("\nSearch results:");
        boolean found = false;
        for (String item : items) {
            if (item.toLowerCase().contains(keyword)) {
                System.out.println(item);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching items found.");
        }
    }
    private static void markAsFound() {  //mark item as found and remove from system
        System.out.print("\nEnter item name to mark as found: ");
        String target = simpleFormatString(scanner.nextLine()).toLowerCase();

        if (!uniqueItems.contains(target)) {
            System.out.println("Item not found in records");
            return;
        }

        String entry = itemDetails.get(target);  //remove from collections
        items.remove(entry);
        recentItems.remove(entry);
        uniqueItems.remove(target);
        itemDetails.remove(target);

        System.out.println("Item marked as found and removed from system");
    }

    private static String simpleFormatString(String input) {
        return input.trim(); // string formating to remove unwanted spaces from strings
    }

    private static void exitSystem() {  //exit system
        System.out.println("\nThank you for using the service. "+
                " For more enquiries: 0113 245 7676 ");
        scanner.close();
    }
}
