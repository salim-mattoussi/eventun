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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author panda
 */
public class UserupdateController implements Initializable {

    @FXML
    private Label lblnom;

    @FXML
    private TextField txtlogin;

    @FXML
    private TextField txtmail;

    @FXML
    private TextField txtnom;

    @FXML
    private TextField txtprenom;

    @FXML
    private TextField txtpwd;

    @FXML
    private TextField txttelf;
    @FXML
    private ComboBox<String> cmbrole;
   private int idu;
    private Connection cnx;
   ObservableList<String> RoleBoxList = FXCollections.observableArrayList("Utilisateur","Responsable Evenement","responsable Publicité");

    @FXML
    void modifier(ActionEvent event) {
  User u = new User();

u.setId(idu);
u.setNom(txtnom.getText());
u.setPrenom(txtprenom.getText());
u.setLogin(txtlogin.getText());
u.setEmail(txtmail.getText());
u.setPwd(txtpwd.getText());
u.setTelephone(Integer.parseInt(txttelf.getText()));
u.setRole(cmbrole.getSelectionModel().getSelectedItem());
if (cmbrole.getSelectionModel().getSelectedItem().equals("Choose your role") || txtpwd.getText().equals("")|| txtnom.getText().equals("")|| txtprenom.getText().equals("") || txtmail.getText().equals("") || txtlogin.getText().equals("") || Integer.parseInt(txttelf.getText())==0)
    
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

    public UserupdateController() {
                  cnx = DataSource.getConnection();

    }
     public void setLabnom(String labnom) {
        this.lblnom.setText(labnom);
    }
     void setTextField() {
        User u =new User();
        userservice us = new userservice();
        us.readAll();
        

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    cmbrole.setValue("Choose your role");
    cmbrole.setItems(RoleBoxList); 
        // TODO
    }    
    
}
