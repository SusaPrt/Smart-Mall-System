package Controllers;


import Model.administration.Administration;
import Model.enterprises.library.classes.Library;
import Model.enterprises.restaurant.classes.Restaurant;
import Model.enterprises.shop.classes.Shop;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Susanna & Marzio
 */
public class MainApplication {
    private final Administration adminstration;
    private HashSet<Library> libraries;
    private HashSet<Restaurant> restaurants;
    private HashSet<Shop> shops;
    
    public MainApplication(){
        this.adminstration = new Administration();
        this.libraries = new HashSet();
        this.libraries.add(new Library());
        this.restaurants = new HashSet();
        this.restaurants.add(new Restaurant(200));
        this.shops = new HashSet();
        this.shops.add(new Shop());
        
        this.findNonDefaultEnterprises();
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
    
    public void saveDatas(){
        this.adminstration.getArchive().saveData();
        
        this.libraries.stream().forEach(l -> l.saveData());
        this.restaurants.stream().forEach(r -> r.saveData());
        this.shops.stream().forEach(s -> s.saveData());      
    }
    
    // Verifica attraverso il nome se sono presenti delle attività che non sono
    // di default e nel qualcaso le carica
    private void findNonDefaultEnterprises(){
        File dir = new File("./src/Model/system/DataFolder");
        String[] fileNames = dir.list();
        try {
            for(String s: fileNames){
                s = s.substring(0, s.length()-4);
                
                if(!s.equals("Account")){
                    if(s.contains("Shop") && !s.equals("Shop"))
                        this.shops.add(new Shop(s));
                    else if(s.contains("Menu") && !s.equals("Menu"))
                        this.restaurants.add(new Restaurant(s, 200));           
                    else if(s.contains("Library") && !s.equals("Library"))
                        this.libraries.add(new Library(s));                  
                }
            }
        } catch (IOException ex) {
                        System.out.println(ex);
        }
    }
}
