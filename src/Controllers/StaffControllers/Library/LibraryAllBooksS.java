/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers.StaffControllers.Library;

import Controllers.MainApplication;
import Controllers.StaffControllers.HomepageStaff;
import Model.administration.Staff;
import Model.enterprises.library.Book;
import Model.enterprises.library.Library;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//@author Susanna

public class LibraryAllBooksS implements Initializable {
    private MainApplication mainApplication;
    private Staff staff;
    private Library library;
    private final String[] types = {"Title", "Genre", "Author"};
    
    private Parent root;
    private Stage stage;
    private Scene scene;    

    @FXML
    private TextField string_search;
    @FXML
    private ChoiceBox<String> choise_search;
    @FXML
    private ScrollPane scrollPane_books;
    @FXML
    private Label label_name_enterpris;
    @FXML
    private Label label_response;
    @FXML
    private TextField refueling;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    public void setData(Staff s, Library l, MainApplication mainApp) {
        this.mainApplication = mainApp;
        this.staff = s;
        this.library = l;        
        this.label_name_enterpris.setText(l.getName());
        this.choise_search.getItems().addAll(this.types);
        this.showBooks(l.getAllBooks());
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
    private void clearInputs(ActionEvent event) {
        this.string_search.clear();
        this.label_response.setText(" ");
        this.refueling.clear();
        this.showBooks(this.library.getAllBooks());
    }

    @FXML
    private void searchBookBy(ActionEvent event) {
        String input = this.string_search.getText();
        String type = this.choise_search.getValue();
        if(!(type == null) && !(input == null)) {
            List<Book> books = new LinkedList<>();
            switch(type) {
                case "Title" -> books = this.library.searchBookByTitle(input).stream().collect(Collectors.toList());
                case "Genre" -> books = this.library.searchBookByGenre(input).stream().collect(Collectors.toList());
                case "Author" -> books = this.library.searchBookByAuthor(input).stream().collect(Collectors.toList());
            }
            this.showBooks(books);
        }
    }

    private void showBooks(List<Book> books) {
        VBox vBox = new VBox();
        for(Book b : books) {
            BorderPane pane = this.createViewBook(b);
            vBox.getChildren().add(pane);
        }
        this.scrollPane_books.setContent(vBox);
        this.scrollPane_books.fitToWidthProperty().set(true);
        this.scrollPane_books.fitToHeightProperty().set(true);
    }

    private BorderPane createViewBook(Book b) {
        BorderPane pane = new BorderPane();
        pane.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        VBox vBox1 = new VBox();
        vBox1.setAlignment(Pos.CENTER_LEFT);
        pane.setLeft(vBox1);
        
        vBox1.getChildren().add(new Label("Name: " + b.getName()));
        vBox1.getChildren().add(new Label("Author: " + b.getAuthor()));
        vBox1.getChildren().add(new Label("ISBN: " + b.getISBN()));
        vBox1.getChildren().add(new Label("Genre: " + b.getGenre()));
        vBox1.getChildren().add(new Label("Year: " + b.getPublishingYear()));
        vBox1.getChildren().add(new Label("Price: " + b.getPrice()));
        vBox1.getChildren().add(new Label("Quantity: " + b.getQuantity()));
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
                boolean done = library.removeBook(b);
                if(done) {
                    showBooks(library.getAllBooks());      
                    label_response.setText("Book " + b.getName() + " removed!");
                } else
                    label_response.setText("ERROR");
            }
        });

        Button btnAdd = new Button();
        btnAdd.setText("Refueling");
        vBox2.getChildren().add(btnAdd);
        btnAdd.setAlignment(Pos.CENTER_LEFT);
        
        btnAdd.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String ref = refueling.getText();
                try {
                    boolean done = library.refueling(b, Integer.parseInt(ref));
                    if(done) {
                        label_response.setText("Refueling " +b.getName() + " by " + Integer.parseInt(ref));
                        showBooks(library.getAllBooks());
                    } else
                        label_response.setText("ERROR");
                } catch(NumberFormatException ex) {
                    label_response.setText("ERROR");
                } finally {
                    refueling.clear();
                }
            }
        });
        
        return pane;
    }


    
    
}
