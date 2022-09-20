/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiPublicite;

import UtilData.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import GestionPublicite.Publicite;
import ServiceEvenTun.PubService;
import java.awt.Image;
import java.io.File;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



public class AddPubliciteController implements Initializable {

     @FXML
    private TextField descriFld;

    @FXML
    private TextField imgFld;

    @FXML
    private TextField typeFld;
    
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    //Publicite publicite = null;
    private boolean update;
    int publiciteID;
     Publicite p =new Publicite();
        PubService pi = new PubService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    
    
    @FXML
    void choose(ActionEvent event) {
       JFileChooser chooser=new JFileChooser();
chooser.showOpenDialog(null);
File f = chooser.getSelectedFile();
String fileName=f.getAbsolutePath();
imgFld.setText(fileName);
Image getAbsolutePath=null;
ImageIcon icon=new ImageIcon(fileName);

}

    public AddPubliciteController() {
        
      cnx = DataSource.getConnection();
    }

    
    
    
    
    
    
    @FXML
    private void save(MouseEvent event) {

        String type = typeFld.getText();
        String description = descriFld.getText();
        String image = imgFld.getText();
        
        if (type.isEmpty() ||description.isEmpty() || image.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();

        } else {
            if (update == false) {
            insert();
            } else{
                p.setId(publiciteID);
                p.setDescription(description);
                p.setType(type);
                p.setImage(image);
                pi.updatepub(p);
            }

        }

    }

    @FXML
    private void clean() {
        typeFld.setText(null);
        descriFld.setText(null);
        imgFld.setText(null);
        
    }


    public void insert() {
       Publicite p=new Publicite(typeFld.getText(),descriFld.getText(),imgFld.getText());
        pi.addpub(p);
        typeFld.setText(null);
        descriFld.setText(null);
        imgFld.setText(null);
       

    }

    void setTextField(int id, String type,String description, String image) {

        publiciteID = id;
        typeFld.setText(type);
        descriFld.setText(description);
        imgFld.setText(image);

    }

    void setUpdate(boolean b) {
         this.update = b;

    }

}
