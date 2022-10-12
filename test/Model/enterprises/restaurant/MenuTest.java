/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model.enterprises.restaurant;

import java.util.LinkedList;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mars_DB
 */
public class MenuTest {
    
    public MenuTest() {
    }

    @Test
    public void testGetTypeDishes() {
        System.out.println("getTypeDishes");
        Course course = null;
        Menu instance = null;
        LinkedList<Dish> expResult = null;
        LinkedList<Dish> result = instance.getTypeDishes(course);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAvailableTypeDishes() {
        System.out.println("getAvailableTypeDishes");
        Course course = null;
        Menu instance = null;
        Set<Dish> expResult = null;
        Set<Dish> result = instance.getAvailableTypeDishes(course);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddDish() {
        System.out.println("addDish");
        String name = "";
        double price = 0.0;
        int quantity = 0;
        Course course = null;
        Menu instance = null;
        instance.addDish(name, price, quantity, course);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRemoveDish() {
        System.out.println("removeDish");
        Dish d = null;
        Menu instance = null;
        instance.removeDish(d);
        fail("The test case is a prototype.");
    }

    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Menu instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Menu instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Menu instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
