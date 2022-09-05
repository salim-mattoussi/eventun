/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceEvenTun;

import GestionEvenement.Evenement;
import UtilData.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohamed
 */
public class eventservice implements service<Evenement> {
    
    
    
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public eventservice() {
        cnx = DataSource.getInstance().getConnection();
    }

   
    @Override
    public void add(Evenement e)  {
        try {
            String requete = "insert into evenement (nom,lieu,date,description) values(?,?,?,?,?)";
            
            try {
                pst = cnx.prepareStatement(requete);
            } catch (SQLException ex) {
                Logger.getLogger(eventservice.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            pst.setString(1, e.getNom());
            pst.setString(2, e.getLieu());
            pst.setString(4, e.getDescription());
            pst.setString(3, e.getDate());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(eventservice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Evenement t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Evenement readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Evenement> readAll() {
         ArrayList<Evenement> list = new ArrayList<>();
        try {
            String requete = "select * from user";
           
            ste = cnx.createStatement();
            rs = ste.executeQuery(requete);
            while (rs.next()) {
                Evenement e = new Evenement(rs.getString("nom"), rs.getString("lieu"), rs.getString("description"), rs.getInt(1));
                list.add(e);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void update(Evenement t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}
