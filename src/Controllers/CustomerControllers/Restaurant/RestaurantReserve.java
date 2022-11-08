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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

//@author Susanna

public class RestaurantReserve implements Initializable {
    private MainApplication mainApplication;
    private Customer customer;
    private Restaurant restaurant;
    private Parent root;
    private Stage stage;
    private Scene scene;
    
    @FXML
    private Label label_name_enterprise;
    @FXML
    private TextField name_reservation;
    @FXML
    private TextField n_seats_reservation;
    @FXML
    private Label label_response;
    @FXML
    private Label label_available_seats;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    public void setData(Customer c, Restaurant r, MainApplication mainApp) {
        this.customer = c;
        this.restaurant = r;
        this.mainApplication = mainApp;
        this.label_name_enterprise.setText(r.getName());
        this.label_available_seats.setText(this.restaurant.getFreeSeats() + "");
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
        stage.show();
    }

    @FXML
    private void addReservation(ActionEvent event) {
        String name = this.name_reservation.getText();
        int seats = Integer.parseInt(this.n_seats_reservation.getText());
        if(!(name.isBlank()) && seats > 0) {
            boolean done = this.restaurant.reserveSeats(seats, name);
            if(done) {
                this.label_response.setText(name + "'s reservation for " + seats + " made!");
                this.label_available_seats.setText(this.restaurant.getFreeSeats() + "");
            } else
                this.label_response.setText("Error");
        }
        this.name_reservation.clear();
        this.n_seats_reservation.clear();
    }

    @FXML
    private void clearInputs(ActionEvent event) {
        this.name_reservation.clear();
        this.n_seats_reservation.clear();
        this.label_response.setText(" ");
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
        stage.show();
    }
    
}
