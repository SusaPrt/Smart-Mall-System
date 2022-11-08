/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controllers;

import Model.enterprises.restaurant.Course;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marzio
 */
public class MainApplicationTest {
    private final MainApplication instance;
    
    public MainApplicationTest() {
        this.instance = new MainApplication();
    }

    @Test
    public void testGetAdminstration() {
        System.out.println("Test metodo 'getAdminstration'");
        boolean expResult = true;
        boolean result = instance.getAdminstration()
                .getArchive().getCustomers().stream()
                .filter(c -> c.getName().equals("Simone") && c.getPassword().equals("3333"))
                .findAny().isPresent();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDefaultLibrary() {
        System.out.println("Test metodo 'getDefaultLibrary'");
        boolean expResult = true;
        boolean result = instance.getDefaultLibrary().getAllBooks().get(0).getISBN() == 34524;
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDefaultRestaurant() {
        System.out.println("Test metodo 'getDefaultRestaurant'");
        boolean expResult = true;
        boolean result = instance.getDefaultRestaurant().getMenu().getWarehouse()
                .get(Course.FIRSTS).getFirst().getName().equals("YYYYY");
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDefaultShop() {
        System.out.println("Test metodo 'getDefaultShop'");
        boolean expResult = true;
        boolean result = instance.getDefaultShop().getWarehouse().get(0)
                .getName().equals("YYYYYY");
        assertEquals(expResult, result);
    }    
}
