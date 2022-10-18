/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers.CustomerControllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Mars_DB
 */
public class RestaurantCustomerViewController implements Initializable {

    @FXML
    private Button btn_menu;
    @FXML
    private Button btn_reserve;
    @FXML
    private Button btn_back;
    @FXML
    private Label label_name_enterprise;
    @FXML
    private Pane pnl_menu;
    @FXML
    private ListView<?> list_menu;
    @FXML
    private Pane pnl_reserve;
    @FXML
    private TextField name_reservation;
    @FXML
    private TextField n_seats_reservation;
    @FXML
    private Button btn_send;
    @FXML
    private Button btn_clear;
    @FXML
    private Label label_response;

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
    private void showReserve(ActionEvent event) {
    }

    @FXML
    private void toHomepage(ActionEvent event) {
    }

    @FXML
    private void searchView(MouseDragEvent event) {
    }

    @FXML
    private void addReservation(ActionEvent event) {
    }

    @FXML
    private void clearInputs(ActionEvent event) {
    }
    
}
