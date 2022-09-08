/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.system;

import Model.administration.Item;
import Model.enterprises.library.Book;
import Model.enterprises.restourant.Dish;
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
            
    }
    
    public void addItem(Object i){
        if(i instanceof Dish){
            
        }else if(i instanceof Book){
            
        }else{
            
        }
    }
    
    
}