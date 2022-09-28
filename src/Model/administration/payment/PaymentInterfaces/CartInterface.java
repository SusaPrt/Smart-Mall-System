/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.administration.payment.PaymentInterfaces;

import Model.administration.Item;
import java.util.LinkedList;

/**
 *
 * @author Mars_DB
 */
public interface CartInterface {
    
    public void addItem(Item i);
    
    public void removeProducts(Item i);
    
    public LinkedList<Item> getProducts();
    
    public double getTotCost();
}
