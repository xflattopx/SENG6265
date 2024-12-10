package project.utils;

import java.util.ArrayList;

public class ListUtils {

    // Method to check if the index is valid for any ArrayList type
    public static <T> boolean isValidIndex(int index, ArrayList<T> list) {
        return index > 0 && index < list.size();
    }

    // Method to safely get an element from an ArrayList with index check
    public static <T> T getElementAtIndex(int index, ArrayList<T> list) {
        if (isValidIndex(index, list)) {
            return list.get(index);
        } else {
            System.out.println("Invalid index: " + index);
            return null;  // Return null for invalid index
        }
    }

    public static void main(String[] args) {
        // Example with ArrayList of Integers
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);

        System.out.println(getElementAtIndex(1, intList));  // Output: 2
        System.out.println(getElementAtIndex(5, intList));  // Output: Invalid index: 5

        // Example with ArrayList of Strings
        ArrayList<String> strList = new ArrayList<>();
        strList.add("Hello");
        strList.add("World");

        System.out.println(getElementAtIndex(0, strList));  // Output: Hello
        System.out.println(getElementAtIndex(2, strList));  // Output: Invalid index: 2
    }
}

