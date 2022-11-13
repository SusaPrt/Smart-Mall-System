/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.administration;

import Model.administration.payment.Payment;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import Model.administration.AdministrationInterfaces.IAdministration;

/**
 *
 * @author Marzio
 */
public class Administration implements IAdministration{
    private final Archive personArchive;
    private final HashSet<Payment> payments;
    
    public Administration(){
        this.payments = new HashSet();
        this.personArchive = new Archive();
    }
    
    @Override
    public void addPayment(Payment p){
        this.payments.add(p);
    }
    
    @Override
    public void removePayment(Payment p){
        this.payments.remove(p);
    }
    
    @Override
    public Set<Payment> getPaymentsByPersonId(int id){
        return Administration.defend(payments)
                .stream()
                .filter(p -> p.getCustomer().getId()==id)
                .collect(Collectors.toSet());
    }
    
    @Override
    public Archive getArchive(){
        return this.personArchive;
    }
    
    @Override
    public double getTotalDayEarnings(){
        return Administration.defend(payments)
                .stream()
                .mapToDouble(Payment::getCost)
                .sum();
    }
    
    @Override
    public HashSet<Payment> getPayments(){
        return Administration.defend(payments);
    }
    
    // Metodo statico di lettura
    private static <T> HashSet<T> defend(HashSet<T> set){
        return (HashSet<T>) set.clone();
    }
}
