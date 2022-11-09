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
import Model.system.DataInterpreter;

 
public interface IRestaurant {
    public MenuOfTheDay getDailyMenu();
    
    public Menu getMenu();
    
    public boolean cancelReservation(String name);
    
    public boolean refueling(Dish d, int i);
    
    public void newDay();
    
    public boolean orderADish(Dish d, int n, Customer c);
    
    public boolean reserveSeats(int n, String name);
    
    public DataInterpreter getDataInterpreter();
}
