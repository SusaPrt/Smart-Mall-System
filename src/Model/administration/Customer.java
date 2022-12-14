/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration;

import Model.administration.payment.Cart;
import Model.administration.payment.Payment;
import java.util.Objects;
import Model.administration.AdministrationInterfaces.ICustomer;

/**
 *
 * @author Marzio
 */
public class Customer extends Person implements ICustomer{

    private double credit;
    private final Cart cart;

    public Customer(String name, String password, double credit){
        super(name, password);  
        this.credit = credit;
        this.cart = new Cart(); 
    }
    
    // Overloading del costruttore per customer da database
    public Customer(String name, String password, double credit, int id){
        super(name, password, id);  
        this.credit = credit;
        this.cart = new Cart();
    }
       
    @Override
    public Boolean payTheCart(Administration adm){                                 //metodo modificato       
        Boolean paid = false; 
        Payment payment = new Payment(this.cart.getTotCost(), this);
        boolean done = this.credit >= this.cart.getTotCost();
        if(done){
            this.credit-=this.cart.getTotCost();
            paid = true;
            for(Item i : this.cart.getProducts())
                this.cart.removeProducts(i);
            adm.addPayment(payment);
        }
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
