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
import Model.enterprises.library.Loan;
import Model.enterprises.restaurant.Dish;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;


/**
 *
 * @author Marzio
 */
public class DataWriter {
    private final String requirer;
    private final File file;
    private LinkedList<String> itemsToWrite;
    
    public DataWriter(File file, String requirer){
        this.file = file;
        this.requirer = requirer;
        this.itemsToWrite = new LinkedList();
        
    }
    
    public void setTxt(){
        if(this.itemsToWrite.contains("#Staff") 
                || this.itemsToWrite.contains("#Comic") 
                || this.itemsToWrite.contains("#FIRSTS"))
        {}else{
            if(this.requirer.equals("Archive")){
                this.itemsToWrite.add("#Staff");
                this.itemsToWrite.add("#Customers");
                
            }else if(this.requirer.equals("Library")){
                this.itemsToWrite.add("#Adventure");
                this.itemsToWrite.add("#Classics");
                this.itemsToWrite.add("#Comic");
                this.itemsToWrite.add("#Loans");
            
            }else if(this.requirer.equals("Restaurant")){
                this.itemsToWrite.add("#FIRSTS");
                this.itemsToWrite.add("#SECONDS");
                this.itemsToWrite.add("#DESSERTS");
                this.itemsToWrite.add("#WINESANDSOFT");           
            }
        }
    }
     
    public void writeOnFile() throws IOException{
        BufferedWriter bW = new BufferedWriter(new FileWriter(this.file));
        for(String s: this.itemsToWrite){
            bW.write(s);
            bW.newLine();
        }
        bW.close();           
    }
    
    //aggiunge una stringa alla posizione corretta alla lista di stringhe da scrivere su file
    //la lista di stringhe originale viene caricata alla creazione del DataWriter partendo dalle
    //stringhe rawData lette dal DataReader
    public void addItem(Object o){
        if(o instanceof Dish){
            //String name, double price, int q, String course
            Dish d = (Dish)o;
            this.itemsToWrite.add(this.itemsToWrite.indexOf("#"+d.getCourse().getName())+1,
                    d.getName()+","+d.getPrice()+","+d.getQuantity());
            
            
        }else if(o instanceof Book){
        //String name,  String author, double price, int quantity, int year, String genre, int sbn
            Book b = (Book)o;
            this.itemsToWrite.add(this.itemsToWrite.indexOf("#"+b.getGenre())+1,
                    b.getName()+","+b.getAuthor()+","+b.getPrice()+","+b.getQuantity()
                    +","+b.getPublishingYear()+","+b.getISBN());  
        }else{
            Item i = (Item)o;
            this.itemsToWrite.add(""+i.getName()+","+i.getPrice()+","+i.getQuantity());
        }
    } 
    
    public void addPerson(Person p){
        if(p instanceof Staff){
            Staff s = (Staff)p;
            this.itemsToWrite.add(this.itemsToWrite.indexOf("#Staff")+1,
                    s.getName()+","+s.getPassword()+","+s.getId());
        }else{
            Customer c = (Customer)p;
            this.itemsToWrite.add(this.itemsToWrite.indexOf("#Customers")+1,
                    c.getName()+","+c.getPassword()+","+c.getCredit()+","+c.getId());
        }            
    }
    
    public void addLoan(Customer c, Loan l){
        this.itemsToWrite.add(this.itemsToWrite.indexOf("#Loans")+1,
                    c.getId()+","+l.getBorrowedBook().getISBN()+","+l.getIssueDate()+","+l.getDueDate());
        
    }
    
    public LinkedList<String> getStuffToWrite(){
        return this.itemsToWrite;
    }
}
