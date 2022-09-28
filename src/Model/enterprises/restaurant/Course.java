/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.enterprises.restaurant;

// @author Susanna

public class Course {

    protected static Course FIRSTS;
    protected static Course SECONDS;
    protected static Course DESSERTS;
    protected static Course WINESANDSOFT;
    
    public static Course selectType(String type) {
        Course work = null;
        switch(type) {
            case "FIRSTS" -> work = Course.FIRSTS;
            case "SECONDS" -> work = Course.SECONDS;
            case "DESSERTS" -> work = Course.DESSERTS;
            case "WINESANDSOFT" -> work = Course.WINESANDSOFT;
            }
        return work;
    }
}
