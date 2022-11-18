/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers.CustomerControllers;

import Controllers.LoginViewController;
import Controllers.MainApplication;
import Model.administration.Customer;
import Model.administration.Item;
import Model.administration.payment.Payment;
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
import javafx.stage.Stage;

//@Author Susanna & Marzio

public class PersonalSpace implements Initializable {
    private Parent root;
    private Stage stage;
    private Scene scene;
    private MainApplication mainApplication;
    private Customer customer;
    
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
    private Label label_response;
    @FXML
    private Label label_cost;
    @FXML
    private ScrollPane scrollPane_payments;
    @FXML
    private Label label_total;

    @Override
    public void initialize(URL url, ResourceBundle rb) {}  
    
    // Metodo per il caricamento del modello da controller precedente
    void setData(MainApplication mainApp, Customer c) {
        this.mainApplication = mainApp;
        this.customer = c;
        this.label_response.setText("");
        this.label_user_name.setText(c.getName());
        this.label_user_id.setText(""+c.getId());
        this.label_user_credit.setText(""+c.getCredit()+" €");
        this.showCart(c);
        this.showPayments(c);
        this.label_cost.setText(c.getCart().getTotCost() + " €");
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
        
        this.mainApplication.saveDatas();
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void payCart(ActionEvent event) {
        boolean done = this.customer.payTheCart(this.mainApplication.getAdminstration());
        if(done) {  
            this.label_user_credit.setText(""+this.customer.getCredit()+" €");
            this.showCart(customer);
            this.label_response.setText("Payment made");
            this.label_cost.setText(this.customer.getCart().getTotCost() + " €");
            
            this.showPayments(this.customer);
        } else {
            this.label_response.setText("ERROR");
        }
    }

    @FXML
    private void addCredit(ActionEvent event) {
        String credit = this.credit_to_add.getText();
        try{            
            this.customer.addCredit(Double.parseDouble(credit));
            this.label_user_credit.setText(""+this.customer.getCredit()+" €");
            this.label_response.setText("Credit added");
        } catch(NumberFormatException ex){
            this.label_response.setText("ERROR");
        } finally {
            this.credit_to_add.clear();
        }
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
                label_cost.setText(customer.getCart().getTotCost() + " €");
            }
        });     
        return pane;    
    } 

    private void showPayments(Customer c) {
        VBox vBox = new VBox(); 
        int counter = 0;
        double totalCost = 0;
        if(this.mainApplication.getAdminstration().getPaymentsByPersonId(this.customer.getId()) != null){
            for(Payment p : this.mainApplication.getAdminstration().getPaymentsByPersonId(this.customer.getId())){
                counter++;
                totalCost += p.getCost();
                BorderPane pane = this.createViewPayment(p, counter);
                vBox.getChildren().add(pane);
            }          
            this.scrollPane_payments.setContent(vBox);
            this.scrollPane_payments.fitToWidthProperty().set(true);
            this.scrollPane_payments.fitToHeightProperty().set(true);
        }
        this.label_total.setText(totalCost+" €");
    }

    private BorderPane createViewPayment(Payment p, int i) {
        BorderPane pane = new BorderPane();
        pane.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        VBox vBox1 = new VBox();
        vBox1.setAlignment(Pos.CENTER_LEFT);
        pane.setLeft(vBox1);
        
        vBox1.getChildren().add(new Label("Payment: #" + i));
        vBox1.getChildren().add(new Label("Cost: " + p.getCost()+" €"));
        vBox1.getChildren().add(new Label());    
    
        return pane;
    }
}
