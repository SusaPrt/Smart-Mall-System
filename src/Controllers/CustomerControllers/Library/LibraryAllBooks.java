/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers.CustomerControllers.Library;

import Controllers.CustomerControllers.Homepage;
import Controllers.MainApplication;
import Model.administration.Customer;
import Model.enterprises.library.classes.Book;
import Model.enterprises.library.classes.Library;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//@author Susanna & Marzio

public class LibraryAllBooks implements Initializable {
    private Parent root;
    private Stage stage;
    private Scene scene;
    private MainApplication mainApplication;
    private Customer customer;
    private Library library;

    @FXML
    private VBox vBox_all_books;
    @FXML
    private Label label_name_enterprise;
    @FXML
    private Label label_response;
    @FXML
    private ScrollPane scrollPane_books;

    @Override
    public void initialize(URL url, ResourceBundle rb) {}    
    
    // Metodo per il caricamento del modello da controller precedente
    public void setData(Customer c, Library l, MainApplication mainApp) {
        this.mainApplication = mainApp;
        this.customer = c;
        this.library = l;
        this.label_name_enterprise.setText(l.getName());
        this.showAllBooks(l);
        this.label_response.setText(" ");
    }    
    
    private void showAllBooks(Library l) {        
        this.vBox_all_books.getChildren().clear();
        for(Book b : l.getAllBooks()) {
            BorderPane pane = createViewBook(b);
            this.vBox_all_books.getChildren().add(pane);
        }
        this.scrollPane_books.setContent(this.vBox_all_books);
        this.scrollPane_books.fitToWidthProperty().set(true);
        this.scrollPane_books.fitToHeightProperty().set(true);
    }

    @FXML
    private void showSearch(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Views/CustomerViews/Library/LibrarySearch.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            System.out.println(ex+"\nEccezione caricamento customer library search");
        }
        LibrarySearch cLSController = loader.getController();
        cLSController.setData(this.customer, this.library, this.mainApplication);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void showLoans(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Views/CustomerViews/Library/LibraryLoans.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            System.out.println(ex+"\nEccezione caricamento customer library loans");
        }
        LibraryLoans cLLController = loader.getController();
        cLLController.setData(this.customer, this.library, this.mainApplication);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void toHomepage(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Views/CustomerViews/HomepageCustomer.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            System.out.println(ex+"\nEccezione caricamento customer homepage");
        }
        Homepage cHController = loader.getController();
        cHController.setData(this.customer, this.mainApplication);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private BorderPane createViewBook(Book b) {
        BorderPane pane = new BorderPane();
        pane.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        VBox vBox1 = new VBox();
        vBox1.setAlignment(Pos.CENTER_LEFT);
        pane.setLeft(vBox1);
        
        vBox1.getChildren().add(new Label("\tName: " + b.getName()));
        vBox1.getChildren().add(new Label("\tAuthor: " + b.getAuthor()));
        vBox1.getChildren().add(new Label("\tISBN: " + b.getISBN()));
        vBox1.getChildren().add(new Label("\tGenre: " + b.getGenre()));
        vBox1.getChildren().add(new Label("\tYear: " + b.getPublishingYear()));
        vBox1.getChildren().add(new Label("\tPrice: " + b.getPrice()));
        vBox1.getChildren().add(new Label());
        
        VBox vBox2 = new VBox();
        vBox2.setAlignment(Pos.CENTER);
        pane.setRight(vBox2);
        
        Button btnBuy = new Button();
        btnBuy.setMinWidth(50);
        btnBuy.setMaxWidth(50);
        btnBuy.setText("Buy");
        vBox2.getChildren().add(btnBuy);
        btnBuy.setAlignment(Pos.CENTER);
        
        Button btnLoan = new Button();
        btnLoan.setMinWidth(50);
        btnLoan.setMaxWidth(50);
        btnLoan.setText("Loan");
        vBox2.getChildren().add(btnLoan);
        btnLoan.setAlignment(Pos.CENTER);
        
        btnBuy.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                customer.getCart().addItem(b);
                b.decreaseQuantity(1);
                label_response.setText("Book " + b.getName() + " added!");
            }
        });
        
        btnLoan.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean work = library.createLoan(customer, b);
                if(work)
                    label_response.setText("Loan " + b.getName() + " created!");
                else
                    label_response.setText("ERROR!");
            }
        });

        return pane;
    }    
}
