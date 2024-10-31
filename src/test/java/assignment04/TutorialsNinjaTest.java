package assignment04;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class TutorialsNinjaTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up the Edge WebDriver
        System.setProperty("webdriver.edge.driver", "C:/Drivers/Edge/msedgedriver.exe"); // Update path accordingly
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testHomePage() {
        // Open the website
        driver.get("https://tutorialsninja.com/demo/");

        // Verify featured items
        List<String> featuredItems = List.of("MacBook", "iPhone", "Apple Cinema 30\"", "Canon EOS 5D");
        for (String item : featuredItems) {
            WebElement element = driver.findElement(By.xpath("//h4/a[contains(text(), '" + item + "')]"));
            Assert.assertTrue(item + " is not displayed.", element.isDisplayed());
        }

        // Verify Canon EOS 5D description
        WebElement canonDescription = driver.findElement(By.xpath("//*[contains(text(), \"Canon's press material for the EOS 5D states that it 'defines (a) new D-SLR category'\")]"));
        Assert.assertTrue("Canon EOS 5D description is not displayed.", canonDescription.isDisplayed());

        // Verify "Add to Cart" text for iPhone
        WebElement addToCartIphone = driver.findElement(By.xpath("//h4/a[contains(text(), 'iPhone')]/../../following-sibling::div//button[contains(text(), 'Add to Cart')]"));
        Assert.assertTrue("'Add to Cart' for iPhone is not displayed.", addToCartIphone.isDisplayed());

        // Verify links exist
        List<String> linksToCheck = List.of("123456789", "My Account", "Wish List", "Shopping Cart", "Checkout");
        for (String linkText : linksToCheck) {
            WebElement link = driver.findElement(By.linkText(linkText));
            Assert.assertTrue(linkText + " link is not displayed.", link.isDisplayed());
        }
    }

    @Test
    public void testProductSearch() {
        // Open the website
        driver.get("https://tutorialsninja.com/demo/");

        // Search for "laptop"
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.clear();
        searchBox.sendKeys("laptop");
        searchBox.submit();

        // Verify search results
        List<WebElement> results = driver.findElements(By.cssSelector(".product-layout"));
        if (results.isEmpty()) {
            WebElement noResultsMessage = driver.findElement(By.xpath("//*[contains(text(), 'There is no product that matches the search criteria.')]"));
            Assert.assertTrue("No results message is not displayed.", noResultsMessage.isDisplayed());
        } else {
            Assert.assertFalse("Search results are displayed for 'laptop' when they shouldn't be.", results.isEmpty());
        }

        // Search for "testing" in the dropdown
        searchBox.clear();
        searchBox.sendKeys("testing");
        // Select "Scanner" from the dropdown
        WebElement categoryDropdown = driver.findElement(By.name("category_id"));
        categoryDropdown.sendKeys("Scanner");
        searchBox.submit();

        // Verify search results
        results = driver.findElements(By.cssSelector(".product-layout"));
        if (results.isEmpty()) {
            WebElement noResultsMessage = driver.findElement(By.xpath("//*[contains(text(), 'There is no product that matches the search criteria.')]"));
            Assert.assertTrue("No results message is not displayed for 'testing' with scanner.", noResultsMessage.isDisplayed());
        } else {
            Assert.assertFalse("Search results are displayed for 'testing' when they shouldn't be.", results.isEmpty());
        }
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}