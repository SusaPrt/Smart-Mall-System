/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.enterprises.library;

//@author Susanna

import Model.administration.Customer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class Library {
    private final String name;
    private int loadID;
    
    private LinkedList<Book> booksList;
    private Map<Customer, Set<Loan>> loansList; 
    
    public Library(String name, LinkedList<LinkedList> list) {
        super();
        this.name = name;
        this.booksList = new LinkedList(list.get(0));
        this.loansList = new HashMap();
    }
    
    public void addBook(String name,  String author, double price, int quantity, int year, String genre, int isbn) {
        if(this.checkISBN(isbn))
            System.out.println("This book is already registered!");
        else {
            this.booksList.add(new Book(name, author, price, quantity, year, genre, isbn));
        }
    }
    
    public void removeBook(int isbn) {
        for(Book book : this.booksList) {
            if(book.getISBN() == isbn)
                this.booksList.remove(book);
        }
    }
    
    public void createLoan(Customer customer, Book book) {
        if(!this.loansList.containsKey(customer))
            this.loansList.put(customer, new HashSet<Loan>());
        this.loansList.get(customer).add(new Loan(book));
    }
    
    public void removeLoan(Customer customer, Book book) {
        
    }
    
    public Set<Book> searchBookByTitle(String title) {
        /*Set<Book> result = new HashSet();
        for(Book work : booksList) {
            if(work.getName().contains(title))
                result.add(work);
        }*/
        return this.booksList.stream().filter(b -> b.getName().equals(title)).collect(Collectors.toSet());
    }
    
    public Set<Book> searchBookByGenre(String genre) {
        /*Set<Book> result = new HashSet();
        for(Book work : booksList) {
            if(work.getGenre().equals(genre))
                result.add(work);
        }*/
        return this.booksList.stream().filter(b -> b.getGenre().equals(genre)).collect(Collectors.toSet());
    }
    
    private boolean checkISBN(int isbn) {
        return this.booksList.stream().anyMatch(b -> isbn == b.getISBN());
    }
}
