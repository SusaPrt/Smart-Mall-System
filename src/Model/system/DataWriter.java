/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.system;

import Model.administration.Customer;
import Model.administration.Item;
import Model.administration.Person;
import Model.administration.Staff;
import Model.enterprises.library.classes.Book;
import Model.enterprises.library.classes.Loan;
import Model.enterprises.restaurant.classes.Dish;
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
    
    // Inserisce l'intestazione del file all'interno della LinkedList di stringhe
    // necessario in quanto gli oggetti che dovranno successivamente essere salvati
    // andranno a posizionarsi nella posizione corretta grazie all'inserimento
    // di queste stringhe che indicheranno il tipo degli oggetti quando il file
    // verrà aperto in lettura
    public void setTxt(){
        
        // Condizione di controllo per evitare che l'intestazione venga scritta
        // più volte
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
    
    // Scrive su file di testo ogni Stringa presente nella LinkedList
    // 'itemsToWrite'
    public void writeOnFile() throws IOException{
        BufferedWriter bW = new BufferedWriter(new FileWriter(this.file));
        for(String s: this.itemsToWrite){
            bW.write(s);
            bW.newLine();
        }
        bW.close();           
    }
    
    // Metodo utilizzato per popolare 'itemsToWrite' un oggetto alla volta
    // convertendolo in una stringa di formato 'CSV'
    public void addItem(Object o){
        if(o instanceof Dish){
            // Parametri 'Dish' 
            // String name, double price, int q, String course
            Dish d = (Dish)o;
            this.itemsToWrite.add(this.itemsToWrite.indexOf("#"+d.getCourse().getName())+1,
                    d.getName()+","+d.getPrice()+","+d.getQuantity());
            
            
        }else if(o instanceof Book){
            // Parametri 'Book'  
            // String name,  String author, double price, int quantity, int year, String genre, int sbn
            Book b = (Book)o;
            this.itemsToWrite.add(this.itemsToWrite.indexOf("#"+b.getGenre())+1,
                    b.getName()+","+b.getAuthor()+","+b.getPrice()+","+b.getQuantity()
                    +","+b.getPublishingYear()+","+b.getISBN());  
        }else{
            // Parametri 'Item'
            // String name, Double price, int quantity
            Item i = (Item)o;
            this.itemsToWrite.add(""+i.getName()+","+i.getPrice()+","+i.getQuantity());
        }
    } 
    
    // Metodo simile a 'addItem' con la differenza che si occupa del salvataggio
    // di oggetti estensioni di 'Person'
    public void addPerson(Person p){
        if(p instanceof Staff){
            // Parametri 'Staff'
            // String name, String password, int id
            Staff s = (Staff)p;
            this.itemsToWrite.add(this.itemsToWrite.indexOf("#Staff")+1,
                    s.getName()+","+s.getPassword()+","+s.getId());
        }else{
            // Parametri 'Customer'
            // String name, String password, Double credit, int id
            Customer c = (Customer)p;
            this.itemsToWrite.add(this.itemsToWrite.indexOf("#Customers")+1,
                    c.getName()+","+c.getPassword()+","+c.getCredit()+","+c.getId());
        }            
    }
    
    // Metodo per salvataggio di oggetti 'Loan'
    public void addLoan(Customer c, Loan l){
        // Parametri Loan
        // int customerId, int bookISBN, String issueDate, String dueDate
        this.itemsToWrite.add(this.itemsToWrite.indexOf("#Loans")+1,
                    c.getId()+","+l.getBorrowedBook().getISBN()+","+l.getIssueDate()+","+l.getDueDate());
        
    }
    /*
    public LinkedList<String> getStuffToWrite(){
        return this.itemsToWrite;
    }*/
}
