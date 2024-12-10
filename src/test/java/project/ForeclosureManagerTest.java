package project;

import org.junit.Before;
import org.junit.Test;
import project.property.Property;
import project.service.ForeclosureManager;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static project.property.PropertyLoader.loadProperties;

public class ForeclosureManagerTest {

    private ForeclosureManager foreclosureManager;
    private ArrayList<Property> properties;

    @Before
    public void setUp() {
        properties = new ArrayList<>();
        properties.add(new Property("COMMERCIAL", "RETAIL", "707 Market Street, Riverdale", "SOLD", 500000));
        properties.add(new Property("RESIDENTIAL", "HOUSE", "1234 Elm St", "FORECLOSED", 300000));
        foreclosureManager = new ForeclosureManager(properties);
    }

    @Test
    public void testAddProperty() {
        int initialSize = properties.size();

        Property newProperty = new Property("RESIDENTIAL", "APARTMENT", "7890 Pine St, Uptown", "AVAILABLE", 400000);

        String input = "RESIDENTIAL\nAPARTMENT\n7890 Pine St, Uptown\nAVAILABLE\n400000\n";
        java.util.Scanner scanner = new java.util.Scanner(input);

        foreclosureManager.addProperty(scanner);

        properties = loadProperties("src/main/resources/properties.json");

        assertEquals(initialSize + 1, properties.size());
    }



    @Test
    public void testRemoveProperty() {
        int initialSize = properties.size();

        foreclosureManager.removeProperty(new java.util.Scanner("707 Market Street, Riverdale\n"));

        properties = loadProperties("src/main/resources/properties.json");

        assertEquals(initialSize - 1, properties.size());
        assertFalse(properties.stream().anyMatch(p -> p.getAddress().equals("707 Market Street, Riverdale")));

        foreclosureManager.removeProperty(new java.util.Scanner("Nonexistent Address\n"));

        properties = loadProperties("src/main/resources/properties.json");

        assertEquals(initialSize - 1, properties.size());
    }


    @Test
    public void testUpdateStatus() {
        String originalStatus = properties.get(0).getStatus();

        foreclosureManager.updateStatus(new java.util.Scanner("707 Market Street, Riverdale\nUNDER_CONTRACT\n"));

        assertNotEquals(originalStatus, properties.get(0).getStatus());
        assertEquals("UNDER_CONTRACT", properties.get(0).getStatus());

    }

    @Test
    public void testShowAllProperties() {
        foreclosureManager.showAllProperties();

        assertEquals(2, properties.size());
    }
}
