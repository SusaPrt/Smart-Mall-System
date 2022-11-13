/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers.CustomerControllers;

import Controllers.CustomerControllers.Library.LibraryAllBooks;
import Controllers.CustomerControllers.Restaurant.RestaurantMenu;
import Controllers.LoginViewController;
import Controllers.MainApplication;
import Model.administration.Customer;
import Model.enterprises.library.Library;
import Model.enterprises.restaurant.Restaurant;
import Model.enterprises.shop.Shop;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//@author Susanna & Marzio

public class Homepage implements Initializable {
    private Parent root;
    private Stage stage;
    private Scene scene;
    private MainApplication mainApplication;
    private Customer customer;
    
    @FXML
    private Label label_user_name;
    @FXML
    private Label label_user_id;
    @FXML
    private VBox vBox_libreries;
    @FXML
    private VBox vBox_restaurants;
    @FXML
    private VBox vBox_shops;

    @Override
    public void initialize(URL url, ResourceBundle rb) {}    
    
    // Metodo per il caricamento del modello da controller precedente
    public void setData(Customer c, MainApplication mainApp){
        this.customer = c;
        this.mainApplication = mainApp;
        this.viewLibreries(this.mainApplication.getLibraries());
        this.viewRestaurants(this.mainApplication.getRestaurants());
        this.viewShops(this.mainApplication.getShops());
        this.label_user_id.setText(""+c.getId());
        this.label_user_name.setText(c.getName());
    }

    @FXML
    private void toLogin(ActionEvent event){
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader()
                .getResource("Views/LoginView.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            System.out.println(ex+"\nEccezione caricamento customer homepage");
        }
        LoginViewController lVcontroller = loader.getController();
        lVcontroller.setData(this.mainApplication);
        
        this.mainApplication.saveDatas();
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    @FXML
    private void toCart(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader()
                .getResource("Views/CustomerViews/PersonalSpace.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            System.out.println(ex+"\nEccezione caricamento customer personal space");
        }
        PersonalSpace cPScontroller = loader.getController();
        cPScontroller.setData(this.mainApplication, this.customer);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    private void viewLibreries(List<Library> libs) {
        this.vBox_libreries.getChildren().clear();
        for(Library l : libs) {
            Button btn = this.createButton(l);
            btn.setMinWidth(100);
            btn.setMaxWidth(100);
            this.vBox_libreries.getChildren().add(btn);
        }
        this.vBox_libreries.setAlignment(Pos.TOP_CENTER);
    }
    
    private void viewRestaurants(List<Restaurant> res) {
        this.vBox_restaurants.getChildren().clear();
        for(Restaurant r : res) {
            Button btn = this.createButton(r);
            btn.setMinWidth(100);
            btn.setMaxWidth(100);
            this.vBox_restaurants.getChildren().add(btn);
        }
        this.vBox_restaurants.setAlignment(Pos.TOP_CENTER);
    }
    
    private void viewShops(List<Shop> shops) {
        this.vBox_shops.getChildren().clear();
        for(Shop s : shops) {
            Button btn = this.createButton(s);
            btn.setMinWidth(100);
            btn.setMaxWidth(100);
            this.vBox_shops.getChildren().add(btn);
        }
        this.vBox_shops.setAlignment(Pos.TOP_CENTER);
    }
    
    private Button createButton(Object e) {
        Button btn = new Button();
        if(e instanceof Library) {
            Library l = (Library) e;
            btn.setText(l.getName());
            btn.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader()
                        .getResource("Views/CustomerViews/Library/LibraryAllBooks.fxml"));
                try {
                    root = loader.load();                    
                } catch (IOException ex) {
                    System.out.println(ex+"\nEccezione caricamento customer library view"); 
                }      
                LibraryAllBooks cLController = loader.getController();
                cLController.setData(customer, l, mainApplication);
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            });
        } else if(e instanceof Restaurant) {
            Restaurant r = (Restaurant) e;
            btn.setText(r.getName());
            btn.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader()
                        .getResource("Views/CustomerViews/Restaurant/RestaurantMenu.fxml"));
                try {
                    root = loader.load();
                } catch (IOException ex) {
                    System.out.println(ex+"\nEccezione caricamento customer restaurant view"); 
                }
                RestaurantMenu cRMController = loader.getController();
                cRMController.setData(this.customer, r, this.mainApplication);
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            });
        } else {
            Shop s = (Shop) e;
            btn.setText(s.getName());
            btn.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader()
                        .getResource("Views/CustomerViews/ShopCustomer.fxml"));
                try {
                    root = loader.load();
                } catch (IOException ex) {
                    System.out.println(ex+"\nEccezione caricamento customer shop view"); 
                }
                ShopCustomer cSController = loader.getController();
                cSController.setData(customer, s, mainApplication);
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            });
        }
        return btn;
    }
}