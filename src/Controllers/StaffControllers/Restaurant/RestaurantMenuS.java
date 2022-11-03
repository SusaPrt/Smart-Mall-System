/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers.StaffControllers.Restaurant;

import Controllers.MainApplication;
import Controllers.StaffControllers.HomepageStaff;
import Model.administration.Staff;
import Model.enterprises.restaurant.Course;
import Model.enterprises.restaurant.Dish;
import Model.enterprises.restaurant.Menu;
import Model.enterprises.restaurant.Restaurant;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//@author Susanna

public class RestaurantMenuS implements Initializable {
    private MainApplication mainApplication;
    private Staff staff;
    private Restaurant restaurant;
    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    private Label label_name_enterprise;
    @FXML
    private TextField name_new_dish;
    @FXML
    private TextField price_new_dish;
    @FXML
    private TextField quantity_new_dish;
    @FXML
    private ChoiceBox<Course> course_choise;
    @FXML
    private Label label_response;
    @FXML
    private ScrollPane scrollPane_menu;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    public void setData(Staff s, Restaurant r, MainApplication mainApp) {
        this.mainApplication = mainApp;
        this.staff = s;
        this.restaurant = r;       
        this.label_name_enterprise.setText(r.getName());
        this.course_choise.getItems().addAll(Course.FIRSTS, Course.SECONDS, Course.DESSERTS, Course.WINESANDSOFT);
        this.showMenu(r.getMenu());
    }

    @FXML
    private void showReservations(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Views/StaffViews/RestaurantReservations.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            System.out.println(ex+"\nEccezione caricamento staff restaurant reservations");
        }
        RestaurantReservations sRRController = loader.getController();
        sRRController.setData(this.staff, this.restaurant, this.mainApplication);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
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
    private void addDish(ActionEvent event) {
        String name = this.name_new_dish.getText();
        double price = Double.parseDouble(this.price_new_dish.getText());
        int quantity = Integer.parseInt(this.quantity_new_dish.getText());
        Course course = this.course_choise.getValue();
        if(!(name == null) && price >= 0 && quantity > 0 && !(course == null)) {
            this.restaurant.getMenu().addDish(name, price, quantity, course);
            this.showMenu(this.restaurant.getMenu());
        }
    }

    @FXML
    private void clearInputs(ActionEvent event) {
        this.label_response.setText(" ");
        this.name_new_dish.clear();
        this.price_new_dish.clear();
        this.quantity_new_dish.clear();
    }

    private void showMenu(Menu menu) {
        VBox vBox = new VBox();
        
        vBox.getChildren().add(new Label("FIRSTS"));        
        for(Dish d : this.restaurant.getMenu().getAvailableTypeDishes(Course.FIRSTS)) {
            BorderPane pane = this.createViewDish(d);
            vBox.getChildren().add(pane);
        }
        
        vBox.getChildren().add(new Label("SECONDS"));
        for(Dish d : this.restaurant.getMenu().getAvailableTypeDishes(Course.SECONDS)) {
            BorderPane pane = this.createViewDish(d);
            vBox.getChildren().add(pane);
        }
        
        vBox.getChildren().add(new Label("DESSERTS"));
        for(Dish d : this.restaurant.getMenu().getAvailableTypeDishes(Course.DESSERTS)) {
            BorderPane pane = this.createViewDish(d);
            vBox.getChildren().add(pane);
        }
        
        vBox.getChildren().add(new Label("WINESANDSOFT"));
        for(Dish d : this.restaurant.getMenu().getAvailableTypeDishes(Course.WINESANDSOFT)) {
            BorderPane pane = this.createViewDish(d);
            vBox.getChildren().add(pane);
        }
              
        this.scrollPane_menu.setContent(vBox);
        this.scrollPane_menu.fitToWidthProperty().set(true);
        this.scrollPane_menu.fitToHeightProperty().set(true);
    }
    
    private BorderPane createViewDish(Dish d) {
        BorderPane pane = new BorderPane();
        pane.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        VBox vBox1 = new VBox();
        vBox1.setAlignment(Pos.CENTER_LEFT);
        pane.setLeft(vBox1);
        
        vBox1.getChildren().add(new Label("Name: " + d.getName()));
        vBox1.getChildren().add(new Label("Price: " + d.getPrice()));
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
                boolean done = restaurant.getMenu().removeDish(d);
                if(done) {
                    label_response.setText("Reservation removed!");
                    showMenu(restaurant.getMenu());
                } else
                    label_response.setText("ERROR");
            }
        });
        
        return pane;
    }

    @FXML
    private void newDay(ActionEvent event) {
        this.restaurant.newDay();
    }
    
}
