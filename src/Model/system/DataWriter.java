/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.system;

import Model.administration.Item;
import Model.enterprises.library.Book;
import Model.enterprises.restaurant.Dish;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author Mars_DB
 */
public class DataWriter {
    private BufferedWriter bW;
    private final String requirer;
    private LinkedList<String> itemsTowrite;
    
    public DataWriter(File file, String requirer, LinkedList<String> rawData){
        try {
            this.bW = new BufferedWriter(new FileWriter(file));
        } catch (IOException ex) {
            System.out.println(ex);
        }
        this.requirer = requirer;
        this.itemsTowrite = rawData;
    }
    
    public void writeOnFile() throws IOException{
        for(String s: this.itemsTowrite){
            this.bW.write(s);
            this.bW.newLine();
        }
        this.bW.close();           
    }
    
    public void addItem(Object o){
        if(o instanceof Dish){
            //String name, double price, int q, String course
            Dish d = (Dish)o;
            
        }else if(o instanceof Book){
        //String name,  String author, double price, int quantity, int year, String genre, int sbn
            Book b = (Book)o;
    //       this.insertLine(""+b.getName()+ ecc ecc, requirer);
    //this.itemsTowrite.
            
        }else{
            Item i = (Item)o;
            this.itemsTowrite.add(""+i.getName()+","+i.getPrice()+","+i.getQuantity());
        }
    } 
    // non serve cè metodo per inserire e shifta tutti gli elementi dopo
    private void insertLine(String newLine, String type){
        String work = null;
        int index = 0;
        for(String s:this.itemsTowrite){
            if(s.equals("#"+type)){
            //    work = 
            }
                
        }
        
    }
}
