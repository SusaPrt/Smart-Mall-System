/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration.payment;

import Model.administration.Item;
import java.util.HashSet;
import java.util.Objects;

/**
 *
 * @author Mars_DB
 */
public class Order {

    private HashSet<Item> purchasedProducts;                            // lista prodotti    
    private double totCost;                                             // costo complessivo
    private final int nOrder;
                                              
    public Order(int nOrder){                                       
        this.purchasedProducts = new HashSet();
        this.nOrder = nOrder;
    }
    
    public void addItem(Item item){                                             //aggiunta elemento          
        this.purchasedProducts.add(item);
    }
    
    public void removeItem(Item item){                                          //rimozione elemento  
        purchasedProducts.remove(item);         
    }   
    
    public double getCost(){                                                   //costo complessivo ordine
        this.totCost = 0;
        purchasedProducts.forEach(i -> {
            this.totCost += i.getPrice();
        });       
        return this.totCost;
    }
    
    public int getNOrder(){
        return this.nOrder;
    }

    @Override
    public String toString(){
        return "Order n°"+nOrder+"\n"+purchasedProducts.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.purchasedProducts);
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.totCost) ^ (Double.doubleToLongBits(this.totCost) >>> 32));
        hash = 73 * hash + this.nOrder;
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
        final Order other = (Order) obj;
        if (Double.doubleToLongBits(this.totCost) != Double.doubleToLongBits(other.totCost)) {
            return false;
        }
        if (this.nOrder != other.nOrder) {
            return false;
        }
        if (!Objects.equals(this.purchasedProducts, other.purchasedProducts)) {
            return false;
        }
        return true;
    }
    
    
}
