/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGAnnotationsExample {

    // Runs once before all test methods in the class
    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass - Setup resources");
    }

    // Runs before each @Test method
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod - Launch application");
    }

    // First test case
    @Test
    public void testLogin() {
        System.out.println("Test - Login functionality");
        Assert.assertTrue(true); // sample assertion
    }

    // Second test case
    @Test
    public void testLogout() {
        System.out.println("Test - Logout functionality");
        Assert.assertEquals("TestNG", "TestNG");
    }

    // Runs after each @Test method
    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod - Close browser");
    }

    // Runs once after all test methods in the class
    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass - Cleanup resources");
    }
}
