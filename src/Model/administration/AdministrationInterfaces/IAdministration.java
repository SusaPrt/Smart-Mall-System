/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.administration.AdministrationInterfaces;

import Model.administration.Archive;
import Model.administration.payment.Payment;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Marzio
 */
public interface IAdministration {
    
    public void addPayment(Payment p);
    
    public void removePayment(Payment p);
    
    public Set<Payment> getPaymentsByPersonId(int id);
    
    public Archive getArchive();
    
    public double getTotalDayEarnings();
    
    public HashSet<Payment> getPayments();
}
