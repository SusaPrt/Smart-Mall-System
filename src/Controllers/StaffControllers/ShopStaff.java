/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers.StaffControllers;

import Controllers.MainApplication;
import Model.administration.Item;
import Model.administration.Staff;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//@author Susanna

public class ShopStaff implements Initializable {
    private MainApplication mainApplication;
    private Staff staff;
    private Shop shop;
    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    private TextField name_new_item;
    @FXML
    private TextField price_new_item;
    @FXML
    private TextField quantity_new_item;
    @FXML
    private Label label_response;
    @FXML
    private ScrollPane scrollPane_items;
    @FXML
    private Label label_name_enterprise;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    public void setData(Staff s, Shop sh, MainApplication mainApp) {
        this.mainApplication = mainApp;
        this.staff = s;
        this.shop = sh;       
        this.label_name_enterprise.setText(sh.getName());
        this.showItems(sh);
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
        stage.show(); 
    }

    @FXML
    private void addItem(ActionEvent event) {
        String name = this.name_new_item.getText();
        double price = Double.parseDouble(this.price_new_item.getText());
        int quantity = Integer.parseInt(this.quantity_new_item.getText());
        if(!(name == null) && price > 0 && quantity >= 0) {
            this.shop.addItem(name, price, quantity);
            this.label_response.setText("Item " + name + " added!");
            this.showItems(this.shop);
        }
    }

    @FXML
    private void clearInputs(ActionEvent event) {
        this.label_response.setText(" ");
        this.name_new_item.clear();
        this.price_new_item.clear();
        this.quantity_new_item.clear();
    }

    private void showItems(Shop sh) {
        VBox vBox = new VBox();
        for(Item i : this.shop.getWarehouse()) {
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
        vBox1.getChildren().add(new Label("Quantity: " + i.getQuantity()));
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
                boolean done = shop.removeItem(i);
                if(done) {
                    label_response.setText("Dish removed!");
                    showItems(shop);
                } else
                    label_response.setText("ERROR");
            }
        });
        
        return pane;
    }
    
}
