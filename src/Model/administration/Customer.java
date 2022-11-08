/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration;

import Model.administration.AdministrationInterfaces.CustomerInterface;
import Model.administration.payment.Cart;
import Model.administration.payment.Payment;
import java.util.Objects;

/**
 *
 * @author Mars_DB
 */
public class Customer extends Person implements CustomerInterface{

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
       
    @Override
    public Boolean payTheCart(Administration adm){                                 //inserimento pagamento       
        Boolean paid = false; 
        this.payment = new Payment(this);
        if(this.payment.checkStatus()){
            this.credit-=this.payment.getCost();
            for(Item i : this.cart.getProducts())
                this.cart.removeProducts(i);
            paid = true;
        }
        if(paid)
            //System.out.println(this.aD.toString());
            adm.addPayment(payment);
        return paid;
    }
      
    @Override
    public double getCredit(){
        return this.credit;
    }
    
    @Override
    public void addCredit(double d){
        this.credit += d;
    }
    
    @Override
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
