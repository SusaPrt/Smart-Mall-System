/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration.payment;

import Model.administration.Item;
import java.util.HashSet;

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
}
