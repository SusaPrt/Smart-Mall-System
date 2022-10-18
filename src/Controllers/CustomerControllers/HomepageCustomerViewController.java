/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers.CustomerControllers;

import Controllers.MainApplication;
import Model.administration.Customer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Mars_DB
 */
public class HomepageCustomerViewController implements Initializable {
    private MainApplication mainApplication;
    private Customer customer;
    
    @FXML
    private Label label_user_name;
    @FXML
    private Label label_user_id;
    @FXML
    private Button btn_logout;
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
    public void setData(Customer c, MainApplication mainApp){
        this.customer = c;
        this.mainApplication = mainApp;
    }
    
}
