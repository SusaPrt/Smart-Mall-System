/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Marzio & Susanna
 */
public class App extends Application{

    @Override
    public void start(Stage primaryStage){
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Views/LoginView.fxml"));
            Scene scene = new Scene(root);
            Image icon = new Image("Model/System/DataFolder/icon.png");
            primaryStage.getIcons().add(icon);
            primaryStage.setTitle("Mall System");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            
        } catch(IOException e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }   
}
