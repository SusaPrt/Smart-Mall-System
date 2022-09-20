/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration.payment;

import Model.administration.Customer;
import java.util.Random;

/**
 *
 * @author Mars_DB
 */
public class Payment {
    
    private final Customer customer;
    private final double cost;                                              
    private final int id;
    
    public Payment(Customer c, int id){                                                                     
        this.cost = c.getCart().getTotCost(); 
        this.customer = c;
        this.id = id;
    }
    
    public Payment(Customer c){                                                                    
        this.cost = c.getCart().getTotCost(); 
        this.customer = c;
        Random rnd = new Random();
        this.id = rnd.nextInt(1000)+101;
    }

    public double getCost() {
       return this.cost;
    }
        
    @Override
    public String toString(){
        return "\nPayment of "+this.cost+"€"+"\nCustomer: "
                +this.customer.getName()+" id: "+this.customer.getId();
    }

    public boolean checkStatus(){
        boolean b = false;
        if(this.cost <= this.customer.getCredit())
            b = true;
        return b;
    }
    
    public Customer getCustomer(){
        return this.customer;
    }
    
    public int getId(){
        return this.id;
    }
}

