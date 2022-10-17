/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.enterprises.restaurant;

//@author Susanna

import Model.enterprises.restaurantInterfaces.IRestaurant;
import Model.system.DataInterpreter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;



public class Restaurant implements IRestaurant {
    
    private final String name;
    private final int totSeats;
    private int freeSeats;
    private final Map<String, Integer> reservations;
    private MenuOfTheDay menuOfTheDay;
    private Menu menu;
    private DataInterpreter dataInt;

    
    public Restaurant(int seats){
        super();
        this.name = "Restaurant";
        this.totSeats = seats;
        this.freeSeats = seats;
        this.reservations = new HashMap<>();
        try {
            this.dataInt = new DataInterpreter(new File("./src/Model/system/DataFolder/Menu.txt"), "Restaurant");
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        this.menu = new Menu(dataInt.getData());
        this.menuOfTheDay = new MenuOfTheDay(menu);
    }
    public Restaurant(String name, int seats) throws IOException{
        super();
        this.name = name;
        this.totSeats = seats;
        this.freeSeats = seats;
        this.reservations = new HashMap<>();
        this.fileChecker();       
    }

    // >> METODI PUBBLICI <<
    public MenuOfTheDay getDailyMenu() {
        return this.menuOfTheDay;
    }

    public Menu getMenu() {
        return this.menu;
    }
    
    public String getStringMenu() {
        return this.menu.toString();
    }
    
    public String getStringDailyMenu() {
        return this.menuOfTheDay.toString();
    }    
    
    public boolean reserveSeats(int n, String name) {
        boolean done = false;
        if((this.freeSeats - n) >= 0) {
            if(!(this.checkReservationName(name))) {
                this.reservations.put(name, n);
                this.freeSeats -= n;
                done = true;
            } else
                System.out.println("Error: name not available");
        } else
            System.out.println("Error: seats are not enough");
        return done;
    }
    
    public boolean cancelReservation(String name) {
        boolean done = false;
        if(this.checkReservationName(name)) {
            this.freeSeats += this.reservations.get(name);
            this.reservations.remove(name);
            done = true;
        } else
            System.out.println("Error: unregistered name");
        return done;
    }      
    
    public boolean orderADish(Dish d) {
        boolean done = false;
        if(this.checkAvaiableDish(d)) {
            d.decreaseQuantity(1);
            done = true;
        }
        if(!done)
            System.out.println("Error: dish not available");
        return done;
    }   
    
    public boolean refueling(Dish d, int i) {
        boolean done = false;
        if(this.checkDish(d)) {
            d.increaseQuantity(i);
            done = true;
        }
        if(!done)
            System.out.println("Error: dish not in the menu");
        return done;
    }
    
    public void newDay() {
        this.reservations.clear();
        this.freeSeats = this.totSeats;
        this.menuOfTheDay = new MenuOfTheDay(menu);
    }
    
    // >> METODI PRIVATI <<
    private void fileChecker() throws IOException{
        try{
        this.dataInt = new DataInterpreter(new File("./src/Model/system/DataFolder/" + name + ".txt"), "Restaurant");       
        }catch(FileNotFoundException fNf){
            File f = new File("./src/Model/system/DataFolder/" + name + ".txt");
            f.createNewFile();
            this.dataInt = new DataInterpreter(f, "Restaurant");
        }finally{
            this.menu = new Menu(dataInt.getData());
            this.menuOfTheDay = new MenuOfTheDay(menu);           
        }
    }    
    private boolean checkDish(Dish d) {
        return this.menu.getTypeDishes(d.getCourse()).stream().filter(dish -> dish.equals(d)).findFirst().isPresent();
    }
    
    private boolean checkAvaiableDish(Dish d) {
        return this.menu.getAvailableTypeDishes(d.getCourse()).stream().filter(dish -> dish.equals(d)).findFirst().isPresent();
    }

    private boolean checkReservationName(String name) {
        return this.reservations.entrySet().stream().filter(r -> r.getKey().equalsIgnoreCase(name)).findFirst().isPresent();
    }
    
    public int getTotSeats(){
        return this.totSeats;
    }
    
    public int getFreeSeats(){
        return this.freeSeats;
    }

    @Override
    public int hashCode() {
        final int hash = 31;
        int result = 1;
        result = result * hash + Objects.hashCode(this.name);
        result = result * hash + this.totSeats;
        result = result * hash + this.freeSeats;
        result = result * hash + Objects.hashCode(this.menu);
        return result;
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
        final Restaurant other = (Restaurant) obj;
        if (this.name != other.name) {
            return false;
        }
        if (this.totSeats != other.totSeats) {
            return false;
        }
        if (this.freeSeats != other.freeSeats) {
            return false;
        }
        return Objects.equals(this.menu, other.menu);
    }

    @Override
    public String toString() {
        return "Restaurant "+ this.name; 
    }    
}
