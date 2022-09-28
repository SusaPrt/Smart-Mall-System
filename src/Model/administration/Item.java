/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration;

import Model.administration.AdministrationInterfaces.ItemInterface;
import java.util.Objects;

/**
 *
 * @author Mars_DB
 */
public class Item implements ItemInterface{
    private final String name;
    private final double price;
    private int quantity;
    
    public Item(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    @Override
    public String getName(){
        return this.name;
    }
    
    @Override
    public double getPrice(){
        return this.price;
    }
    
    @Override
    public int getQuantity(){
        return this.quantity;
    }
    
    @Override
    public void decreaseQuantity(int i){
        this.quantity = this.quantity - i;                  
    }                                           

    @Override
    public void increaseQuantity(int i){
        this.quantity = this.quantity + i;
    }
    
    @Override
    public boolean isAvailable(){
        return this.quantity > 0;
    }
    
    @Override
    public String toString(){
        return "\nItem: "+this.name+"\nPrice: "+this.price+"\n"+"Quantity: "+this.quantity+"\n"+"Available: "+this.isAvailable();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.name);
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 43 * hash + this.quantity;
        return hash;
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
        final Item other = (Item) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
}        



