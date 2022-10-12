/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model.enterprises.library;

import Model.administration.Administration;
import Model.administration.Customer;
import Model.system.DataInterpreter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mars_DB
 */
public class LibraryTest {
    private Library instance;
    private LinkedList<Loan> loans;
    private LinkedList<Customer> customer;
    private LinkedList<Book> books;
    
    public LibraryTest() throws FileNotFoundException {
        this.instance = new Library();
        this.loans = new LinkedList();
        this.loans.add(new Loan(new Book("H.P. e la pietra filosofale", 
                "J.K. Rowling", 20.00, 50, 1997, "Fantasy", 3945)));
        this.loans.add(new Loan(new Book("Il mondo di Sofia", 
                "Jostein Gaarder", 20.50, 1, 1991, "Adventure", 9928)));
        this.loans.add(new Loan(new Book("Il trono di spade", "G.R.R. Martin", 9.50, 40, 1996, "Fantasy", 6830)));
        
        DataInterpreter libraryDataInterpreter = new DataInterpreter(new File("./src/Model/system/DataFolder/Library.txt")
                    ,"Library"); 
        this.books = libraryDataInterpreter.getData().getFirst();
        
        Administration aD = new Administration();
        DataInterpreter archiveDataInterpreter= new DataInterpreter(new File("./src/Model/system/DataFolder/Account.txt")
                                                , "Archive", aD);
        this.customer = (LinkedList)aD.getArchive().getCustomers().stream().toList();
        this.customer.add(new Customer("Giovanni", "12345", 300.00, 7777, new Administration()));
        
        this.instance.createLoan(customer.getFirst(), books.getFirst());
        this.instance.createLoan(customer.getFirst(), books.getLast());
        this.instance.createLoan(customer.getLast(), books.get(1));      
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "Library";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAllBooks() throws FileNotFoundException {
        System.out.println("getAllBooks");
        
        DataInterpreter libraryDataInterpreter;        
        libraryDataInterpreter = new DataInterpreter(new File("./src/Model/system/DataFolder/Library.txt")
                    ,"Library");       
        List<Book> expResult = this.books;
        
        List<Book> result = instance.getAllBooks();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAllLoans() {
        System.out.println("getAllLoans");
        Map<Customer, Set<Loan>> expResult = new HashMap();
        
        expResult.put(customer.getFirst(), new HashSet());
        expResult.get(customer.getFirst()).add(new Loan(books.getFirst()));
        expResult.get(customer.getFirst()).add(new Loan(books.getLast()));
        expResult.put(customer.getLast(), new HashSet());
        expResult.get(customer.getLast()).add(new Loan(books.get(1)));
        
        
        Map<Customer, Set<Loan>> result = instance.getAllLoans();
        assertEquals(expResult, result);
    }

    @Test
    public void testAddBook() {
        System.out.println("addBook");
        Book b = new Book("Il signore degli anelli", "J.R.R. Tolkien", 20.60, 40, 1954, "Fantasy", 73737);
        this.instance.addBook("Il signore degli anelli", "J.R.R. Tolkien", 20.60, 40, 1954, "Fantasy", 73737);
        boolean expResult = true;
        boolean result = this.instance.getAllBooks().contains(b);
        assertEquals(expResult, result);       
    }

    @Test
    public void testRemoveBook() {
        System.out.println("removeBook");
        Book b = this.books.getFirst();
        this.instance.removeBook(b);
        boolean expResult = false;
        boolean result = this.instance.getAllBooks().contains(b);
        assertEquals(expResult, result);
    }

    @Test
    public void testCreateLoan() {
        System.out.println("createLoan");
        Library instance = new Library();
        instance.createLoan(this.customer.getLast(), this.books.getFirst());
        boolean expResult = true;
        boolean result = this.instance.getAllLoans().get(this.customer.getLast()).contains(this.books.getFirst());
        assertEquals(expResult, result);
    }

    @Test
    public void testCancelLoan() {
        System.out.println("cancelLoan");
        instance.cancelLoan(this.customer.getFirst(), this.books.getFirst());
        boolean expResult = false;
        boolean result = this.instance.getAllLoans().get(this.customer.getFirst()).contains(this.books.getFirst());
        assertEquals(expResult, result);
    }

    @Test
    public void testSearchBookByTitle() {
        System.out.println("searchBookByTitle");
        String title = "H.P. e la pietra filosofale";
        Set<Book> expResult = new HashSet();
        expResult.add(this.books.getFirst());
        Set<Book> result = instance.searchBookByTitle(title);
        assertEquals(expResult, result);
    }

    @Test
    public void testSearchBookByGenre() {
        System.out.println("searchBookByGenre");
        String genre = "Fantasy";
        Set<Book> expResult = new HashSet();
        expResult.add(this.books.getFirst());
        expResult.add(this.books.getLast());
        Set<Book> result = instance.searchBookByGenre(genre);
        assertEquals(expResult, result);
    }

    @Test
    public void testSearchBookByAuthor() {
        System.out.println("searchBookByAuthor");
        String author = "G.R.R. Martin";
        Set<Book> expResult = new HashSet();
        expResult.add(this.books.getLast());
        Set<Book> result = instance.searchBookByAuthor(author);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCustomerLoans() {
        System.out.println("getCustomerLoans");
        Set<Loan> expResult = new HashSet();
        expResult.add(this.loans.getLast());
        Set<Loan> result = instance.getCustomerLoans(this.customer.getLast());
        assertEquals(expResult, result);
    }

    @Test
    public void testRefueling() {
        System.out.println("refueling");
        Book b = this.books.getLast();
        int n = 10;
        boolean expResult = true;
        boolean result = instance.refueling(b, n);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEquals() throws IOException {
        System.out.println("equals");
        Object obj = this.instance;
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNotEquals() throws IOException {
        System.out.println("equals");
        Object obj = new Library("DaPino");
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
}
