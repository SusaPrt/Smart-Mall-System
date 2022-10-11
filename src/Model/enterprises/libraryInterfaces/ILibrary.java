/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.enterprises.libraryInterfaces;

//@author Susanna

import Model.administration.Customer;
import Model.enterprises.library.Book;
import Model.enterprises.library.Loan;
import java.util.List;
import java.util.Map;
import java.util.Set;


public interface ILibrary {
    //ritorna il nome della libreria
    public String getName();
    
    //ritorna la lisra dei libri disponibili
    public List<Book> getAllBooks();
    
    //ritorna tutti i prestiti effettuati
    public Map<Customer, Set<Loan>> getAllLoans();
    
    //aggiunge un libro al magazzino
    public void addBook(String name,  String author, double price, int quantity, int year, String genre, int isbn);
    
    //rimuove un libro dal magazzino
    public void removeBook(Book b);
    
    //crea un prestito
    public void createLoan(Customer customer, Book book);
    
    //cancella un prestito
    public void cancelLoan(Customer customer, Book book);
    
    //cerca libri tramite titolo
    public Set<Book> searchBookByTitle(String title);
    
    //cerca libri tramite genere
    public Set<Book> searchBookByGenre(String genre);
    
    //cerca libri tramite autore
    public Set<Book> searchBookByAuthor(String author);
    
    //ritorna tutti i prestiti effettuati dal cliente customer
    public Set<Loan> getCustomerLoans(Customer customer);
    
    //rifornisce di n quantità il libro indicato, ritorna il risultato dell'operazione
    public boolean refueling(Book b, int n);
}
