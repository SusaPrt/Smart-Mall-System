/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers.StaffControllers;

import Controllers.MainApplication;
import Model.administration.Customer;
import Model.administration.Staff;
import Model.administration.payment.Payment;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Map;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Payments implements Initializable {
    private Parent root;
    private Stage stage;
    private Scene scene;
    private MainApplication mainApplication;
    private Staff staff;

    @FXML
    private Label label_staff_name;
    @FXML
    private Label label_staff_id;
    @FXML
    private ScrollPane scrollPane_customers;
    @FXML
    private ScrollPane scrollPane_payments;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    void setData(MainApplication mainApp, Staff s) {
        this.mainApplication = mainApp;
        this.staff = s;
        this.label_staff_id.setText(s.getId()+"");
        this.label_staff_name.setText(s.getName());
        this.showCustomers(mainApp.getAdminstration().getPayments());
    }

    @FXML
    private void toHomepage(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Views/StaffViews/HomepageStaff.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            System.out.println(ex+"\nEccezione caricamento staff homepage");
        }
        HomepageStaff sHController = loader.getController();
        sHController.setData(this.staff, this.mainApplication);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show(); 
    }

    private void showCustomers(Map<Customer, LinkedList<Payment>> payments) {
        VBox vBoxC = new VBox();
        for(Customer c : payments.keySet()) {
            BorderPane pane = createViewCustomer(c);
            vBoxC.getChildren().add(pane);
        }
        this.scrollPane_customers.setContent(vBoxC);
        this.scrollPane_customers.fitToWidthProperty().set(true);
        this.scrollPane_customers.fitToHeightProperty().set(true);
    }

    private BorderPane createViewCustomer(Customer c) {
        BorderPane pane = new BorderPane();
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        pane.setCenter(vBox);
        
        Button btn = new Button();
        btn.setMinWidth(80);
        btn.setMaxWidth(80);
        btn.setText(c.getName());
        vBox.getChildren().add(btn);
        vBox.getChildren().add(new Label());
        
        btn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showPayments(mainApplication.getAdminstration().getPaymentsByPerson(c));
            }            
        });
        return pane;
    }

    private void showPayments(LinkedList<Payment> payments) {
        VBox vBoxL = new VBox();
        for(Payment p : payments) {
            BorderPane pane = this.createViewPayment(p);
            vBoxL.getChildren().add(pane);
        }
        this.scrollPane_payments.setContent(vBoxL);
        this.scrollPane_payments.fitToWidthProperty().set(true);
        this.scrollPane_payments.fitToHeightProperty().set(true);
    }

    private BorderPane createViewPayment(Payment p) {
        BorderPane pane = new BorderPane();
        pane.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER_LEFT);
        pane.setCenter(vBox);
        
        vBox.getChildren().add(new Label(p.toString()));
        vBox.getChildren().add(new Label());
        return pane;
    }
    
}
