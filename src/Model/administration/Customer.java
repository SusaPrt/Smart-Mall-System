/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration;

import Model.administration.payment.Cart;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Mars_DB
 */
public class Customer extends Person{

    private final int idLocker;
    private double credit;
    private final Cart cart;

    public Customer(String name, String password, int credit){
        super(name, password);  
        Random r = new Random();
        this.idLocker = r.nextInt(1000)+101;
        this.credit = credit;
        this.cart = new Cart(this);
    }
    
    public String payTheCart(){                                 //inserimento pagamento
        String goodBye =""; 
        if(this.cart.getTotCost() <= this.credit){
            this.credit-= this.cart.getTotCost();
            goodBye = this.cart.getTotCost()+"€.\nThanks to shop here, goodbye!";
        }
        else
            goodBye = "Your credit is not enough to afford the payment of "
                    +this.cart.getTotCost()+"€.\nThanks to shop here, goodbye!";
        return goodBye;
    }
        
    public int getIdLocker(){
        return this.idLocker;
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
                + this.credit + "€" + "\nId Loacker: " + this.idLocker;                                
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(super.getName());
        hash = 47 * hash + Objects.hashCode(super.getPassword());
        hash = 47 * hash + this.idLocker;
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
        
        if (this.idLocker != other.idLocker) {
            return false;
        }
        return true;
    }
    
    

}
