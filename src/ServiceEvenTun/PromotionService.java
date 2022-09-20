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
import java.util.Optional;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;


public class PromotionService implements service<Tickets>{
    
    private Connection cnx;
    private Statement ste;
    private ResultSet rs,res;
     

    public PromotionService() {
        cnx = DataSource.getConnection();
    }
    
   
 
    public float getTickets (){
        // ArrayList<Tickets> list = new ArrayList<>();
        float ticket = 0;
         try{
        String requete ="SELECT prix FROM tickets as T inner join evenement as E ON T.idE = E.idE WHERE T.idE = E.idE;";
         ste = cnx.createStatement();
            rs = ste.executeQuery(requete);
            while (rs.next()) {
                ticket = rs.getFloat("prix");
               // System.out.println(ticket);
//                Tickets  ticket = new Tickets (rs.getInt("idT"), rs.getFloat("prix"), rs.getInt("promotion"));
//                list.add(ticket);
            }
         }catch (SQLException ex) {
            Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);
         }
         return ticket;
    }
     public float getprixV (){
        float prixx = 0;
        String rqt="SELECT prix FROM tickets as T inner join evenement as E ON T.idE = E.idE WHERE T.idE = E.idE; ";
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
     
     
     public float getpromotion(){
          ArrayList<Float> listP = new ArrayList<>();
              float min = 0.7f;
           float max = 0.99f;
                Random rand = new Random();
            float finalprix ;
            //float nb;
          // nb =  Math.random();
          //(float)Math.floor
            // nb = (Math.random()*(max-min+1)+min);
           // nb = rand.nextFloat();
           float nb = min + rand.nextFloat()*(max-min);
            PromotionService serv = new PromotionService();
             finalprix = serv.getprixV()* nb ;
             System.out.println(nb);
             System.out.println((float)finalprix);
             listP.add(finalprix);
            
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("votre offre est "+finalprix);
                ButtonType buttonTypeOne = new ButtonType("OK");
                alert.getButtonTypes().setAll(buttonTypeOne);
                Optional<ButtonType> result = alert.showAndWait();
                int st = 0;
                String reqt =" UPDATE tickets as T inner join evenement as E ON T.idE = E.idE SET promotion ="+ finalprix +" WHERE T.idE = E.idE;" ;
            try{
            ste= cnx.createStatement();
           st = ste.executeUpdate(reqt);
           
            }catch(SQLException ex) {
               Logger.getLogger(userservice.class.getName()).log(Level.SEVERE, null, ex);}
                
                //windows wind = new windows();
               
                //alert.showAndWait();
//               ObservableList<Float> obs1 = FXCollections.observableArrayList(listP);
//                System.out.println(obs1);
//               prfinal.setCellValueFactory(new PropertyValueFactory<>("prix"));
//               finalTable.setItems(obs1);
             return finalprix;
     }
     
 
     //update 
//     public void update(){
//         String rqt2= "update tickets set montant="+prixfinal;
//     }
//    public void addPrix (double finalprix ){
//        listP.add(finalprix);
//    }
  

   

    @Override
    public void readByIdpromo(int id) {
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
    public int getfinalpage (){
       // ArrayList<Tickets> lista = new ArrayList<>();
       
        String req=" select promotion from tickets where idE = idT ";
       int prommo =0;
        try {
              ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            
             while(rs.next()){
                prommo=rs.getInt("promotion");
             }
             } catch (SQLException ex) {
            Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);
         
             System.out.println(prommo);
        }return prommo;
    }

    @Override
    public void adduser(Tickets u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addpub(Tickets t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean forgetpass(Tickets t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteuser(Tickets t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletepub(Tickets t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean readById(Tickets t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<Tickets> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void login(Tickets t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updatepass(Tickets t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void upuser(Tickets t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updatepub(Tickets t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void readByLogin(Tickets t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
