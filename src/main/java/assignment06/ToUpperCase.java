package assignment06;

public class ToUpperCase {
    public static String toUpperCase(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        return input.toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(toUpperCase("hello"));  // Example: Output "HELLO"
        System.out.println(toUpperCase("WORLD"));  // Example: Output "WORLD"
        System.out.println(toUpperCase("Java123")); // Example: Output "JAVA123"
    }
}
