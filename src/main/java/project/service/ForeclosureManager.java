package project.service;

import project.property.Property;
import project.utils.ListUtils;

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
    }

    public void viewProperty(Scanner scanner) {
        System.out.print("Enter property id to view: ");
        int id = Integer.parseInt(scanner.nextLine());

//        Property property = database.getProperty(address);
        while (!ListUtils.isValidIndex(id, properties)) {
            System.out.print("Invalid id...\nPlease enter property id to view: ");
            id = Integer.parseInt(scanner.nextLine());
        }
        Property property = properties.get(id - 1);

        if (property != null) {
            System.out.println("Property: " + property.getAddress());
            System.out.println("Legal Status: " + property.getStatus());
        } else {
            System.out.println("Property not found.");
        }
    }

    public void updateStatus(Scanner scanner) {
        System.out.print("Enter property address to update foreclosure status: ");
        String address = scanner.nextLine();
    }

}

