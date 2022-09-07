/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration;

import java.util.HashSet;

/**
 *
 * @author Mars_DB
 */
public class Archive {
    private HashSet<Staff> staff;
    private HashSet<Customer> costumers;
    
    public Archive(){
        this.staff = new HashSet();
        this.costumers = new HashSet();
    }
    
    public <T> void addPerson(T p){        
        if(p instanceof Customer)
            this.costumers.add((Customer)p);
        else
            this.staff.add((Staff)p);
    }
        
    public boolean autentication(int id, String password){  
        boolean found = false;
        if(this.costumers.stream()
                .filter(c -> c.getIdLocker()==id && c.getPassword().equals(password))
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
        this.remove(this.getById(id));        
    }
    
    private <T> void remove(T p){        
        if(p instanceof Customer)
            this.costumers.remove((Customer)p);
        else
            this.staff.remove((Staff)p);
    }
    
    private Object getById(int id){
        Object person = null;        
        if(this.costumers.stream()
                .filter(c -> c.getIdLocker()==id)
                .findAny()
                .isPresent()){
        
            person = this.costumers.stream()
                                    .filter(c -> c.getIdLocker()==id)
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
}
