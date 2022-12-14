/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.enterprises.shop.interfaces;

// @author Susanna

import Model.administration.Customer;
import Model.administration.Item;
import Model.system.DataInterpreter;
import java.util.List;
import java.util.stream.Collectors;


public interface IShop {
    
    // >> METODI PUBBLICI <<
    public List<Item> getWarehouse();
    public DataInterpreter getDataInterpreter();
    
    // >> METODI STAFF <<
    public boolean addItem(String name, double price, int quantity);
    
    public boolean removeItem(Item i);
    
    public boolean refueling(Item i, int n);
    
    // >> METODO CUSTOMER <<
    public boolean buyAItem(Item i, int n, Customer c);
}
