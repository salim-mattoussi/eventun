/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package GuiPublicite;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author wissem
 */
public class Publicite extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
  Parent root= FXMLLoader.load(getClass().getClassLoader().getResource("GuiPublicite/FormulairePublicite.fxml"));   
        Scene scene = new Scene(root);
        
       primaryStage.setTitle("ajouter publicite");
        primaryStage.setScene(scene);
        primaryStage.show();
       
        
    }
    
    

  public static void main(String[] args) {
        launch(args);
    }
}