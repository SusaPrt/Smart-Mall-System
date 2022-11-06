/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.enterprises.library;

//@author Susanna

import Model.enterprises.libraryInterfaces.ILoan;
import java.time.LocalDate;
import java.util.Objects;
 
public class Loan implements ILoan {
    private final Book borrowedBook;
    private final LocalDate issueDate;      
    private LocalDate dueDate;        
    
    public Loan(Book book) {
        super();
        this.borrowedBook   = book;
        this.issueDate = LocalDate.now();
        this.dueDate = LocalDate.now().plusDays(30);
    }
    
    public Loan(Book book, LocalDate start, LocalDate due){
        this.borrowedBook = book;
        this.issueDate = start;
        this.dueDate = due;
    }
    
    @Override
    public Book getBorrowedBook() {
        return this.borrowedBook;
    }
   
    @Override
    public LocalDate getIssueDate() {
        return this.issueDate;
    }
    
    @Override
    public LocalDate getDueDate() {
        return this.dueDate;
    }
    
    @Override
    public void increaseLoanDays(int i) {
        this.dueDate = dueDate.plusDays(i);
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
