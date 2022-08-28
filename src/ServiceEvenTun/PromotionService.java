/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceEvenTun;

import UtilData.DataSource;
import gestionevenement.Tickets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PromotionService implements service<Tickets>{
    
    private Connection cnx;
    private Statement ste;
    private ResultSet rs,res;
     

    public PromotionService() {
        cnx = DataSource.getInstance().getConnection();
    }
    
   
 
    public ArrayList <Tickets> getTickets (){
         ArrayList<Tickets> list = new ArrayList<>();
         try{
        String requete ="select * from tickets ";
         ste = cnx.createStatement();
            rs = ste.executeQuery(requete);
            while (rs.next()) {
                Tickets  ticket = new Tickets (rs.getInt("id"), rs.getInt("numero"), rs.getFloat("prix"), rs.getInt("promotion"));
                list.add(ticket);
            }
         }catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
         }
         return list;
    }
     public float getprixV (){
        float prixx = 0;
        String rqt="select prix from tickets";
        try{
        ste= cnx.createStatement();
        res = ste.executeQuery(rqt);
        while(res.next()){
             prixx = res.getFloat("prix");
        }
        }catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);}
        
        return prixx;
    }
     
 
     //update 
//     public void update(){
//         String rqt2= "update tickets set montant="+prixfinal;
//     }
//    public void addPrix (double finalprix ){
//        listP.add(finalprix);
//    }
    @Override
    public void add(Tickets t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Tickets t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    @Override
    public ArrayList<Tickets> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Tickets t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void readById(int id) {
     String sq1= "select id , prix from tickets where id="+id;
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(sq1);
            } catch (SQLException ex) {
            Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);
         try {
             while(rs.next()){
                 int id1 = rs.getInt("id");
                 float prix =rs.getFloat("prix");
             }
         } catch (SQLException ex1) {
             Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex1);
         }
        }
        System.out.println(rs);
    }
    
    
    //affichage de final page 
    public void getfinalpage (){
        String req=" select promotion ,nom  from tickets as t full join evenement as e on t.id = e.id  ";
        try {
              ste = cnx.createStatement();
            rs = ste.executeQuery(req);
        } catch (SQLException ex) {
            Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);
             try {
             while(rs.next()){
                 float prom = rs.getFloat("promotion");
                 String nomf =rs.getString("nom");
             }
         } catch (SQLException ex1) {
             Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex1);
         }
        }
    }
}
