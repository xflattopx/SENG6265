package project.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import project.property.Property;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ForeclosureManager {

    private ArrayList<Property> properties;

    public ForeclosureManager(ArrayList<Property> properties) {
        this.properties = new ArrayList<Property>(properties);
    }

    public void showAllProperties() {
        for (Property property : properties) {
            System.out.println(property.toString());
        }
    }

    public void addProperty(Scanner scanner) {
        System.out.print("Enter property category: ");
        String category = String.valueOf(scanner.nextLine());
        System.out.print("Enter property type: ");
        String type = String.valueOf(scanner.nextLine());
        System.out.print("Enter property address: ");
        String address = scanner.nextLine();
        System.out.print("Enter property status: ");
        String status = String.valueOf(scanner.nextLine());
        System.out.print("Enter price: ");
        int price = scanner.nextInt();

        Property property = new Property(category, type, address, status, price);
        properties.add(property);

        System.out.println("Property added successfully!");

        savePropertiesToFile("src/main/resources/properties.json");


    }

    private void savePropertiesToFile(String filePath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(properties, writer);  // Write the updated list to the file
        } catch (IOException e) {
            System.out.println("Error saving properties to file: " + e.getMessage());
        }
    }


    public void updateStatus(Scanner scanner) {
        // Prompt for the address of the property to update
        System.out.print("Enter property address to update foreclosure status: ");
        String address = scanner.nextLine();

        // Find the property by its address
        Property propertyToUpdate = null;
        for (Property property : properties) {
            if (property.getAddress().equalsIgnoreCase(address)) {
                propertyToUpdate = property;
                break;
            }
        }

        // If the property was found, update the status
        if (propertyToUpdate != null) {
            System.out.print("Enter new foreclosure status for property at " + address + ": ");
            String newStatus = scanner.nextLine();

            // Update the property status
            propertyToUpdate.setStatus(newStatus);

            // Confirm the update
            System.out.println("Foreclosure status updated successfully!");

            // Save the updated properties list back to the JSON file
            savePropertiesToFile("src/main/resources/properties.json");
        } else {
            // If no property with the given address is found
            System.out.println("Property with address " + address + " not found.");
        }
    }

    public void removeProperty(Scanner scanner) {
        // Prompt for the address of the property to remove
        System.out.print("Enter property address to remove: ");
        String address = scanner.nextLine();

        // Find the property by its address
        Property propertyToRemove = null;
        for (Property property : properties) {
            if (property.getAddress().equalsIgnoreCase(address)) {
                propertyToRemove = property;
                break;
            }
        }

        // If the property was found, remove it from the list
        if (propertyToRemove != null) {
            properties.remove(propertyToRemove);

            // Confirm the removal
            System.out.println("Property at " + address + " has been removed successfully!");

            // Save the updated properties list back to the JSON file
            savePropertiesToFile("src/main/resources/properties.json");
        } else {
            // If no property with the given address is found
            System.out.println("Property with address " + address + " not found.");
        }
    }



}

