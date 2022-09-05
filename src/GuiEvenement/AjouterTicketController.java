/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GuiEvenement;

import ServiceEvenTun.eventservice;
import UtilData.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class AjouterTicketController implements Initializable {

    @FXML
    private Button Ticketx;
    @FXML
    private TextField NTicketx;
    @FXML
    private TextField Pux;

    private Connection cnx = DataSource.getInstance().getConnection();
    private PreparedStatement pst;
    private ResultSet rs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ajoutticket(ActionEvent event) {
        if ((NTicketx.getText().length() == 0)) {

            NTicketx.setStyle("-fx-border-color: red ; -fx-border-width: 2px;");
            new animatefx.animation.Shake(NTicketx).play();

        } else {
            NTicketx.setStyle(null);
        }


        if ((Pux.getText().length() == 0)) {

            Pux.setStyle("-fx-border-color: red ; -fx-border-width: 2px;");
            new animatefx.animation.Shake(Pux).play();

        } else {
            Pux.setStyle(null);
        }

        try {
            String requete = "insert into tickets (numero,prix,promotion) values(?,?,?)";
            
            try {
                pst = cnx.prepareStatement(requete);
            } catch (SQLException ex) {
                Logger.getLogger(eventservice.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            pst.setString(1, NTicketx.getText());
            pst.setString(2, Pux.getText());
            pst.setString(3, null);
           
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(eventservice.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    }
    
    
