/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers.CustomerControllers.Library;

import Controllers.CustomerControllers.Homepage;
import Controllers.MainApplication;
import Model.administration.Customer;
import Model.enterprises.library.Library;
import Model.enterprises.library.Loan;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//@author Susanna

public class LibraryLoans implements Initializable {
    private MainApplication mainApplication;
    private Customer customer;
    private Library library;
    private Parent root;
    private Stage stage;
    private Scene scene;
    
    @FXML
    private Label label_name_enterprise;
    @FXML
    private VBox vBox_your_loans;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }   
    
    public void setData(Customer c, Library l, MainApplication mainApp) {
        this.mainApplication = mainApp;
        this.customer = c;
        this.library = l;
        this.label_name_enterprise.setText(l.getName());
        this.showLoans(l);
    } 
    
    @FXML
    private void showAllBooks(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Views/CustomerViews/Library/LibraryAllBooks.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            System.out.println(ex+"\nEccezione caricamento customer library all books");
        }
        LibraryAllBooks cLABController = loader.getController();
        cLABController.setData(this.customer, this.library, this.mainApplication);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void showSearch(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Views/CustomerViews/Library/LibrarySearch.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            System.out.println(ex+"\nEccezione caricamento customer homepage");
        }
        LibrarySearch cLSController = loader.getController();
        cLSController.setData(this.customer, this.library, this.mainApplication);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void showLoans(Library l) {
        this.vBox_your_loans.getChildren().clear();
        if(l.getAllLoans().containsKey(this.customer)) {
            for(Loan loan : l.getAllLoans().get(this.customer)) {
                BorderPane pane = createViewLoan(loan);
                this.vBox_your_loans.getChildren().add(pane);
            }
        }
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
        stage.show();
    }

    private BorderPane createViewLoan(Loan loan) {
        BorderPane pane = new BorderPane();
        pane.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER_LEFT);
        pane.setLeft(vBox);
        
        vBox.getChildren().add(new Label("Borrowed Book: " + loan.getBorrowedBook().getName()));
        vBox.getChildren().add(new Label("Issue date: " + loan.getIssueDate()));
        vBox.getChildren().add(new Label("Due date: " + loan.getDueDate()));
        vBox.getChildren().add(new Label());
        
        return pane;
    }
    
}
