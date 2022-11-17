/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.enterprises.restaurant.interfaces;

//@author Susanna

import Model.enterprises.restaurant.classes.Course;
import Model.enterprises.restaurant.classes.Dish;
import java.util.LinkedList;
import java.util.List;

 
public interface IMenu {
    //ritorna tutti i piatti della portata indicata
    public LinkedList<Dish> getTypeDishes(Course course);
    
    //ritorna tutti i piatti disponibili della portata indicata
    public List<Dish> getAvailableTypeDishes(Course course);
    
    //aggiunge un piatto al menu
    public boolean addDish(String name, double price, int quantity, Course course);
    
    //rimuove un piatto dal menu
    public boolean removeDish(Dish d);
}
