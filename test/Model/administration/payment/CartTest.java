/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model.administration.payment;

import Model.administration.Item;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marzio
 */
public class CartTest {
    private final Item i, e;
    private final Cart instance;
    
    public CartTest() {
        this.instance = new Cart();
        this.i = new Item("Computer", 150.00, 1);
        this.e = new Item("Monitor", 100.00, 1);
    }

    @Test
    public void testAddItem() {
        System.out.println("Test per metodo 'addItem'");     
        instance.addItem(i);
        int expResult = 1;
        int result = instance.getProducts().size();
        assertEquals(expResult, result);      
    }

    @Test
    public void testRemoveProducts() {
        System.out.println("Test per metodo 'removeProducts'");
        instance.addItem(i);
        instance.removeProducts(i);
        int expResult = 0;
        int result = instance.getProducts().size();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testGetTotCost() {
        System.out.println("Test per metodo 'getTotCost'");
        instance.addItem(i);
        instance.addItem(e);
        double expResult = 250.0;
        double result = instance.getTotCost();
        assertEquals(expResult, result, 0.01);
    }    
    
    @Test
    public void testDefend(){
        System.out.println("Test per verifica di difesa della collection");
        instance.addItem(i);
        instance.addItem(e);
        instance.getProducts().remove(e);
        int expResult = 2;
        int result = instance.getProducts().size();
        assertEquals(expResult, result);
    }
}
