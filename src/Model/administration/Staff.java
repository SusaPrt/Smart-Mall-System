/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration;

/**
 *
 * @author Mars_DB
 */
public class Staff extends Person{
    private  final int    idLocker;

    
    public Staff(String name, String password){
        super(name, password);
        this.idLocker = (int) (Math.random() * 100);
    }
    
    @Override
    public String getName(){
        return super.getName();
    }
    
    @Override
    public String getPassword(){
        return super.getPassword();
    }
    
    public int getIdLocker(){
        return this.idLocker;
    }
    
     @Override
    public String toString(){
        return "\nName: " + super.getName() + "\nPassword: " + super.getPassword() + "\nId Locker: " + this.idLocker;
    }
}

