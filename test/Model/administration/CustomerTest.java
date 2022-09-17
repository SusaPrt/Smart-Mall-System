/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model.administration;

import Model.administration.payment.Cart;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mars_DB
 */
public class CustomerTest {
    
    public CustomerTest() {
    }

    @Test
    public void testPayTheCart() {
        System.out.println("Test per metodo 'payTheCart' true per passare");
        Customer instance = new Customer("Simone", "77777", 300.50, 3333, new Administration());
        instance.getCart().addItem(new Item("Computer", 190, 1));
        instance.getCart().addItem(new Item("Monitor", 90, 1));
        instance.getCart().addItem(new Item("Stereo", 20, 1));
        Boolean expResult = true;
        Boolean result = instance.payTheCart();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCantPayTheCart() {
        System.out.println("Test per metodo 'payTheCart' false per passare");
        Customer instance = new Customer("Simone", "77777", 300.50, 3333, new Administration());
        instance.getCart().addItem(new Item("Computer", 190, 1));
        instance.getCart().addItem(new Item("Monitor", 90, 1));
        instance.getCart().addItem(new Item("Stereo", 50, 1));
        Boolean expResult = false;
        Boolean result = instance.payTheCart();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCredit() {
        System.out.println("Test per metodo 'getCredit'");
        Customer instance = new Customer("Simone", "77777", 300.50, 3333, new Administration());
        double expResult = 300.50;
        double result = instance.getCredit();
        assertEquals(expResult, result, 0.0001);
    }

    @Test
    public void testAddCredit() {
        System.out.println("Test per metodo 'addCredit'");
        double d = 200.0;
        Customer instance = new Customer("Simone", "77777", 300.50, 3333, new Administration());
        instance.addCredit(d);
        double expResult = 500.50;
        double result = instance.getCredit();
        assertEquals(expResult, result, 0.0001);
        
    }

    @Test
    public void testNotEquals() {
        System.out.println("Test per metodo 'equals' false per passare");
        Object obj = new Customer("Giorgio", "83844", 300.50, 4444, new Administration());
        Customer instance = new Customer("Simone", "77777", 300.50, 3333, new Administration());
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }  
    
    @Test
    public void testEquals() {
        System.out.println("Test per metodo 'equals' true per passare");
        Object obj = new Customer("Simone", "77777", 300.50, 3333, new Administration());
        Customer instance = new Customer("Simone", "77777", 300.50, 3333, new Administration());
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    } 
}
