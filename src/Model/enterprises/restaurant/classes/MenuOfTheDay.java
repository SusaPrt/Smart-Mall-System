/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.enterprises.restaurant.classes;

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
        this.lunch = new LinkedList<>();
        this.dinner = new LinkedList<>();
        this.rnd = new Random();
        if(!(m.getAvailableTypeDishes(Course.FIRSTS).isEmpty()))
            this.makeMenuOFTheDay();
    } 

    public LinkedList<Dish> getLunch() {
        return this.lunch;
    }

    public LinkedList<Dish> getDinner() {
        return this.dinner;
    }
    
    private void makeMenuOFTheDay() {
        this.lunch.add(this.menu.getAvailableTypeDishes(Course.FIRSTS).get(this.rnd.nextInt(this.menu.getAvailableTypeDishes(Course.FIRSTS).size())));
        this.lunch.add(this.menu.getAvailableTypeDishes(Course.SECONDS).get(this.rnd.nextInt(this.menu.getAvailableTypeDishes(Course.SECONDS).size())));
        this.lunch.add(this.menu.getAvailableTypeDishes(Course.DESSERTS).get(this.rnd.nextInt(this.menu.getAvailableTypeDishes(Course.DESSERTS).size())));

        this.dinner.add(this.menu.getAvailableTypeDishes(Course.FIRSTS).get(this.rnd.nextInt(this.menu.getAvailableTypeDishes(Course.FIRSTS).size())));
        this.dinner.add(this.menu.getAvailableTypeDishes(Course.FIRSTS).get(this.rnd.nextInt(this.menu.getAvailableTypeDishes(Course.SECONDS).size())));
        this.dinner.add(this.menu.getAvailableTypeDishes(Course.DESSERTS).get(this.rnd.nextInt(this.menu.getAvailableTypeDishes(Course.DESSERTS).size())));
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
