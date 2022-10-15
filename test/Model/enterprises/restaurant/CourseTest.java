/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model.enterprises.restaurant;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mars_DB
 */
public class CourseTest {
    private final Course instance;
    
    public CourseTest() {
        this.instance = Course.DESSERTS;
    }

    @Test
    public void testSelectType() {
        System.out.println("selectType");
        String course = "FIRSTS";
        Course expResult = Course.FIRSTS;
        Course result = Course.selectType(course);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "DESSERTS";
        String result = this.instance.getName();
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = Course.DESSERTS;
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNotEquals() {
        System.out.println("equals");
        Object obj = Course.WINESANDSOFT;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
}
