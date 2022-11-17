/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers.StaffControllers.Restaurant;

import Controllers.MainApplication;
import Controllers.StaffControllers.HomepageStaff;
import Model.administration.Staff;
import Model.enterprises.restaurant.classes.Course;
import Model.enterprises.restaurant.classes.Dish;
import Model.enterprises.restaurant.classes.Menu;
import Model.enterprises.restaurant.classes.Restaurant;
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

//@author Susanna & Marzio

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
    private ChoiceBox<String> course_choise;
    @FXML
    private Label label_response;
    @FXML
    private ScrollPane scrollPane_menu;
    @FXML
    private TextField refueling;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    } 
    
    // Metodo per il caricamento del modello da controller precedente 
    public void setData(Staff s, Restaurant r, MainApplication mainApp) {
        this.mainApplication = mainApp;
        this.staff = s;
        this.restaurant = r;       
        this.label_name_enterprise.setText(r.getName());
        this.course_choise.getItems().addAll(Course.FIRSTS.getName(), Course.SECONDS.getName(), Course.DESSERTS.getName(), Course.WINESANDSOFT.getName());
        this.showMenu(r.getMenu());
    }

    @FXML
    private void showReservations(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Views/StaffViews/Restaurant/RestaurantReservations.fxml"));
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
        stage.setResizable(false);
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
        stage.setResizable(false);
        stage.show(); 
    }

    @FXML
    private void addDish(ActionEvent event) {
        String name = this.name_new_dish.getText();
        String price = this.price_new_dish.getText();
        String quantity = this.quantity_new_dish.getText();
        Course course = Course.selectType(this.course_choise.getValue());
        try {
            boolean done = this.restaurant.getMenu().addDish(name, 
                    Double.parseDouble(price), 
                    Integer.parseInt(quantity), course);
            if(done) {
                this.label_response.setText("Dish " + name + " added!");
                this.showMenu(this.restaurant.getMenu());
            } else
                this.label_response.setText("ERROR");
        } catch(NumberFormatException ex) {
            this.label_response.setText("ERROR");
        } finally {
            this.name_new_dish.clear();
            this.price_new_dish.clear();
            this.quantity_new_dish.clear();
        }
    }

    @FXML
    private void clearInputs(ActionEvent event) {
        this.label_response.setText(" ");
        this.name_new_dish.clear();
        this.price_new_dish.clear();
        this.quantity_new_dish.clear();
        this.refueling.clear();
    }

    @FXML
    private void newDay(ActionEvent event) {
        this.restaurant.newDay();
        this.label_response.setText("New day confirmed!");
    }

    // PARAMETRO MENU NON VIENE MAI LETTO - SERVE ?
    private void showMenu(Menu menu) {
        VBox vBox = new VBox();
        
        vBox.getChildren().add(new Label("FIRSTS"));        
        for(Dish d : this.restaurant.getMenu().getTypeDishes(Course.FIRSTS)) {
            BorderPane paneFirsts = this.createViewDish(d);
            vBox.getChildren().add(paneFirsts);
        }
        
        vBox.getChildren().add(new Label("SECONDS"));
        for(Dish d : this.restaurant.getMenu().getTypeDishes(Course.SECONDS)) {
            BorderPane paneSeconds = this.createViewDish(d);
            vBox.getChildren().add(paneSeconds);
        }
        
        vBox.getChildren().add(new Label("DESSERTS"));
        for(Dish d : this.restaurant.getMenu().getTypeDishes(Course.DESSERTS)) {
            BorderPane paneDesserts = this.createViewDish(d);
            vBox.getChildren().add(paneDesserts);
        }
        
        vBox.getChildren().add(new Label("WINESANDSOFT"));
        for(Dish d : this.restaurant.getMenu().getTypeDishes(Course.WINESANDSOFT)) {
            BorderPane paneWineAndSoft = this.createViewDish(d);
            vBox.getChildren().add(paneWineAndSoft);
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
        vBox1.getChildren().add(new Label("Quantity: " + d.getQuantity()));
        vBox1.getChildren().add(new Label());
        
        VBox vBox2 = new VBox();
        vBox2.setAlignment(Pos.CENTER);
        pane.setRight(vBox2);
        
        Button btnRemove = new Button();
        btnRemove.setMinWidth(80);
        btnRemove.setMaxWidth(80);
        btnRemove.setText("Remove");
        vBox2.getChildren().add(btnRemove);
        btnRemove.setAlignment(Pos.CENTER);
        
        btnRemove.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean done = restaurant.getMenu().removeDish(d);
                if(done) {
                    label_response.setText("Dish " +d.getName() + " removed!");
                    showMenu(restaurant.getMenu());
                } else
                    label_response.setText("ERROR");
            }
        });
        
        Button btnAdd = new Button();
        btnAdd.setMinWidth(80);
        btnAdd.setMaxWidth(80);
        btnAdd.setText("Refueling");
        vBox2.getChildren().add(btnAdd);
        btnAdd.setAlignment(Pos.CENTER_LEFT);
        
        btnAdd.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String ref = refueling.getText();
                try {
                    boolean done = restaurant.refueling(d, Integer.parseInt(ref));
                    if(done) {                        
                        label_response.setText("Refueling " +d.getName());
                        showMenu(restaurant.getMenu());
                    } else                 
                        label_response.setText("ERROR");
                } catch(NumberFormatException ex) {
                    label_response.setText("ERROR");
                } finally {
                    refueling.clear();
                }
            }
        });
        
        return pane;
    }
}
