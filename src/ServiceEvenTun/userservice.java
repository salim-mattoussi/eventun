/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceEvenTun;

import GestionUser.user;
import GuiUser.login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.service;
import UtilData.DataSource;
import javax.swing.JOptionPane;

/**
 *
 * @author panda
 */
public class userservice implements service<user>{
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
        cnx = DataSource.getInstance().getConnection();
    }


    public void adduser(user u) throws SQLException {
     
             pst = cnx.prepareStatement("insert into user (name, login, pwd, telephone,email, role) values(?,?,?,?,?,?)");
            
            
            pst.setString(1, u.getEmail());
            pst.setString(2, u.getLogin());
            pst.setString(3, u.getPwd());
            pst.setInt(4, u.getTelf());
            pst.setString(5, u.getName());
            pst.setString(6, u.getRole());
           
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Account successfully registered");
         
    }

    public ArrayList<user> readAll() {
         ArrayList<user> list = new ArrayList<>();
        try {
            String requete = "select * from user";
           
            ste = cnx.createStatement();
            rs = ste.executeQuery(requete);
            while (rs.next()) {
                user u = new user(rs.getInt(3), rs.getString(2), rs.getString(1), rs.getInt(4));
                list.add(u);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

//    @Override
   public void add(user p) {
//        String requete = "insert into personne (nom,prenom,age) values('" + u.ge + "','" + p.getPrenom() + "'," + p.getAge() + ")";
//        Statement ste;
//        try {
//            ste = cnx.createStatement();
//            ste.executeUpdate(requete);
//        } catch (SQLException ex) {
//            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);       }
    }

   

   

    @Override
    public void delete(user t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(user t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public user readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


