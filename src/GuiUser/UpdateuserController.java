/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiUser;

import GestionUser.User;
import UtilData.DataSource;
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
        ObservableList<String> RoleBoxList = FXCollections.observableArrayList("User","event Manager","advertising manager");

    /**
     * Initializes the controller class.
     */
//       public ObservableList<User> getRegisteredList() throws SQLException {
//        String sql = "SELECT * FROM user";
//        ObservableList<User> list=FXCollections.observableArrayList();
//        list.clear();
//        try {
//           
//            Statement stmt = cnx.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                User u=new User(rs.getInt("id"),rs.getString("login"),rs.getString("pwd"));
//                list.add(p);
//            }
//            rs.close();
//            cnx.close();
//        } 
//        catch (ClassNotFoundException | SQLException ex) {
//        }
//        System.out.print(list.size());
//        return list;
//   }
      public void update(ActionEvent event) throws SQLException{
          
        try{ 
        User u = new User();
//        String email=txtemail.getText();
//        String login=txtlogin.getText();
          //String telephone = txttelf.getText();
//        String password = txtpwd.getText();
//        String role= cmbrole.getSelectionModel().getSelectedItem();
//        Integer id =u.getId();

            u.setId(idu);
            u.setLogin(txtlogin.getText());
             u.setEmail(txtemail.getText()); 
             u.setPwd(txtpwd.getText()); 
             u.setTelephone(Integer.parseInt(txttelf.getText())); 
             u.setRole(cmbrole.getSelectionModel().getSelectedItem());

        if (cmbrole.getSelectionModel().getSelectedItem().equals("Choose your role") || txtpwd.getText().equals("") || txtemail.getText().equals("") || txtlogin.getText().equals("") || Integer.parseInt(txttelf.getText())==0)
            
              JOptionPane.showMessageDialog(null,"please complete all the fills");
        
         else {
               if (Integer.parseInt(txttelf.getText())<8){
                  
                   JOptionPane.showMessageDialog(null,"telephone  is too weak, please choose 8 characters");
               }
        else {
                 
           

           pst = cnx.prepareStatement("UPDATE user set   `login` = " +"'"+u.getLogin()+"'" +", `pwd` = " +"'"+ u.getPwd()+"'" +", `telephone` = "+"'"+u.getTelephone()+"'"+", `email` = "+"'"+u.getEmail()+"'"+", `role` = "+"'"+u.getRole()+"'"+" WHERE id = "+u.getId() );
             
             
             pst.executeUpdate();
      
            JOptionPane.showMessageDialog(null,"Account successfully updated");
         
        }
        
    }} catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
       
   void setTextField(int id, String login ,String pwd , int Telephone, String email, String role) {
        idu = id;
        
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
