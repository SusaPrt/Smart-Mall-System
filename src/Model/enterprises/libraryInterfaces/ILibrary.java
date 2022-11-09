/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.enterprises.libraryInterfaces;

//@author Susanna

import Model.administration.Customer;
import Model.enterprises.library.Book;
import Model.enterprises.library.Loan;
import Model.system.DataInterpreter;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public interface ILibrary {
    public String getName();
    
    public List<Book> getAllBooks();
    
    public Set<Book> searchBookByTitle(String title);
    
    public Set<Book> searchBookByGenre(String genre);
    
    public Set<Book> searchBookByAuthor(String author);

    public Set<Loan> getCustomerLoans(Customer customer);
    
    public DataInterpreter getDataInterpreter();
    
    // >> METODI STAFF <<
    public Map<Customer, Set<Loan>> getAllLoans();
    
    public boolean addBook(String name,  String author, double price, int quantity, int year, String genre, int isbn);
    
    public boolean removeBook(Book b);
    
    public boolean createLoan(Customer customer, Book book);
    
    public boolean cancelLoan(Customer customer, Book book);
    
    public boolean refueling(Book b, int n);
    
    // >> METODO CUSTOMER <<
    public boolean buyABook(Book b, int i, Customer c);
    
}
