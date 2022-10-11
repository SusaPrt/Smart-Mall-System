/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.enterprises.shopInterfaces;

// @author Susanna

import Model.administration.Item;
import java.util.List;


public interface IShop {
    
    //ritorna tutti gli item in magazzino
    public List<Item> getWarehouse();
    
    //aggiunge un item al magazzino
    public void addItem(String name, double price, int quantity);
    
    //rimuove un item dal magazzino
    public void removeItem(Item i);

    //rifornisce di n quantità l'item indicato, ritorna il risultato dell'operazione
    public boolean refueling(Item i, int n);
    
}
