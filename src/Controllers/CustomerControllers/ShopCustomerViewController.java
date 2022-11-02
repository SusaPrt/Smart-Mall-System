/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers.CustomerControllers;

import Model.administration.Customer;
import Model.enterprises.shop.Shop;
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
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Mars_DB
 */
public class ShopCustomerViewController implements Initializable {
    private Shop shop;
    private Customer customer;
    @FXML
    private Button btn_back;
    @FXML
    private Label label_name_enterprise;
    @FXML
    private Button btn_items;
    @FXML
    private Pane pnl_your_loans;
    @FXML
    private ListView<?> list_items;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setData(Customer customer, Shop s) {
        this.customer = customer;
        this.shop = s;
    }
    @FXML
    private void toHomepage(ActionEvent event) {
    }

    @FXML
    private void showItems(ActionEvent event) {
    }

   



    
}
