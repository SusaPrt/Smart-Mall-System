/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.enterprises.library;

//@author Susanna

import Model.administration.Customer;
import Model.enterprises.libraryInterfaces.ILibrary;
import Model.enterprises.restaurant.Menu;
import Model.enterprises.restaurant.MenuOfTheDay;
import Model.system.DataInterpreter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


public class Library implements ILibrary {
    private final String name;
    private LinkedList<Book> booksList;
    private Map<Customer, Set<Loan>> loansList; 
    private DataInterpreter dataInt;
    
        
    public Library(){
        super();
        this.name = "Library";        
        this.loansList = new HashMap();
        try {
            this.dataInt = new DataInterpreter(new File("./src/Model/system/DataFolder/Library.txt"), "Library");
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        this.booksList = this.dataInt.getData().getFirst();
    }
    
    public Library(String name) throws IOException{
        super();
        this.name = name;        
        this.loansList = new HashMap();
        this.fileChecker();
    }
    
    // >> METODI PUBBLICI <<
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public List<Book> getAllBooks() {
        return this.booksList.stream().filter(b -> b.getQuantity() > 0).collect(Collectors.toList());
    }
    
    @Override
    public Set<Book> searchBookByTitle(String title) {
        return this.booksList.stream().filter(b -> b.getName().contains(title)).collect(Collectors.toSet());
    }
    
    @Override
    public Set<Book> searchBookByGenre(String genre) {
        return this.booksList.stream().filter(b -> b.getGenre().equals(genre)).collect(Collectors.toSet());
    }
    
    @Override
    public Set<Book> searchBookByAuthor(String author) {
        return this.booksList.stream().filter(b -> b.getAuthor().contains(author)).collect(Collectors.toSet());
    }
    @Override
    public Set<Loan> getCustomerLoans(Customer customer) {
        return this.loansList.get(customer);
    }
    
    // >> METODI STAFF <<
    @Override
    public Map<Customer, Set<Loan>> getAllLoans() {
        return this.loansList;
    }
    
    @Override
    public void addBook(String name,  String author, double price, int quantity, int year, String genre, int isbn) {
        if(this.checkISBN(isbn))
            System.out.println("Error: book already registered");
        else
            this.booksList.add(new Book(name, author, price, quantity, year, genre, isbn));        
    }
    
    @Override
    public void removeBook(Book b) {
        if(this.checkISBN(b.getISBN()))
            this.booksList.remove(b);
        else
            System.out.println("Error: book non registered");
    }
    
    @Override
    public void createLoan(Customer customer, Book book) {
        if(!this.loansList.containsKey(customer))
            this.loansList.put(customer, new HashSet<>());
        book.decreaseQuantity(1);
        this.loansList.get(customer).add(new Loan(book));
    }
    
    @Override
    public void cancelLoan(Customer customer, Book book) {
        Loan work = this.loansList.get(customer).stream().filter(l -> l.getBorrowedBook().equals(book)).findFirst().get();
        this.loansList.get(customer).remove(work);
        book.increaseQuantity(1);
    }
    
    @Override
    public boolean refueling(Book b, int n) {
        boolean done = false;
        if(this.checkISBN(b.getISBN())) {
            b.increaseQuantity(n);
            done = true;
        }
        if(!done)
            System.out.println("Error: book not registered");
        return done;
    }
    // >> METODO CUSTOMER <<
    public boolean buyABook(Book b, int i, Customer c) {
        boolean done = false;
        if(b.getQuantity() >= i) {
            if ((c.getCredit() - b.getPrice()) >= 0) {
                b.decreaseQuantity(i);
                c.getCart().addItem(b);
                done = true;
            } else
                System.out.println("Error: insufficient credit ");
        } else
            System.out.println("Error: books not enough"); 
        return done;
    }
    
    // >> METODI PRIVATI <<
    private boolean checkISBN(int isbn) {
        return this.booksList.stream().anyMatch(b -> isbn == b.getISBN());
    }

    
    private void fileChecker() throws IOException{
        try{
        this.dataInt = new DataInterpreter(new File("./src/Model/system/DataFolder/" + name + ".txt"), "Library");       
        }catch(FileNotFoundException fNf){
            File f = new File("./src/Model/system/DataFolder/" + name + ".txt");
            f.createNewFile();
            this.dataInt = new DataInterpreter(f, "Library");
        }finally{
            this.booksList = dataInt.getData().getFirst();          
        }
    }
    
    @Override
    public int hashCode() {
        final int hash = 31;
        int result = 1;
        result = result * hash + Objects.hashCode(this.name);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Library other = (Library) obj;
        return this.getName().equals(other.getName());
    }

    @Override
    public String toString() {
        return "Library: " + this.name;
    }   
    
}
