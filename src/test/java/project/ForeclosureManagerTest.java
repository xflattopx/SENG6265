package project;

import org.junit.Before;
import org.junit.Test;
import project.property.Property;
import project.service.ForeclosureManager;

import java.util.ArrayList;
import java.util.Scanner;

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

        String input = "RESIDENTIAL\nAPARTMENT\n7890 Pine St, Uptown\nAVAILABLE\n400000\n";
        Scanner scanner = new Scanner(input);

        foreclosureManager.addProperty(scanner);

        properties = loadProperties("src/main/resources/properties.json");

        assertEquals(initialSize + 1, properties.size());
    }

    @Test
    public void testRemoveProperty() {
        int initialSize = properties.size();

        foreclosureManager.removeProperty(new Scanner("707 Market Street, Riverdale\n"));

        properties = loadProperties("src/main/resources/properties.json");

        assertEquals(initialSize - 1, properties.size());
        assertFalse(properties.stream().anyMatch(p -> p.getAddress().equals("707 Market Street, Riverdale")));

        foreclosureManager.removeProperty(new Scanner("Nonexistent Address\n"));

        properties = loadProperties("src/main/resources/properties.json");
        assertEquals(initialSize - 1, properties.size());
    }

    @Test
    public void testUpdateStatus() {
        String originalStatus = properties.get(0).getStatus();

        foreclosureManager.updateStatus(new Scanner("707 Market Street, Riverdale\nUNDER_CONTRACT\n"));

        assertNotEquals(originalStatus, properties.get(0).getStatus());
        assertEquals("UNDER_CONTRACT", properties.get(0).getStatus());
    }

    @Test
    public void testShowAllProperties() {
        foreclosureManager.showAllProperties();

        assertEquals(2, properties.size());
    }

    @Test
    public void testAddDuplicateProperty() {
        String input = "RESIDENTIAL\nAPARTMENT\n1234 Elm St\nAVAILABLE\n400000\n";
        Scanner scanner = new Scanner(input);
        foreclosureManager.addProperty(scanner);

        properties = loadProperties("src/main/resources/properties.json");
        assertEquals(3, properties.size());
    }

    @Test
    public void testRemoveNonExistentProperty() {
        int initialSize = properties.size();
        foreclosureManager.removeProperty(new Scanner("Nonexistent Address"));

        properties = loadProperties("src/main/resources/properties.json");
        assertEquals(initialSize, properties.size());
    }

    @Test
    public void testPropertyStatusUpdateAfterNewPropertyAdded() {
        foreclosureManager.addProperty(new Scanner("RESIDENTIAL\nHOUSE\n5678 Oak St\nAVAILABLE\n500000"));
        foreclosureManager.updateStatus(new Scanner("5678 Oak St\nSOLD"));

        properties = loadProperties("src/main/resources/properties.json");
        Property updatedProperty = properties.stream()
                .filter(p -> p.getAddress().equals("5678 Oak St"))
                .findFirst()
                .orElse(null);

        assertNotNull(updatedProperty);
        assertEquals("SOLD", updatedProperty.getStatus());
    }



    @Test
    public void testPropertyPersistence() {
        String filePath = "src/main/resources/properties.json";

        foreclosureManager.addProperty(new Scanner("RESIDENTIAL\nHOUSE\n9999 Maple St\nAVAILABLE\n500000"));
        ArrayList<Property> addedProperty = loadProperties(filePath);
        assertEquals(3, addedProperty.size());

        foreclosureManager.removeProperty(new Scanner("707 Market Street, Riverdale"));
        ArrayList<Property> afterRemoval = loadProperties(filePath);
        assertEquals(2, afterRemoval.size());

        foreclosureManager.updateStatus(new Scanner("1234 Elm St\nSOLD"));
        ArrayList<Property> updatedStatus = loadProperties(filePath);
        assertTrue(updatedStatus.stream().anyMatch(p -> p.getAddress().equals("1234 Elm St") && p.getStatus().equals("SOLD")));
    }

    @Test
    public void testValidStatusUpdate() {
        String originalStatus = properties.get(1).getStatus();
        foreclosureManager.updateStatus(new Scanner("1234 Elm St\nUNDER_CONTRACT"));
        properties = loadProperties("src/main/resources/properties.json");
        assertNotEquals(originalStatus, properties.get(1).getStatus());
        assertEquals("UNDER_CONTRACT", properties.get(1).getStatus());
    }

    @Test
    public void testInvalidPropertyType() {
        String input = "RESIDENTIAL\nINVALID_TYPE\n7890 Pine St, Uptown\nAVAILABLE\n400000\n";
        Scanner scanner = new Scanner(input);
        foreclosureManager.addProperty(scanner);
        properties = loadProperties("src/main/resources/properties.json");
        assertEquals(3, properties.size());
    }
}
