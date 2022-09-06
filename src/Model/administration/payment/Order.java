/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration.payment;

import Model.administration.Customer;
import Model.administration.Item;
import java.util.LinkedList;

/**
 *
 * @author Mars_DB
 */
public class Order {

    private Customer account;                                           // account di riferimento
    private LinkedList<Item> items;                                     // lista prodotti
    private int orderPin;                                               // codice ordine    
    private double totCost;                                             // costo complessivo
                                              
    public Order(int orderCode, Customer account){                                       
        this.orderPin = orderCode;
        this.items = new LinkedList();
        this.account = account;
    }
    
    public void addItem(Item item){                                             //aggiunta elemento          
        this.items.add(item);
    }
    
    public void removeItem(Item item){                                          //rimozione elemento  
        items.remove(item);         
    }   
    
    public double getCost(){                                                   //costo complessivo ordine
        this.totCost = 0;
        items.forEach(i -> {
            this.totCost += i.getPrice();
        });       
        return this.totCost;
    }
    
    public Customer getAccount(){
        return this.account;
    }
    
    @Override
    public String toString(){
        return "Order n°"+this.orderPin+"\n"+items.toString();
    }
}
