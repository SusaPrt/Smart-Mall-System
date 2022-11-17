/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model.enterprises.library;

import Model.enterprises.library.classes.Book;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Susanna
 */
public class BookTest {
    private final Book instance;
    
    public BookTest() {
        this.instance = new Book("Il mondo di Sofia", "Jostein Gaarder", 20.50, 1, 1991, "Adventure", 9928 );
    }

    @Test
    public void testGetAuthor() {
        System.out.println("Test per metodo 'getAuthor'");
        String expResult = "Jostein Gaarder";
        String result = instance.getAuthor();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPublishingYear() {
        System.out.println("Test per metodo 'getPublishingYear'");
        int expResult = 1991;
        int result = instance.getPublishingYear();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetGenre() {
        System.out.println("Test per metodo 'getGenre'");
        String expResult = "Adventure";
        String result = instance.getGenre();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetISBN() {
        System.out.println("Test per metodo 'getISBN'");
        int expResult = 9928;
        int result = instance.getISBN();
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals() {
        System.out.println("Test per metodo 'equals'");
        Object obj = new Book("Il mondo di Sofia", "Jostein Gaarder", 20.50, 1, 1991, "Adventure", 9928 );
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNotEquals() {
        System.out.println("Test per metodo 'equals'");
        Object obj = new Book("Il mondo di Sofia", "Jostein Gaarder", 20.50, 1, 1991, "Adventure", 9938 );
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }    
}
