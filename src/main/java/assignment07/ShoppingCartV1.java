package assignment07;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartV1 {
        List<Item> cart = new ArrayList<>();
        // Adds an item to the cart and returns the updated cart
        public List<Item> addItem(String name, double price) {
            cart.add(new Item(name, price));
            return cart; // Return the updated cart for verification
        }
        // Returns the current list of items in the cart
        public List<Item> getCart() {
            return new ArrayList<>(cart); // Return a copy of the cart for testing
        }
        // Calculates and returns the total price of items in the cart
        public double getTotalPrice() {
            double total = 0.0;
            for (Item item : cart) {
                total += item.price;
            }
            return total;
        }
        public static void main(String[] args) {
            ShoppingCartV1 shoppingCart = new ShoppingCartV1();
            shoppingCart.addItem("Book", 10.99);
            shoppingCart.addItem("Pen", 1.50);
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
