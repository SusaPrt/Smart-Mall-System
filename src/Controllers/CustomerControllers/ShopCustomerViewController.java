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
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Mars_DB
 */
public class ShopCustomerViewController implements Initializable {

    @FXML
    private Text txt_name_enterprise;
    @FXML
    private Button btn_items;
    @FXML
    private Button btn_back;
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

    @FXML
    private void showItems(ActionEvent event) {
    }

    @FXML
    private void homePage(ActionEvent event) {
    }
    
}
