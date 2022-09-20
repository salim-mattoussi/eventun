/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiUser;

import GestionUser.User;
import ServiceEvenTun.userservice;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import UtilData.DataSource;

import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author panda
 */
public class ForgetpwdController implements Initializable {
    
    @FXML
    private Button btnback;
    
    @FXML
    private TextField txtmdp;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtrep;
    
    private Connection cnx;
   
   
    static String login;
    @FXML
    private Button btnserch;
    userservice us = new userservice();
    
    public ForgetpwdController() {
        cnx = DataSource.getConnection();
    }
    
    @FXML
    void search(ActionEvent event) throws IOException {
        try {
            
            login = this.txtnom.getText().trim();
            if (login.isEmpty()) {
                
                JOptionPane.showMessageDialog(null, "S'il vous plaît entrer votre nom");
            } else {
                User u1 = new User(login);
                if ((us.forgetpass(u1) == false)) {
                    System.out.println("ok");
                } else {
                    Parent view4 = FXMLLoader.load(getClass().getResource("forgetpwd2.fxml"));
                    Scene scene4 = new Scene(view4);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(scene4);
                    window.show();
                    
                }
                
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    @FXML
    void retrivePsw(ActionEvent event) {

//        u.setId(idu);
        try {
            //System.out.println("ttttttttt"+login);

//            String login = txtnom.getText();
            String pwd = txtmdp.getText().trim();
            String pwd1 = txtrep.getText().trim();

            //String login = setlogin(login);
            if ((pwd.isEmpty()) || (pwd1.isEmpty())) {
                
                JOptionPane.showMessageDialog(null, "S'il vous plaît remplir les champs vides ");
                
            } else if (!(pwd).equals(pwd1)) {
                JOptionPane.showMessageDialog(null, "Mot de passe incorrect veuillez verifier les deux champs  ");
                
            } else {
                User u = new User(login, pwd);
                
                us.updatepass(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    @FXML
    void back(ActionEvent event) throws IOException {
        
        if (event.getSource() == btnback) {
            
            Parent root = FXMLLoader.load(getClass().getResource("forgetpwd.fxml"));
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
            
        }
    }
    
    @FXML
    void back1(ActionEvent event) throws IOException {
        
        if (event.getSource() == btnback) {
            
            Parent root = FXMLLoader.load(getClass().getResource("logininterface.fxml"));
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
            
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) { // TODO
    }
    
}
