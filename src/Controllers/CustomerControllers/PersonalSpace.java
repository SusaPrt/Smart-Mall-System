/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers.CustomerControllers;

import Controllers.LoginViewController;
import Controllers.MainApplication;
import Model.administration.Customer;
import Model.administration.Item;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//@Author Susanna

public class PersonalSpace implements Initializable {
    private MainApplication mainApplication;
    private Customer customer;
    private Parent root;
    private Stage stage;
    private Scene scene;
    
    @FXML
    private Label label_user_id;
    @FXML
    private Label label_user_credit;
    @FXML
    private ScrollPane scrollPane_cart;
    @FXML
    private TextField credit_to_add;
    @FXML
    private Label label_user_name;
    @FXML
    private Text label_response;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }  
    void setData(MainApplication mainApp, Customer c) {
        this.mainApplication = mainApp;
        this.customer = c;
        this.label_response.setText("");
        this.label_user_name.setText(c.getName());
        this.label_user_id.setText(""+c.getId());
        this.label_user_credit.setText(""+c.getCredit());
        this.showCart(c);
    }
    @FXML
    private void toLogin(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Views/LoginView.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            System.out.println(ex+"\nEccezione caricamento customer homepage");
        }
        LoginViewController lVcontroller = loader.getController();
        lVcontroller.setData(this.mainApplication);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void payCart(ActionEvent event) {
        boolean done = this.customer.payTheCart();
        if(done) {
            for(Item i : this.customer.getCart().getProducts())
                this.customer.getCart().removeProducts(i);
            this.showCart(customer);
            this.label_response.setText("Payment made");
        } else {
            this.label_response.setText("ERROR");
        }
    }

    @FXML
    private void addCredit(ActionEvent event) {
        this.customer.addCredit(Double.parseDouble(this.credit_to_add.getText()));
        this.label_user_credit.setText(""+this.customer.getCredit());
    }

    @FXML
    private void toHomepage(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Views/CustomerViews/HomepageCustomer.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            System.out.println(ex+"\nEccezione caricamento customer homepage");
        }
        Homepage cHController = loader.getController();
        cHController.setData(this.customer, this.mainApplication);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void showCart(Customer c) {
        VBox vBox = new VBox();       
        for(Item i : c.getCart().getProducts()) {
            BorderPane pane = this.createViewItem(i);
            vBox.getChildren().add(pane);
        }
        this.scrollPane_cart.setContent(vBox);
        this.scrollPane_cart.fitToWidthProperty().set(true);
        this.scrollPane_cart.fitToHeightProperty().set(true);
    }

    private BorderPane createViewItem(Item i) {
        BorderPane pane = new BorderPane();
        pane.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        VBox vBox1 = new VBox();
        vBox1.setAlignment(Pos.CENTER_LEFT);
        pane.setLeft(vBox1);
        
        vBox1.getChildren().add(new Label("Name: " + i.getName()));
        vBox1.getChildren().add(new Label("Price: " + i.getPrice()));
        vBox1.getChildren().add(new Label());
        
        VBox vBox2 = new VBox();
        vBox2.setAlignment(Pos.CENTER);
        pane.setRight(vBox2);
        
        Button btnRemove = new Button();
        btnRemove.setText("Remove");
        vBox2.getChildren().add(btnRemove);
        btnRemove.setAlignment(Pos.CENTER);
        
        btnRemove.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                customer.getCart().removeProducts(i);
                i.increaseQuantity(1);
                showCart(customer);
            }
        });
        
        return pane;    
    }

    
    
}
