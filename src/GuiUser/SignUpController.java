/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiUser;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import service.userservice;
import UtilData.DataSource;

/**
 * FXML Controller class
 *
 * @author panda
 */
public class SignUpController implements Initializable {
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public SignUpController() {
         cnx = DataSource.getConnection();
    }
    
    ObservableList<String> RoleBoxList = FXCollections.observableArrayList("User","event Manager","advertising manager");

   @FXML
    private Button btnsignup;

    @FXML
    private ComboBox<String> comborole;
    
    @FXML
    private TextField txtemail;
    
    @FXML
    private TextField txtpwd;

    @FXML
    private TextField txtlogin;

    

    @FXML
    private TextField txttelf;
    
  
    
    

    @FXML
    void select(ActionEvent event) throws SQLException {
       try{ 
        String email=txtemail.getText();
        String login=txtlogin.getText();
        String telephone = txttelf.getText();
        String password = txtpwd.getText();
        String role=comborole.getSelectionModel().getSelectedItem();
        
        if (email.equals("") || login.equals("") || telephone.equals("") || role.equals("Choose your role") || password.equals(""))
            
              JOptionPane.showMessageDialog(null,"please complete all the fills");
        
         else {
               if (telephone.length()<8){
                  
                   JOptionPane.showMessageDialog(null,"telephone  is too weak, please choose 8 characters");
               }
        else {
                 
         
           pst = cnx.prepareStatement("select * from user where login=? ");
           ste = cnx.createStatement();
           pst.setString(1, login );
           rs = pst.executeQuery();
           
            if(rs.next()){
                 JOptionPane.showMessageDialog(null,"Username already taken, please try another username");
             } 
        
        
      
        else{  
         
             pst = cnx.prepareStatement("insert into user ( login, pwd, telephone,email, role) values(?,?,?,?,?)");
          
            pst.setString(1, txtlogin.getText().trim());
            pst.setString(2, txtpwd.getText().trim());
            pst.setString(3, txttelf.getText().trim());
            pst.setString(4, txtemail.getText().trim());
            pst.setString(5, comborole.getSelectionModel().getSelectedItem());
           
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Account successfully registered");
         
        }
        
    }}}
     catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    
    public void initialize(URL location, ResourceBundle resources) {
        
    /**
     * Initializes the controller class.
     */
    comborole.setValue("Choose your role");
    comborole.setItems(RoleBoxList);    
    }
}
   
    

