package assignment07;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RegressionTest {
    private ShoppingCartV1_1 shoppingCart;

    @Before
    public void setUp() {
        shoppingCart = new ShoppingCartV1_1();
    }

    @Test
    public void addItemTest() {
        shoppingCart.addItem("Coffee Mug", 12.99);
        List<Item> cart = shoppingCart.getCart();
        assertEquals(1, cart.size());
        assertEquals("Coffee Mug", cart.get(0).name);
        assertEquals(12.99, cart.get(0).price, 0.01);
    }

    @Test
    public void getCartTest() {
        shoppingCart.addItem("Coffee Mug", 12.99);
        shoppingCart.addItem("Notebook", 5.49);
        List<Item> cart = shoppingCart.getCart();
        assertEquals(2, cart.size());
        assertEquals("Coffee Mug", cart.get(0).name);
        assertEquals("Notebook", cart.get(1).name);
    }

    @Test
    public void removeItemTest() {
        shoppingCart.addItem("Coffee Mug", 12.99);
        shoppingCart.addItem("Notebook", 5.49);
        boolean removed = shoppingCart.removeItem("Notebook");
        assertTrue(removed);
        List<Item> cart = shoppingCart.getCart();
        assertEquals(1, cart.size());
        assertEquals("Coffee Mug", cart.get(0).name);

        removed = shoppingCart.removeItem("Pen");
        assertFalse(removed);
    }

    @Test
    public void getTotalPriceTest() {
        shoppingCart.addItem("Coffee Mug", 12.99);
        shoppingCart.addItem("Notebook", 5.49);
        double totalPrice = shoppingCart.getTotalPrice();
        assertEquals(18.48, totalPrice, 0.01);
    }

    @Test
    public void getCartWhenEmptyTest() {
        List<Item> cart = shoppingCart.getCart();
        assertTrue(cart.isEmpty());
    }

    @Test
    public void getTotalPriceWhenEmptyTest() {
        double totalPrice = shoppingCart.getTotalPrice();
        assertEquals(0.0, totalPrice, 0.01);
    }



}
