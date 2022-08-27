/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiUser;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import UtilData.DataSource;

import gestionutilisateur.user;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author panda
 */
public class ForgetpwdController implements Initializable {
    
      @FXML
    private Label labelemail;
    
     @FXML
    private Button btnback;

    @FXML
    private Button btnrecap;

    @FXML
    private Button btnserch;

    @FXML
    private TextField txtmdp;

    @FXML
    private TextField txtnom;

    @FXML
    private TextField txtrep;

    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    private user u;
    
    
    public ForgetpwdController() {
        cnx = DataSource.getInstance().getConnection();
    }
 @FXML
    void search(ActionEvent event) throws IOException, SQLException {
       try{
            String name = txtnom.getText().trim();
            
            if(name.isEmpty()){
               
                JOptionPane.showMessageDialog(null, "S'il vous plaît entrer votre nom");
            }
            else {
                 pst = cnx.prepareStatement("select login,email from user where login=?");
                 ste = cnx.createStatement();
                 pst.setString(1, name );
        
                 rs = pst.executeQuery();
              
                if(rs.next()){
                
                Parent view4=FXMLLoader.load(getClass().getResource("forgetpwd2.fxml"));
                Scene scene4=new Scene(view4);
                Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene4);
                window.show();
                   
                    
                    
                 
                }
                else {
                    JOptionPane.showMessageDialog(null,"Error: nom  incorrect");
                     txtnom.setText("");
                     txtrep.setText("");
                     txtmdp.setText("");
                     txtnom.requestFocus();
            
                }
                
                
                
            }
            
        } catch (Exception ex) {
            System.out.println(ex);
        } 
            
    }

 @FXML
    void retrivePsw(ActionEvent event) throws IOException, SQLException {
try{
        String login = txtnom.getText();
        String pwd = txtmdp.getText();
        String pwd1 = txtrep.getText();
      
        
             if(!pwd1.equals(pwd)){
                 
                JOptionPane.showMessageDialog(null, "Veuillez vérifier votre saisie dans les deux champs ");}
                
              else {
                
                pst = cnx.prepareStatement("update user set pwd=? where login=? " );
                ste = cnx.createStatement();
                pst.setString(3, pwd );
                pst.setString(2, login );
                pst.executeUpdate();
                while (rs.next()) {
                JOptionPane.showMessageDialog(null, "le mot de passe a  été modifier");}
                   

            
        } }catch (Exception ex) {
            ex.printStackTrace();
        
            
}
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
