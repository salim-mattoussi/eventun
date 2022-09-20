/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceEvenTun;

import GestionPublicite.Publicite;
import UtilData.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;

public class PubService implements service<Publicite> {

    private final Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public PubService() {
        cnx = DataSource.getConnection();
    }

    @Override
    public void addpub(Publicite p) {

        try {

            String requete = "INSERT INTO `publicite`( `type`,`description`, `image`) VALUES (?,?,?)";
            pst = cnx.prepareStatement(requete);
              
            pst.setString(1, p.getType());
            pst.setString(2, p.getDescription());
            pst.setString(3, p.getImage());
           
             pst.execute();
             
        } catch (SQLException ex) {
            Logger.getLogger(PubService.class.getName()).log(Level.SEVERE, null, ex);
        }
         JOptionPane.showMessageDialog(null, "ADD scusseful");

       

    }

    @Override
    public void deleteuser(Publicite t) {
 //        query = "DELETE FROM `publicite` WHERE id  ="+publicite.getId();
//                                cnx= DataSource.getConnection();
//                                preparedStatement = cnx.prepareStatement(query);
//                                preparedStatement.execute();
    }


    @Override
    public void  updatepub(Publicite p) {
        
    //     boolean rowUpdated = false;
        

         try {
            pst = cnx.prepareStatement("UPDATE publicite set   `type` = " + "'" + p.getType() + "'" + ", `description` = " + "'" + p.getDescription() + "'" + ", `image` = " + "'" + p.getImage() +  "'" + " WHERE id = " + p.getId());
          
          pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Publiciter successfully updated");
          

           
        } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }
           //return rowUpdated;

       }

    @Override
    public void adduser(Publicite u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean forgetpass(Publicite t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean readById(Publicite t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<Publicite> readAll() {
         ObservableList<Publicite> list =FXCollections.observableArrayList();
        try {
            String requete = "select * from publicite";

            ste = cnx.createStatement();
            rs = ste.executeQuery(requete);

            while (rs.next()) {
                Publicite p = new Publicite();
                 p.setId(rs.getInt(1));
                 p.setType(rs.getString(2));
                  p.setDescription(rs.getString(3));
                  p.setImage(rs.getString(4));
                  
               list.add(p);
                //rs.getInt("id"), rs.getString("login"), rs.getString("pwd"), rs.getInt("Telephone"), rs.getString("email"), rs.getString("role"));
//
//                list.add(u);

            }

        } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void login(Publicite t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updatepass(Publicite t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void upuser(Publicite t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletepub(Publicite t) {
       try {
            pst = cnx.prepareStatement("Delete from publicite where id=?");

            ste = cnx.createStatement();
            pst.setInt(1, t.getId());
            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("la publicite a été supprimer avec succée");
            alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void readByIdpromo(int t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void readByLogin(Publicite t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
