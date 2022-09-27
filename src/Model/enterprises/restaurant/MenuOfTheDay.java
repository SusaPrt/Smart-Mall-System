/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.enterprises.restaurant;

//@author Susanna

import java.util.LinkedList;
import java.util.Objects;
import java.util.Random;

public class MenuOfTheDay {
    private final Menu menu;
    private final LinkedList<Dish> lunch;
    private final LinkedList<Dish> dinner;
    private final Random rnd;
    
    public MenuOfTheDay(Menu m) {
        this.menu = m;
        this.lunch = new LinkedList<Dish>();
        this.dinner = new LinkedList<Dish>();
        this.rnd = new Random();
        this.makeMenuOFTheDay();
    } 
    
    private void makeMenuOFTheDay() {
        this.lunch.add(this.menu.getFirst().get(this.rnd.nextInt(this.menu.getFirst().size())));
        this.lunch.add(this.menu.getSeconds().get(this.rnd.nextInt(this.menu.getSeconds().size())));
        this.lunch.add(this.menu.getDesserts().get(this.rnd.nextInt(this.menu.getDesserts().size())));

        this.dinner.add(this.menu.getFirst().get(this.rnd.nextInt(this.menu.getFirst().size())));
        this.dinner.add(this.menu.getSeconds().get(this.rnd.nextInt(this.menu.getSeconds().size())));
        this.dinner.add(this.menu.getDesserts().get(this.rnd.nextInt(this.menu.getDesserts().size())));
    }

    @Override
    public int hashCode() {
        final int hash = 31;
        int result = 1;
        result = result * hash + Objects.hashCode(this.lunch);
        result = result * hash + Objects.hashCode(this.dinner);
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
        final MenuOfTheDay other = (MenuOfTheDay) obj;
        if (!Objects.equals(this.lunch, other.lunch)) {
            return false;
        }
        return Objects.equals(this.dinner, other.dinner);
    }

    @Override
    public String toString() {
        return "Menu of the day\n" + "Lunch\n" + 
                "First: " + this.lunch.get(0) + "\n" +
                "Second: " + this.lunch.get(1) + "\n" +
                "Dessert: " + this.lunch.get(2) + "\n\n" + 
                "Dinner\n" + 
                "First: " + this.dinner.get(0) + "\n" +
                "Second: " + this.dinner.get(1) + "\n" +
                "Dessert: " + this.dinner.get(2);
    }
    
    
}
