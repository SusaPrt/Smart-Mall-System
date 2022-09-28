/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.enterprises.library;

//@author Susanna

import Model.administration.Customer;
import Model.system.DataInterpreter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


public class Library {
    private final String name;
    private final LinkedList<Book> booksList;
    private final Map<Customer, Set<Loan>> loansList; 
    private final DataInterpreter dataInt;
    
        
    public Library(String name) throws FileNotFoundException{
        super();
        this.name = name;        
        this.loansList = new HashMap();
        this.dataInt = new DataInterpreter(new File("./src/Model/system/DataFolder/Library.txt"), "Library");
        this.booksList = this.dataInt.getData().getFirst();
    }
    
    public String getName() {
        return this.name;
    }
    
    public LinkedList<Book> getAllBooks() {
        return this.booksList;
    }
    
    public Map<Customer, Set<Loan>> getAllLoans() {
        return this.loansList;
    }
    
    public void addBook(String name,  String author, double price, int quantity, int year, String genre, int isbn) {
        if(this.checkISBN(isbn))
            System.out.println("Error: book already registered");
        else
            this.booksList.add(new Book(name, author, price, quantity, year, genre, isbn));
        
    }
    
    public void removeBook(Book b) {
        if(this.checkISBN(b.getISBN()))
            this.booksList.remove(b);
        else
            System.out.println("Error: book non registered");
    }
    
    public void createLoan(Customer customer, Book book) {
        if(!this.loansList.containsKey(customer))
            this.loansList.put(customer, new HashSet<>());
        book.decreaseQuantity(1);
        this.loansList.get(customer).add(new Loan(book));
    }
    
    public void cancelLoan(Customer customer, Book book) {
        Loan work = this.loansList.get(customer).stream().filter(l -> l.getBorrowedBook().equals(book)).findFirst().get();
        this.loansList.get(customer).remove(work);
        book.increaseQuantity(1);
    }
    
    public Set<Book> searchBookByTitle(String title) {
        return this.booksList.stream().filter(b -> b.getName().contains(title)).collect(Collectors.toSet());
    }
    
    public Set<Book> searchBookByGenre(String genre) {
        return this.booksList.stream().filter(b -> b.getGenre().equals(genre)).collect(Collectors.toSet());
    }
    
    public Set<Book> searchBookByAuthor(String author) {
        return this.booksList.stream().filter(b -> b.getAuthor().contains(author)).collect(Collectors.toSet());
    }
    
    public Set<Loan> getCustomerLoans(Customer customer) {
        return this.loansList.get(customer);
    }
    
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
    
    private boolean checkISBN(int isbn) {
        return this.booksList.stream().anyMatch(b -> isbn == b.getISBN());
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
