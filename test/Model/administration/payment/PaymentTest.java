/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model.administration.payment;

import Model.administration.Customer;
import Model.administration.Item;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marzio
 */
public class PaymentTest {
    private final Customer c;
    private final Payment instance;
    private final Item i, e;
    
    public PaymentTest() {
        this.c = new Customer("Simone", "77777", 300);
        this.i = new Item("Computer", 200.00, 1);
        this.e = new Item("Monitor", 100.00, 1);
        c.getCart().addItem(i);
        c.getCart().addItem(e);
        this.instance = new Payment(300, 101);
        
    }

    @Test
    public void testGetCost() {
        System.out.println("Test per metodo 'getCost'");
        double expResult = 300.0;
        double result = instance.getCost();
        assertEquals(expResult, result, 0.001);
    }

    @Test
    public void testGetCustomerId() {
        System.out.println("Test per metodo 'getCustomer'");
        int expResult = c.getId();
        int result = instance.getCustomerId();
        assertEquals(expResult, result);
    }  
}
