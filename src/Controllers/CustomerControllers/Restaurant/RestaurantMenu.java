/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers.CustomerControllers.Restaurant;

import Controllers.CustomerControllers.Homepage;
import Controllers.MainApplication;
import Model.administration.Customer;
import Model.enterprises.restaurant.classes.Course;
import Model.enterprises.restaurant.classes.Dish;
import Model.enterprises.restaurant.classes.Restaurant;
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

public class RestaurantMenu implements Initializable {
    private Parent root;
    private Stage stage;
    private Scene scene;
    private MainApplication mainApplication;
    private Customer customer;
    private Restaurant restaurant;
    
    @FXML
    private Label label_name_enterprise;
    @FXML
    private ScrollPane scrollPane_menu;
    @FXML
    private Label label_response;

    @Override
    public void initialize(URL url, ResourceBundle rb) {}  
    
    // Metodo per il caricamento del modello da controller precedente
    public void setData(Customer c, Restaurant r, MainApplication mainApp) {
        this.customer = c;
        this.restaurant = r;
        this.mainApplication = mainApp;
        this.label_name_enterprise.setText(r.getName());
        this.showMenu(r);
    }

    @FXML
    private void showReserve(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Views/CustomerViews/Restaurant/RestaurantReserve.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            System.out.println(ex+"\nEccezione caricamento customer restaurant reserve");
        }
        RestaurantReserve cRRController = loader.getController();
        cRRController.setData(this.customer, this.restaurant, this.mainApplication);
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
    
    @FXML
    private void showMenuOfTheDay(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Views/CustomerViews/Restaurant/RestaurantMenuOfTheDay.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            System.out.println(ex+"\nEccezione caricamento customer menu of the day");
        }
        RestaurantMenuOfTheDay cMOTDController = loader.getController();
        cMOTDController.setData(this.customer, this.restaurant, this.mainApplication);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void showMenu(Restaurant r) {
        VBox vBox = new VBox();
        vBox.getChildren().add(new Label("\tFIRSTS"));        
        for(Dish d : this.restaurant.getMenu().getAvailableTypeDishes(Course.FIRSTS)) {
            BorderPane pane = this.createViewDish(d);
            vBox.getChildren().add(pane);
        }
        
        vBox.getChildren().add(new Label("\tSECONDS"));
        for(Dish d : this.restaurant.getMenu().getAvailableTypeDishes(Course.SECONDS)) {
            BorderPane pane = this.createViewDish(d);
            vBox.getChildren().add(pane);
        }
        
        vBox.getChildren().add(new Label("\tDESSERTS"));
        for(Dish d : this.restaurant.getMenu().getAvailableTypeDishes(Course.DESSERTS)) {
            BorderPane pane = this.createViewDish(d);
            vBox.getChildren().add(pane);
        }
        
        vBox.getChildren().add(new Label("\tWINESANDSOFT"));
        for(Dish d : this.restaurant.getMenu().getAvailableTypeDishes(Course.WINESANDSOFT)) {
            BorderPane pane = this.createViewDish(d);
            vBox.getChildren().add(pane);
        }
        
        this.scrollPane_menu.setContent(vBox);
        this.scrollPane_menu.fitToWidthProperty().set(true);
        this.scrollPane_menu.fitToHeightProperty().set(true);
    }

    private BorderPane createViewDish(Dish d) {
        BorderPane pane = new BorderPane();
        pane.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        VBox vBox1 = new VBox();
        vBox1.setAlignment(Pos.CENTER_LEFT);
        pane.setLeft(vBox1);
        
        vBox1.getChildren().add(new Label("\tName: " + d.getName()));
        vBox1.getChildren().add(new Label("\tPrice: " + d.getPrice()));
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
        
        btnBuy.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                customer.getCart().addItem(d);
                label_response.setText("Book " + d.getName() + " added!");
            }
        });
        
        return pane;
    }   
}
