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
public class PersonTest {
    
    public PersonTest() {
    }

    @Test
    public void testGetName() {
        System.out.println("Test metodo 'getName'");
        Person instance = new Person("Simone", "ovolollo");
        String expResult = "Simone";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPassword() {
        System.out.println("Test metodo 'getPassword'");
        Person instance = new Person("Simone", "ovolollo");
        String expResult = "ovolollo";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals() {
        System.out.println("Test metodo 'equals' true per passare");
        Object obj = new Person("Simone", "ovolollo");
        Person instance = new Person("Simone", "ovolollo");
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    } 
    
    @Test
    public void testNotEquals() {
        System.out.println("Test metodo 'equals' false per passare");
        Object obj = new Person("Giorgio", "savalalla");
        Person instance = new Person("Simone", "ovolollo");
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    } 
}
