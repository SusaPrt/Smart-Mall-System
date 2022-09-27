/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.enterprises.restaurant;

//@author Susanna

import Model.administration.Item;
import java.util.Objects;

public class Dish extends Item {
    private final String description;
    
    public Dish (String name, double price, int quantity, String description) {
        super(name, price, quantity);
        this.description = description;
    }
    
    public String getDescription() {
        return this.description;
    }

    @Override
    public int hashCode() {
        final int hash = 31;
        int result = 1;
        result = result * hash + Objects.hashCode(this.description);
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
        return Objects.equals(this.description, other.description);
    }

    @Override
    public String toString() {
        return "\nDish: " + super.getName() + " \nPrice: " + super.getPrice() +
                "\nDescription: " + this.description;
    }
    
    
}
