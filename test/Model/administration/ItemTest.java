/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model.administration;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marzio
 */
public class ItemTest {
    private final Item instance;
    
    public ItemTest() {
        this.instance = new Item("Computer", 399.99, 25);
    }
    

    @Test
    public void testGetName() {
        System.out.println("Test metodo 'getName'");
        String expResult = "Computer";
        String result = instance.getName();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testGetPrice() {
        System.out.println("Test metodo 'getPrice'");
        double expResult = 399.99;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0.001);
        
    }

    @Test
    public void testGetQuantity() {
        System.out.println("Test metodo 'getQuantity'");
        int expResult = 25;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
    }

    @Test
    public void testDecreaseQuantity() {
        System.out.println("Test metodo 'decreaseQuantity'");
        int i = 10;        
        int expResult = 15;         
        instance.decreaseQuantity(i);
        int result = instance.getQuantity();       
        assertEquals(expResult, result);
    }

    @Test
    public void testIncreaseQuantity() {
        System.out.println("Test metodo 'increaseQuantity'");
        int i = 10;
        int expResult = 35; 
        instance.increaseQuantity(i);
        int result = instance.getQuantity();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsAvailable() {
        System.out.println("Test metodo 'isAvailable' true per passare");
        boolean expResult = true;
        boolean result = instance.isAvailable();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsNotAvailable() {
        System.out.println("Test metodo 'isAvailable' false per passare");
        Item outOfStock = new Item("Computer", 399.99, 0);
        boolean expResult = false;
        boolean result = outOfStock.isAvailable();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals() {
        System.out.println("Test metodo 'equals' true per passare");
        Item instance2 = new Item("Computer", 399.99, 25);
        boolean expResult = true;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    } 

    @Test
    public void testNotEquals() {
        System.out.println("Test metodo 'equals' false per passare");
        Item instance2 = new Item("Monitor", 200.50, 45);
        boolean expResult = false;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }    
}
