/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model.system;

import Model.administration.Administration;
import Model.administration.Customer;
import Model.administration.Item;
import Model.administration.Person;
import Model.administration.Staff;
import Model.enterprises.library.Book;
import Model.enterprises.restaurant.Course;
import Model.enterprises.restaurant.Dish;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marzio
 */
public class DataInterpreterTest {
    private final DataInterpreter libraryDataInterpreter;
    private final DataInterpreter shopDataInterpreter;
    private final DataInterpreter restourantDataInterpreter;
    private final DataInterpreter archiveDataInterpreter;
    private final Administration aD;
    
    
    public DataInterpreterTest() throws FileNotFoundException {
        this.aD = new Administration();
        this.archiveDataInterpreter = new DataInterpreter(new File("./src/Model/system/DataFolder/Account.txt")
                                                , "Archive");
        this.libraryDataInterpreter = new DataInterpreter(new File("./src/Model/system/DataFolder/Library.txt")
                                                ,"Library");
        this.shopDataInterpreter = new DataInterpreter(new File("./src/Model/system/DataFolder/Shop.txt")
                                                ,"Shop");
        this.restourantDataInterpreter = new DataInterpreter(new File("./src/Model/system/DataFolder/Menu.txt")
                                                ,"Restaurant");
    }

    
    @Test
    public void testGetLibraryData() {
        System.out.println("Test relativo a libreria per metodo 'getData'");
        LinkedList expResult = new LinkedList();
        //String name,  String author, double price, int quantity, int year, String genre, int isbn
        expResult.add(new Book("YYYYY","XXXX",4,283,1989,"Adventure",34524));//1
        expResult.add(new Book("YYYYYY","XXXXX",5,623,1993,"Adventure",34566));//2
        expResult.add(new Book("YYY","XXXXX",5,837,2009,"Adventure",7896));//3
        expResult.add(new Book("YYYYYYY","XXXXX",7,625,2010,"Adventure",745));//4
        
        expResult.add(new Book("YYYYY","XXXXXX",2,872,2009,"Classics",123445));//5
        expResult.add(new Book("YYY","XXXXX",9,615,1993,"Classics",378123));//6
        expResult.add(new Book("YYYYYYY","XXXX",8,102,1999,"Classics",93847));//7
        expResult.add(new Book("YYYYYY","XXXXX",7,61,2010,"Classics",94576));//8
        
        expResult.add(new Book("YYYYY","XXXXX",23,827,1979,"Comic",8355));//9
        expResult.add(new Book("YYYYYY","XXXXX",9,201,2010,"Comic",93745));//10
        expResult.add(new Book("YYYYYY","XXXXXX",27,817,2017,"Comic",28475));//11
        expResult.add(new Book("YYYYYYY","XXXXXX",6,72,2009,"Comic",38485));//12
               
        LinkedList result = libraryDataInterpreter.getData().getFirst();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetShopData() {
        System.out.println("Test relativo a shop per metodo 'getData'");
        LinkedList<LinkedList> expResult = new LinkedList();
        expResult.add(new LinkedList());
        //String name, double price, int quantity
        expResult.get(0).add(new Item("YYYYYY", 10, 129));
        expResult.get(0).add(new Item("YYYY", 9, 372));
        expResult.get(0).add(new Item("YYYYYY", 11, 281));
        expResult.get(0).add(new Item("YYYYYYY", 19, 829));
        expResult.get(0).add(new Item("YYYYY", 51, 271));
        LinkedList<LinkedList> result = shopDataInterpreter.getData();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetRestourantData() {
        System.out.println("Test relativo a restaurant per metodo 'getData'");
        LinkedList<LinkedList> expResult = new LinkedList();
        expResult.add(new LinkedList());
        //String name, double price, int quantity, String description
        expResult.get(0).add(new Dish("YYYYY",4,625, Course.selectType("FIRSTS")));
        expResult.get(0).add(new Dish("YYYYYYY",3,253, Course.selectType("FIRSTS")));
        expResult.get(0).add(new Dish("YYYY",4,485, Course.selectType("FIRSTS")));
        
        expResult.add(new LinkedList());
        expResult.get(1).add(new Dish("YYYYYYYYY",5,720, Course.selectType("SECONDS")));
        expResult.get(1).add(new Dish("YYYYYY",12,312, Course.selectType("SECONDS")));
        
        expResult.add(new LinkedList());
        expResult.get(2).add(new Dish("YYYYYYYY",7,182, Course.selectType("DESSERTS")));
        expResult.get(2).add(new Dish("YYYYY",8,109, Course.selectType("DESSERTS")));
        
        expResult.add(new LinkedList());
        expResult.get(3).add(new Dish("YYYY",4,102, Course.selectType("WINESANDSOFT")));
        expResult.get(3).add(new Dish("YYYYY",8,182, Course.selectType("WINESANDSOFT")));
        expResult.get(3).add(new Dish("YYYYYY",2,625, Course.selectType("WINESANDSOFT")));
        
        
        LinkedList<LinkedList> result = restourantDataInterpreter.getData();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetAccounts() {
        System.out.println("Test per metodo 'getAccounts'");
        LinkedList<Person> expResult = new LinkedList();
        expResult.add(new Staff("Marzio", "1111", 12345));            
        expResult.add(new Staff("Susanna", "2222", 53421));
        expResult.add(new Customer("Simone", "3333", 300.5, 12543));
        LinkedList<Person> result = archiveDataInterpreter.getAccounts();
        assertEquals(expResult, result);
    }   
}
