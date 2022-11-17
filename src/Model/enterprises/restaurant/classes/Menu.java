/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.enterprises.restaurant.classes;

//@author Susanna

import Model.enterprises.restaurant.interfaces.IMenu;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Menu implements IMenu {
    
    private final Map<Course, LinkedList<Dish>> warehouse;
    
    public Menu(LinkedList<LinkedList> l) {
        this.warehouse = new HashMap<>();
        this.warehouse.put(Course.FIRSTS, l.get(0));
        this.warehouse.put(Course.SECONDS, l.get(1));
        this.warehouse.put(Course.DESSERTS, l.get(2));
        this.warehouse.put(Course.WINESANDSOFT, l.get(3));
    }  
    
    public Menu() {
        this.warehouse = new HashMap<>();
        this.warehouse.put(Course.FIRSTS, new LinkedList<>());
        this.warehouse.put(Course.SECONDS, new LinkedList<>());
        this.warehouse.put(Course.DESSERTS, new LinkedList<>());
        this.warehouse.put(Course.WINESANDSOFT, new LinkedList<>());
    }
    
    @Override
    public LinkedList<Dish> getTypeDishes(Course course) {
        return this.warehouse.get(course);
    
    }
    @Override
    public List<Dish> getAvailableTypeDishes(Course course) {
        return this.warehouse.get(course).stream().filter(d -> d.getQuantity() > 0).collect(Collectors.toList());
    }
    
    @Override
    public boolean addDish(String name, double price, int quantity, Course course) {
        boolean done = false;
        if(!(this.checkDish(name, course))) {
            this.warehouse.get(course).add(new Dish(name, price, quantity, course));
            done = true;
        } else
            System.out.println("Error: dish already registered");
        return done;
    }
    
    @Override
    public boolean removeDish(Dish d) {
        boolean done = false;
        if(this.checkDish(d.getName(), d.getCourse())) {
            this.warehouse.get(d.getCourse()).remove(d);
            done = true;
        } else
            System.out.println("Error: dish not in the menu");
        return done;
    } 
    
    private boolean checkDish(String name, Course course) {
        return this.warehouse.get(course).stream().filter(dish -> dish.getName().equalsIgnoreCase(name)).findFirst().isPresent();
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

    public Map<Course, LinkedList<Dish>> getWarehouse() {
        return this.warehouse;
    }

}
