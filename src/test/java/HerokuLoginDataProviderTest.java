/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class HerokuLoginDataProviderTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // 🔹 DataProvider
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
            // username, password, expectedResult
            {"tomsmith", "SuperSecretPassword!", "success"},
            {"wrongUser", "SuperSecretPassword!", "failure"},
            {"tomsmith", "wrongPassword", "failure"}
        };
    }

    // 🔹 Test using DataProvider
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password, String expectedResult) {

        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(username);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String message = driver.findElement(By.id("flash")).getText();

        if (expectedResult.equals("success")) {
            Assert.assertTrue(message.contains("You logged into a secure area!"),
                    "Expected successful login");
        } else {
            Assert.assertTrue(message.contains("Your username is invalid")
                            || message.contains("Your password is invalid"),
                    "Expected login failure");
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
