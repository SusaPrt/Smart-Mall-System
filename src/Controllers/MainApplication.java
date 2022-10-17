package Controllers;


import Model.administration.Administration;
import Model.enterprises.library.Library;
import Model.enterprises.restaurant.Restaurant;
import Model.enterprises.shop.Shop;
import java.io.FileNotFoundException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mars_DB
 */
public class MainApplication {
    private final Administration adminstration;
    private final Library library;
    private final Restaurant restaurant;
    private final Shop shop;
    
    public MainApplication(){
        this.adminstration = new Administration();
        this.library = new Library(this.adminstration);
        this.restaurant = new Restaurant(200);
        this.shop = new Shop();
    }

    public Administration getAdminstration() {
        return this.adminstration;
    }

    public Library getLibrary() {
        return this.library;
    }

    public Restaurant getRestaurant() {
        return this.restaurant;
    }

    public Shop getShop() {
        return this.shop;
    }
    
}