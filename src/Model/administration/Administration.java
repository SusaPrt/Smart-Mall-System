/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration;

import Model.administration.payment.Payment;
import java.util.HashSet;
import Model.administration.AdministrationInterfaces.IAdministration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author Marzio
 */
public class Administration implements IAdministration{
    private final Archive personArchive;
    private HashMap<Customer, LinkedList<Payment>> payments;
    
    public Administration(){
        this.payments = new HashMap<Customer, LinkedList<Payment>>();
        this.personArchive = new Archive();
    }
    
    @Override
    public void addPayment(Payment p){
        
        if(!this.payments.containsKey(p.getCustomer())){
            this.payments.put(p.getCustomer(), new LinkedList<Payment>());
        }
        
        this.payments.get(p.getCustomer()).add(p);
    }
    
    //  REVIEW
    @Override
    public LinkedList<Payment> getPaymentsByPerson(Customer c){
        return this.payments.get(c);
    }
    
    @Override
    public Archive getArchive(){
        return this.personArchive;
    }
    
    @Override
    public double getTotalDayEarnings(){
        LinkedList<Payment> earnings = new LinkedList();
        Administration.mapDefend(this.payments)
                .values().forEach(l -> l.stream().forEach(p -> earnings.addFirst(p)));
        return earnings.stream().mapToDouble(Payment::getCost).sum();
    }
    
    @Override
    public Map<Customer, LinkedList<Payment>> getPayments(){
        return Administration.mapDefend(this.payments);
    }
    
    // Metodi statico di lettura
    private static <T> HashSet<T> setDefend(HashSet<T> set){
        return (HashSet<T>) set.clone();
    }
    
    private static <T, V> Map<T, V> mapDefend(HashMap<T, V> set){
        return (HashMap<T, V>) set.clone();
    }
}
