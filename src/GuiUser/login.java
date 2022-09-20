/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiUser;

//<<<<<<< HEAD
//=======
import java.io.IOException;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//>>>>>>> master
/**
 *
 * @author panda
 */
public class login extends Application {

    @Override
//<<<<<<< HEAD
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("logininterface.fxml"));

        Scene scene = new Scene(root);

        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

////=======
//   public void start(Stage primaryStage) throws IOException {
//        Parent root=FXMLLoader.load(getClass().getResource("logininterface.fxml"));
//        Scene scene = new Scene(root);
//        
//        primaryStage.setTitle("Login page !");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//>>>>>>> master
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
//<<<<<<< HEAD

    }

//=======
}

//    
//>>>>>>> master

