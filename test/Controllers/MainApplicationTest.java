/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controllers;

import Model.administration.Administration;
import Model.enterprises.library.Library;
import Model.enterprises.restaurant.Restaurant;
import Model.enterprises.shop.Shop;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mars_DB
 */
public class MainApplicationTest {
    private final MainApplication instance;
    
    public MainApplicationTest() {
        this.instance = new MainApplication();
    }

    @Test
    public void testGetAdminstration() {
        System.out.println("getAdminstration");
        boolean expResult = false;
        boolean result = instance.getAdminstration().getArchive().getCustomers().isEmpty();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDefaultLibrary() {
        System.out.println("getDefaultLibrary");
        boolean expResult = false;
        boolean result = instance.getDefaultLibrary().getAllBooks().isEmpty();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDefaultRestaurant() {
        System.out.println("getDefaultRestaurant");
        boolean expResult = false;
        boolean result = instance.getDefaultRestaurant().getMenu().getWareouse().isEmpty();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDefaultShop() {
        System.out.println("getDefaultShop");
        boolean expResult = false;
        boolean result = instance.getDefaultShop().getWarehouse().isEmpty();
        assertEquals(expResult, result);
    }    
}
