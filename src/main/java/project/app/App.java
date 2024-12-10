package project.app;

import project.property.Property;
import project.service.ForeclosureManager;

import java.util.ArrayList;
import java.util.Scanner;

import static project.property.PropertyLoader.loadProperties;

public class App {
    public static void main(String[] args) throws InterruptedException, Exception {
        displayLogo();

        String filePath = "src/main/resources/properties.json";
        ArrayList<Property> properties = loadProperties(filePath);

        Scanner scanner = new Scanner(System.in);
        ForeclosureManager foreclosureManager = new ForeclosureManager(properties);

        while (true) {
            // Display the menu with colors using ANSI escape codes
            displayMenu();

            System.out.print("\u001B[33mChoose an option: \u001B[0m"); // Bright Yellow
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    foreclosureManager.addProperty(scanner);
                    break;
                case 2:
                    foreclosureManager.showAllProperties();
                    break;
                case 3:
                    foreclosureManager.updateStatus(scanner);
                    break;
                case 4:
                    foreclosureManager.removeProperty(scanner);  // Add remove property option
                    break;
                case 5:
                    System.out.println("\u001B[31mExiting...\u001B[0m"); // Red
                    return;
                default:
                    System.out.println("\u001B[31m\u001B[1mInvalid option. Try again.\u001B[0m"); // Bold red
            }
        }
    }

    // Method to display the FMS logo
    private static void displayLogo() throws InterruptedException {
        System.out.print("\n");
        System.out.println("\u001B[0m /$$$$$$$$ /$$      /$$  /$$$$$$ \u001B[0m");
        System.out.println("\u001B[0m| $$_____/| $$$    /$$$ /$$__  $$\u001B[0m");
        System.out.println("\u001B[0m| $$      | $$$$  /$$$$| $$  \\__/\u001B[0m");
        System.out.println("\u001B[0m| $$$$$   | $$ $$/$$ $$|  $$$$$$ \u001B[0m");
        System.out.println("\u001B[0m| $$__/   | $$  $$$| $$ \\____  $$\u001B[0m");
        System.out.println("\u001B[0m| $$      | $$\\  $ | $$ /$$  \\ $$\u001B[0m");
        System.out.println("\u001B[0m| $$      | $$ \\/  | $$|  $$$$$$/\u001B[0m");
        System.out.println("\u001B[0m|__/      |__/     |__/ \\______/ \u001B[0m");
        System.out.print("\n"); // Space between logo and menu
    }

    private static void displayMenu() {
        System.out.println("\u001B[36m\u001B[1mForeclosure Management System\u001B[0m"); // Cyan and bold
        System.out.println("\u001B[32m1. Add New Property\u001B[0m"); // Green
        System.out.println("\u001B[32m2. View Properties\u001B[0m"); // Green
        System.out.println("\u001B[32m3. Update Foreclosure Status\u001B[0m"); // Green
        System.out.println("\u001B[32m4. Remove Property\u001B[0m"); // Green - New option for removing a property
        System.out.println("\u001B[32m5. Exit\u001B[0m\n"); // Green
    }
}
