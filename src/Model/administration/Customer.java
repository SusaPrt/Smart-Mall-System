/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration;

import Model.administration.payment.Cart;
import Model.administration.payment.Payment;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Mars_DB
 */
public class Customer extends Person{

    private double credit;
    private final Cart cart;
    private Payment payment;

    public Customer(String name, String password, double credit){
        super(name, password);  
        this.credit = credit;
        this.cart = new Cart();
    }
    
    public Customer(String name, String password, double credit, int id){
        super(name, password, id);  
        this.credit = credit;
        this.cart = new Cart();
    }
       
    public String payTheCart(){                                 //inserimento pagamento       
        String goodBye =""; 
        this.payment = new Payment(this.cart, this);
        if(this.payment.getStatus()){
            this.credit-=this.payment.getCost();
            goodBye = this.payment.getCost()+"€.\nThanks to shop here, goodbye!";
        }else{
            goodBye = "Your credit is not enough to afford the payment of "
                    +this.payment.getCost()+"€.\nThanks to shop here, goodbye!";           
        }
        return goodBye;
    }
      
    public double getCredit(){
        return this.credit;
    }
    
    public void addCredit(double d){
        this.credit += d;
    }
    
    public Cart getCart(){
        return this.cart;
    }
    
    @Override
    public String toString(){
        return "\nName: " + super.getName() + "\nCredit: "
                + this.credit + "€" + "\nId Loacker: " + super.getId();                                
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(super.getName());
        hash = 47 * hash + Objects.hashCode(super.getPassword());
        hash = 47 * hash + super.getId();
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
        final Customer other = (Customer) obj;
        if (!Objects.equals(super.getName(), other.getName())) {
            return false;
        }
        
        if (!Objects.equals(super.getPassword(), other.getPassword())) {
            return false;
        }
        
        if (super.getId() != other.getId()) {
            return false;
        }
        return true;
    }
}
