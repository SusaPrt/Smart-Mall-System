package Controllers;


import Model.administration.Administration;
import Model.enterprises.library.Library;
import Model.enterprises.restaurant.Restaurant;
import Model.enterprises.shop.Shop;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

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
    private HashSet<Library> libraries;
    private HashSet<Restaurant> restaurants;
    private HashSet<Shop> shops;
    
    public MainApplication(){
        this.adminstration = new Administration();
        this.libraries = new HashSet();
        this.libraries.add(new Library(this.adminstration));
        this.restaurants = new HashSet();
        this.restaurants.add(new Restaurant(200));
        this.shops = new HashSet();
        this.shops.add(new Shop());
    }

    public Administration getAdminstration() {
        return this.adminstration;
    }

    public Library getDefaultLibrary() {
        return this.libraries.stream().filter(l -> l.getName().equals("Library")).findFirst().get();
    }
    
    public List<Library> getLibraries(){
        return this.libraries.stream().collect(Collectors.toList());
    }

    public Restaurant getDefaultRestaurant() {
        return this.restaurants.stream().filter(r -> r.getName().equals("Restaurant")).findFirst().get();
    }
    
    public List<Restaurant> getRestaurants(){
        return this.restaurants.stream().collect(Collectors.toList());
    }

    public Shop getDefaultShop() {
        return this.shops.stream().filter(s -> s.getName().equals("Shop")).findFirst().get();
    }
    
    public List<Shop> getShops(){
        return this.shops.stream().collect(Collectors.toList());
    }
    
    public boolean addEnterprises(Object o){
        boolean success = false;
        if(o instanceof Library){
            Library l = (Library)o;
            success = this.libraries.add(l);
        }else if(o instanceof Restaurant){
            Restaurant r = (Restaurant)o;
            success = this.restaurants.add(r);
        }else if(o instanceof Shop){
            Shop s = (Shop)o;
            success = this.shops.add(s);
        }
        return success;
    }
    
    public boolean removeEnterprises(Object o){
        boolean success = false;
        if(o instanceof Library){
            Library l = (Library)o;
            success = this.libraries.remove(l);
        }else if(o instanceof Restaurant){
            Restaurant r = (Restaurant)o;
            success = this.restaurants.remove(r);
        }else if(o instanceof Shop){
            Shop s = (Shop)o;
            success = this.shops.remove(s);
        }
        return success;
    }   
}
