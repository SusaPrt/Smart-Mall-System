/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.enterprises.restaurant;

//@author Susanna

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Menu {
    
    private final Map<Course, LinkedList<Dish>> warehouse;
    
    public Menu(LinkedList<LinkedList> l) {
        this.warehouse = new HashMap<>();
        this.warehouse.put(Course.FIRSTS, l.get(0));
        this.warehouse.put(Course.SECONDS, l.get(1));
        this.warehouse.put(Course.DESSERTS, l.get(2));
        this.warehouse.put(Course.WINESANDSOFT, l.get(3));
    }  
    
    public LinkedList<Dish> getTypeDishes(Course type) {
        return this.warehouse.get(type);
    }
    
    public Set<Dish> getAvailableTypeDishes(Course type) {
        return this.warehouse.get(type).stream().filter(d -> d.getQuantity() > 0).collect(Collectors.toSet());
    }
    
    //conversione
    public void addDish(String name, double price, int quantity, String type) {
        if(!(this.checkDish(name, Course.selectType(type))))
            this.warehouse.get(Course.selectType(type)).add(new Dish(name, price, quantity, type));
        else
            System.out.println("Error: dish already registered");
    }
    
    public void removeDish(Dish d) {
        if(this.checkDish(d.getName(), d.getCourse()))    
            this.warehouse.get(d.getCourse()).remove(d);
        else
            System.out.println("Error: dish not in the menu");
    }    
    
    private boolean checkDish(String name, Course type) {
        return this.warehouse.get(type).stream().filter(dish -> dish.getName().equalsIgnoreCase(name)).findFirst().isPresent();
    }

    @Override
    public int hashCode() {
        final int hash = 31;
        int result = 1;
        result = result * hash + Objects.hashCode(this.warehouse);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Menu other = (Menu) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Menu\n" + this.warehouse;
    }
    
    
}
