/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.enterprises.restaurant;

// @author Susanna & Marzio

import java.util.Objects;


public class Course {

    public static final Course FIRSTS = new Course("FIRSTS");
    public static final Course SECONDS = new Course("SECONDS");
    public static final Course DESSERTS = new Course("DESSERTS");
    public static final Course WINESANDSOFT = new Course("WINESANDSOFT");
    
    private final String name;
    
    private Course(String name){
        this.name = name;
    }
    
    public static Course selectType(String course) {
        Course work = null;
        switch(course) {
            case "FIRSTS" -> work = Course.FIRSTS;
            case "SECONDS" -> work = Course.SECONDS;
            case "DESSERTS" -> work = Course.DESSERTS;
            case "WINESANDSOFT" -> work = Course.WINESANDSOFT;
            }
        return work;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public int hashCode() {
        final int hash = 31;
        int result = 1;
        result = result * hash + Objects.hashCode(this.name);
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
        final Course other = (Course) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
}
