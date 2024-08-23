package com.example.ecommerce.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ProductListTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\BrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testAddAndListProduct() {
        driver.get("http://localhost:8080/products/list");
        System.out.println("Sayfa yüklendi: http://localhost:8080/products/list");

        // Form alanlarını bul
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productName")));
        WebElement descriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productDescription")));
        WebElement priceField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productPrice")));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Product']")));

        nameField.sendKeys("Test Product");
        descriptionField.sendKeys("This is a test product.");
        priceField.sendKeys("99.99");
        submitButton.click();
        System.out.println("Form gönderildi");

        wait.until(ExpectedConditions.stalenessOf(submitButton));
        wait.until(driver -> (Boolean) ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        wait.until(ExpectedConditions.urlToBe("http://localhost:8080/products/list"));

        System.out.println("Sayfa yenilendi");

        // Ürünlerin listeye eklenip eklenmediğini kontrol et
        List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#productTableBody tr")));
        if (rows.isEmpty()) {
            System.out.println("Ürünler tablosunda hiçbir satır bulunamadı.");
        } else {
            System.out.println("Tablodaki satırlar:");
            for (WebElement row : rows) {
                System.out.println(row.getText());
            }
        }

        boolean productFound = false;
        for (WebElement row : rows) {
            String rowText = row.getText();
            if (rowText.contains("Test Product") && rowText.contains("This is a test product.") && rowText.contains("99.99")) {
                productFound = true;
                break;
            }
        }

        Assert.assertTrue(productFound, "Ürün listeye eklenmedi");
        System.out.println("Ürün listeye başarıyla eklendi");
    }
}