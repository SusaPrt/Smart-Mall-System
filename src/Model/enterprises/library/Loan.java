/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.enterprises.library;

//@author Susanna

import Model.enterprises.libraryInterfaces.ILoan;
import java.util.Calendar;
import java.util.Objects;
 
public class Loan implements ILoan {
    private final Book borrowedBook;
    private final Calendar issueDate;      
    private final Calendar dueDate;        
    
    public Loan(Book book) {
        super();
        this.borrowedBook   = book;
        
        Calendar calendar   = Calendar.getInstance();
        this.issueDate      = calendar;
        
        calendar.add(Calendar.DATE, 30);
        this.dueDate        = calendar;
    }
    
    @Override
    public Book getBorrowedBook() {
        return this.borrowedBook;
    }
   
    @Override
    public Calendar getIssueDate() {
        return this.issueDate;
    }
    
    @Override
    public Calendar getDueDate() {
        return this.dueDate;
    }
    
    @Override
    public void increaseLoanDays(int i) {
        this.dueDate.add(Calendar.DATE, i);
    }

    @Override
    public int hashCode() {
        final int hash = 31;
        int result = 1;
        result = result * hash + Objects.hashCode(this.borrowedBook);
        result = result * hash + Objects.hashCode(this.issueDate);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Loan other = (Loan) obj;
        if (!Objects.equals(this.borrowedBook, other.borrowedBook)) {
            return false;
        }
        return Objects.equals(this.issueDate, other.issueDate);
    }

    @Override
    public String toString() {
        return "\nBorrowed book: " + borrowedBook + "\nIssue Date: " + issueDate + "\nDue Date: " + dueDate;
    }
    
    
}
