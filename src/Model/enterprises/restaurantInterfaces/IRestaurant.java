/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.enterprises.restaurantInterfaces;

// @author Susanna

import Model.enterprises.restaurant.Dish;
import Model.enterprises.restaurant.Menu;
import Model.enterprises.restaurant.MenuOfTheDay;

 
public interface IRestaurant {
    //ritorna il menu del giorno come oggetto
    public MenuOfTheDay getDailyMenu();

    //ritorna il menu come oggetto
    public Menu getMenu();
    
    //ritorna il menu come stringa
    public String getStringMenu();
    
    //ritorna il menu del giorno come stringa
    public String getStringDailyMenu();
   
    //permette di riservare n posti, ritorna il risultato dell'operazione
    public boolean reserveSeats(int n, String name);
    
    //cancella una prenotazione, ritorna il risultato dell'operazione
    public boolean cancelReservation(String name);
    
    //permette di ordinare un piatto dal menu
    public boolean orderADish(Dish d);
    
    //rifornisce di n quantità il piatto indicato, ritorna il risultato dell'operazione
    public boolean refueling(Dish d, int i);
    
    //cancella tutte le prenotazioni, crea un nuovo menu del giorno
    public void newDay();
}
