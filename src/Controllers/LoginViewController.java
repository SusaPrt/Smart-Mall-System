/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import Controllers.CustomerControllers.Homepage;
import Controllers.StaffControllers.HomepageStaff;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginViewController implements Initializable {
    private MainApplication mainApp;
    private Parent root;
    private Stage stage;
    private Scene scene;

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
    
    public void setData(MainApplication mainApp){
        this.mainApp = mainApp;
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
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Views/StaffViews/HomepageStaff.fxml"));
                try {
                    root = loader.load();
                } catch (IOException ex) {
                    System.out.println(ex+"\nEccezione caricamento staff homepage");
                }
                HomepageStaff sHController = loader.getController();
                sHController.setData(s, this.mainApp);
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show(); 
                
            }else{
                Customer c = (Customer)p;
                //richiamo view per CUSTOMER
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Views/CustomerViews/HomepageCustomer.fxml"));
                try {                                   
                    root = loader.load();
                } catch (IOException ex) {
                    System.out.println(ex+"\nEccezione caricamento customer homepage");
                }
                Homepage cHController = loader.getController();
                cHController.setData(c, this.mainApp);
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();       
            }
        } else {
            this.label_error_sign_in.setText("Error: try again");
        }
    }

    @FXML
    private void signUp(ActionEvent event){
        String userName = this.sign_in_username.getText();
        String userPwd = this.sign_in_password.getText();
        Customer c = null;
        
        if(!userName.isBlank() && !userPwd.isBlank()) {
            this.mainApp.getAdminstration().getArchive()
                    .addPerson(c = new Customer(userName, userPwd, 
                            100, this.mainApp.getAdminstration()));
            // richiamo view per customer
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Views/CustomerViews/HomepageCustomer.fxml"));
            try {
                root = loader.load();
            } catch (IOException ex) {
                System.out.println(ex+"\nEccezione caricamento customer homepage");
            }
            Homepage hC = loader.getController();
            hC.setData(c, this.mainApp);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show(); 
            
        } else {
            this.label_error_sign_in.setText("Error: try again");
        }
    }   
}
