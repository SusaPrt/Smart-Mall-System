/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.enterprises.restaurantInterfaces;

// @author Susanna

import Model.administration.Customer;
import Model.enterprises.restaurant.Dish;
import Model.enterprises.restaurant.Menu;
import Model.enterprises.restaurant.MenuOfTheDay;

 
public interface IRestaurant {
    // >> METODI PUBBLICI <<
    public MenuOfTheDay getDailyMenu();
    
    public Menu getMenu();
    
    public String getStringMenu();
    
    public String getStringDailyMenu();
    
    // >> METODI STAFF <<
    public boolean cancelReservation(String name);
    
    public boolean refueling(Dish d, int i);
    
    public void newDay();
    
    // >> METODI CUSTOMER <<
    public boolean orderADish(Dish d, int n, Customer c);
    
    public boolean reserveSeats(int n, String name);
}
