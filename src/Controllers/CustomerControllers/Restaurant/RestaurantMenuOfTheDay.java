/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers.CustomerControllers.Restaurant;

import Controllers.CustomerControllers.Homepage;
import Controllers.MainApplication;
import Model.administration.Customer;
import Model.enterprises.restaurant.Restaurant;
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
import javafx.stage.Stage;

//@author Susanna

public class RestaurantMenuOfTheDay implements Initializable {
    private MainApplication mainApplication;
    private Customer customer;
    private Restaurant restaurant;
    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    private Label label_name_enterprise;
    @FXML
    private Label label_lunch_first;
    @FXML
    private Label label_lunch_second;
    @FXML
    private Label label_lunch_dessert;
    @FXML
    private Label label_dinner_first;
    @FXML
    private Label label_dinner_second;
    @FXML
    private Label label_dinner_dessert;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }   
    void setData(Customer c, Restaurant r, MainApplication mainApp) {
        this.mainApplication = mainApp;
        this.restaurant = r;
        this.customer = c;
        this.label_name_enterprise.setText(r.getName());
        this.setMenu(r);
    }       

    @FXML
    private void showMenu(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Views/CustomerViews/Restaurant/RestaurantMenu.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            System.out.println(ex+"\nEccezione caricamento customer restaurant menu");
        }
        RestaurantMenu cRMController = loader.getController();
        cRMController.setData(this.customer, this.restaurant, this.mainApplication);
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

    private void setMenu(Restaurant r) {
        this.label_lunch_first.setText(r.getDailyMenu().getLunch().get(0).getName());
        this.label_lunch_second.setText(r.getDailyMenu().getLunch().get(1).getName());
        this.label_lunch_dessert.setText(r.getDailyMenu().getLunch().get(2).getName());
        
        this.label_dinner_first.setText(r.getDailyMenu().getDinner().get(0).getName());
        this.label_dinner_second.setText(r.getDailyMenu().getDinner().get(1).getName());
        this.label_dinner_dessert.setText(r.getDailyMenu().getDinner().get(2).getName());
    }
    
}
