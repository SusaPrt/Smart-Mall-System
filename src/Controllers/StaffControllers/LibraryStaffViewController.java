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
public class LibraryStaffViewController implements Initializable {

    @FXML
    private Button btn_books;
    @FXML
    private Button btn_add;
    @FXML
    private Button btn_loans;
    @FXML
    private Button btn_back;
    @FXML
    private Label label_name_enterprise;
    @FXML
    private Pane pnl_loans;
    @FXML
    private Button btn_loan_send;
    @FXML
    private Button btn_loan_clear;
    @FXML
    private ChoiceBox<?> choice_customer_loan;
    @FXML
    private ChoiceBox<?> choice_book_loan;
    @FXML
    private ListView<?> list_loans;
    @FXML
    private Pane pnl_add;
    @FXML
    private TextField name_new_book;
    @FXML
    private TextField author_new_book;
    @FXML
    private TextField price_new_book;
    @FXML
    private TextField quantity_new_book;
    @FXML
    private TextField year_new_book;
    @FXML
    private TextField genre_new_book;
    @FXML
    private TextField isbn_new_book;
    @FXML
    private Button btn_add_send;
    @FXML
    private Label label_add_response;
    @FXML
    private Button btn_add_clear;
    @FXML
    private Pane pnl_books;
    @FXML
    private ListView<?> list_books;
    @FXML
    private Button btn_clear_search;
    @FXML
    private TextField search_parameter;
    @FXML
    private ChoiceBox<?> choise_search;
    @FXML
    private Button btn_send_search;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showAllBooks(ActionEvent event) {
    }

    @FXML
    private void searchView(MouseDragEvent event) {
    }

    @FXML
    private void showYourLoans(ActionEvent event) {
    }

    @FXML
    private void toHomepage(ActionEvent event) {
    }

    @FXML
    private void addLoan(ActionEvent event) {
    }

    @FXML
    private void clearInputsLoan(ActionEvent event) {
    }

    @FXML
    private void showCustomer(MouseEvent event) {
    }

    @FXML
    private void showBooks(MouseEvent event) {
    }

    @FXML
    private void addBook(ActionEvent event) {
    }

    @FXML
    private void clearInputs(ActionEvent event) {
    }

    @FXML
    private void searchBookBy(ActionEvent event) {
    }
    
}
