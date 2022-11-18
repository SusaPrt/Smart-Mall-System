/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration.payment;

import Model.administration.payment.PaymentInterfaces.IPayment;
import java.util.Objects;

/**
 *
 * @author Marzio
 */
public class Payment implements IPayment{
    
    private final double cost;                                              
    private final int customerId;
    
    public Payment(double c, int customerId){                                                                     
        this.cost = c;
        this.customerId = customerId;
    }

    @Override
    public double getCost() {
       return this.cost;
    }

    
    @Override
    public int getCustomerId(){
        return this.customerId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.cost) ^ (Double.doubleToLongBits(this.cost) >>> 32));
        hash = 67 * hash + this.customerId;
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

        return Objects.equals(this.customerId, other.customerId);
    }
    
    @Override
    public String toString(){
        return "\nPayment of "+this.cost+"€";
    }
}

