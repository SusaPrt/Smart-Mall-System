/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration;

import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Mars_DB
 */
public class Staff extends Person{
   
    public Staff(String name, String password){
        super(name, password);
    }
    
    public Staff(String name, String password, int id){
        super(name, password, id);
    }

    @Override
    public String toString(){
        return "\nName: " + super.getName() + "\nPassword: " + super.getPassword() + "\nId Locker: " + super.getId();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(super.getName());
        hash = 67 * hash + Objects.hashCode(super.getPassword());
        hash = 67 * hash + super.getId();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Staff other = (Staff) obj;
        
        if (!Objects.equals(super.getName(), other.getName())) {
            return false;
        }
        
        if (!Objects.equals(super.getPassword(), other.getPassword())) {
            return false;
        }
        
        if (super.getId() != other.getId()) {
            return false;
        }
        return true;
    }
    
    
}

