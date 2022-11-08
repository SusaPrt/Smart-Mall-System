/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers.CustomerControllers;

import Controllers.MainApplication;
import Model.administration.Customer;
import Model.administration.Item;
import Model.enterprises.shop.Shop;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//@author Susanna

public class ShopCustomer implements Initializable {
    private MainApplication mainApplication;
    private Customer customer;
    private Shop shop;
    private Parent root;
    private Stage stage;
    private Scene scene;
    
    @FXML
    private Label label_name_enterprise;
    @FXML
    private ScrollPane scrollPane_items;
    @FXML
    private Label label_response;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    void setData(Customer c, Shop s, MainApplication mainApp) {
        this.customer = c;
        this.shop = s;
        this.mainApplication = mainApp;
        this.label_name_enterprise.setText(s.getName());
        this.showItems(s);
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

    private void showItems(Shop s) {
         VBox vBox = new VBox();
         for(Item i : s.getWarehouse()) {
            BorderPane pane = this.createViewItem(i);
            vBox.getChildren().add(pane);
         }
        this.scrollPane_items.setContent(vBox);
        this.scrollPane_items.fitToWidthProperty().set(true);
        this.scrollPane_items.fitToHeightProperty().set(true);
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
        
        Button btnBuy = new Button();
        btnBuy.setText("Buy");
        vBox2.getChildren().add(btnBuy);
        btnBuy.setAlignment(Pos.CENTER);
        
        btnBuy.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                customer.getCart().addItem(i);
                label_response.setText("Item  " + i.getName() + " added!");
            }
        });
        
        return pane;
    }

    
    
}
