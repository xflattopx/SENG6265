package assignment07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
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

public class ExploratoryTest {

    static {
        System.setProperty("webdriver.edge.driver", "C:/Drivers/Edge/msedgedriver.exe");
    }

    @Test
    public void testBrokenLinksInBusinessDistrict() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://tutorialsninja.com/demo/");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        for (WebElement link : allLinks) {
            String linkUrl = link.getAttribute("href");
            if (linkUrl != null && !linkUrl.isEmpty()) {
                driver.get(linkUrl);
                int statusCode = driver.getTitle().equals("404 Not Found") ? 404 : 200;
                Assert.assertTrue("Broken link found: " + linkUrl,statusCode == 200 );
            }
        }

        driver.quit();
    }

    @Test
    public void testProductPriceAccuracy() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://tutorialsninja.com/demo/");

        WebElement productLink = driver.findElement(By.xpath("//a[contains(text(), 'MacBook')]"));
        productLink.click();

        WebElement priceElement = driver.findElement(By.className("price"));
        String displayedPrice = priceElement.getText().trim();

        String expectedPrice = "$600.00";

        Assert.assertEquals(expectedPrice, displayedPrice, "The price for the product is incorrect");

        driver.quit();
    }

    @Test
    public void testHttpsConnectionSecurity() throws Exception {
        URL url = new URL("https://tutorialsninja.com/demo/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();

        Assert.assertTrue("The connection is not secure or there is an issue with the server",responseCode == 200);

    }

    @Test
    public void testProductLinkFunctionality() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://tutorialsninja.com/demo/");

        WebElement productLink = driver.findElement(By.xpath("//a[contains(text(), 'HP LP3065')]"));
        productLink.click();

        String pageTitle = driver.getTitle();
        Assert.assertTrue("The product page did not load correctly or redirected to a non-existent page",pageTitle.contains("HP LP3065"));

        driver.quit();
    }

    @Test
    public void testTourPackageLinkFunctionality() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://tutorialsninja.com/demo/");

        WebElement tourLink = driver.findElement(By.xpath("//a[contains(text(), 'Canon EOS 5D')]"));
        tourLink.click();

        WebElement description = driver.findElement(By.className("description"));
        Assert.assertTrue("Tour package information is missing or the link is broken",description.isDisplayed());

        driver.quit();
    }

    @Test
    public void testMixedContentWarnings() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://tutorialsninja.com/demo/");

        String pageSource = driver.getPageSource();
        Assert.assertTrue("The page contains insecure HTTP resources",!pageSource.contains("http://"));

        driver.quit();
    }

    @Test
    public void testCheckoutPageFunctionality() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://tutorialsninja.com/demo/");

        WebElement productLink = driver.findElement(By.xpath("//a[contains(text(), 'MacBook')]"));
        productLink.click();

        WebElement addToCartButton = driver.findElement(By.id("button-cart"));
        addToCartButton.click();

        WebElement checkoutButton = driver.findElement(By.id("cart"));
        checkoutButton.click();

        String checkoutPageTitle = driver.getTitle();
        Assert.assertTrue("The checkout page did not load successfully",checkoutPageTitle.contains("Checkout"));

        driver.quit();
    }
}

