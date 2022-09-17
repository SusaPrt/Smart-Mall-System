/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration;

import Model.administration.payment.Payment;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Mars_DB
 */
public class Administration {
    private Archive personArchive;
    private HashSet<Payment> payments;
    
    public Administration(){
        this.payments = new HashSet();
        this.personArchive = new Archive(this);
    }
    
    public void addPayment(Payment p){
        this.payments.add(p);
    }
    
    public void removePayment(Payment p){
        this.payments.remove(p);
    }
    public Set<Payment> getPaymentsByPersonId(int id){
        return this.payments.stream().filter(p -> p.getCustomer().equals(this.personArchive.getById(id)))
                .collect(Collectors.toSet());
    }
    
    public Archive getArchive(){
        return this.personArchive;
    }
}
