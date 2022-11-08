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
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
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
    private ScrollPane scrollPane_loans;
    @FXML
    private Label label_response;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }       
    public void setData(Customer c, Library l, MainApplication mainApp) {
        this.mainApplication = mainApp;
        this.customer = c;
        this.library = l;
        this.label_name_enterprise.setText(l.getName());
        this.showLoans(l.getAllLoans());
        this.label_response.setText(" ");
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
            System.out.println(ex+"\nEccezione caricamento customer library search");
        }
        LibrarySearch cLSController = loader.getController();
        cLSController.setData(this.customer, this.library, this.mainApplication);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void showLoans(Map<Customer, Set<Loan>> loans) {
        VBox vBox = new VBox();
        if(loans.containsKey(this.customer)) {
            for(Loan loan : loans.get(this.customer)) {
                BorderPane pane = createViewLoan(loan);
                vBox.getChildren().add(pane);
            }
        }
        this.scrollPane_loans.setContent(vBox);
        this.scrollPane_loans.fitToWidthProperty().set(true);
        this.scrollPane_loans.fitToHeightProperty().set(true);
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
        vBox.getChildren().add(new Label("ISBN: " + loan.getBorrowedBook().getISBN()));
        vBox.getChildren().add(new Label("Issue date: " + loan.getIssueDate()));
        vBox.getChildren().add(new Label("Due date: " + loan.getDueDate()));
        vBox.getChildren().add(new Label());
        
        VBox vBox2 = new VBox();
        vBox2.setAlignment(Pos.CENTER);
        pane.setRight(vBox2);
        
        Button btnRemove = new Button();
        btnRemove.setText("Remove");
        vBox2.getChildren().add(btnRemove);
        btnRemove.setAlignment(Pos.CENTER);
        
        btnRemove.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
            boolean done = library.cancelLoan(customer, loan.getBorrowedBook());
            if(done) {
                showLoans(library.getAllLoans());
                label_response.setText("Loan " + loan.getBorrowedBook().getName() + " removed!");
            } else
                label_response.setText("ERROR");
        });
        return pane;
    }
    
}
