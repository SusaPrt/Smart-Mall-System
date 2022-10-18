/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Model.administration.Customer;
import Model.administration.Person;
import Model.administration.Staff;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginViewController implements Initializable {
    private MainApplication mainApp;

    @FXML
    private TextField sign_up_username;    
    @FXML
    private TextField sign_in_username;
    @FXML
    private PasswordField sign_up_password;
    @FXML
    private PasswordField sign_in_password;
    @FXML
    private Button btn_sign_in;
    @FXML
    private Button btn_sign_up;
    @FXML
    private Label label_error_sign_in;
    @FXML
    private Label label_error_sign_up;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*Carica un immagine
        File nomeFile = new File("percorso image");
        Image nomeImgae = new Image(nomeFile.toURI().toString());
        nomeFXML.setImage(nomeImage);
        */
        this.mainApp = new MainApplication();
       
    }    
    
    @FXML
    public void signIn(ActionEvent event) {
        String userName = this.sign_in_username.getText();
        String userPwd = this.sign_in_password.getText();
        Person p = this.mainApp.getAdminstration().getArchive().getAccount(userName, userPwd);
        
        if(this.mainApp.getAdminstration().getArchive().autentication(userName, userPwd)) {
            if( p instanceof Staff){
                Staff s = (Staff)p;
                // richiamo view per STAFF
            }else{
                Customer c = (Customer)p;
                //richiamo view per CUSTOMER
            }
        } else {
            this.label_error_sign_in.setText("Error: try again");
        }
    }

    @FXML
    private void signUp(ActionEvent event) {
        String userName = this.sign_in_username.getText();
        String userPwd = this.sign_in_password.getText();
        
        if(!userName.isBlank() && !userPwd.isBlank()) {
            this.mainApp.getAdminstration().getArchive()
                    .addPerson(new Customer(userName, userPwd, 
                            100, this.mainApp.getAdminstration()));
            // richiamo view per customer
        } else {
            this.label_error_sign_in.setText("Error: try again");
        }
    }
    
    private void switchScene() throws IOException{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("src/Views/Homepage.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Homepage");
        stage.setScene(new Scene(root, 450, 450));
        stage.show();
    }
    
}
