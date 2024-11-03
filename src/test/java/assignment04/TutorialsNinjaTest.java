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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TutorialsNinjaTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "C:/Drivers/Edge/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testHomePageFeaturedItems() {
        driver.get("https://tutorialsninja.com/demo/");
        List<String> featuredItems = List.of("MacBook", "iPhone", "Apple Cinema 30\"", "Canon EOS 5D");
        for (String item : featuredItems) {
            WebElement element = driver.findElement(By.xpath("//h4/a[contains(text(), '" + item + "')]"));
            Assert.assertTrue(item + " is not displayed.", element.isDisplayed());
        }
    }

    @Test
    public void testCanonEOS5DIsDisplayed() {
        driver.get("https://tutorialsninja.com/demo/");
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
        Assert.assertTrue("Monitor description is not displayed.", monitorDescription.isDisplayed());
    }

    @Test
    public void testCanonEOS5DTextExists() {
        driver.get("https://tutorialsninja.com/demo/");
        String expectedText = "Canon's press material for the EOS 5D states that it 'defines (a) new D-SLR category', while we'r..";
        String pageSource = driver.getPageSource();
        Assert.assertTrue("Expected text is not present on the page.", pageSource.contains(expectedText));
    }

    @Test
    public void testAddToCartIphone() {
        driver.get("https://tutorialsninja.com/demo/");
        String xpath = "//body//div[@id='common-home']//div[@class='row']//div[@class='row']//div[2]//div[1]//div[3]//button[1]";
        WebElement addToCartIphone = driver.findElement(By.xpath(xpath));
        Assert.assertTrue("'Add to Cart' for iPhone is not displayed.", addToCartIphone.isDisplayed());
    }

    @Test
    public void testLinksOnHomePage() {
        driver.get("https://tutorialsninja.com/demo/");
        List<String> linksToCheck = List.of("123456789", "My Account", "Wish List", "Shopping Cart", "Checkout");
        for (String linkText : linksToCheck) {
            WebElement link = driver.findElement(By.linkText(linkText));
            Assert.assertTrue(linkText + " link is not displayed.", link.isDisplayed());
        }
    }

    @Test
    public void testProductSearchLaptop() {
        driver.get("https://tutorialsninja.com/demo/");
        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        searchBox.clear();
        searchBox.sendKeys("laptop");
        WebElement submit = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
        submit.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Products meeting the search criteria']")));
        List<WebElement> results = driver.findElements(By.cssSelector(".product-layout"));
        if (results.isEmpty()) {
            WebElement noResultsMessage = driver.findElement(By.xpath("//*[contains(text(), 'There is no product that matches the search criteria.')]"));
            Assert.assertTrue("No results message is not displayed.", noResultsMessage.isDisplayed());
        }
    }

    @Test
    public void testProductSearchScanner() {
        driver.get("https://tutorialsninja.com/demo/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']")));
        searchBox.clear();
        searchBox.click();
        searchBox.sendKeys("testing");
        WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
        searchButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("category_id")));
        WebElement dropdown = driver.findElement(By.name("category_id"));
        dropdown.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("option")));
        Select categorySelect = new Select(dropdown);
        categorySelect.selectByValue("31");
        WebElement submit = driver.findElement(By.xpath("//input[@id='button-search']"));
        submit.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]")));
        String pageSource = driver.getPageSource();
        if (pageSource.contains("There is no product that matches the search criteria.")) {
            Assert.assertTrue("No results message is not displayed.", true);
        } else {
            List<WebElement> results = driver.findElements(By.xpath("//img[@title]"));
            Assert.assertFalse("Search results are displayed", results.isEmpty());
        }
    }

    @Test
    public void testCheckoutProduct() {
        driver.get("https://tutorialsninja.com/demo/");
        WebElement macBookLink = driver.findElement(By.xpath("//a[contains(text(), 'MacBook')]"));
        macBookLink.click();
        WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='button-cart']"));
        addToCartButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'alert-success')]")));
        WebElement checkoutLink = driver.findElement(By.xpath("//span[@id='cart-total']"));
        checkoutLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[normalize-space()='Checkout']")));
        WebElement checkoutText = driver.findElement(By.xpath("//strong[normalize-space()='Checkout']"));
        checkoutText.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-primary']")));
        WebElement checkoutButton = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        Assert.assertEquals("Checkout text is not displayed.", "Checkout", checkoutButton.getText());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
