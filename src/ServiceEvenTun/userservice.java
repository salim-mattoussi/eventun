/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceEvenTun;

import GestionUser.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import UtilData.DataSource;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.JOptionPane;

/**
 *
 * @author chayma
 */
public class userservice implements service<User> {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
   

    public userservice() {
        cnx = DataSource.getConnection();
    }
//ajouter utilisateur
    @Override
    public void adduser(User u) {

        try {
            pst = cnx.prepareStatement("insert into user (Nom,Prenom, login, pwd, telephone,email, role) values(?,?,?,?,?,?,?)");
            pst.setString(1, u.getNom());
            pst.setString(2, u.getPrenom());
            pst.setString(3, u.getLogin());
            pst.setString(4, u.getPwd());
            pst.setInt(5, u.getTelephone());
            pst.setString(6, u.getEmail());
            pst.setString(7, u.getRole());

            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(null, "Account successfully registered");

    }
//afficher touts les utilisteurs
    @Override
    public List<User> readAll() {
        List<User> list = new ArrayList<>();
        try {
            String requete = "select * from user";

            ste = cnx.createStatement();
            rs = ste.executeQuery(requete);

            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt(1));
                u.setNom(rs.getString(2));
                u.setPrenom(rs.getString(3));
                u.setLogin(rs.getString(4));
                u.setPwd(rs.getString(5));
                u.setTelephone(rs.getInt(6));
                u.setEmail(rs.getString(7));
                u.setRole(rs.getString(8));
                list.add(u);
  
            }

        } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
//supprimer utilisateur selon id
    @Override
    public void deleteuser(User t) {

        try {
            pst = cnx.prepareStatement("Delete from user where id=?");

            ste = cnx.createStatement();
            pst.setInt(1, t.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//verifier le nom d'utilisateur
    @Override
    public boolean readById(User u) {
        try {

            pst = cnx.prepareStatement("select * from user where login=? ");
            ste = cnx.createStatement();
            pst.setString(1, u.getLogin());
            rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "le nom deja existe");
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
//login selon role d'utilisateur
    private void switchrole(String role) throws IOException {

        switch (role) {

            case "Utilisateur":

                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GuiPromotion/Acceuil.fxml"));

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                stage.setTitle("Admin");
                stage.setFullScreen(false);
                break;

            case "Responsable Evenement":
                Parent root2 = FXMLLoader.load(getClass().getClassLoader().getResource("GuiPromotion/Acceuil_1.fxml"));

                Scene scene2 = new Scene(root2);
                Stage stage2 = new Stage();
                stage2.setScene(scene2);
                stage2.show();
                stage2.setTitle("Hospital-IT");
                stage2.setFullScreen(false);
                break;

            case "Responsable Publicité":
                Parent root3 = FXMLLoader.load(getClass().getClassLoader().getResource("GuiPromotion/Acceuil_2.fxml"));

                Scene scene3 = new Scene(root3);
                Stage stage3 = new Stage();
                stage3.setScene(scene3);
                stage3.show();
                stage3.setTitle("QuarantineCenter-IT");
                stage3.setFullScreen(false);
                break;

        }
    }
//login
    @Override
    public void login(User u) {

        try {
            pst = cnx.prepareStatement("select login,pwd,role from user where login=? and pwd=?");
            ste = cnx.createStatement();
            pst.setString(1, u.getLogin());
            pst.setString(2, u.getPwd());
            rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "login success");
                String username = rs.getString(1);
                String password = rs.getString(2);
                String role = rs.getString(3);
                System.out.println(username + password + role);
                switchrole(role);

            } else {

                JOptionPane.showMessageDialog(null, "login Failed");

            }
        } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
// chercher login dans la base de données
    @Override
    public boolean forgetpass(User t) {

        try {
            pst = cnx.prepareStatement("select login from user where login=?");
            ste = cnx.createStatement();
            pst.setString(1, t.getLogin());

            rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("nom existe");
                return true;

            } else {
                JOptionPane.showMessageDialog(null, "Error: nom  incorrect");
            }
        } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
//modifier mot de passe
    @Override
    public void updatepass(User t) {
        try {
            ste = cnx.createStatement();
            String req = "UPDATE user set `pwd` = " + "'" + t.getPwd() + "'" + " WHERE login = '" + t.getLogin() + "'";
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(null, "la nouveau mot de passe a changé avec succée");
    }
//modifier utilisateur
    @Override
    public void upuser(User u) {

        try {
            pst = cnx.prepareStatement("UPDATE user set  `Nom` = " + "'" + u.getNom() + "'" + ",`Prenom` = " + "'" + u.getPrenom() + "'" + ", `login` = " + "'" + u.getLogin() + "'" + ", `pwd` = " + "'" + u.getPwd() + "'" + ", `telephone` = " + "'" + u.getTelephone() + "'" + ", `email` = " + "'" + u.getEmail() + "'" + ", `role` = " + "'" + u.getRole() + "'" + " WHERE id = " + u.getId());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Account successfully updated");
        } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    @Override
    public void addpub(User t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updatepub(User t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletepub(User t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void readByIdpromo(int t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void readByLogin(User t) {
        try {
            pst = cnx.prepareStatement("select * from user where login=? ");
            ste = cnx.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
