/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.administration.AdministrationInterfaces;

import Model.administration.Administration;
import Model.administration.payment.Cart;

/**
 *
 * @author Marzio
 */
public interface ICustomer extends IPerson{
    
    public Boolean payTheCart(Administration ad);
    
    public double getCredit();
    
    public void addCredit(double d);
    
    public Cart getCart();
}
