package assignment04;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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
    public void testHomePageFeaturedItems() {
        // Open the website
        driver.get("https://tutorialsninja.com/demo/");

        // Verify featured items
        List<String> featuredItems = List.of("MacBook", "iPhone", "Apple Cinema 30\"", "Canon EOS 5D");
        for (String item : featuredItems) {
            WebElement element = driver.findElement(By.xpath("//h4/a[contains(text(), '" + item + "')]"));
            Assert.assertTrue(item + " is not displayed.", element.isDisplayed());
        }
    }

    @Test
    public void testCanonEOS5DIsDisplayed() {
        // Open the website
        driver.get("https://tutorialsninja.com/demo/");
        //
        // Verify Canon EOS 5D description
        WebElement canonDescription = driver.findElement(By.xpath("//h4/a[normalize-space()='Canon EOS 5D']"));
        Assert.assertTrue("Canon EOS 5D description is not displayed.", canonDescription.isDisplayed());
    }

    @Test
    public void testMacBookIsDisplayed() {
        driver.get("https://tutorialsninja.com/demo/");
        WebElement macBookElementDescription = driver.findElement(By.xpath("//h4/a[normalize-space()='MacBook']"));
        Assert.assertTrue("MacBook description is not displayed.", macBookElementDescription.isDisplayed());
    }

    @Test
    public void testIPhoneIsDisplayed() {
        driver.get("https://tutorialsninja.com/demo/");
        WebElement iPhoneDescription = driver.findElement(By.xpath("//h4//a[normalize-space()='iPhone']"));
        Assert.assertTrue("iPhone description is not displayed.", iPhoneDescription.isDisplayed());
    }

    @Test
    public void testMonitorIsDisplayed() {
        driver.get("https://tutorialsninja.com/demo/");
        WebElement monitorDescription = driver.findElement(By.xpath("//h4/a[normalize-space()='Apple Cinema 30\"']"));
        Assert.assertTrue("iPhone description is not displayed.", monitorDescription.isDisplayed());
    }

    @Test
    public void testCanonEOS5DTextExists() {
        // Open the website
        driver.get("https://tutorialsninja.com/demo/");

        // Verify the specific text is present on the home page
        String expectedText = "Canon's press material for the EOS 5D states that it 'defines (a) new D-SLR category', while we'r..";
        String pageSource = driver.getPageSource();

        Assert.assertTrue("Expected text is not present on the page.", pageSource.contains(expectedText));
    }

    @Test
    public void testAddToCartIphone() {
        // Open the website
        driver.get("https://tutorialsninja.com/demo/");
        String xpath = "//body//div[@id='common-home']//div[@class='row']//div[@class='row']//div[2]//div[1]//div[3]//button[1]";
        // Verify "Add to Cart" text for iPhone
        WebElement addToCartIphone = driver.findElement(By.xpath(xpath));
        Assert.assertTrue("'Add to Cart' for iPhone is not displayed.", addToCartIphone.isDisplayed());
    }

    @Test
    public void testLinksOnHomePage() {
        // Open the website
        driver.get("https://tutorialsninja.com/demo/");

        // Verify links exist
        List<String> linksToCheck = List.of("123456789", "My Account", "Wish List", "Shopping Cart", "Checkout");
        for (String linkText : linksToCheck) {
            WebElement link = driver.findElement(By.linkText(linkText));
            Assert.assertTrue(linkText + " link is not displayed.", link.isDisplayed());
        }
    }

    @Test
    public void testProductSearchLaptop() {
        // Open the website
        driver.get("https://tutorialsninja.com/demo/");

        // Search for "laptop"
        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        searchBox.clear();
        searchBox.sendKeys("laptop");
        WebElement submit = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
        submit.click();
        // Wait for search results to load (5 seconds)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Products meeting the search criteria']")));

        // Verify search results
        List<WebElement> results = driver.findElements(By.cssSelector(".product-layout"));
        if (results.isEmpty()) {
            WebElement noResultsMessage = driver.findElement(By.xpath("//*[contains(text(), 'There is no product that matches the search criteria.')]"));
            Assert.assertTrue("No results message is not displayed.", noResultsMessage.isDisplayed());
        } else {
            Assert.assertFalse("Search results are displayed for 'laptop' when they shouldn't be.", results.isEmpty());
        }
    }

    @Test
    public void testProductSearchTestingWithScanner() {
        // Open the website
        driver.get("https://tutorialsninja.com/demo/");

        // Search for "testing" in the dropdown
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.clear();
        searchBox.sendKeys("testing");

        // Select "Scanner" from the dropdown
        WebElement categoryDropdown = driver.findElement(By.name("category_id"));
        categoryDropdown.sendKeys("Scanner");
        searchBox.submit();

        // Verify search results
        List<WebElement> results = driver.findElements(By.cssSelector(".product-layout"));
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
