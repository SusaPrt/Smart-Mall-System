/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration;

/**
 *
 * @author Mars_DB
 */
public class Item { protected final String name;
    private final double price;
    private int quantity;
    
    public Item(String name, double price, int quantity){
        this.name       = name;
        this.price      = price;
        this.quantity   = quantity;
    }
    
    public String getName(){
        return this.name;
    }
    
    public double getPrice(){
        return this.price;
    }
    
    public int getQuantity(){
        return this.quantity;
    }
    
    public void decreaseQuantity(int i){
        this.quantity =- i;                 // i come parametro, per non richiamare f. 20 volte nel caso di un ordine di 20 elementi
    }                                           // per stesso oggetto
    public void increaseQuantity(int i){
        this.quantity =+ i;
    }
    
    @Override
    public String toString(){
        return "\nItem: "+this.name+"\nPrice: "+this.price+"\n"+"Quantity: "+this.quantity+"\n";
    }
}