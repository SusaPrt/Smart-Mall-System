/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration;

import java.util.Objects;

/**
 *
 * @author Mars_DB
 */
public class Item{
    private final String name;
    private final double price;
    private int quantity;
    
    public Item(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getName(){
        return this.name;
    }
    
    public double getPrice(){
        return this.price;
    }
    
    public int getQuantity(){
        return this.quantity;
    }
    
    public void decreaseQuantity(int i){
        this.quantity =- i;                 // i come parametro, per non richiamare f. 20 volte nel caso di un ordine di 20 elementi
    }                                           // per stesso oggetto

    public void increaseQuantity(int i){
        this.quantity =+ i;
    }
    
    public boolean isAvailable(){
        return this.quantity > 0;
    }
    
    @Override
    public String toString(){
        return "\nItem: "+this.name+"\nPrice: "+this.price+"\n"+"Quantity: "+this.quantity+"\n";
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
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
}        



