/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration;

import java.util.Objects;

/**
 *
 * @author Mars_DB
 */
public class Person {
    private  final String name;
    private  final String password;
    
    public Person(String n, String p){
        this.name = n;
        this.password = p;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getPassword(){
        return this.password;
    }    
    @Override
    public String toString(){
        return "\nName: "+this.name+"\nPassword: "+this.password;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.password);
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
        final Person other = (Person) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }
    
}

