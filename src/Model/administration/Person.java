/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration;

import Model.administration.AdministrationInterfaces.PersonInterface;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Mars_DB
 */
public abstract class Person implements PersonInterface{
    private  final String name;
    private  final String password;
    private final int id;
    
    public Person(String name, String password){
        this.name = name;
        this.password = password;
        Random r = new Random();
        this.id = r.nextInt(1000)+101;
    }
    
    public Person(String name, String password, int id){
        this.name = name;
        this.password = password;
        this.id = id;
    }
    
    @Override
    public String getName(){
        return this.name;
    }
    
    @Override
    public String getPassword(){
        return this.password;
    }  
    
    @Override
    public int getId(){
        return this.id;
    }
    @Override
    public String toString(){
        return "\nName: "+this.name+"\nPassword: "+this.password;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.password);
        hash = 79 * hash + this.id;
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
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }    
}

