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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Susanna
 */
public class LibraryTest {
    private Library instance;
    private Map<Customer, Set<Loan>> loans;
    private Customer customer1;
    private Customer customer2;
    private Book book1;
    private Book book2;
    private Book dFault;
    
    public LibraryTest() {
        this.instance = new Library(new Administration());
        
        this.book1 = this.instance.getAllBooks().get(0);
        this.book2 = this.instance.getAllBooks().get(1);
        this.customer1 = new Customer("Giorgio", "123", 200.00, 8888, new Administration());
        this.customer2 = new Customer("Giovanni", "12345", 300.00, 7777, new Administration());
        
        this.loans = new HashMap();
        this.instance.createLoan(customer1, book1);
        this.instance.createLoan(customer1, book2);
        this.instance.createLoan(customer2, book1); 
        
        this.loans.put(customer1, new HashSet());
        this.loans.put(customer2, new HashSet());
        
        this.loans.get(customer1).add(new Loan(book1));
        this.loans.get(customer1).add(new Loan(book2));
        this.loans.get(customer2).add(new Loan(book1));
        
        this.dFault = new Book("H.P. e la pietra filosofale", 
                "J.K. Rowling", 20.00, 50, 1997, "Fantasy", 3945);         
    }

    @Test
    public void testGetName() {
        System.out.println("Test per metodo 'getName'");
        String expResult = "Library";
        String result = this.instance.getName();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAllBooks() throws FileNotFoundException {
        System.out.println("Test per metodo 'getAllBooks'");
        DataInterpreter libraryDataInterpreter;        
        
        libraryDataInterpreter = new DataInterpreter(new File("./src/Model/system/DataFolder/Library.txt")
                    ,"Library");    
        
        List<Book> expResult = libraryDataInterpreter.getData().get(0);
        List<Book> result = instance.getAllBooks();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAllLoans() {
        System.out.println("Test per metodo 'getAllLoans'");
        Map<Customer, Set<Loan>> expResult = this.loans;
        Map<Customer, Set<Loan>> result = instance.getAllLoans();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testAddBook() {
        System.out.println("Test per metodo 'addBook'");
        Book b = new Book("Il signore degli anelli", "J.R.R. Tolkien", 20.60, 40, 1954, "Fantasy", 73737);
        this.instance.addBook("Il signore degli anelli", "J.R.R. Tolkien", 20.60, 40, 1954, "Fantasy", 73737);
        boolean expResult = true;
        boolean result = this.instance.getAllBooks().contains(b);
        assertEquals(expResult, result);       
    }

    @Test
    public void testRemoveBook() {
        System.out.println("Test per metodo 'removeBook'");
        Book b = new Book("Il signore degli anelli", "J.R.R. Tolkien", 20.60, 40, 1954, "Fantasy", 73737);
        this.instance.addBook("Il signore degli anelli", "J.R.R. Tolkien", 20.60, 40, 1954, "Fantasy", 73737);
        this.instance.removeBook(b);
        boolean expResult = false;
        boolean result = this.instance.getAllBooks().contains(b);
        assertEquals(expResult, result);
    }

    @Test
    public void testCreateLoan() {
        System.out.println("Test per metodo 'createLoan'");
        instance.createLoan(this.customer2, this.book2);
        Loan l = new Loan(this.book2);
        boolean expResult = true;
        boolean result = this.instance.getAllLoans().get(this.customer2).contains(l);
        assertEquals(expResult, result);
    }

    @Test
    public void testCancelLoan() {
        System.out.println("Test per metodo 'cancelLoan'");
        instance.createLoan(this.customer2, this.book2);
        instance.cancelLoan(this.customer2, this.book2);
        Loan l = new Loan(this.book2);
        boolean expResult = false;
        boolean result = this.instance.getAllLoans().get(this.customer2).contains(l);
        assertEquals(expResult, result);
    }

    @Test
    public void testSearchBookByTitle() {
        System.out.println("Test per metodo 'searchBookByTitle'");
        String title = "H.P. e la pietra filosofale";
        this.instance.addBook("H.P. e la pietra filosofale", 
                "J.K. Rowling", 20.00, 50, 1997, "Fantasy", 3945);
        Set<Book> expResult = new HashSet();
        expResult.add(this.dFault);
        Set<Book> result = instance.searchBookByTitle(title);
        assertEquals(expResult, result);
    }

    @Test
    public void testSearchBookByGenre() {
        System.out.println("Test per metodo 'searchBookByGenre'");
        String genre = "Fantasy";
        this.instance.addBook("H.P. e la pietra filosofale", 
                "J.K. Rowling", 20.00, 50, 1997, "Fantasy", 3945);
        Set<Book> expResult = new HashSet();
        expResult.add(this.dFault);
        Set<Book> result = instance.searchBookByGenre(genre);
        assertEquals(expResult, result);
    }

    @Test
    public void testSearchBookByAuthor() {
        System.out.println("Test per metodo 'searchBookByAuthor'");
        String author = "J.K. Rowling";
        this.instance.addBook("H.P. e la pietra filosofale", 
                "J.K. Rowling", 20.00, 50, 1997, "Fantasy", 3945);
        Set<Book> expResult = new HashSet();
        expResult.add(this.dFault);
        Set<Book> result = instance.searchBookByAuthor(author);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCustomerLoans() {
        System.out.println("Test per metodo 'getCustomerLoans'");
        Set<Loan> expResult = new HashSet();
        expResult.add(new Loan(this.book1));
        expResult.add(new Loan(this.book2));
        
        Set<Loan> result = instance.getCustomerLoans(this.customer1);
        assertEquals(expResult, result);
    }

    @Test
    public void testRefueling() {
        System.out.println("Test per metodo 'refueling'");
        int n = 10;
        boolean expResult = true;
        boolean result = instance.refueling(this.book1, n);
        assertEquals(expResult, result);
    }
}
