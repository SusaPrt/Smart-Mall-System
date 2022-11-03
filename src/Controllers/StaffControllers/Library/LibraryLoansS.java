/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers.StaffControllers.Library;

import Controllers.MainApplication;
import Controllers.StaffControllers.HomepageStaff;
import Model.administration.Customer;
import Model.administration.Staff;
import Model.enterprises.library.Book;
import Model.enterprises.library.Library;
import Model.enterprises.library.Loan;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//@author Susanna

public class LibraryLoansS implements Initializable {
    private MainApplication mainApplication;
    private Staff staff;
    private Library library;
    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    private Label label_name_enterprise;
    @FXML
    private ChoiceBox<Customer> choice_customer;
    @FXML
    private ChoiceBox<Book> choice_book;
    @FXML
    private ScrollPane scrollPane_loans;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    public void setData(Staff s, Library l, MainApplication mainApp) {
        this.mainApplication = mainApp;
        this.staff = s;
        this.library = l;     
        this.label_name_enterprise.setText(l.getName());
        this.choice_customer.getItems().addAll(this.mainApplication.getAdminstration().getArchive().getCustomers().stream().collect(Collectors.toList()));
        this.choice_book.getItems().addAll(this.library.getAllBooks());
        this.showLoans(l.getAllLoans());
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
    private void showAddBook(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Views/StaffViews/Library/LibraryAddBook.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            System.out.println(ex+"\nEccezione caricamento staff library add book");
        }
        LibraryAddBook sABController = loader.getController();
        sABController.setData(this.staff, this.library, this.mainApplication);
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
    private void addLoan(ActionEvent event) {
        Customer c = this.choice_customer.getValue();
        Book b = this.choice_book.getValue();
        if(!(c == null) && !(b == null)) {
            this.library.createLoan(c, b);
            this.showLoans(this.library.getAllLoans());
        }
    }

    private void showLoans(Map<Customer, Set<Loan>> loans) {
        VBox vBox = new VBox();
        for(Customer c : loans.keySet()) {
            BorderPane pane = this.createViewLoansCustomer(c, loans.get(c));
            vBox.getChildren().add(vBox);
        }
        this.scrollPane_loans.setContent(vBox);
        this.scrollPane_loans.fitToWidthProperty().set(true);
        this.scrollPane_loans.fitToHeightProperty().set(true);
    }

    private BorderPane createViewLoansCustomer(Customer c, Set<Loan> loans) {
        BorderPane pane = new BorderPane();
        pane.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        VBox vBox1 = new VBox();
        vBox1.setAlignment(Pos.CENTER_LEFT);
        pane.setLeft(vBox1);
        
        vBox1.getChildren().add(new Label(""));
        vBox1.getChildren().add(new Label("Customer: " + c.getName()));
        vBox1.getChildren().add(new Label("ID: " + c.getId()));
        vBox1.getChildren().add(new Label("Loans: "));
        for(Loan l : loans) {
            vBox1.getChildren().add(new Label("Book: " + l.getBorrowedBook()));
            vBox1.getChildren().add(new Label("Issue Date: " + l.getIssueDate()));
            vBox1.getChildren().add(new Label("Due Date: " + l.getIssueDate()));
            vBox1.getChildren().add(new Label(""));
        
            vBox1.getChildren().add(new Label(""));

            VBox vBox2 = new VBox();
            vBox2.setAlignment(Pos.CENTER);
            pane.setRight(vBox2);

            Button btnRemove = new Button();
            btnRemove.setText("Buy");
            vBox2.getChildren().add(btnRemove);
            btnRemove.setAlignment(Pos.CENTER);

            btnRemove.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    library.cancelLoan(c, l.getBorrowedBook());
                    showLoans(library.getAllLoans());
                }
            });
        }
        return pane;
    }


    
}
