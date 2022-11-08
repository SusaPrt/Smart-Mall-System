/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.enterprises.restaurantInterfaces;

import Model.enterprises.restaurant.Dish;
import java.util.LinkedList;

/**
 *
 * @author Mars_DB
 */
public interface iMenuOfTheDay {
    
    public LinkedList<Dish> getLunch();
    public LinkedList<Dish> getDinner();
    
}
