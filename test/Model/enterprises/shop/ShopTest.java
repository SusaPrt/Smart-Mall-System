/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model.enterprises.shop;

import Model.administration.Item;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Susanna
 */
public class ShopTest {
    
    public ShopTest() {
    }

    @Test
    public void testGetWarehouse() {
        System.out.println("getWarehouse");
        Shop instance = new Shop();
        List<Item> expResult = null;
        List<Item> result = instance.getWarehouse();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddItem() {
        System.out.println("addItem");
        String name = "";
        double price = 0.0;
        int quantity = 0;
        Shop instance = new Shop();
        instance.addItem(name, price, quantity);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRemoveItem() {
        System.out.println("removeItem");
        Item i = null;
        Shop instance = new Shop();
        instance.removeItem(i);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRefueling() {
        System.out.println("refueling");
        Item i = null;
        int n = 0;
        Shop instance = new Shop();
        boolean expResult = false;
        boolean result = instance.refueling(i, n);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Shop instance = new Shop();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Shop instance = new Shop();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Shop instance = new Shop();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
