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
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application{

    @Override
    public void start(Stage primaryStage){
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Views/LoginView.fxml"));
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("Login");
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch(IOException e) {
            System.out.println(e);
        }
/*
        Button btnl = new Button("Hello World");
        StackPane root = new StackPane();
        root.getChildren().add(btnl);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Prova JavaFX application");
        primaryStage.show();
*/
    }
    public static void main(String[] args) {
        launch(args);
    }   
}
