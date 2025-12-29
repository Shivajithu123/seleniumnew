/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */


import org.testng.annotations.Test;

public class ParallelProofTest {

    @Test
    public void testOne() throws InterruptedException {
        System.out.println("Test ONE started | Thread ID: "
                + Thread.currentThread().getId());
        Thread.sleep(5000); // simulate long task
        System.out.println("Test ONE ended");
    }

    @Test
    public void testTwo() throws InterruptedException {
        System.out.println("Test TWO started | Thread ID: "
                + Thread.currentThread().getId());
        Thread.sleep(5000); // simulate long task
        System.out.println("Test TWO ended");
    }
}

