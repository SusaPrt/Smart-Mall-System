/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.enterprises.restaurant;

//@author Susanna

import Model.system.DataInterpreter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Restaurant {
    
    private final String name;
    private final int totSeats;
    private int freeSeats;
    private Map<String, Integer> reservations;
    private MenuOfTheDay dailyMenu;
    private Menu menu;
    
    public Restaurant(String name, int seats, File file) throws FileNotFoundException{
        this.name = name;
        this.totSeats = seats;
        this.freeSeats = seats;
        this.reservations = new HashMap<>();
        DataInterpreter dataInt = new DataInterpreter(file, this.getClass().getSimpleName());
        this.menu = new Menu(dataInt.getData());
        this.dailyMenu = new MenuOfTheDay(menu);
    }
    
    public String getMenu() {
        return this.menu.toString();
    }
    public String getDailyMenu() {
        return this.dailyMenu.toString();
    }    
    
    public boolean reserveSeats(int n, String name) {
        boolean done = false;
        if((this.freeSeats - n) >= 0) {
            if(!(this.checkName(name))) {
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
        if(this.checkName(name)) {
            this.freeSeats += this.reservations.get(name);
            this.reservations.remove(name);
            done = true;
        } else
            System.out.println("Error: unregistered name");
        return done;
    }      
    
    public boolean orderADish(Dish d, int n) {
        boolean done = false;
        switch(n) {
            case 0 -> {
                if(this.menu.getAvailableFirsts().contains(d)) {
                    d.decreaseQuantity(1);
                    done = true;
                }
            }
            case 1 -> {
                if(this.menu.getAvailableSeconds().contains(d)) {
                    d.decreaseQuantity(1);
                    done = true;
                }
            }
            case 2 -> {
                if(this.menu.getAvailableDesserts().contains(d)) {
                    d.decreaseQuantity(1);
                    done = true;
                }
            }
            case 3 -> {
                if(this.menu.getAvailableWinesAndSoft().contains(d)) {
                    d.decreaseQuantity(1);
                    done = true;
                }
            }
        }
        if(!done)
            System.out.println("Dish not available");
        return done;
    }   
    
    public boolean refueling(Dish d, int n, int i) {
        boolean done = false;
        switch(n) {
            case 0 -> {
                if(this.menu.getFirsts().contains(d)) {
                    d.increaseQuantity(i);
                    done = true;
                }
            }
            case 1 -> {
                if(this.menu.getSeconds().contains(d)) {
                    d.increaseQuantity(i);
                    done = true;
                }
            }
            case 2 -> {
                if(this.menu.getDesserts().contains(d)) {
                    d.increaseQuantity(i);
                    done = true;
                }
            }
            case 3 -> {
                if(this.menu.getWinesAndSoft().contains(d)) {
                    d.increaseQuantity(i);
                    done = true;
                }
            }
        }
        if(!done)
            System.out.println("Dish not in the menu");
        return done;
    }
    
    public void newDay() {
        this.reservations.clear();
        this.freeSeats = this.totSeats;
        this.dailyMenu = new MenuOfTheDay(menu);
    }

    private boolean checkName(String name) {
        return this.reservations.entrySet().stream().filter(r -> r.getKey().equalsIgnoreCase(name)).findFirst().isPresent();
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
