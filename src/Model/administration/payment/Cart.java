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
    
    public Cart(){
        this.purchasedProducts = new LinkedList();
    }
    
    public void addItem(Item i){
        this.purchasedProducts.add(i);
    }
    
    public void removeProducts(Item i){
        this.purchasedProducts.remove(i);
        
    }
    
    public LinkedList<Item> getProducts(){
        return Cart.defend(this.purchasedProducts);
    }
    
    public double getTotCost(){
    /*    double cost = 0.0;
        cost = this.purchasedProducts.stream().map(i -> i.getPrice())
                .reduce(cost, (accumulator, _item) -> accumulator + _item);*/
        return this.purchasedProducts.stream().mapToDouble(Item::getPrice).sum();
    /*    for(Item i:this.purchasedProducts){
            cost = cost + i.getPrice();
        }
        return cost;*/
    }
    
    @Override
    public String toString(){
        String show = "Order list of this cart:";
        this.purchasedProducts.forEach(i -> {
            show.concat("\n"+i.toString());
        });
        return show;
    }
    
    private static <T> LinkedList<T>  defend(LinkedList<T> list){
        return (LinkedList<T>) list.clone();
    }
}
