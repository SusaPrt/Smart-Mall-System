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
    public void start(Stage primaryStage) throws Exception {
        MainApplication application = new MainApplication();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("src/Views/LoginView.fxml"));
            primaryStage.setTitle("Login");
            primaryStage.setScene(new Scene(root, 450, 450));
            primaryStage.show();
        } catch(IOException e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }   
}
