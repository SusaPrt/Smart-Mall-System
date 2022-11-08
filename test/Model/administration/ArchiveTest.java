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
public class ArchiveTest {
    private final Archive instance;
    private final Staff staff;
    private final Customer customer;
    private final Administration Ad;
    
    public ArchiveTest() {
        this.Ad = new Administration();
        this.instance = new Archive(this.Ad);
        this.staff = new Staff("Marzio", "1111", 123458);
        this.customer = new Customer("Simone", "2222", 100.00, 54321);
    }
    /*La classe Archivio compone la classe Administration che alla sua creazione
      carica gli account, se ce ne sono, dal file di test Account.txt, su file 
      sono presenti 2 staff e 1 customer, quindi per la verifica del corretto 
      funzionamento dei test sono stai presi in considerazione anche gli account
      presenti su file*/

    @Test
    public void testAddStaff() {
        System.out.println("Test metodo 'addPerson' per instanza di Staff");
        System.out.println("Numero staff in organico prima: "+instance.getStaff().size());
        instance.addPerson(staff);
        System.out.println("Numero staff in organico dopo add: "+instance.getStaff().size());
        int result = instance.getStaff().size();
        int expResult = 3;
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAddCustomer() {
        System.out.println("Test metodo 'addPerson' per instanza di Customer");
        instance.addPerson(customer);
        int result = instance.getCustomers().size();
        int expResult = 2;
        assertEquals(expResult, result);
    }

    @Test
    public void testStaffAutentication() {
        System.out.println("Test metodo 'autentication' per instanza di Staff");
        instance.addPerson(staff);
        String name = "Marzio";
        String password = "1111";
        boolean expResult = true;
        boolean result = instance.autentication(name, password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCustomerAutentication() {
        System.out.println("Test metodo 'autentication' per instanza di Customer");
        instance.addPerson(customer);
        String name = "Simone";
        String password = "2222";
        boolean expResult = true;
        boolean result = instance.autentication(name, password);
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveStaffById() {
        System.out.println("Test metodo 'removeById' per instanza di Staff");
        int id = 12345;
        instance.addPerson(staff);
        instance.removeById(id);    
        int result = instance.getStaff().size();
        int expResult = 2;
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRemoveCustomerById() {
        System.out.println("Test metodo 'removeById' per instanza di Customer");
        int id = 54321;
        instance.addPerson(customer);
        instance.removeById(id);
        int result = instance.getCustomers().size();
        int expResult = 1;
        assertEquals(expResult, result);
    }

    @Test
    public void testGetStaffById() {
        System.out.println("Test metodo 'getById' per instanza di Staff");
        instance.addPerson(staff);
        int id = 123458;
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
