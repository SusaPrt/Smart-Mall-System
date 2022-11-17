/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.enterprises.library.interfaces;

// @author Susanna

import Model.enterprises.library.classes.Book;
import java.time.LocalDate;

 
public interface ILoan {
    //ritorna il libro di questo prestito
    public Book getBorrowedBook();
    
    //ritorna la data di emissione del prestito
    public LocalDate getIssueDate();
    
    //ritorna la data di scadenza del prestito
    public LocalDate getDueDate();
    
    //permette di incrementare i giorni del prestito di i giorni
    public void increaseLoanDays(int i);
    
}
