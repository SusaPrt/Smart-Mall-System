/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration.payment;

import Model.administration.Item;
import java.util.LinkedList;

/**
 *
 * @author Mars_DB
 */
public class Cart {
    private LinkedList<Item> purchasedProducts;
    private int orderCounter;
    
    public Cart(){
        this.purchasedProducts = new LinkedList();
        this.orderCounter = 1;
    }
    
    public void addItem(Item i){
        this.purchasedProducts.add(i);
        this.orderCounter++;
    }
    
    public void removeProducts(Item i){
        this.purchasedProducts.remove(i);
        
    }
    
    public double getTotCost(){
        double cost = 0.0;
        cost = this.purchasedProducts.stream().map(i -> i.getPrice())
                .reduce(cost, (accumulator, _item) -> accumulator + _item);
        return cost;
    }
    
    @Override
    public String toString(){
        String show = "Order list of this cart:";
        this.purchasedProducts.forEach(i -> {
            show.concat("\n"+i.toString());
        });
        return show;
    }
}
