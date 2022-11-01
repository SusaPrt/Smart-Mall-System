/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import Controllers.MainApplication;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

    @Override
    public void start(Stage primaryStage){
        
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Views/LoginView.fxml"));
            //fxmlLoader.setLocation(getClass().getResource("Views/CustomerViews/HomepageCustomer.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("Login");
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch(IOException e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }   
}
