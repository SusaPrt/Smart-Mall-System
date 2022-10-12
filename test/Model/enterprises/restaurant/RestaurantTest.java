/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model.enterprises.restaurant;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mars_DB
 */
public class RestaurantTest {
    
    public RestaurantTest() {
    }

    @Test
    public void testGetDailyMenu() {
        System.out.println("getDailyMenu");
        Restaurant instance = null;
        MenuOfTheDay expResult = null;
        MenuOfTheDay result = instance.getDailyMenu();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetMenu() {
        System.out.println("getMenu");
        Restaurant instance = null;
        Menu expResult = null;
        Menu result = instance.getMenu();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetStringMenu() {
        System.out.println("getStringMenu");
        Restaurant instance = null;
        String expResult = "";
        String result = instance.getStringMenu();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetStringDailyMenu() {
        System.out.println("getStringDailyMenu");
        Restaurant instance = null;
        String expResult = "";
        String result = instance.getStringDailyMenu();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testReserveSeats() {
        System.out.println("reserveSeats");
        int n = 0;
        String name = "";
        Restaurant instance = null;
        boolean expResult = false;
        boolean result = instance.reserveSeats(n, name);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCancelReservation() {
        System.out.println("cancelReservation");
        String name = "";
        Restaurant instance = null;
        boolean expResult = false;
        boolean result = instance.cancelReservation(name);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testOrderADish() {
        System.out.println("orderADish");
        Dish d = null;
        Restaurant instance = null;
        boolean expResult = false;
        boolean result = instance.orderADish(d);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRefueling() {
        System.out.println("refueling");
        Dish d = null;
        int i = 0;
        Restaurant instance = null;
        boolean expResult = false;
        boolean result = instance.refueling(d, i);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testNewDay() {
        System.out.println("newDay");
        Restaurant instance = null;
        instance.newDay();
        fail("The test case is a prototype.");
    }

    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Restaurant instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Restaurant instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Restaurant instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
