
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SeleniumTest {

    @Test
    public void testProductListing() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zeyne\\OneDrive\\Masaüstü\\ecommerce\\ecommerce\\src\\main\\resources\\chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/products");

        // Web sayfasında ürünlerin listelendiğini doğrulayan basit bir test
        WebElement productList = driver.findElement(By.tagName("body"));
        assert productList.getText().contains("Product");

        driver.quit();
    }

    @Test
    public void testUserRegistration() {
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/users");

        // Kullanıcı kaydını simüle eden basit bir test
        driver.findElement(By.name("username")).sendKeys("testuser");
        driver.findElement(By.name("email")).sendKeys("testuser@example.com");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.id("submit")).click();

        // Kullanıcının başarılı bir şekilde kaydedildiğini doğrulayan bir test
        WebElement body = driver.findElement(By.tagName("body"));
        assert body.getText().contains("User created successfully");

        driver.quit();
    }

}
