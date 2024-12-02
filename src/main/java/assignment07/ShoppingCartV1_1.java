package assignment07;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartV1_1 {
    List<Item> cart = new ArrayList<>();
    // Adds an item to the cart and returns the updated cart
    public List<Item> addItem(String name, double price) {
        cart.add(new Item(name, price));
        return new ArrayList<>(cart); // Return a copy of the cart for verification
    }
    // Returns a list of all items in the cart
    public List<Item> getCart() {
        return new ArrayList<>(cart); // Return a copy of the cart
    }
// Removes an item by name and returns true if the item was found and removed,
//false otherwise
    public boolean removeItem(String name) {
        return cart.removeIf(item -> item.name.equals(name));
    }
    // Calculates and returns the total price of items in the cart
    public double getTotalPrice() {
        return cart.stream().mapToDouble(item -> item.price).sum();
    }
    public static void main(String[] args) {
        ShoppingCartV1_1 shoppingCart = new ShoppingCartV1_1();
// Add items to the cart
        shoppingCart.addItem("Book", 10.99);
        shoppingCart.addItem("Pen", 1.50);
// Remove an item
        if (shoppingCart.removeItem("Pen")) {
            System.out.println("Pen removed successfully.");
        } else {
            System.out.println("Pen not found!");
        }
// Display cart items
        List<Item> cartContents = shoppingCart.getCart();
        for (Item item : cartContents) {
            System.out.println(item.name + " - $" + item.price);
        }
// Display total price
        double totalPrice = shoppingCart.getTotalPrice();
        System.out.printf("Total Price: $%.2f%n", totalPrice);
    }
}
