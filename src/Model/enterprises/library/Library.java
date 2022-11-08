/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.enterprises.library;

//@author Susanna

import Model.administration.Administration;
import Model.administration.Archive;
import Model.administration.Customer;
import Model.enterprises.libraryInterfaces.ILibrary;
import Model.system.DataInterpreter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


public class Library implements ILibrary {
    private final String name;
    private LinkedList<Book> booksList;
    private Map<Customer, Set<Loan>> loansList; 
    private DataInterpreter dataInt;
    private final Archive archive;
    
        
    public Library(Administration ad){
        super();
        this.name = "Library";        
        this.loansList = new HashMap();
        try {
            this.dataInt = new DataInterpreter(new File("./src/Model/system/DataFolder/Library.txt"), "Library");
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        this.booksList = this.dataInt.getData().getFirst();
        this.archive = ad.getArchive();
        this.loansLoader();
    }
    
    public Library(String name, Administration ad) throws IOException{
        super();
        this.name = name;        
        this.loansList = new HashMap();
        this.archive = ad.getArchive();
        this.fileChecker();
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public List<Book> getAllBooks() {
        return this.booksList.stream().filter(b -> b.getQuantity() > 0).collect(Collectors.toList());
    }
    
    @Override
    public Set<Book> searchBookByTitle(String title) {
        return this.booksList.stream().filter(b -> b.getName().contains(title)).collect(Collectors.toSet());
    }
    
    @Override
    public Set<Book> searchBookByGenre(String genre) {
        return this.booksList.stream().filter(b -> b.getGenre().contains(genre)).collect(Collectors.toSet());
    }
    
    @Override
    public Set<Book> searchBookByAuthor(String author) {
        return this.booksList.stream().filter(b -> b.getAuthor().contains(author)).collect(Collectors.toSet());
    }
    @Override
    public Set<Loan> getCustomerLoans(Customer customer) {
        return this.loansList.get(customer);
    }
    
    @Override
    public Map<Customer, Set<Loan>> getAllLoans() {
        return this.loansList;
    }
    
    @Override
    public boolean addBook(String name,  String author, double price, int quantity, int year, String genre, int isbn) {
        boolean done = false;
        if(!(this.checkISBN(isbn))){
            this.booksList.add(new Book(name, author, price, quantity, year, genre, isbn));  
            done = true;
        }
        return done;
    }
    
    @Override
    public boolean removeBook(Book b) {
        boolean done = false;
        if(this.checkISBN(b.getISBN())) {
            this.booksList.remove(b);
            done = true;
        }
        return done;
    }
    
    @Override
    public boolean createLoan(Customer customer, Book book) {
        boolean done = false;
        if(book.getQuantity() > 0){
            if(!this.loansList.containsKey(customer))
                this.loansList.put(customer, new HashSet<>());
            book.decreaseQuantity(1);
            done = true;
            this.loansList.get(customer).add(new Loan(book));
        }
        return done;
    }
    
    @Override
    public boolean cancelLoan(Customer customer, Book book) {
        boolean done = false;
        Loan work = this.loansList.get(customer).stream().filter(l -> l.getBorrowedBook().equals(book)).findFirst().get();
        if(!(work == null)) {
            this.loansList.get(customer).remove(work);
            book.increaseQuantity(1);
            if(this.loansList.get(customer).isEmpty())
                this.loansList.keySet().remove(customer);
            done = true;
        }
        return done;
    }
    
    @Override
    public boolean refueling(Book b, int n) {
        boolean done = false;
        if(this.checkISBN(b.getISBN())) {
            b.increaseQuantity(n);
            done = true;
        }
        if(!done)
            System.out.println("Error: book not registered");
        return done;
    }

    public boolean buyABook(Book b, int i, Customer c) {
        boolean done = false;
        if(b.getQuantity() >= i) {
            if ((c.getCredit() - b.getPrice()) >= 0) {
                b.decreaseQuantity(i);
                c.getCart().addItem(b);
                done = true;
            } else
                System.out.println("Error: insufficient credit ");
        } else
            System.out.println("Error: books not enough"); 
        return done;
    }
    
    private boolean checkISBN(int isbn) {
        return this.booksList.stream().anyMatch(b -> isbn == b.getISBN());
    }

    
    private void fileChecker() throws IOException{
        try{
        this.dataInt = new DataInterpreter(new File("./src/Model/system/DataFolder/" + name + ".txt"), "Library"); 
        this.loansLoader();
        }catch(FileNotFoundException fNf){
            File f = new File("./src/Model/system/DataFolder/" + name + ".txt");
            f.createNewFile();
            FileWriter fw = new FileWriter(f, true);
            fw.write("#Adventure\n");
            fw.write("#Classics\n");
            fw.write("#Comic\n");
            fw.write("#Loan\n");
            this.dataInt = new DataInterpreter(f, "Library");
        }finally{
            this.booksList = dataInt.getData().getFirst();          
        }
    }
    
    @Override
    public int hashCode() {
        final int hash = 31;
        int result = 1;
        result = result * hash + Objects.hashCode(this.name);
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
        final Library other = (Library) obj;
        return this.getName().equals(other.getName());
    }

    @Override
    public String toString() {
        return "Library: " + this.name;
    }   

    private void loansLoader() {
        Customer c;
        Book b;
        Loan l;
        LocalDate start, due;
        
        for(String[] s: (LinkedList<String[]>)this.dataInt.getData().get(1)){
            c = (Customer) this.archive.getById(Integer.parseInt(s[0]));
            b = this.booksList.stream().filter(bo -> bo.getISBN() == Integer.parseInt(s[1])).findFirst().get();
            start = LocalDate.parse(s[2]);
            due = LocalDate.parse(s[3]);
            l = new Loan(b, start, due);
            
            if(!this.loansList.containsKey(c)){
                this.loansList.put(c, new HashSet());
                this.loansList.get(c).add(l);
            }else{
                this.loansList.get(c).add(l);
            }           
        }     
    } 
}
