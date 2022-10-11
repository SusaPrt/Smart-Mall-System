/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model.system;

import Model.administration.Administration;
import Model.administration.Item;
import Model.administration.Person;
import Model.administration.Staff;
import Model.enterprises.library.Book;
import Model.enterprises.restaurant.Course;
import Model.enterprises.restaurant.Dish;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mars_DB
 */
public class DataWriterTest {
    private final DataInterpreter ShopDataInterpreter;
    private final DataInterpreter ArchiveDataInterpreter;
    private final DataInterpreter LibraryDataInterpreter;
    private final DataInterpreter RestourantDataInterpreter;
    private final Administration aD;
    
    public DataWriterTest() throws FileNotFoundException {
        this.aD = new Administration();
        this.ArchiveDataInterpreter = new DataInterpreter(new File("./src/Model/system/DataFolder/Account.txt")
                                                , "Archive", aD);
        this.ShopDataInterpreter = new DataInterpreter(new File("./src/Model/system/DataFolder/Shop.txt")
                                                ,"Shop");
        this.LibraryDataInterpreter = new DataInterpreter(new File("./src/Model/system/DataFolder/Library.txt")
                                                ,"Library");
        this.RestourantDataInterpreter = new DataInterpreter(new File("./src/Model/system/DataFolder/Menu.txt")
                                                ,"Restourant");
    }

    @Test
    public void testAddItem() throws IOException {
        System.out.println("Test relativo a shop del metodo 'addItem'");
        Item i = new Item("Monitor", 150.5, 1);
        boolean expResult = true;      
        this.ShopDataInterpreter.getDataWriter().addItem(i);
        this.ShopDataInterpreter.getDataWriter().writeOnFile();
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
        Book b = new Book("Il mondo di Sofia", "Jostein Gaarder", 20.50, 1, 1991, "Adventure", 9928 );
        boolean expResult = true;
        this.LibraryDataInterpreter.getDataWriter().addItem(b);
        this.LibraryDataInterpreter.getDataWriter().writeOnFile();
        //simulo la chiusura e la riaccensione del sistema cosi che il DataReader legge i dati precedentemente salvati
        DataInterpreter LibraryDataInterpreter = new DataInterpreter(new File("./src/Model/system/DataFolder/Library.txt")
                                                ,"Library");
        LinkedList<LinkedList> data = LibraryDataInterpreter.getData();
        boolean result = data.get(0).contains(b);
        assertEquals(expResult, result);
        
    }
    
    @Test 
    public void testAddDish() throws IOException{
        System.out.println("Test relativo al ristorante del metodo 'addItem'");
        Dish d = new Dish("Cannelloni alla besciamella", 12.5, 100, Course.selectType("FIRSTS"));
        boolean expResult = true;
        System.out.println(d.getCourse().toString());
        this.RestourantDataInterpreter.getDataWriter().addItem(d);
        this.RestourantDataInterpreter.getDataWriter().writeOnFile();
        //simulo la chiusura e la riaccensione del sistema cosi che il DataReader legge i dati precedentemente salvati
        DataInterpreter RestourantDataInterpreter = new DataInterpreter(new File("./src/Model/system/DataFolder/Menu.txt")
                                                ,"Restourant");
        LinkedList<LinkedList> data = RestourantDataInterpreter.getData();
        boolean result = data.get(0).contains(d);
        assertEquals(expResult, result);      
    }

    @Test
    public void testAddPerson() throws IOException {
        System.out.println("Test relativo all'archivio del metodo 'addPerson'");
        Staff p = new Staff("Giorgio", "123456", 9090);
        boolean expResult = true;
        this.ArchiveDataInterpreter.getDataWriter().addPerson(p);
        this.ArchiveDataInterpreter.getDataWriter().writeOnFile();
        //simulo la chiusura e la riaccensione del sistema cosi che il DataReader legge i dati precedentemente salvati
        DataInterpreter ArchiveDataInterpreter = new DataInterpreter(new File("./src/Model/system/DataFolder/Account.txt")
                                                , "Archive", aD);
        LinkedList<Person> data = ArchiveDataInterpreter.getAccounts();
        boolean result = data.contains(p);
        
        assertEquals(expResult, result);
    }     
}
