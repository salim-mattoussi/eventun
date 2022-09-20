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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SALIM
 */
public class CardController implements Initializable {

    @FXML
    private HBox box;
    @FXML
    private ImageView partyimg;
    @FXML
    private Label partydet;
    @FXML
    private Label descparty;
    @FXML
    private Button btnachat;
     protected float ticket;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private String [] colors ={"B9E5FF" , "BDB2FE" , "FB9AA8", "FF5056"};
    public void setData (evenement even){
        Image image = new Image(getClass().getResourceAsStream(even.getImagesrc())) ;
        partyimg.setImage(image);
        partydet.setText(even.getNom());
        descparty.setText(even.getDescription());
        box.setStyle("-fx-background-color :#"+ colors[(int) (Math.random() * colors.length)]+";"+"-fx-background-radius: 15;"
        +"-fx-effect: dropShadow(three-pass-box, rgba(0,0,0,0.1), 10, 0 ,0 ,10);");
    }

    @FXML
    private void acheter(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("promographic.fxml"));      
        Stage window = (Stage)btnachat.getScene().getWindow();
        window.setScene(new Scene(root ,1000,750));
         PromotionService ps = new PromotionService();
           
                        ticket = ps.getTickets();
            ObservableList<Float> obs =FXCollections.observableArrayList(ticket);
    }
    
}
