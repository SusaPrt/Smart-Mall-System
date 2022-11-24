/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model.administration;

import Model.administration.payment.Payment;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marzio
 */
public class AdministrationTest {
    private final Administration instance;
    private final Customer c;
    private final Payment p;
    
    public AdministrationTest() {
        this.instance = new Administration();
        this.c = new Customer("Simone", "1111", 300.00, 12345);
        this.c.getCart().addItem(new Item("Computer", 200.00, 1));
        this.c.getCart().addItem(new Item("Monitor", 100.00, 1));
        this.p = new Payment(300, c);
    }

    @Test
    public void testAddPayment() {
        System.out.println("Test per metodo 'addPayment'");
        instance.addPayment(p);
        int result = this.instance.getPayments().size();
        int expResult = 1;
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPaymentsByPerson() {
        System.out.println("Test per metodo 'getPaymentsByPersonId'");
        int id = 12345;
        LinkedList<Payment> expResult = new LinkedList();
        expResult.add(p);
        instance.addPayment(p);
        LinkedList<Payment> result = instance.getPaymentsByPerson(c);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTotalDayEarnings() {
        System.out.println("Test per metodo 'getTotalDayEarnings'");
        instance.addPayment(p);
        double expResult = 300.0;
        double result = instance.getTotalDayEarnings();
        assertEquals(expResult, result, 0.001);
    }   
}
