/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.administration.AdministrationInterfaces;

import Model.administration.Customer;
import Model.administration.Person;
import Model.administration.Staff;
import Model.system.DataInterpreter;
import java.util.HashSet;

/**
 *
 * @author Marzio
 */
public interface IArchive {
    
    public void addPerson(Person p);
    
    public boolean autentication(String name, String password);
    
    public Person getAccount(String name, String pwd);
    
    public void removeById(int id);
    
    public Object getById(int id);
    
    public HashSet<Staff> getStaff();
    
    public HashSet<Customer> getCustomers();
    
    public DataInterpreter getDataInterpreter();
}
