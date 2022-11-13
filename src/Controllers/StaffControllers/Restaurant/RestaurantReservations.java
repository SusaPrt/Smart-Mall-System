/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers.StaffControllers.Restaurant;

import Controllers.MainApplication;
import Controllers.StaffControllers.HomepageStaff;
import Model.administration.Staff;
import Model.enterprises.restaurant.Restaurant;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//@author Susanna & Marzio

public class RestaurantReservations implements Initializable {
    private Parent root;
    private Stage stage;
    private Scene scene;
    private MainApplication mainApplication;
    private Staff staff;
    private Restaurant restaurant;

    @FXML
    private Label label_name_enterprise;
    @FXML
    private TextField name_reservation;
    @FXML
    private TextField n_seats_reservation;
    @FXML
    private Label label_response;
    @FXML
    private ScrollPane scrollPane_reservations;
    @FXML
    private Label label_available_seats;

    @Override
    public void initialize(URL url, ResourceBundle rb) {}  
    
    // Metodo per il caricamento del modello da controller precedente 
    public void setData(Staff s, Restaurant r, MainApplication mainApp) {
        this.mainApplication = mainApp;
        this.staff = s;
        this.restaurant = r;       
        this.label_name_enterprise.setText(r.getName());
        this.showReservations(r.getReservations());
        this.label_available_seats.setText(r.getFreeSeats() + "");
    }

    @FXML
    private void showMenu(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Views/StaffViews/Restaurant/RestaurantMenuS.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            System.out.println(ex+"\nEccezione caricamento staff restaurant menu");
        }
        RestaurantMenuS sRMController = loader.getController();
        sRMController.setData(this.staff, this.restaurant, this.mainApplication);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
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
        stage.setResizable(false);
        stage.show(); 
    }

    @FXML
    private void addReservation(ActionEvent event) {
        String name = this.name_reservation.getText();
        String seats = this.n_seats_reservation.getText();
        try {
            boolean done = this.restaurant.reserveSeats(Integer.parseInt(seats), name);
            if(done) {
                this.label_response.setText("Reservation " + name + " added!");
                this.showReservations(this.restaurant.getReservations());
                this.label_available_seats.setText(this.restaurant.getFreeSeats() + "");
            } else
                this.label_response.setText("ERROR");
        } catch(NumberFormatException ex) {
            this.label_response.setText("ERROR");
        } finally {
            this.name_reservation.clear();
            this.n_seats_reservation.clear();
        }
    }

    @FXML
    private void clearInputs(ActionEvent event) {
        this.n_seats_reservation.clear();
        this.name_reservation.clear();
        this.label_response.setText(" ");
    }    

    @FXML
    private void newDay(ActionEvent event) {
        this.restaurant.newDay();
        this.showReservations(this.restaurant.getReservations());
        this.label_response.setText("New day confirmed!");
    }
    
    private void showReservations(Map<String, Integer> reservations) {
        VBox vBox = new VBox();
        for(String s : reservations.keySet()) {
            BorderPane pane = createViewReservation(s, reservations.get(s));
            vBox.getChildren().add(pane);
        }        
        this.scrollPane_reservations.setContent(vBox);
        this.scrollPane_reservations.fitToWidthProperty().set(true);
        this.scrollPane_reservations.fitToHeightProperty().set(true);
    }

    private BorderPane createViewReservation(String s, Integer i) {
        BorderPane pane = new BorderPane();
        pane.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        VBox vBox1 = new VBox();
        vBox1.setAlignment(Pos.CENTER_LEFT);
        pane.setLeft(vBox1);
        
        vBox1.getChildren().add(new Label("Name: " + s));
        vBox1.getChildren().add(new Label("N°: " + i));
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
                boolean done = restaurant.cancelReservation(s);
                if(done) {
                    label_response.setText("Reservation " + s + " removed!");
                    showReservations(restaurant.getReservations());
                    label_available_seats.setText(restaurant.getFreeSeats() + "");
                } else
                    label_response.setText("ERROR");                
            }
        });

        return pane;
    }
}
