/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTestNGTest {

    @Test
    public void testAddition() {
        int a = 10;
        int b = 20;
        int sum = a + b;

        Assert.assertEquals(sum, 30, "Addition result is incorrect");
        System.out.println("testAddition executed");
    }

    @Test
    public void testStringEquality() {
        String actual = "TestNG";
        String expected = "TestNG";

        Assert.assertEquals(actual, expected);
        System.out.println("testStringEquality executed");
    }
}
