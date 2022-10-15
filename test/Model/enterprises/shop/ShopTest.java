/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model.enterprises.shop;

import Model.administration.Item;
import Model.system.DataInterpreter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Susanna
 */
public class ShopTest {
    private final Shop instance;
    private List<Item> initialWarehouse;
    private final Item item1;
    private final Item item2;
    
    public ShopTest() {
        this.instance = new Shop();
        this.item1 = new Item("monitor", 120.5, 10);
        this.item2 = new Item("switch", 64.9, 23);
        
        try {
            DataInterpreter dI = new DataInterpreter(new File("./src/Model/system/DataFolder/Shop.txt")
                    ,"Shop");
            this.initialWarehouse = dI.getData().getFirst();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void testGetWarehouse() {
        System.out.println("getWarehouse");
        List<Item> expResult = this.initialWarehouse;
        List<Item> result = instance.getWarehouse();
        assertEquals(expResult, result);
    }

    @Test
    public void testAddItem() {
        System.out.println("addItem");

        this.instance.addItem(this.item1.getName(), this.item1.getPrice(), this.item1.getQuantity());
        
        boolean expResult = true;
        boolean result = this.instance.getWarehouse().contains(this.item1);
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveItem() {
        System.out.println("removeItem");
        this.instance.addItem(this.item1.getName(), this.item1.getPrice(), this.item1.getQuantity());
        instance.removeItem(this.item1);
    }

    @Test
    public void testRefueling() {
        System.out.println("refueling");
        this.instance.addItem(this.item1.getName(), this.item1.getPrice(), this.item1.getQuantity());
        int n = 10;
        boolean expResult = true;
        boolean result = this.instance.refueling(this.item1, n);
        assertEquals(expResult, result);
    }
}
