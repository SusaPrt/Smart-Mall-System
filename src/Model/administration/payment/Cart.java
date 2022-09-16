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
    private int orderCounter;
    
    public Cart(){
        this.orderList = new LinkedList();
        this.orderCounter = 1;
    }
    
    public void addOrder(){
        this.orderList.add(new Order(this.orderCounter));
        this.orderCounter++;
    }
    
    public void removeOrder(int orderToRemove){
        this.orderList.remove(this.orderList
                .stream()
                .filter(o -> o.getNOrder()==orderToRemove)
                .findFirst()
                .get());
        
    }
    
    public double getTotCost(){
        double cost = 0.0;
        cost = this.orderList.stream().map(o -> o.getCost())
                .reduce(cost, (accumulator, _item) -> accumulator + _item);
        return cost;
    }
    
    @Override
    public String toString(){
        String show = "Order list of this cart:";
        this.orderList.forEach(o -> {
            show.concat("\n"+o.toString());
        });
        return show;
    }
}
