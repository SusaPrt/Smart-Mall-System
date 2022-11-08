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
public class CustomerTest {
    final private Customer instance;
    final private Item c, m, s;
    
    public CustomerTest() {
        this.instance = new Customer("Simone", "77777", 300.50, 3333);
        this.c = new Item("Computer", 190, 1);
        this.m = new Item("Monitor", 90, 1);
        this.s = new Item("Stereo", 20, 1);
    }

    @Test
    public void testPayTheCart() {
        System.out.println("Test per metodo 'payTheCart' true per passare");
        instance.getCart().addItem(c);
        instance.getCart().addItem(m);
        instance.getCart().addItem(s);
        Boolean expResult = true;
        Boolean result = instance.payTheCart(new Administration());
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCantPayTheCart() {
        System.out.println("Test per metodo 'payTheCart' false per passare");
        instance.getCart().addItem(c);
        instance.getCart().addItem(m);
        instance.getCart().addItem(new Item("Stereo2", 50, 1));
        Boolean expResult = false;
        Boolean result = instance.payTheCart(new Administration());
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCredit() {
        System.out.println("Test per metodo 'getCredit'");
        double expResult = 300.50;
        double result = instance.getCredit();
        assertEquals(expResult, result, 0.0001);
    }

    @Test
    public void testAddCredit() {
        System.out.println("Test per metodo 'addCredit'");
        double d = 200.0;
        instance.addCredit(d);
        double expResult = 500.50;
        double result = instance.getCredit();
        assertEquals(expResult, result, 0.0001);
        
    }

    @Test
    public void testNotEquals() {
        System.out.println("Test per metodo 'equals' false per passare");
        Object obj = new Customer("Giorgio", "83844", 300.50, 4444);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }  
    
    @Test
    public void testEquals() {
        System.out.println("Test per metodo 'equals' true per passare");
        Object obj = new Customer("Simone", "77777", 300.50, 3333);
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    } 
}
