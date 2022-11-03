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

//@author Susanna

public class LibraryAddBook implements Initializable {
    private MainApplication mainApplication;
    private Staff staff;
    private Library library;
    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    private Label label_name_enterprise;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    public void setData(Staff s, Library l, MainApplication mainApp) {
        this.mainApplication = mainApp;
        this.staff = s;
        this.library = l;       
        this.label_name_enterprise.setText(l.getName());
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
        stage.show(); 
    }

    @FXML
    private void addBook(ActionEvent event) {
         String name = this.name_new_book.getText();
         String author = this.author_new_book.getText();
         double price = Double.parseDouble(this.price_new_book.getText());
         int quantity = Integer.parseInt(this.price_new_book.getText());
         int year = Integer.parseInt(this.year_new_book.getText());
         String genre = this.genre_new_book.getText();
         int isbn = Integer.parseInt(this.isbn_new_book.getText());
         
         if(!(genre == null) && !(name == null) && !(author == null) && price > 0 && quantity >= 0 && isbn >= 0) {
             boolean done = this.library.addBook(name, author, price, quantity, year, genre, isbn);
             if(done)
                 this.label_response.setText("Book " + name + " added!");
             else
                 this.label_response.setText("ERROR");
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
