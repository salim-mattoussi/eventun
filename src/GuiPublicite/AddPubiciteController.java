/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiPublicite;

import GestionPublicite.Publicite;
import UtilData.DataSource;
import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;




public class AddPubiciteController  implements Initializable {

    @FXML
    private Button btnimage;

    @FXML
    private Label image;

    @FXML
    private TextField img_text;

    @FXML
    private TextField txtdescription;

    @FXML
    private TextField txttYpe;

    String query = null;
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement;
    Publicite Publicite = null;
    private boolean update;
    private Object img;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public AddPubiciteController() {
        cnx = DataSource.getInstance().getConnection();
    }
    //variable
    private final Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
      @FXML
    void choose(ActionEvent event) {
       JFileChooser chooser=new JFileChooser();
chooser.showOpenDialog(null);
File f = chooser.getSelectedFile();
String fileName=f.getAbsolutePath();
img_text.setText(fileName);
Image getAbsolutePath=null;
ImageIcon icon=new ImageIcon(fileName);

}

    
   @FXML
    private void save(ActionEvent event) {

     Connection  cnx = DataSource.getInstance().getConnection();
        
        String type = txttYpe.getText();
        String description = txtdescription.getText();
        String image = img_text.getText();

        if (type.isEmpty() || description.isEmpty() || image.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();

        } else {
            getQuery();
            insert();
            clean();

        }

    }

   @FXML
    private void clean(ActionEvent event) {
        txttYpe.setText(null);
        txtdescription.setText(null);
        img_text.setText(null);  
    }

    private void getQuery() {

        if (update == false) {
            
            query = "INSERT INTO `publicite`( `type`, `description`, `image`) VALUES (?,?,?)";

        }else{
            query = "UPDATE `publicite` SET "
                    + "`type`=?,"
                    + "`description`=?,"
                    + "`image`=?,";
                   
        }

    }

    private void insert() {

        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, txttYpe.getText());
            preparedStatement.setString(2, txtdescription.getText());
            preparedStatement.setString(3, img_text.getText());
            preparedStatement.execute();
             JOptionPane.showMessageDialog(null,"publicite est ajouter");

        } catch (SQLException ex) {
            Logger.getLogger(AddPubiciteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void setTextField(int id, String type, String description, String image) {

         int PubliciteId = id;
      
        txttYpe.setText(type);
       
        txtdescription.setText(description);
        img_text.setText(image);

    }

    void setUpdate(boolean b) {
        this.update = b;

    }

    private void clean() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}