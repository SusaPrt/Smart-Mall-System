/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model.system;

import Model.administration.Archive;
import Model.administration.Customer;
import Model.administration.Item;
import Model.administration.Person;
import Model.administration.Staff;
import Model.enterprises.library.classes.Book;
import Model.enterprises.library.classes.Library;
import Model.enterprises.library.classes.Loan;
import Model.enterprises.restaurant.classes.Course;
import Model.enterprises.restaurant.classes.Dish;
import Model.enterprises.restaurant.classes.Restaurant;
import Model.enterprises.shop.classes.Shop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marzio
 */
public class DataWriterTest {
    
    public DataWriterTest() throws FileNotFoundException {}

    @Test
    public void testAddItem() throws IOException {
        System.out.println("Test relativo a shop del metodo 'addItem'");
        
        Shop shop = new Shop();       
        Item i = new Item("Monitor", 150.5, 1);
        shop.addItem("Monitor", 150, 1);
        shop.saveData();
        boolean expResult = true;      
        //simulo la chiusura e la riaccensione del sistema cosi che il DataReader legge i dati precedentemente salvati
        DataInterpreter ShopDataInterpreter = new DataInterpreter(new File("./src/Model/system/DataFolder/Shop.txt")
                                                ,"Shop");
        
        LinkedList<LinkedList> data = ShopDataInterpreter.getData();
        boolean result = data.get(0).contains(i);
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAddBook() throws IOException{
        System.out.println("Test relativo alla libreria del metodo 'addItem'");
        
        Library library = new Library();
        Book b = new Book("Il mondo di Sofia", "Jostein Gaarder", 20.50, 1, 1991, "Adventure", 9928 );
        library.addBook("Il mondo di Sofia", "Jostein Gaarder", 20.50, 1, 1991, "Adventure", 9928);
        library.saveData();
        boolean expResult = true;

        //simulo la chiusura e la riaccensione del sistema cosi che il DataReader legge i dati precedentemente salvati
        DataInterpreter LibraryDataInterpreter = new DataInterpreter(new File("./src/Model/system/DataFolder/Library.txt")
                                                ,"Library");
        LinkedList<LinkedList> data = LibraryDataInterpreter.getData();
        boolean result = data.get(0).contains(b);
        assertEquals(expResult, result);        
    }
    
    @Test
    public void testAddLoan() throws IOException{
        System.out.println("Test relativo alla libreria del metodo 'addLoan'");
        
        Library library = new Library();
        Book b = new Book("Il mondo di Sofia", "Jostein Gaarder", 20.50, 1, 1991, "Adventure", 9928 );
        library.addBook("Il mondo di Sofia", "Jostein Gaarder", 20.50, 1, 1991, "Adventure", 9928);
        Loan l = new Loan(b);
        Customer c = new Customer("Simone", "3333", 300.5, 12543);
        library.createLoan(c, b);
        library.saveData();
        boolean expResult = true;

        //simulo la chiusura e la riaccensione del sistema cosi che il DataReader legge i dati precedentemente salvati
        Library library2 = new Library();
        boolean result = library2.getAllLoans().get(c).contains(l);
        assertEquals(expResult, result);        
    }
    
    @Test 
    public void testAddDish() throws IOException{
        System.out.println("Test relativo al ristorante del metodo 'addItem'");
        
        Restaurant restaurant = new Restaurant(200);      
        Dish d = new Dish("Cannelloni alla besciamella", 12.5, 100, Course.selectType("FIRSTS"));
        restaurant.getMenu().addDish("Cannelloni alla besciamella", 12.5, 100, Course.FIRSTS);
        restaurant.saveData();
        boolean expResult = true;
        
        //simulo la chiusura e la riaccensione del sistema cosi che il DataReader legge i dati precedentemente salvati
        DataInterpreter RestourantDataInterpreter = new DataInterpreter(new File("./src/Model/system/DataFolder/Menu.txt")
                                                ,"Restaurant");
        LinkedList<LinkedList> data = RestourantDataInterpreter.getData();
        boolean result = data.get(0).contains(d);
        assertEquals(expResult, result);      
    }

    @Test
    public void testAddPerson() throws IOException {
        System.out.println("Test relativo all'archivio del metodo 'addPerson'");
        Archive a = new Archive();        
        Staff p = new Staff("Giorgio", "123456", 9090);
        a.addPerson(p);
        boolean expResult = true;
        a.saveData();

        //simulo la chiusura e la riaccensione del sistema cosi che il DataReader legge i dati precedentemente salvati
        DataInterpreter ArchiveDataInterpreter = new DataInterpreter(new File("./src/Model/system/DataFolder/Account.txt")
                                                , "Archive");
        LinkedList<Person> data = ArchiveDataInterpreter.getAccounts();
        boolean result = data.contains(p);
        
        assertEquals(expResult, result);
    }
}
