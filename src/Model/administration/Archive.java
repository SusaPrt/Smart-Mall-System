/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration;


import Model.system.DataInterpreter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;


/**
 *
 * @author Mars_DB
 */
public class Archive {
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
    
    public void addPerson(Person p){        
        if(p instanceof Customer customer)
            this.costumers.add(customer);
        else
            this.staff.add((Staff)p);
        
    }
        
    public boolean autentication(int id, String password){  
        boolean found = false;
        
        if(this.costumers.stream()
                .filter(c -> c.getId()==id && c.getPassword().equals(password))
                .findAny()
                .isPresent()){
        
           found = true;
        }else if(this.staff.stream()
                .filter(c -> c.getId()==id && c.getPassword().equals(password))
                .findAny()
                .isPresent()){
            
           found = true;
        }    
        return found;
    } 
       
    public void removeById(int id){
        String output = null;
        this.remove((Person)this.getById(id));    
    }
    
    private void remove(Person p){        
        if(p instanceof Customer customer)
            this.costumers.remove(customer);
        else
            this.staff.remove((Staff)p);
    }
    
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
    
    private void accountLoader(){
        this.dataInterpreter.getAccounts().stream().forEach((Person p) -> {
            if (p instanceof Staff staff1)
                Archive.this.staff.add(staff1);
            else
                Archive.this.costumers.add((Customer)p);
        });       
    }
    

}
