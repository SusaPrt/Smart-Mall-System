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
    //private final HashSet<Payment> payments;
    private HashMap<Integer, LinkedList<Payment>> payments;
    
    public Administration(){
        this.payments = new HashMap<Integer, LinkedList<Payment>>();
        this.personArchive = new Archive();
    }
    
    @Override
    public void addPayment(Payment p){
        Customer c = (Customer) this.personArchive.getById(p.getCustomerId());
        if(!this.payments.containsKey(p.getCustomerId())){
            this.payments.put(p.getCustomerId(), new LinkedList<Payment>());
        }
        
        this.payments.get(p.getCustomerId()).add(p);
    }
    
    @Override
    public void removePayment(Payment p){
        this.payments.remove(p);
    }
    
    //  REVIEW
    @Override
    public LinkedList<Payment> getPaymentsByPersonId(int id){
    //    LinkedList<Payment> ps = new LinkedList();
    /*    this.payments.keySet().stream()
                .forEach(s -> this.payments.get(id).stream()
                        .filter(p -> p.getCustomerId() == id)
                        .forEach(p -> ps.addFirst(p)));
    */
        return this.payments.get(id);
        /*return Administration.defend(payments)
                .stream()
                .filter(p -> p.getId() == id)
                .collect(Collectors.toSet());*/
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
                /*
                .stream()
                .mapToDouble(Payment::getCost)
                .sum();*/
                
        return earnings.stream().mapToDouble(Payment::getCost).sum();
    }
    
    @Override
    public Map<Integer, LinkedList<Payment>> getPayments(){
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
