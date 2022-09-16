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
        System.out.println("Test per metodo 'payTheCart'");
        Customer instance = new Customer("Giorgio", "alpha", 300.50, 12345678);
        String expResult = "";
        String result = instance.payTheCart();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetId() {
        System.out.println("Test per metodo 'getId'");
        Customer instance = new Customer("Giorgio", "alpha", 300.50, 12345678);
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCredit() {
        System.out.println("Test per metodo 'getCredit'");
        Customer instance = new Customer("Giorgio", "alpha", 300.50, 12345678);
        double expResult = 0.0;
        double result = instance.getCredit();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testAddCredit() {
        System.out.println("Test per metodo 'addCredit'");
        double d = 0.0;
        Customer instance = new Customer("Giorgio", "alpha", 300.50, 12345678);
        instance.addCredit(d);
    }

    @Test
    public void testGetCart() {
        System.out.println("Test per metodo 'getCart'");
        Customer instance = new Customer("Giorgio", "alpha", 300.50, 12345678);
        Cart expResult = null;
        Cart result = instance.getCart();
        assertEquals(expResult, result);
    }


    @Test
    public void testEquals() {
        System.out.println("Test per metodo 'equals'");
        Object obj = null;
        Customer instance = new Customer("Giorgio", "alpha", 300.50, 12345678);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
}
