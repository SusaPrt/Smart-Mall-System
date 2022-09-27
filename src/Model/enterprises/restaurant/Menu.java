/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.enterprises.restaurant;

//@author Susanna

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Menu {
    
    private final LinkedList<Dish> firsts;
    private final LinkedList<Dish> seconds;
    private final LinkedList<Dish> desserts;
    private final LinkedList<Dish> winesAndSoft;
    
    public Menu(LinkedList<LinkedList> l) {
        this.firsts = new LinkedList(l.get(0));
        this.seconds = new LinkedList(l.get(1));
        this.desserts = new LinkedList(l.get(2));
        this.winesAndSoft = new LinkedList(l.get(3));
    }

    public List<Dish> getFirst() {
        return this.firsts.stream().filter(d -> d.getQuantity() > 0).collect(Collectors.toList());
    }
    public List<Dish> getSeconds() {
        return this.seconds.stream().filter(d -> d.getQuantity() > 0).collect(Collectors.toList());
    }
    public List<Dish> getDesserts() {
        return this.desserts.stream().filter(d -> d.getQuantity() > 0).collect(Collectors.toList());
    }
    public List<Dish> getWinesAndSoft() {
        return this.winesAndSoft.stream().filter(d -> d.getQuantity() > 0).collect(Collectors.toList());
    }
    
    public void addDish(Dish d, int n) {
        switch(n) {
            case 1 -> this.firsts.add(d);
            case 2 -> this.seconds.add(d);
            case 3 -> this.desserts.add(d);
            case 4 -> this.winesAndSoft.add(d);
        }
    }
    
    public void removeDish(Dish d, int n) {
        switch(n) {
            case 1 -> this.firsts.remove(d);
            case 2 -> this.seconds.remove(d);
            case 3 -> this.desserts.remove(d);
            case 4 -> this.winesAndSoft.remove(d);
        }
    }

    @Override
    public int hashCode() {
        int hash = 31;
        int result = 1;
        result = result * hash + Objects.hashCode(this.firsts);
        result = result * hash + Objects.hashCode(this.seconds);
        result = result * hash + Objects.hashCode(this.desserts);
        result = result * hash + Objects.hashCode(this.winesAndSoft);
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
        final Menu other = (Menu) obj;
        if (!Objects.equals(this.firsts, other.firsts)) {
            return false;
        }
        if (!Objects.equals(this.seconds, other.seconds)) {
            return false;
        }
        if (!Objects.equals(this.desserts, other.desserts)) {
            return false;
        }
        return Objects.equals(this.winesAndSoft, other.winesAndSoft);
    }

    @Override
    public String toString() {
        return "Menu" + 
                "\nFirsts: " + this.firsts + 
                "\nSeconds: " + this.seconds + 
                "\nDesserts: " + this.desserts + 
                "\nWines And Soft: " + this.winesAndSoft;
    }
    
    
}
