/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers.StaffControllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Mars_DB
 */
public class RestaurantStaffViewController implements Initializable {

    @FXML
    private Button btn_menu;
    @FXML
    private Button btn_reservations;
    @FXML
    private Button btn_back;
    @FXML
    private Label label_name_enterprise;
    @FXML
    private Pane pnl_menu;
    @FXML
    private Button btn_add_send;
    @FXML
    private Button btn_add_clear;
    @FXML
    private TextField name_new_dish;
    @FXML
    private TextField price_new_dish;
    @FXML
    private TextField quantity_new_dish;
    @FXML
    private ChoiceBox<?> course_new_book;
    @FXML
    private ListView<?> list_menu;
    @FXML
    private Label label_add_response;
    @FXML
    private Pane pnl_reservations;
    @FXML
    private Button btn_reservation_send;
    @FXML
    private Button btn_reservation_clear;
    @FXML
    private TextField name_reservation;
    @FXML
    private TextField n_seats_reservation;
    @FXML
    private ListView<?> list_reservations;
    @FXML
    private Label label_reservation_response;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showMenu(ActionEvent event) {
    }

    @FXML
    private void showReservations(ActionEvent event) {
    }

    @FXML
    private void toHomepage(ActionEvent event) {
    }

    @FXML
    private void searchView(MouseDragEvent event) {
    }

    @FXML
    private void addDish(ActionEvent event) {
    }

    @FXML
    private void clearInputs(ActionEvent event) {
    }

    @FXML
    private void showCourses(MouseEvent event) {
    }

    @FXML
    private void addReservation(ActionEvent event) {
    }
    
}
