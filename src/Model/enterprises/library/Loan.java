/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.enterprises.library;

//@author Susanna

import java.util.Calendar;
 
public class Loan {
    private final Book borrowedBook;
    private final Calendar issueDate;   //data di emissione prestito
    private Calendar dueDate;               //scadenza prestito
    
    public Loan(Book book) {
        super();
        this.borrowedBook   = book;
        
        Calendar calendar    = Calendar.getInstance();
        this.issueDate      = calendar;
        
        calendar.add(Calendar.DATE, 30);
        this.dueDate        = calendar;
    }
    
    public Book getBorrowedBook() {
        return this.borrowedBook;
    }
    public Calendar getIssueDate() {
        return this.issueDate;
    }
    
    public Calendar getDueDate() {
        return this.dueDate;
    }
    public void increaseLoanDays(int i) {
        this.dueDate.add(Calendar.DATE, i);
    }
    
}
