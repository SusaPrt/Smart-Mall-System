/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.administration.AdministrationInterfaces;

/**
 *
 * @author Mars_DB
 */
public interface ItemInterface {
    
    public String getName();
    
    public double getPrice();
    
    public int getQuantity();
    
    public void decreaseQuantity(int i);
    
    public void increaseQuantity(int i);
    
    public boolean isAvailable();
        
}
