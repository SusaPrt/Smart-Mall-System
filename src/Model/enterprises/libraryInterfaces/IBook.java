/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.enterprises.libraryInterfaces;

// Susanna
public interface IBook {
    //ritorna l'autore del libro
    public String getAuthor();
    
    //ritorna l'anno di pubblicazione del libro
    public int getPublishingYear();
    
    //ritorna il genere del libro
    public String getGenre();
    
    //ritorna il codice univoco ISBN del libro
    public int getISBN();
}
