/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Model.administration.Archive;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginViewController implements Initializable {
    
    private MainApplication app;

    @FXML
    private TextField sign_up_username;
    @FXML
    private PasswordField sign_in_password;
    @FXML
    private TextField sign_in_username;
    @FXML
    private PasswordField sign_up_password;
    @FXML
    private Button btn_sign_in;
    @FXML
    private Button btn_sign_up;
    @FXML
    private Label error_sign_in;
    @FXML
    private Label error_sign_up;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*Carica un immagine
        File nomeFile = new File("percorso image");
        Image nomeImgae = new Image(nomeFile.toURI().toString());
        nomeFXML.setImage(nomeImage);
        */
        
    }    
    
    @FXML
    public void signIn(ActionEvent event) {
        if(this.sign_in_username.getText().isBlank() == false && this.sign_in_password.getText().isBlank() == false) {

            if() {
                
            }
        } else {
            this.error_sign_in.setText("Error: try again");
        }
    }

    @FXML
    private void signUp(ActionEvent event) {
        if(this.sign_in_username.getText().isBlank() == false && this.sign_in_password.getText().isBlank() == false) {
            
        } else {
            this.error_sign_in.setText("Error: try again");
        }
    }
    
}
