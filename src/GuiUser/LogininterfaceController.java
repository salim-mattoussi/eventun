/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiUser;

//
//<<<<<<< HEAD
//=======
//
//import com.cathive.fonts.fontawesome.FontAwesomeIconView;
//>>>>>>> master
import GestionUser.User;
import ServiceEvenTun.userservice;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import UtilData.DataSource;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
//=======

import javax.swing.JOptionPane;

//import util.DataSource;
//>>>>>>> master
/**
 * FXML Controller class
 *
 * @author chayma
 */
public class LogininterfaceController implements Initializable {
//<<<<<<< HEAD

    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
//=======
//>>>>>>> master

    /**
     * Initializes the controller class.
     */
//<<<<<<< HEAD
    public LogininterfaceController() {
        cnx = DataSource.getConnection();
    }

//=======
//>>>>>>> master
    @FXML
    private Button btnlogin;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private TextField txtusername;
    @FXML
    private Hyperlink btnsignup;

    @FXML
    private Hyperlink btnrest;
         Parent root = null;

        FXMLLoader fxmlLoader = null;
//<<<<<<< HEAD

    @FXML
    void rest(ActionEvent event) throws IOException {

        if (event.getSource() == btnrest) {

            Parent root = FXMLLoader.load(getClass().getResource("forgetpwd.fxml"));
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();

        }
    }

    @FXML
    void Signup(ActionEvent event) throws IOException {

        if (event.getSource() == btnsignup) {

            Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();

        }
    }

    @FXML
    void login(ActionEvent event) throws SQLException, IOException {

        String username = txtusername.getText();
        String password = txtpassword.getText();

//<<<<<<< HEAD

        if (username.equals("") && password.equals("")) {

            JOptionPane.showMessageDialog(null, "nom ou mot de passe est vide!!");

        } else {
            if (("admin".equals(username))&&("admin".equals(password))){
            Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
            }
        else {

            User u = new User(username, password);
       
            userservice u1 = new userservice();
            u1.login(u);
           
        }
 

    }}

         
     

//=======
//>>>>>>> master
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//<<<<<<< HEAD
//=======
//        
//>>>>>>> master
    }

}
