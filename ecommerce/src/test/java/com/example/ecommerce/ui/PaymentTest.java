package com.example.ecommerce.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class PaymentTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\BrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testProcessPayment() {
        driver.get("http://localhost:8080/payment");

        WebElement userIdField = driver.findElement(By.name("userId"));
        userIdField.sendKeys("1");

        WebElement amountField = driver.findElement(By.name("amount"));
        amountField.sendKeys("100.0");

        WebElement statusField = driver.findElement(By.name("status"));
        statusField.sendKeys("Completed");

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        wait.until(ExpectedConditions.urlToBe("http://localhost:8080/payment/list"));

        WebElement lastPaymentRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[last()]"))); //last elemente bak

        WebElement userIdCell = lastPaymentRow.findElement(By.xpath("td[2]"));
        WebElement amountCell = lastPaymentRow.findElement(By.xpath("td[3]"));

        Assert.assertEquals(userIdCell.getText(), "1", "User ID should be displayed correctly");
        Assert.assertEquals(amountCell.getText(), "100.0", "Payment amount should be displayed correctly");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
