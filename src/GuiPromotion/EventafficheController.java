/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GuiPromotion;

import ServiceEvenTun.PromotionService;
import gestionevenement.evenement;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SALIM
 */
public class EventafficheController implements Initializable {

    @FXML
    private ImageView eventimg;
    @FXML
    private Label eventname;
    @FXML
    private Label description;
    @FXML
    private Button btnprix;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setData (evenement even){
        Image image = new Image(getClass().getResourceAsStream(even.getImagesrc()));
        eventimg.setImage(image);
        eventname.setText(even.getNom());
        description.setText(even.getDescription());
    }

    @FXML
    private void achat(ActionEvent event) throws IOException {
         Parent root=FXMLLoader.load(getClass().getResource("promographic.fxml"));      
        Stage window = (Stage)btnprix.getScene().getWindow();
        window.setScene(new Scene(root ,1000,750));
         PromotionService ps = new PromotionService();
           
        float ticket = ps.getTickets();
            ObservableList<Float> obs =FXCollections.observableArrayList(ticket);
    }
    
}
