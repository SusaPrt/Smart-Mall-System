/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model.enterprises.restaurant;

import Model.enterprises.restaurant.classes.Course;
import Model.enterprises.restaurant.classes.Menu;
import Model.enterprises.restaurant.classes.Dish;
import Model.enterprises.restaurant.classes.Restaurant;
import Model.enterprises.restaurant.classes.MenuOfTheDay;
import Model.administration.Administration;
import Model.administration.Customer;
import Model.system.DataInterpreter;
import java.io.File;
import java.io.FileNotFoundException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Susanna
 */
public class RestaurantTest {
    private final Restaurant instance;
    private final DataInterpreter dI;
    private final Dish dish;
    
    public RestaurantTest() throws FileNotFoundException {
        this.instance = new Restaurant(200);
        
        this.dI = new DataInterpreter(new File("./src/Model/system/DataFolder/Menu.txt")
                    ,"Restaurant");
            
        this.dish = new Dish("YYYY",4,485, Course.selectType("FIRSTS"));
       
    }

    @Test
    public void testGetDailyMenu() {
        System.out.println("Test per metodo 'getDailyMenu'");
        MenuOfTheDay result = instance.getDailyMenu();      
        MenuOfTheDay expResult = new MenuOfTheDay(new Menu(this.dI.getData()));
        assertEquals(expResult, result);      
    }

    @Test
    public void testGetMenu() {
        System.out.println("Test per metodo 'getMenu'");
        Menu expResult = new Menu(this.dI.getData());
        Menu result = instance.getMenu();
        assertEquals(expResult, result);
    }

    @Test
    public void testReserveSeats() {
        System.out.println("Test per metodo 'reserveSeats'");
        int n = 10;
        String name = "Giovanni";
        boolean expResult = true;
        boolean result = instance.reserveSeats(n, name);
        assertEquals(expResult, result);
    }

    @Test
    public void testCancelReservation() {
        System.out.println("Test per metodo 'cancelReservation'");
        instance.reserveSeats(10, "Giovanni");
        String name = "Giovanni";
        boolean expResult = true;
        boolean result = instance.cancelReservation(name);
        assertEquals(expResult, result);
    }

    @Test
    public void testOrderADish() {
        System.out.println("Test per metodo 'orderADish'");    
        boolean expResult = true;
        boolean result = instance.orderADish(this.dish, 1, 
                new Customer("Gino", "123", 200.5));
        assertEquals(expResult, result);
    }

    @Test
    public void testRefueling() {
        System.out.println("Test per metodo 'refueling'");
        int i = 10;
        boolean expResult = true;
        boolean result = instance.refueling(this.dish, i);
        assertEquals(expResult, result);
    }

    @Test
    public void testNewDay() {
        System.out.println("Test per metodo 'newDay'");
        this.instance.reserveSeats(10, "Giovanni");
        instance.newDay();
        int expResult = this.instance.getTotSeats();
        int result = this.instance.getFreeSeats();
        assertEquals(expResult, result);
    }
}
