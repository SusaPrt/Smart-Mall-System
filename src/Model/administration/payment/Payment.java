/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration.payment;

import java.util.Random;
import Model.administration.payment.PaymentInterfaces.IPayment;

/**
 *
 * @author Marzio
 */
public class Payment implements IPayment{
    
    private final double cost;                                              
    private final int id;
    private final Random rnd;
    
    public Payment(double c){                                                                     
        this.cost = c;
        this.rnd = new Random();
        this.id = rnd.nextInt(1000)+101;
    }

    @Override
    public double getCost() {
       return this.cost;
    }

    
    @Override
    public int getId(){
        return this.id;
    }
    
    @Override
    public String toString(){
        return "\nPayment of "+this.cost+"€";
    }
}

