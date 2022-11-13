/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers.StaffControllers.Library;

import Controllers.MainApplication;
import Controllers.StaffControllers.HomepageStaff;
import Model.administration.Staff;
import Model.enterprises.library.Library;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

//@author Susanna & Marzio

public class LibraryAddBook implements Initializable {
    private Parent root;
    private Stage stage;
    private Scene scene;
    private MainApplication mainApplication;
    private Staff staff;
    private Library library;

    @FXML
    private TextField name_new_book;
    @FXML
    private TextField author_new_book;
    @FXML
    private TextField price_new_book;
    @FXML
    private TextField quantity_new_book;
    @FXML
    private TextField year_new_book;
    @FXML
    private TextField genre_new_book;
    @FXML
    private TextField isbn_new_book;
    @FXML
    private Label label_response;
    @FXML
    private Label label_name_enterpris;

    @Override
    public void initialize(URL url, ResourceBundle rb) {}   
    
    // Metodo per il caricamento del modello da controller precedente
    public void setData(Staff s, Library l, MainApplication mainApp) {
        this.mainApplication = mainApp;
        this.staff = s;
        this.library = l;       
        this.label_name_enterpris.setText(l.getName());
    }

    @FXML
    private void showAllBooks(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Views/StaffViews/Library/LibraryAllBooks.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            System.out.println(ex+"\nEccezione caricamento staff library all books");
        }
        LibraryAllBooksS sABController = loader.getController();
        sABController.setData(this.staff, this.library, this.mainApplication);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void showLoans(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Views/StaffViews/Library/LibraryLoans.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            System.out.println(ex+"\nEccezione caricamento staff library loans");
        }
        LibraryLoansS sLController = loader.getController();
        sLController.setData(this.staff, this.library, this.mainApplication);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void toHomepage(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Views/StaffViews/HomepageStaff.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            System.out.println(ex+"\nEccezione caricamento staff homepage");
        }
        HomepageStaff sHController = loader.getController();
        sHController.setData(this.staff, this.mainApplication);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show(); 
    }

    @FXML
    private void addBook(ActionEvent event) {
         String name = this.name_new_book.getText();
         String author = this.author_new_book.getText();
         String price = this.price_new_book.getText();
         String quantity = this.price_new_book.getText();
         String year = this.year_new_book.getText();
         String genre = this.genre_new_book.getText();
         String isbn = this.isbn_new_book.getText();
         
        try {
            boolean done = this.library.addBook(name, author, 
                    Double.parseDouble(price), Integer.parseInt(quantity), 
                    Integer.parseInt(year), genre, 
                    Integer.parseInt(isbn));
            if(done)
                this.label_response.setText("Book " + name + " added!");
            else
                this.label_response.setText("ERROR");
        } catch(NumberFormatException ex) {
                    label_response.setText("ERROR");
        } finally {
            this.name_new_book.clear();
            this.author_new_book.clear();
            this.price_new_book.clear();
            this.quantity_new_book.clear();
            this.year_new_book.clear();
            this.genre_new_book.clear();
            this.isbn_new_book.clear();
        }
    }

    @FXML
    private void clearInputs(ActionEvent event) {
        this.name_new_book.clear();
        this.author_new_book.clear();
        this.price_new_book.clear();
        this.quantity_new_book.clear();
        this.year_new_book.clear();
        this.genre_new_book.clear();
        this.isbn_new_book.clear();
        this.label_response.setText(" ");
    }
}
