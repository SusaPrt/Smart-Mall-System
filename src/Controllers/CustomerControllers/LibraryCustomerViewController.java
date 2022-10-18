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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Mars_DB
 */
public class LibraryCustomerViewController implements Initializable {

    private Button btnAllBooks;
    private Button btnSearch;
    private Pane pnlAllBooks;
    private Pane pnlSearch;
    private Pane pnlCLoans;
    @FXML
    private Button btn_all_books;
    @FXML
    private Button btn_search;
    @FXML
    private Button btn_your_loans;
    @FXML
    private Button btn_back;
    @FXML
    private Label label_name_enterprise;
    @FXML
    private Pane pnl_search;
    @FXML
    private ListView<?> list_search;
    @FXML
    private Button btn_send_search;
    @FXML
    private TextField search_string;
    @FXML
    private ChoiceBox<?> choise_search;
    @FXML
    private Button btn_clear_search;
    @FXML
    private Pane pnl_your_loans;
    @FXML
    private ListView<?> list_your_loans;
    @FXML
    private Pane pnl_all_books;
    @FXML
    private ListView<?> list_all_books;

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

    @FXML
    private void showAllBooks(javafx.event.ActionEvent event) {
    }

    @FXML
    private void showSearch(javafx.event.ActionEvent event) {
    }

    @FXML
    private void showYourLoans(javafx.event.ActionEvent event) {
    }

    @FXML
    private void toHomepage(javafx.event.ActionEvent event) {
    }

    @FXML
    private void searchBookBy(javafx.event.ActionEvent event) {
    }

    @FXML
    private void showParameters(MouseEvent event) {
    }

    @FXML
    private void clearInputs(javafx.event.ActionEvent event) {
    }
    
}
