/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.system;

import Model.administration.Customer;
import Model.administration.Item;
import Model.administration.Person;
import Model.administration.Staff;
import Model.enterprises.library.Book;
import Model.enterprises.restaurant.Course;
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
    private final File file;
    private LinkedList<String> itemsTowrite;
    
    public DataWriter(File file, String requirer, LinkedList<String> rawData){
        this.file = file;
        this.requirer = requirer;
        this.itemsTowrite = rawData;
    }
    
    public void writeOnFile() throws IOException{
        this.bW = new BufferedWriter(new FileWriter(this.file));
        for(String s: this.itemsTowrite){
            this.bW.write(s);
            this.bW.newLine();
        }
        this.bW.close();           
    }
    
    //aggiunge una stringa alla posizione corretta alla lista di stringhe da scrivere su file
    //la lista di stringhe originale viene caricata alla creazione del DataWriter partendo dalle
    //stringhe rawData lette dal DataReader
    public void addItem(Object o){
        if(o instanceof Dish){
            //String name, double price, int q, String course
            Dish d = (Dish)o;
            this.itemsTowrite.add(this.itemsTowrite.indexOf("#"+d.getCourse().getName())+1,
                    d.getName()+","+d.getPrice()+","+d.getQuantity());
            
            
        }else if(o instanceof Book){
        //String name,  String author, double price, int quantity, int year, String genre, int sbn
            Book b = (Book)o;
            this.itemsTowrite.add(this.itemsTowrite.indexOf("#"+b.getGenre())+1,
                    b.getName()+","+b.getAuthor()+","+b.getPrice()+","+b.getQuantity()
                    +","+b.getPublishingYear()+","+b.getISBN());           
        }else{
            Item i = (Item)o;
            this.itemsTowrite.add(""+i.getName()+","+i.getPrice()+","+i.getQuantity());
        }
    } 
    
    public void addPerson(Person p){
        if(p instanceof Staff){
            Staff s = (Staff)p;
            this.itemsTowrite.add(this.itemsTowrite.indexOf("#Staff")+1,
                    s.getName()+","+s.getPassword()+","+s.getId());
        }else{
            Customer c = (Customer)p;
            this.itemsTowrite.add(this.itemsTowrite.indexOf("#Customer")+1,
                    c.getName()+","+c.getPassword()+","+c.getCredit()+","+c.getId());
        }            
    }
    
    public LinkedList<String> getStuffToWrite(){
        return this.itemsTowrite;
    }
}
