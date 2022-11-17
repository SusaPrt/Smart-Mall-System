/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.enterprises.library.classes;

import Model.administration.Item;
import Model.enterprises.library.interfaces.IBook;

//@author Susanna

public class Book extends Item implements IBook {
    private final String author;
    private final int publishingYear;
    private final String genre;
    private final int ISBN;
    
    public Book(String name,  String author, double price, int quantity, int year, String genre, int isbn){
        super(name, price, quantity);
        this.author         = author;
        this.publishingYear = year;
        this.genre          = genre;
        this.ISBN           = isbn;
    }

    @Override
    public String getAuthor(){
        return this.author;
    }
    @Override
    public int getPublishingYear(){
        return this.publishingYear;
    }
    @Override
    public String getGenre(){
        return this.genre;
    }
    @Override
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
        return ("\nTitle: " + super.getName() + "\n Author: " + this.author +
                "\n Publishing Year: " + this.publishingYear + "\n Genre: " + this.genre +
                "\n ISBN: " + this.getISBN()) + "\n Price: " + super.getPrice();
    }
}
