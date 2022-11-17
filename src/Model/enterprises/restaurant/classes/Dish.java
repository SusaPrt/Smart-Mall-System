/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.enterprises.restaurant.classes;

//@author Susanna

import Model.administration.Item;
import Model.enterprises.restaurant.interfaces.IDish;
import java.util.Objects;

public class Dish extends Item implements IDish {
    private final Course course;
    
    public Dish (String name, double price, int quantity, Course course) {
        super(name, price, quantity);
        this.course = course;
    }
    
    // >> METODI PUBBLICI <<
    @Override
    public Course getCourse() {
        return this.course;
    }

    @Override
    public int hashCode() {
        final int hash = 31;
        int result = 1;
        result = result * hash + Objects.hashCode(this.course);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dish other = (Dish) obj;
        return Objects.equals(this.course, other.course);
    }

    @Override
    public String toString() {
        return "\nDish: " + super.getName() + " - " + super.getPrice() + " €";
    }
        
}
