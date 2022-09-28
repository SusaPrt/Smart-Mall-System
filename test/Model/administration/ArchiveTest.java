/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model.administration;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mars_DB
 */
public class ArchiveTest {
    private final Archive instance;
    private final Staff staff;
    private final Customer customer;
    private final Administration Ad;
    
    public ArchiveTest() {
        this.Ad = new Administration();
        this.instance = new Archive(this.Ad);
        this.staff = new Staff("Marzio", "1111", 12345);
        this.customer = new Customer("Simone", "2222", 100.00, 54321, this.Ad);
    }

    @Test
    public void testAddStaff() {
        System.out.println("Test metodo 'addPerson' per instanza di Staff");
        instance.addPerson(staff);
        int result = instance.getStaff().size();
        int expResult = 1;
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAddCustomer() {
        System.out.println("Test metodo 'addPerson' per instanza di Customer");
        instance.addPerson(customer);
        int result = instance.getCustomers().size();
        int expResult = 1;
        assertEquals(expResult, result);
    }

    @Test
    public void testStaffAutentication() {
        System.out.println("Test metodo 'autentication' per instanza di Staff");
        instance.addPerson(staff);
        int id = 12345;
        String password = "1111";
        boolean expResult = true;
        boolean result = instance.autentication(id, password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCustomerAutentication() {
        System.out.println("Test metodo 'autentication' per instanza di Customer");
        instance.addPerson(customer);
        int id = 54321;
        String password = "2222";
        boolean expResult = true;
        boolean result = instance.autentication(id, password);
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveStaffById() {
        System.out.println("Test metodo 'removeById' per instanza di Staff");
        int id = 12345;
        instance.addPerson(staff);
        instance.removeById(id);
        int result = instance.getStaff().size();
        int expResult = 0;
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRemoveCustomerById() {
        System.out.println("Test metodo 'removeById' per instanza di Customer");
        int id = 54321;
        instance.addPerson(customer);
        instance.removeById(id);
        int result = instance.getCustomers().size();
        int expResult = 0;
        assertEquals(expResult, result);
    }

    @Test
    public void testGetStaffById() {
        System.out.println("Test metodo 'getById' per instanza di Staff");
        instance.addPerson(staff);
        int id = 12345;
        Object expResult = staff;
        Object result = instance.getById(id);
        assertEquals(expResult, result);
    } 
    
    @Test
    public void testGetCustomerById() {
        System.out.println("Test metodo 'getById' per instanza di Customer");
        instance.addPerson(customer);
        int id = 54321;
        Object expResult = customer;
        Object result = instance.getById(id);
        assertEquals(expResult, result);
    }
}
