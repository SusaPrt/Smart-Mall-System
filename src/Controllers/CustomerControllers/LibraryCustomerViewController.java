/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers.CustomerControllers;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Mars_DB
 */
public class LibraryCustomerViewController implements Initializable {

    @FXML
    private Text name;
    @FXML
    private Button btnAllBooks;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnCLoans;
    @FXML
    private Button btnBack;
    @FXML
    private Pane pnlAllBooks;
    @FXML
    private Pane pnlSearch;
    @FXML
    private Pane pnlCLoans;

    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == this.btnAllBooks)
            this.pnlAllBooks.toFront();
        else if(event.getSource() == this.btnSearch)
            this.pnlSearch.toFront();
        else 
            this.pnlCLoans.toFront();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void searchView(MouseDragEvent event) {
    }
    
}
