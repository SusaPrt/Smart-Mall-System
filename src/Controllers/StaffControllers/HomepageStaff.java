/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers.StaffControllers;

import Controllers.CustomerControllers.Library.LibraryAllBooks;
import Controllers.LoginViewController;
import Controllers.MainApplication;
import Controllers.StaffControllers.Library.LibraryAllBooksS;
import Model.administration.Staff;
import Model.enterprises.library.Library;
import Model.enterprises.restaurant.Restaurant;
import Model.enterprises.shop.Shop;
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
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//@author Susanna

public class HomepageStaff implements Initializable {
    private MainApplication mainApplication;
    private Staff staff;
    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    private Label label_staff_name;
    @FXML
    private Label label_staff_id;
    @FXML
    private TextField name_new_library;
    @FXML
    private TextField name_new_restaurant;
    @FXML
    private TextField name_new_shop;
    @FXML
    private TextField n_seats_new_restaurant;
    @FXML
    private ScrollPane scrollPane_libraries;
    @FXML
    private ScrollPane scrollPane_restaurants;
    @FXML
    private ScrollPane scrollPane_shops;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    public void setData(Staff s, MainApplication mainApp) {
        this.mainApplication = mainApp;
        this.staff = s;
        this.label_staff_id.setText(s.getId()+"");
        this.label_staff_name.setText(s.getName());
        this.showRestaurants(mainApp);
        this.showLibraries(mainApp);
        this.showShops(mainApp);
        
    }

    @FXML
    private void toLogin(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Views/LoginView.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            System.out.println(ex+"\nEccezione caricamento customer homepage");
        }
        LoginViewController lVcontroller = loader.getController();
        lVcontroller.setData(this.mainApplication);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void addRestaurant(ActionEvent event) throws IOException {
        this.mainApplication.addEnterprises(new Restaurant(this.name_new_restaurant.getText(), Integer.parseInt(this.n_seats_new_restaurant.getText())));
        this.showRestaurants(this.mainApplication);
    }

    @FXML
    private void addLibrary(ActionEvent event) throws IOException {
        this.mainApplication.addEnterprises(new Library(this.name_new_library.getText(), this.mainApplication.getAdminstration()));
        this.showLibraries(this.mainApplication);
    }

    @FXML
    private void addShop(ActionEvent event) throws IOException {
        this.mainApplication.addEnterprises(new Shop(this.name_new_shop.getText()));
        this.showShops(this.mainApplication);
    }
    
    @FXML
    private void clearInputs(ActionEvent event) {
        this.name_new_library.clear();
        this.name_new_restaurant.clear();
        this.name_new_shop.clear();
    }

    private void showRestaurants(MainApplication mainApplication) {
        VBox vBox = new VBox();
        for(Restaurant r : this.mainApplication.getRestaurants()) {
            BorderPane pane = this.createViewEnterprises(r);
            vBox.getChildren().add(pane);
        }            
        this.scrollPane_restaurants.setContent(vBox);
        this.scrollPane_restaurants.fitToWidthProperty().set(true);
        this.scrollPane_restaurants.fitToHeightProperty().set(true);
    }

    private void showShops(MainApplication mainApplication) {
        VBox vBox = new VBox();
        for(Restaurant r : this.mainApplication.getRestaurants()) {
            BorderPane pane = this.createViewEnterprises(r);
            vBox.getChildren().add(pane);
        }            
        this.scrollPane_shops.setContent(vBox);
        this.scrollPane_shops.fitToWidthProperty().set(true);
        this.scrollPane_shops.fitToHeightProperty().set(true);
    }

    private void showLibraries(MainApplication mainApplication) {
        VBox vBox = new VBox();
        for(Restaurant r : this.mainApplication.getRestaurants()) {
            BorderPane pane = this.createViewEnterprises(r);
            vBox.getChildren().add(pane);
        }            
        this.scrollPane_libraries.setContent(vBox);
        this.scrollPane_libraries.fitToWidthProperty().set(true);
        this.scrollPane_libraries.fitToHeightProperty().set(true);
    }

    private BorderPane createViewEnterprises(Object e) {
        BorderPane pane = new BorderPane();
        pane.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        VBox vBox1 = new VBox();
        vBox1.setAlignment(Pos.CENTER_LEFT);
        pane.setLeft(vBox1);
        
        vBox1.getChildren().add(new Label("Name: " + e.getClass().getName()));
        vBox1.getChildren().add(new Label());
        
        VBox vBox2 = new VBox();
        vBox2.setAlignment(Pos.CENTER);
        pane.setRight(vBox2);
        
        Button btnOpen = new Button();
        btnOpen.setText("Open");
        vBox2.getChildren().add(btnOpen);
        btnOpen.setAlignment(Pos.CENTER);
        
        Button btnRemove = new Button();
        btnRemove.setText("Remove");
        vBox2.getChildren().add(btnOpen);
        btnRemove.setAlignment(Pos.CENTER);
        
        btnOpen.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(e instanceof Library) {
                    Library l = (Library) e;
                    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Views/StaffViews/Library/LibraryAllBooks.fxml"));
                    try {
                        root = loader.load();                    
                    } catch (IOException ex) {
                        System.out.println(ex+"\nEccezione caricamento customer library view"); 
                    }      
                    LibraryAllBooksS cLController = loader.getController();
                    cLController.setData(staff, l, mainApplication);
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else if(e instanceof Restaurant) {
                    
                } else {
                    
                }                    
            }
        });
        
        btnRemove.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainApplication.removeEnterprises(e);
                if(e instanceof Restaurant)
                    showRestaurants(mainApplication);
                else if(e instanceof Library)
                    showLibraries(mainApplication);
                else
                    showShops(mainApplication);
            }
        });
        
        return pane;
    }
    
    
}
