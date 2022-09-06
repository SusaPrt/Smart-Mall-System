/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration;

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
}

