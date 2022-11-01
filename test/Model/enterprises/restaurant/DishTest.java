/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model.enterprises.restaurant;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Susanna
 */
public class DishTest {
    private final Dish instance;
    
    public DishTest() {
        this.instance = new Dish("Cannelloni alla besciamella", 12.5, 100, Course.selectType("FIRSTS"));
    }

    @Test
    public void testGetCourse() {
        System.out.println("Test per metodo 'getCourse'");
        Course expResult = Course.FIRSTS;
        Course result = this.instance.getCourse();
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals() {
        System.out.println("Test per metodo 'equals' true per passare");
        Object obj = new Dish("Cannelloni alla besciamella", 12.5, 100, Course.selectType("FIRSTS"));
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNotEquals() {
        System.out.println("Test per metodo 'equals' false per passare");
        Object obj = new Dish("Lasagne radicchio e noci", 15.5, 88, Course.selectType("SECONDS"));
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
}
