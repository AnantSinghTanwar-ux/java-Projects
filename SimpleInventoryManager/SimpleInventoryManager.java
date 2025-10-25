import java.util.ArrayList;
import java.util.Scanner;

/**
 * SimpleInventoryManager - A menu-driven inventory management system
 * 
 * Features:
 * - Add new items to inventory
 * - View all items in inventory
 * - Update stock quantity of existing items
 * - Remove items from inventory
 * - Uses ArrayList (Java Collection) to store inventory items
 */
public class SimpleInventoryManager {
    
    // ArrayList to store inventory items
    private static ArrayList<InventoryItem> inventory = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    /**
     * Main method - Entry point of the application
     */
    public static void main(String[] args) {
        boolean running = true;
        
        while (running) {
            displayMenu();
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear newline
                
                switch (choice) {
                    case 1:
                        addItem();
                        break;
                    case 2:
                        viewItems();
                        break;
                    case 3:
                        updateStock();
                        break;
                    case 4:
                        removeItem();
                        break;
                    case 5:
                        running = false;
                        System.out.println("Thank you for using Inventory Manager. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1-5.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
    
    /**
     * Displays the main menu
     */
    private static void displayMenu() {
        System.out.println("=========================================");
        System.out.println("   Simple Inventory Management System   ");
        System.out.println("=========================================");
        System.out.println("1. Add Item");
        System.out.println("2. View All Items");
        System.out.println("3. Update Stock");
        System.out.println("4. Remove Item");
        System.out.println("5. Exit");
        System.out.println("=========================================");
        System.out.print("Enter your choice (1-5): ");
    }
    
    /**
     * Adds a new item to the inventory
     */
    private static void addItem() {
        System.out.println("\n--- Add New Item ---");
        
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter item price: $");
        double price = scanner.nextDouble();
        
        System.out.print("Enter stock quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Clear newline
        
        InventoryItem item = new InventoryItem(name, price, quantity);
        inventory.add(item);
        
        System.out.println("Item added successfully!");
    }
    
    /**
     * Displays all items in the inventory
     */
    private static void viewItems() {
        System.out.println("\n--- Inventory List ---");
        
        if (inventory.isEmpty()) {
            System.out.println("No items in inventory.");
            return;
        }
        
        System.out.println("=========================================");
        System.out.printf("%-5s %-20s %-10s %-10s%n", "ID", "Name", "Price", "Quantity");
        System.out.println("=========================================");
        
        for (int i = 0; i < inventory.size(); i++) {
            InventoryItem item = inventory.get(i);
            System.out.printf("%-5d %-20s $%-9.2f %-10d%n", 
                i + 1, item.getName(), item.getPrice(), item.getQuantity());
        }
        
        System.out.println("=========================================");
        System.out.println("Total items: " + inventory.size());
    }
    
    /**
     * Updates the stock quantity of an existing item
     */
    private static void updateStock() {
        System.out.println("\n--- Update Stock ---");
        
        if (inventory.isEmpty()) {
            System.out.println("No items in inventory to update.");
            return;
        }
        
        viewItems();
        
        System.out.print("\nEnter item ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear newline
        
        if (id < 1 || id > inventory.size()) {
            System.out.println("Invalid item ID!");
            return;
        }
        
        System.out.print("Enter new stock quantity: ");
        int newQuantity = scanner.nextInt();
        scanner.nextLine(); // Clear newline
        
        inventory.get(id - 1).setQuantity(newQuantity);
        System.out.println("Stock updated successfully!");
    }
    
    /**
     * Removes an item from the inventory
     */
    private static void removeItem() {
        System.out.println("\n--- Remove Item ---");
        
        if (inventory.isEmpty()) {
            System.out.println("No items in inventory to remove.");
            return;
        }
        
        viewItems();
        
        System.out.print("\nEnter item ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear newline
        
        if (id < 1 || id > inventory.size()) {
            System.out.println("Invalid item ID!");
            return;
        }
        
        InventoryItem removed = inventory.remove(id - 1);
        System.out.println("Item '" + removed.getName() + "' removed successfully!");
    }
}

/**
 * InventoryItem class - Represents an item in the inventory
 */
class InventoryItem {
    private String name;
    private double price;
    private int quantity;
    
    /**
     * Constructor to create a new inventory item
     */
    public InventoryItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
