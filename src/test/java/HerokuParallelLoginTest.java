/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class HerokuParallelLoginTest {

    // Thread-safe WebDriver
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void loginTestOne() {
        System.out.println("LoginTestOne | Thread ID: "
                + Thread.currentThread().getId());

        getDriver().get("https://the-internet.herokuapp.com/login");
        getDriver().findElement(By.id("username")).sendKeys("tomsmith");
        getDriver().findElement(By.id("password"))
                .sendKeys("SuperSecretPassword!");
        getDriver().findElement(By.cssSelector("button[type='submit']")).click();

        String msg = getDriver().findElement(By.id("flash")).getText();
        Assert.assertTrue(msg.contains("You logged into a secure area!"));
    }

    @Test
    public void loginTestTwo() {
        System.out.println("LoginTestTwo | Thread ID: "
                + Thread.currentThread().getId());

        getDriver().get("https://the-internet.herokuapp.com/login");
        getDriver().findElement(By.id("username")).sendKeys("tomsmith");
        getDriver().findElement(By.id("password"))
                .sendKeys("SuperSecretPassword!");
        getDriver().findElement(By.cssSelector("button[type='submit']")).click();

        String msg = getDriver().findElement(By.id("flash")).getText();
        Assert.assertTrue(msg.contains("You logged into a secure area!"));
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        driver.remove();
    }
}

