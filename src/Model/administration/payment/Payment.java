/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration.payment;

import Model.administration.Customer;

/**
 *
 * @author Mars_DB
 */
public class Payment {
    
    private final Cart cart;
    private final double cost;                                              
    private boolean overBudget;
    
    public Payment(Cart cart, Customer c){                                                                   
        this.cart = cart;    
        this.cost = this.cart.getTotCost();
        this.overBudget = checkStatus(c.getCredit());
    }

    public double getCost() {
       return this.cost;
    }
    
    
    @Override
    public String toString(){
        return "\nPayment of "+this.cost+"€"+"\nDiscount: "+!this.overBudget;
    }
    
    public boolean getStatus(){
        return this.overBudget;
    }
    
    private boolean checkStatus(double CostumerCredit){
        boolean b = false;
        if(this.cost < CostumerCredit)
            b = true;
        return b;
    }
}

