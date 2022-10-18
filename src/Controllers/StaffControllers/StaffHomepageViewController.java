/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers.StaffControllers;

import Controllers.MainApplication;
import Model.administration.Staff;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mars_DB
 */
public class StaffHomepageViewController implements Initializable {
    private MainApplication mainApplication;
    private Staff staff;

    @FXML
    private Label label_staff_name;
    @FXML
    private Label label_staff_id;
    @FXML
    private Button btn_logout;
    @FXML
    private TextField name_new_library;
    @FXML
    private TextField name_new_restaurant;
    @FXML
    private TextField name_new_shop;
    @FXML
    private TextField n_seats_new_restaurant;
    @FXML
    private Button btn_send;
    @FXML
    private Button btn_clear;
    @FXML
    private ListView<?> list_libreries;
    @FXML
    private ListView<?> list_restaurants;
    @FXML
    private ListView<?> list_shops;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    public void setData(Staff s, MainApplication mainApp) {
        this.mainApplication = mainApp;
        this.staff = s;
    }

    @FXML
    private void toLogin(ActionEvent event) {
    }

    @FXML
    private void addEnterprise(ActionEvent event) {
    }

    @FXML
    private void clearInputs(ActionEvent event) {
    }
    
}
