/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiUser;

import GestionUser.User;
import ServiceEvenTun.userservice;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import UtilData.DataSource;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Hyperlink;

import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class SignUpController implements Initializable {

    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public SignUpController() {
        cnx = DataSource.getConnection();
    }

    ObservableList<String> RoleBoxList = FXCollections.observableArrayList("Utilisateur","Responsable Evenement","Responsable Publicité");

    @FXML
    private Button btnsignup;

    @FXML
    private ComboBox<String> comborole;
 @FXML
    private TextField txtNom;

    @FXML
    private TextField txtprenom;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtpwd;

    @FXML
    private TextField txtlogin;

    @FXML
    private Hyperlink btnlogin;

    @FXML
    private TextField txttelf;
    // private User u;

    @FXML
    void select(ActionEvent event) throws SQLException {
        String email = txtemail.getText();
        String login = txtlogin.getText();
        String Nom = txtNom.getText();
        String Prenom = txtprenom.getText();
        String telephone = txttelf.getText();
        String password = txtpwd.getText();
        String role = comborole.getSelectionModel().getSelectedItem();
        userservice us = new userservice();

        if (email.equals("") || login.equals("") || telephone.equals("") || role.equals("Choose your role") || password.equals("") || Nom.equals("") || Prenom.equals("")) {
            JOptionPane.showMessageDialog(null, "please complete all the fills");
        } else {
          if (validateEmail()==false){ 
               JOptionPane.showMessageDialog(null, "verifier votre adresse mail");
          }else{
            if (telephone.length() < 8) {
                JOptionPane.showMessageDialog(null, "telephone  is too weak, please choose 8 characters");

            } else {
                User u1 = new User(txtlogin.getText());
                if ((us.readById(u1) == true)) {
                    System.out.println(u1);
                } else {
                    User u = new User(txtNom.getText(),txtprenom.getText(),txtlogin.getText(), txtpwd.getText(), Integer.parseInt(txttelf.getText()), txtemail.getText(), comborole.getSelectionModel().getSelectedItem());

                    us.adduser(u);
                }

                }
            }
        }

    }
    

    @FXML
    void login(ActionEvent event) throws IOException {

        if (event.getSource() == btnlogin) {

            Parent root = FXMLLoader.load(getClass().getResource("logininterface.fxml"));
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();

        }
    }
    private boolean validateEmail(){
       Pattern p=Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
       Matcher m=p.matcher(txtemail.getText());
       if (m.find()&& m.group().equals(txtemail.getText())){
          // System.out.println("ok");
       return true;
       }
       // System.out.println("not ok");
        return false;
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
