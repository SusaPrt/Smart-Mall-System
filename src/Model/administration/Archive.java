/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration;


import Model.administration.AdministrationInterfaces.ArchiveInterface;
import Model.system.DataInterpreter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;


/**
 *
 * @author Mars_DB
 */
public class Archive implements ArchiveInterface{
    private HashSet<Staff> staff;
    private HashSet<Customer> costumers;
    private DataInterpreter dataInterpreter;
    
    public Archive(Administration aD){
        this.staff = new HashSet();
        this.costumers = new HashSet();
        try {
            this.dataInterpreter = 
                    new DataInterpreter(new File("./src/Model/system/DataFolder/Account.txt")
                                                , "Archive", aD);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        this.accountLoader();
    }
    
    @Override
    public void addPerson(Person p){        
        if(p instanceof Customer customer)
            this.costumers.add(customer);
        else
            this.staff.add((Staff)p);
        
    }
        
    @Override
    public boolean autentication(String name, String password){  
        boolean found = false;
        
        if(this.costumers.stream()
                .filter(c -> c.getName().equals(name) && c.getPassword().equals(password))
                .findAny()
                .isPresent()){
        
           found = true;
        }else if(this.staff.stream()
                .filter(c -> c.getName().equals(name) && c.getPassword().equals(password))
                .findAny()
                .isPresent()){
            
           found = true;
        }    
        return found;
    } 
       
    @Override
    public void removeById(int id){
        this.remove((Person)this.getById(id));    
    }
    
    @Override
    public Object getById(int id){
        Object person = null;        
        if(this.costumers.stream()
                .filter(c -> c.getId()==id)
                .findAny()
                .isPresent()){
        
            person = this.costumers.stream()
                                    .filter(c -> c.getId()==id)
                                    .findAny()
                                    .get();
        }else if(this.staff.stream()
                .filter(c -> c.getId()==id)
                .findAny()
                .isPresent()){
            
            person = this.staff.stream()
                                .filter(c -> c.getId()==id)
                                .findAny()
                                .get();
        }        
        return person;
    }
    
    @Override
    public HashSet<Staff> getStaff(){
        return Archive.defend(this.staff);
    }
    
    @Override
    public HashSet<Customer> getCustomers(){
        return Archive.defend(this.costumers);
    }
    
    @Override
    public Person getAccount(String name, String pwd){
        Person p = null;
        if(this.costumers.stream()
                .filter(c -> c.getName().equals(name) && c.getPassword().equals(pwd))
                .findAny()
                .isPresent()){
        
            p = this.costumers.stream()
                    .filter(c -> c.getName().equals(name) && c.getPassword().equals(pwd))
                    .findAny()
                    .get();
        }else if(this.staff.stream()
                .filter(c -> c.getName().equals(name) && c.getPassword().equals(pwd))
                .findAny()
                .isPresent()){
            
            p = this.staff.stream()
                                .filter(c -> c.getName().equals(name) && c.getPassword().equals(pwd))
                                .findAny()
                                .get();
        }       
        return p;
    }
    
    private void accountLoader(){
        this.dataInterpreter.getAccounts().stream().forEach((Person p) -> {
            if (p instanceof Staff staff1)
                Archive.this.staff.add(staff1);
            else
                Archive.this.costumers.add((Customer)p);
        });       
    }
    
    private void remove(Person p){        
        if(p instanceof Customer customer)
            this.costumers.remove(customer);
        else
            this.staff.remove((Staff)p);
    }
    
    
    private static <T> HashSet<T> defend(HashSet<T> set){
        return (HashSet<T>) set.clone();
    }
}
