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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Mars_DB
 */
public class ShopStaffViewController implements Initializable {

    @FXML
    private Text txt_name_enterprise;
    @FXML
    private Button btn_items;
    @FXML
    private Button btn_back;
    @FXML
    private Pane pnl_items;
    @FXML
    private ListView<?> list_items;
    @FXML
    private TextField name_new_item;
    @FXML
    private TextField price_new_item;
    @FXML
    private TextField quantity_new_item;
    @FXML
    private Button btn_add_send;
    @FXML
    private Button btn_add_clear;
    @FXML
    private Label label_add_response;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showItems(ActionEvent event) {
    }

    @FXML
    private void toHomepage(ActionEvent event) {
    }

    @FXML
    private void addItem(ActionEvent event) {
    }

    @FXML
    private void clearInputs(ActionEvent event) {
    }
    
}
