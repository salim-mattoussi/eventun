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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import service.userservice;
import util.DataSource;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class LogininterfaceController implements Initializable {
   private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    /**
     * Initializes the controller class.
     */
    public LogininterfaceController() {
         cnx = DataSource.getInstance().getConnection();
    }

    
      @FXML
    private Button btnlogin;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private TextField txtusername;

    @FXML
    void login(ActionEvent event) throws SQLException {
        
        String username=txtusername.getText();
        String password=txtpassword.getText();
        
        if (username.equals("") && password.equals("")) {
            
               JOptionPane.showMessageDialog(null, "Username or password is empty");
            }
        else
         {
           try{
             
          
         
           pst = cnx.prepareStatement("select * from user where login=? and pwd=?");
           ste = cnx.createStatement();
           pst.setString(1, username );
           pst.setString(2, password);
           rs = pst.executeQuery();
            if (rs.next()) {
             JOptionPane.showMessageDialog(null, "login success");
            
            }
            else{
                
             JOptionPane.showMessageDialog(null, "login Failed");
             txtusername.setText("");
             txtpassword.setText("");
             txtusername.requestFocus();
            
            }
  } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
