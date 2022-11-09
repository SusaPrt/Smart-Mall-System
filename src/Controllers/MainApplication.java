package Controllers;


import Model.administration.Administration;
import Model.enterprises.library.Library;
import Model.enterprises.restaurant.Restaurant;
import Model.enterprises.shop.Shop;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Marzio
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
    
    // da finire con datawriter
    private void saveData(){
        try {
            this.adminstration.getArchive().getDataInterpreter().getDataWriter().writeOnFile();
        } catch (IOException ex) {
            System.out.println("Scrittura su archivio: "+ex);
        }
        
        this.libraries.stream().forEach(l -> {
            try {
                l.getDataInterpreter().getDataWriter().writeOnFile();
                l.getDataInterpreter().getDataWriter().writeOnFile();
            } catch (IOException ex) {
                System.out.println("Scrittura su librerie: "+ex);
            }
        });
        
        
        this.restaurants.stream().forEach(r -> {
            try {
                r.getDataInterpreter().getDataWriter().writeOnFile();
            } catch (IOException ex) {
                System.out.println("Scrittura su ristoranti: "+ex);
            }
        });
        
        this.shops.stream().forEach(s -> {
            try {
                s.getDataInterpreter().getDataWriter().writeOnFile();
            } catch (IOException ex) {
                System.out.println("Scrittura su shop: "+ex);
            }
        });
    }
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
                        System.out.println("Eccezione caricamento nuove enterprises");
        }
    }
}
