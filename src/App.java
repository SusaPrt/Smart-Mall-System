
import Controllers.LoginViewController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author Mars_DB
 */
public class App extends Application{

    /**
     * @param args the command line arguments
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        MainApplication application = new MainApplication();    // CLASSE CHE DEVO MANDARE AI CONTROLLER
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/Controllers/LoginViewController.fxml"));
            Parent root = FXMLLoader.load(getClass().getResource("/Controllers/LoginViewController.fxml"));
            
          //  LoginViewController loginViewController = root.getC;
            Scene scene = new Scene(root);
            /*
            Image icon = new Image("icon.png");
            primaryStage.getIcons().add(icon);
            */
            primaryStage.setResizable(false);
            
            primaryStage.setTitle("Drink It Safe!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {}
        
        /*QUI ANDRO' A INSTAZIARE LE CLASSI FXMLLOADER*/
        
        
    }
    public static void main(String[] args) {
        launch(args);
    }   
}
