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

    private final int id;
    private double credit;
    private final Cart cart;
    private Payment payment;

    public Customer(String name, String password, double credit){
        super(name, password);  
        Random r = new Random();
        this.id = r.nextInt(1000)+101;
        this.credit = credit;
        this.cart = new Cart(this);
    }
    
    public Customer(String name, String password, double credit, int id){
        super(name, password);  
        this.id = id;
        this.credit = credit;
        this.cart = new Cart(this);
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
        
    public int getId(){
        return this.id;
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
                + this.credit + "€" + "\nId Loacker: " + this.id;                                
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(super.getName());
        hash = 47 * hash + Objects.hashCode(super.getPassword());
        hash = 47 * hash + this.id;
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
        
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    

}
