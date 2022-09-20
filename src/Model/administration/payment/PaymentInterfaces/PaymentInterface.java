/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.administration.payment.PaymentInterfaces;

import Model.administration.Customer;

/**
 *
 * @author Mars_DB
 */
public interface PaymentInterface {
    
    public double getCost();
    
    public boolean checkStatus();
    
    public Customer getCustomer();
    
    public int getId();
}
