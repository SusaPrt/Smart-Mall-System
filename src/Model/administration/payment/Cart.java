/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration.payment;

import Model.administration.Customer;
import java.util.LinkedList;

/**
 *
 * @author Mars_DB
 */
public class Cart {
    private LinkedList<Order> orderList;
    private Customer costumer;
    private double check;
    
    public Cart(Customer c){
        this.costumer = c;
        this.check = 0;
        this.orderList = new LinkedList();
    }
    
    public void addOrder(Order o){
        this.orderList.add(o);
    }
    
    public void removeOrder(Order o){
        this.orderList.remove(o);
    }
    
    public double getTotCost(){
        double cost = 0.0;
        cost = this.orderList.stream().map(o -> o.getCost())
                .reduce(cost, (accumulator, _item) -> accumulator + _item);
        return cost;
    }
    
    public Customer getCostumer(){
        return this.costumer;
    }
    
    @Override
    public String toString(){
        String show = "Order list of this cart:";
       for(Order o: this.orderList){
           show.concat("\n"+o.toString());
       }
        return show;
    }
}
