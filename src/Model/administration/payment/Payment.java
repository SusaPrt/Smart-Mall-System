/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration.payment;

import Model.administration.Customer;
import Model.administration.payment.PaymentInterfaces.IPayment;
import java.util.Objects;

/**
 *
 * @author Marzio
 */
public class Payment implements IPayment{
    
    private final double cost;                                              
    private final Customer customer;
    
    public Payment(double c, Customer customer){                                                                     
        this.cost = c;
        this.customer = customer;
    }

    @Override
    public double getCost() {
       return this.cost;
    }

    
    @Override
    public Customer getCustomer(){
        return this.customer;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.cost) ^ (Double.doubleToLongBits(this.cost) >>> 32));
        hash = 67 * hash + this.customer.getId();
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
        final Payment other = (Payment) obj;
        if (Double.doubleToLongBits(this.cost) != Double.doubleToLongBits(other.cost)) {
            return false;
        }

        return Objects.equals(this.customer.getId(), other.customer.getId());
    }
    
    @Override
    public String toString(){
        return "\nPayment of "+this.cost+"€";
    }
}

