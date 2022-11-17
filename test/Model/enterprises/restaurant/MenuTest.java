/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model.enterprises.restaurant;

import Model.enterprises.restaurant.classes.Course;
import Model.enterprises.restaurant.classes.Menu;
import Model.enterprises.restaurant.classes.Dish;
import Model.enterprises.restaurant.classes.Restaurant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Susanna
 */
public class MenuTest {
    private final Menu instance;
    private final Dish dish;
    
    public MenuTest() {
        Restaurant r = new Restaurant(200);
        this.instance = r.getMenu();
        this.dish = new Dish("Cannelloni alla besciamella", 12.5, 100, Course.selectType("FIRSTS"));
    }

    @Test
    public void testGetTypeDishes() {
        System.out.println("Test per metodo 'getTypeDishes'");
        Course course = Course.SECONDS;
        LinkedList<Dish> expResult = new LinkedList();
        expResult.add(new Dish("YYYYYYYYY", 5, 720, Course.SECONDS));
        expResult.add(new Dish("YYYYYY", 12, 312, Course.SECONDS));
        
        LinkedList<Dish> result = instance.getTypeDishes(course);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAvailableTypeDishes() {
        System.out.println("Test per metodo 'getAvailableTypeDishes'");
        List<Dish> expResult = new ArrayList();
        expResult.add(new Dish("YYYYYYYYY", 5, 720, Course.SECONDS));
        expResult.add(new Dish("YYYYYY", 12, 312, Course.SECONDS));
        
        ArrayList<Dish> result = (ArrayList<Dish>) instance.getAvailableTypeDishes(Course.SECONDS);
        assertEquals(expResult, result);
    }

    @Test
    public void testAddDish() {
        System.out.println("Test per metodo 'addDish'");

        instance.addDish(this.dish.getName(),this.dish.getPrice(), 
                this.dish.getQuantity(), this.dish.getCourse());
        boolean expResult = true;
        boolean result = this.instance.getWarehouse()
                .get(this.dish.getCourse()).contains(this.dish);
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveDish() {
        System.out.println("Test per metodo 'removeDish'");

        instance.addDish(this.dish.getName(),this.dish.getPrice(), 
                this.dish.getQuantity(), this.dish.getCourse());
        boolean expResult = true;
        instance.removeDish(this.dish);
        boolean result = this.instance.getWarehouse()
                .get(this.dish.getCourse()).contains(this.dish);
        assertEquals(expResult, result);
    }
}
