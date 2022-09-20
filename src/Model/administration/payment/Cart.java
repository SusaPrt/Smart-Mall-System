/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration.payment;

import Model.administration.Item;
import Model.administration.payment.PaymentInterfaces.CartInterface;
import java.util.LinkedList;

/**
 *
 * @author Mars_DB
 */
public class Cart implements CartInterface{
    private LinkedList<Item> purchasedProducts;
    
    public Cart(){
        this.purchasedProducts = new LinkedList();
    }
    
    @Override
    public void addItem(Item i){
        this.purchasedProducts.add(i);
    }
    
    @Override
    public void removeProducts(Item i){
        this.purchasedProducts.remove(i);
        
    }
    
    @Override
    public LinkedList<Item> getProducts(){
        return Cart.defend(this.purchasedProducts);
    }
    
    @Override
    public double getTotCost(){
        return this.purchasedProducts.stream().mapToDouble(Item::getPrice).sum();
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
