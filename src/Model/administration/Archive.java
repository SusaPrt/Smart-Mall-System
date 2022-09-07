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
    private HashSet<Person> persons;
    
    public Archive(){
        this.staff = new HashSet();
        this.costumers = new HashSet();
        this.persons = new HashSet();
    }
    
    public void addPerson(Person p){
        this.persons.add(p);
        
        if(p instanceof Customer customer)
            this.costumers.add(customer);
        else if(p instanceof Staff staff1)
            this.staff.add(staff1);
    }
    
    public void remove(Person p){
        this.persons.remove(p);
        
        if(p instanceof Customer customer)
            this.costumers.remove(customer);
        else if(p instanceof Staff staff1)
            this.staff.remove(staff1);
    }
    
    public boolean autentication(String name, String password){
        
        return this.persons.contains(this.persons.stream()
                .filter(p -> p.getName()
                .equals(name) && p.getPassword().equals(password))
                .findAny()
                .get());
    } 
}
