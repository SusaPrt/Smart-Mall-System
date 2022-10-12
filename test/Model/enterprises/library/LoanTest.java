/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model.enterprises.library;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mars_DB
 */
public class LoanTest {
    private final Loan instance;
    private final Book book;
    private final LocalDate today;
    
    public LoanTest() {
        this.book = new Book("Il mondo di Sofia", "Jostein Gaarder", 20.50, 1, 1991,
                "Adventure", 9928 );
        this.instance = new Loan(book);
        this.today = LocalDate.now();
    }

    @Test
    public void testGetBorrowedBook() {
        System.out.println("Test per metodo 'getBorrowedBook'");
        Book expResult = new Book("Il mondo di Sofia", "Jostein Gaarder", 20.50, 1, 1991,
                "Adventure", 9928 );
        Book result = instance.getBorrowedBook();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetIssueDate() {
        System.out.println("Test per metodo 'getIssueDate'");
        LocalDate expResult = LocalDate.now();
        LocalDate result = instance.getIssueDate();
        assertEquals(this.today, result);
    }

    @Test
    public void testGetDueDate() {
        System.out.println("Test per metodo 'getDueDate'");
        LocalDate expResult = today.plusDays(30);
        LocalDate result = instance.getDueDate();
        assertEquals(expResult, result);
    }

    @Test
    public void testIncreaseLoanDays() {
        System.out.println("Test per metodo 'increaseLoanDays'");       
        instance.increaseLoanDays(8);
        LocalDate expResult = today.plusDays(38);
        LocalDate result = instance.getDueDate();
        assertEquals(expResult, result);        
    }
    
    @Test
    public void testEquals() {
        System.out.println("Test per metodo 'equals'");
        Object obj = this.instance;
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }  
    
    @Test
    public void testNotEquals() {
        System.out.println("Test per metodo 'equals'");
        Object obj = this.today.plusDays(3);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
}
