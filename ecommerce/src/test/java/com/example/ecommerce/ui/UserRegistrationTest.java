package com.example.ecommerce.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserRegistrationTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // WebDriver'ı başlatın
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\BrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testUserRegistration() {
        driver.get("http://localhost:8080/users/register");

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("testuser");

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("testuser@example.com");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement successMessage = driver.findElement(By.id("successMessage"));
        Assert.assertEquals(successMessage.getText(), "Registration successful!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
