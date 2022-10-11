/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.enterprises.libraryInterfaces;

// @author Susanna

import Model.enterprises.library.Book;
import java.util.Calendar;

 
public interface ILoan {
    //ritorna il libro di questo prestito
    public Book getBorrowedBook();
    
    //ritorna la data di emissione del prestito
    public Calendar getIssueDate();
    
    //ritorna la data di scadenza del prestito
    public Calendar getDueDate();
    
    //permette di incrementare i giorni del prestito di i giorni
    public void increaseLoanDays(int i);
    
}
