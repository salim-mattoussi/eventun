/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GuiEvenement;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class GestionEvenementController implements Initializable {

    @FXML
    private TableView<?> tablex;
    @FXML
    private TableColumn<?, ?> col_nom;
    @FXML
    private TableColumn<?, ?> col_lieu;
    @FXML
    private TableColumn<?, ?> col_dateevent;
    @FXML
    private TableColumn<?, ?> col_descption;
    @FXML
    private TableColumn<?, ?> col_nbrticket;
    @FXML
    private TableColumn<?, ?> col_prix;
    @FXML
    private TableColumn<?, ?> col_etat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
