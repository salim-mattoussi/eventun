/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GuiPromotion;

import ServiceEvenTun.PromotionService;
import gestionevenement.Tickets;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author SALIM
 */
public class TestButtomController implements Initializable {

    @FXML
    private Button acheter;
    
    public void achatTick () throws IOException{
        Parent root=FXMLLoader.load(getClass().getResource("promographic.fxml"));
        
        Stage window = (Stage)acheter.getScene().getWindow();
        window.setScene(new Scene(root ,750,500));
         PromotionService ps = new PromotionService();
            ArrayList<Tickets> list = ps.getTickets();
            ObservableList<Tickets> obs =FXCollections.observableArrayList(list);
            System.out.println(obs);
           // System.out.println(obs.get(3));
            
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
//    public void MontantTicket (){
//            PromotionService ps = new PromotionService();
//            ArrayList<Tickets> list = ps.getTickets();
//            ObservableList<Tickets> obs =FXCollections.observableArrayList(list);
////            montant.setText(list.prix);
//        }
}
