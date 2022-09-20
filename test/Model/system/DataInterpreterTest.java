/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model.system;

import Model.administration.Administration;
import Model.administration.Customer;
import Model.administration.Person;
import Model.administration.Staff;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mars_DB
 */
public class DataInterpreterTest {
    private final DataInterpreter LibraryDataInterpreter;
    private final DataInterpreter ShopDataInterpreter;
    private final DataInterpreter RestourantDataInterpreter;
    private final DataInterpreter ArchiveDataInterpreter;
    private final Administration aD;
    
    
    public DataInterpreterTest() throws FileNotFoundException {
        this.aD = new Administration();
        this.ArchiveDataInterpreter = new DataInterpreter(new File("./src/Model/system/DataFolder/Account.txt")
                                                , "Archive", aD);
        this.LibraryDataInterpreter = new DataInterpreter(new File("./src/Model/system/DataFolder/Library.txt")
                                                ,"Library");
        this.ShopDataInterpreter = new DataInterpreter(new File("./src/Model/system/DataFolder/Shop.txt")
                                                ,"Shop");
        this.RestourantDataInterpreter = new DataInterpreter(new File("./src/Model/system/DataFolder/Menu.txt")
                                                ,"Restourant");
    }
/*
    @Test
    public void testGetLibraryData() {
        System.out.println("getData");
        LinkedList<LinkedList> expResult = null;
        LinkedList<LinkedList> result = LibraryDataInterpreter.getData();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetShopData() {
        System.out.println("getData");
        LinkedList<LinkedList> expResult = null;
        LinkedList<LinkedList> result = ShopDataInterpreter.getData();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetRestourantData() {
        System.out.println("getData");
        LinkedList<LinkedList> expResult = null;
        LinkedList<LinkedList> result = RestourantDataInterpreter.getData();
        assertEquals(expResult, result);
    }
    */
    @Test
    public void testGetAccounts() {
        System.out.println("getAccounts");
        LinkedList<Person> expResult = new LinkedList();
        expResult.add(new Staff("Marzio", "1111", 12345));            
        expResult.add(new Staff("Susanna", "2222", 54321));
        expResult.add(new Customer("Simone", "3333", 300.50, 12543, aD));
        
        LinkedList<Person> result = ArchiveDataInterpreter.getAccounts();
        assertEquals(expResult, result);
    }    
}
