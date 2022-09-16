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
public class StaffTest {
    
    public StaffTest() {
    }

    @Test
    public void testGetId() {
        System.out.println("Test metodo 'getId'");
        Staff instance = new Staff("Marzio", "1111", 12345678);
        int expResult = 12345678;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    @Test
    public void testNotEquals() {
        System.out.println("Test metodo 'equals' false per passare");
        Object obj = new Staff("Susanna", "2222");
        Staff instance = new Staff("Marzio", "1111");
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals() {
        System.out.println("Test metodo 'equals' true per passare");
        Object obj = new Staff("Marzio", "1111", 12345678);
        Staff instance = new Staff("Marzio", "1111", 12345678);
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
}
