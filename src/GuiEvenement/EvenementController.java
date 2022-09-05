/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GuiEvenement;

import ServiceEvenTun.eventservice;
import UtilData.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class EvenementController implements Initializable {

    @FXML
    private DatePicker Datex;
    @FXML
    private TextField Nomx;
    @FXML
    private TextField Lieux;
    @FXML
    private TextField Descriptionx;
    
    @FXML
    private Button ajouterx;
    @FXML
    private Button Annulerx;

   
    private Connection cnx = DataSource.getInstance().getConnection();
     
   // private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
   private Stage stage ;
       protected Scene scene;
       private Parent root;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Verifier(ActionEvent event) throws IOException, ParseException {
        if ((Nomx.getText().length() == 0)) {

            Nomx.setStyle("-fx-border-color: red ; -fx-border-width: 2px;");
            new animatefx.animation.Shake(Nomx).play();

        } else {
            Nomx.setStyle(null);
        }
        String date = String.valueOf(Datex.getValue());
        if (date.isEmpty()) {

            Datex.setStyle("-fx-border-color: red ; -fx-border-width: 2px;");
            new animatefx.animation.Shake(Datex).play();

        } else {
            Datex.setStyle(null);
        }

        if ((Lieux.getText().length() == 0)) {

            Lieux.setStyle("-fx-border-color: red ; -fx-border-width: 2px;");
            new animatefx.animation.Shake(Lieux).play();

        } else {
            Lieux.setStyle(null);
        }

        if ((Descriptionx.getText().length() == 0)) {

            Descriptionx.setStyle("-fx-border-color: red ; -fx-border-width: 2px;");
            new animatefx.animation.Shake(Descriptionx).play();

        } else {
            Descriptionx.setStyle(null);
        }
        
  //              if ((Imagex.getText().length() == 0)) {

//            Imagex.setStyle("-fx-border-color: red ; -fx-border-width: 2px;");
//            new animatefx.animation.Shake(Imagex).play();
//
//        } else {
//            Imagex.setStyle(null);
 if ((Nomx.getText().length()!=0)&&(Lieux.getText().length()!=0)&&(Descriptionx.getText().length()!=0)&& !(date.isEmpty())){
   
        try {
            String requete = "insert into evenement (nom,lieu,dateevent,description) values(?,?,?,?)";
            
            try {
                pst = cnx.prepareStatement(requete);
            } catch (SQLException ex) {
                Logger.getLogger(eventservice.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            pst.setString(1, Nomx.getText());
            pst.setString(2, Lieux.getText());
            pst.setString(4, Descriptionx.getText());
            pst.setString(3, ((TextField)Datex.getEditor()).getText());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(eventservice.class.getName()).log(Level.SEVERE, null, ex);
        }
        Parent root = FXMLLoader.load(getClass().getResource("AjouterTicket.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
             scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
     //  if ((Nomx.getText().length()!=0)&&(Lieux.getText().length()!=0)&&(Descriptionx.getText().length()!=0)){
//          Parent root = FXMLLoader.load(getClass().getResource("AjouterTicket.fxml"));
//        
//        
//       stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//                scene= new Scene(root);
//                stage.setScene(scene);
//                stage.show();
//    }
         //  System.out.println("test");
 

    }
    }
}
