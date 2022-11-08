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
import javafx.scene.layout.BorderPane;
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
    private ChoiceBox<Customer> choice_customer;
    @FXML
    private ChoiceBox<Book> choice_book;
    @FXML
    private ScrollPane scrollPane_loans;
    @FXML
    private Label label_name_enterpris;
    @FXML
    private Label label_response;
    @FXML
    private ScrollPane scrollPane_customers;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    public void setData(Staff s, Library l, MainApplication mainApp) {
        this.mainApplication = mainApp;
        this.staff = s;
        this.library = l;     
        this.label_name_enterpris.setText(l.getName());
        this.choice_customer.getItems().addAll(this.mainApplication.getAdminstration().getArchive().getCustomers().stream().collect(Collectors.toList()));
        this.choice_book.getItems().addAll(this.library.getAllBooks());
        this.showCustomers(l.getAllLoans());        
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
            boolean done = this.library.createLoan(c, b);
            if(done) {
                this.showCustomers(this.library.getAllLoans());
                this.showLoans(this.library.getCustomerLoans(c), c);
                this.label_response.setText(c.getName() + "'s loan added!");
            } else
                this.label_response.setText("ERROR");
        }
    }    

    private void showCustomers(Map<Customer, Set<Loan>> allLoans) {
        VBox vBoxC = new VBox();
        for(Customer c : allLoans.keySet()) {
            BorderPane pane = createViewCustomer(c);
            vBoxC.getChildren().add(pane);
        }
        this.scrollPane_customers.setContent(vBoxC);
        this.scrollPane_customers.fitToWidthProperty().set(true);
        this.scrollPane_customers.fitToHeightProperty().set(true);
    }

    private BorderPane createViewCustomer(Customer c) {
        BorderPane pane = new BorderPane();
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        pane.setCenter(vBox);
        
        Button btn = new Button();
        btn.setText(c.getName());
        vBox.getChildren().add(btn);
        vBox.getChildren().add(new Label());
        
        btn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showLoans(library.getCustomerLoans(c), c);
            }            
        });
        return pane;
    }
    
    private void showLoans(Set<Loan> customerLoans, Customer c) {
        VBox vBoxL = new VBox();
        for(Loan l : customerLoans) {
            BorderPane pane = this.createViewLoan(l, c);
            vBoxL.getChildren().add(pane);
        }
        this.scrollPane_loans.setContent(vBoxL);
        this.scrollPane_loans.fitToWidthProperty().set(true);
        this.scrollPane_loans.fitToHeightProperty().set(true);
    }

    private BorderPane createViewLoan(Loan l, Customer c) {
        BorderPane pane = new BorderPane();
        pane.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        VBox vBox1 = new VBox();
        vBox1.setAlignment(Pos.CENTER_LEFT);
        pane.setLeft(vBox1);
        
        vBox1.getChildren().add(new Label("Book: " + l.getBorrowedBook().getName()));
        vBox1.getChildren().add(new Label("Issue date: " + l.getIssueDate()));
        vBox1.getChildren().add(new Label("Due date: " + l.getDueDate()));
        vBox1.getChildren().add(new Label());
        
        VBox vBox2 = new VBox();
        vBox2.setAlignment(Pos.CENTER);
        pane.setRight(vBox2);
        
        Button btnRemove = new Button();
        btnRemove.setText("Remove");
        vBox2.getChildren().add(btnRemove);
        btnRemove.setAlignment(Pos.CENTER);
        
        btnRemove.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean done = library.cancelLoan(c, l.getBorrowedBook());
                if(done) {
                    showCustomers(library.getAllLoans());
                    if(library.getCustomerLoans(c) == null)
                        scrollPane_loans.setContent(new VBox());
                    else
                        showLoans(library.getCustomerLoans(c), c);     
                    label_response.setText("Loan " + c.getName() + "-" + l.getBorrowedBook().getName() + " removed!");
                } else
                    label_response.setText("ERROR");
            }
        });
        return pane;
    }


    
}
