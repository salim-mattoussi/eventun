/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiUser;

import GestionUser.User;
import ServiceEvenTun.userservice;
import UtilData.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * 
 * @author panda
 */
public class UpdateuserController implements Initializable {
    private Connection cnx;

    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
     @FXML
    private Button btnback;

    @FXML
    private Button btnmodifier;

    @FXML
    private ComboBox<String> cmbrole;

    @FXML
    private TextField txtemail;
  @FXML
    private TextField txtnom;

    @FXML
    private TextField txtprenom;
    @FXML
    private TextField txtlogin;

    @FXML
    private TextField txtpwd;

    @FXML
    private TextField txttelf;
   // private User u;
     private int idu;
    public UpdateuserController() {
          cnx = DataSource.getConnection();
    }
        ObservableList<String> RoleBoxList = FXCollections.observableArrayList("Utilisateur","Responsable Evenement","responsable Publicité");

    /**
     * Initializes the controller class.
     */

      public void update(ActionEvent event) {
          
          User u = new User();
//        String email=txtemail.getText();
//        String login=txtlogin.getText();
//String telephone = txttelf.getText();
//        String password = txtpwd.getText();
//        String role= cmbrole.getSelectionModel().getSelectedItem();
//        Integer id =u.getId();
u.setId(idu);
u.setNom(txtnom.getText());
u.setPrenom(txtprenom.getText());
u.setLogin(txtlogin.getText());
u.setEmail(txtemail.getText());
u.setPwd(txtpwd.getText());
u.setTelephone(Integer.parseInt(txttelf.getText()));
u.setRole(cmbrole.getSelectionModel().getSelectedItem());
if (cmbrole.getSelectionModel().getSelectedItem().equals("Choose your role") || txtpwd.getText().equals("")|| txtnom.getText().equals("")|| txtprenom.getText().equals("") || txtemail.getText().equals("") || txtlogin.getText().equals("") || Integer.parseInt(txttelf.getText())==0)
    
    JOptionPane.showMessageDialog(null,"please complete all the fills");

else {
    if (Integer.parseInt(txttelf.getText())<8){
        
        JOptionPane.showMessageDialog(null,"telephone  is too weak, please choose 8 characters");
    }
    else {
        
        
        userservice us = new userservice();
        us.upuser(u);
        
    }
    
}
    
    }
       
   void setTextField(int id,String nom,String prenom, String login ,String pwd , int Telephone, String email, String role) {
        idu = id;
        txtnom.setText(nom);
        txtprenom.setText(prenom);
        txtlogin.setText(login);
        txtpwd.setText(pwd);
        txttelf.setText(String.valueOf(Telephone));
        txtemail.setText(email);
        cmbrole.setValue(role);
        
        

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    cmbrole.setValue("Choose your role");
    cmbrole.setItems(RoleBoxList); 
    }    
    
}
