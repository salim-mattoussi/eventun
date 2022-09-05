/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GuiPromotion;

import ServiceEvenTun.PromotionService;
import UtilData.DataSource;
import gestionevenement.Tickets;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author SALIM
 */
public class ImprimeTiketsController implements Initializable {

  
    @FXML
    private TextField prom;
     private Connection cnx  = DataSource.getInstance().getConnection();;
        
    private Statement ste;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    
    

    
}
