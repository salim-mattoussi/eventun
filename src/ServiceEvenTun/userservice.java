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
public class userservice implements service<User>{
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


    public void adduser(User u) throws SQLException {
     
             pst = cnx.prepareStatement("insert into user ( login, pwd, telephone,email, role) values(?,?,?,?,?,?)");
            
            
            pst.setString(1, u.getEmail());
            pst.setString(2, u.getLogin());
            pst.setString(3, u.getPwd());
            pst.setInt(4, u.getTelephone());
           
            pst.setString(6, u.getRole());
           
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Account successfully registered");
         
    }

    public ArrayList<User> readAll() {
         ArrayList<User> list = new ArrayList<>();
        try {
            String requete = "select * from user";
           
            ste = cnx.createStatement();
            rs = ste.executeQuery(requete);
            while (rs.next()) {
//                User u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
//                list.add(u);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

//    @Override
   public void add(User p) {
//        String requete = "insert into personne (nom,prenom,age) values('" + u.ge + "','" + p.getPrenom() + "'," + p.getAge() + ")";
//        Statement ste;
//        try {
//            ste = cnx.createStatement();
//            ste.executeUpdate(requete);
//        } catch (SQLException ex) {
//            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);       }
    }

   

   

    @Override
    public void delete(User t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(User t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


