/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.enterprises.library;

import Model.administration.Item;
import java.util.Objects;

//@author Susanna

public class Book extends Item {
    private final String    author;
    private final int       publishingYear;
    private final String    genre;
    private final int    ISBN;
    
    public Book(String name,  String author, double price, int quantity, int year, String genre, int isbn){
        super(name, price, quantity);
        this.author         = author;
        this.publishingYear = year;
        this.genre          = genre;
        this.ISBN           = isbn;
    }

    public String getAuthor(){
        return this.author;
    }
    public int getPublishingYear(){
        return this.publishingYear;
    }
    public String getGenre(){
        return this.genre;
    }
    public int getISBN() {
        return this.ISBN;
    }
    @Override
    public int hashCode() {
        final int hash = 31;
        int result = 1;
        result = result * hash + this.ISBN;
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
        final Book other = (Book) obj;
        return this.getISBN() == other.getISBN();
    }
    
    @Override
    public String toString(){
        return ("\nTitle: " + super.getName() + "\nAuthor: " + this.author +
                "\nPublishing Year: " + this.publishingYear + "\nGenre: " + this.genre +
                "\nPrice: " + super.getPrice() + "\nISBN: " + this.getISBN()) + 
                "\nAvailable: " + super.getQuantity() + "\n";
    }
}
