/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GuiPromotion;

import ServiceEvenTun.PromotionService;
import ServiceEvenTun.userservice;
import UtilData.DataSource;
import com.sun.java.swing.plaf.windows.resources.windows;
import gestionevenement.Tickets;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Observable;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
//import javax.management.Notification;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author SALIM
 */
public class PromographicController implements Initializable {

    private ObservableList<Tickets> proTable;
    @FXML
    private TextField numeroCarte;
   @FXML
    private DatePicker exdate = new DatePicker();
    @FXML
    private TextField codeS;
    @FXML
    private TextField postal;
    @FXML
    private Label   error1 ,error2;
    @FXML
    private RadioButton tn , visa;
  
    @FXML
    private Button pay , promoBtn;
    @FXML
    private TableView<Tickets> table ;
       @FXML
    private TableColumn<Tickets, Float> montant ;
       private Stage stage ;
       private Scene scene;
       private Parent root;
        private Connection cnx  = DataSource.getInstance().getConnection();;
        
    private Statement ste;
    private ResultSet rs,res;
    int carte ;
    int codee;
    ArrayList<Float> listP = new ArrayList<>();
    @FXML
    private ToggleGroup visamar;
    
    
    @FXML
    private void payementickets (ActionEvent event) throws ParseException, IOException{
//        try{
//      carte = Integer.parseInt(numeroCarte.getText());
//        }catch (NumberFormatException e){
//            error1.setText("must be number");
//        }
          
       
      
//        carte=Integer.parseInt(numeroCarte.getText());
        if ((numeroCarte.getText().length()==0) ){
//             try{
//      carte = Integer.parseInt(numeroCarte.getText());
//        }catch (NumberFormatException e){
//            error1.setText("must be number");
//        }
            numeroCarte.setStyle("-fx-border-color: red ; -fx-border-width: 2px;");
            new animatefx.animation.Shake(numeroCarte).play();
            
        }else numeroCarte.setStyle(null);
        
        
     if (codeS.getText().length()==0){
//           try{
//      codee = Integer.parseInt(codeS.getText());
//        }catch (NumberFormatException e){
//            error2.setText("must be number");
//        }
           
            codeS.setStyle("-fx-border-color: red ; -fx-border-width: 2px;");
            new animatefx.animation.Shake(codeS).play();
            
        }else codeS.setStyle(null);
     if (postal.getText().length()==0){
            postal.setStyle("-fx-border-color: red ; -fx-border-width: 2px;");
            new animatefx.animation.Shake(postal).play();
            
        }else postal.setStyle(null);
         
         
         String st = String.valueOf(exdate.getValue());
         if (st.isEmpty() ){
              exdate.setStyle("-fx-border-color: red ; -fx-border-width: 2px;");            
            new animatefx.animation.Shake(exdate).play();
         }else {
             exdate.setStyle(null);
         }
         if ((numeroCarte.getText().length()!=0)&&(codeS.getText().length()!=0)&&(postal.getText().length()!=0)){
             Parent root = FXMLLoader.load(getClass().getResource("ImprimeTikets.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
         }
//      if (exdate.getValue().toString()== ""){
//            exdate.setStyle("-fx-border-color: red ; -fx-border-width: 2px;");
//            new animatefx.animation.Shake(exdate).play();
//            
//        }else exdate.setStyle(null);

          }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        remplirTab();
       // remplirTabPromo();
      // calculepromo();
    }    
    
        public void remplirTab() {
        PromotionService ps = new PromotionService();
        ArrayList<Tickets> list = ps.getTickets();

        ObservableList<Tickets> obs = FXCollections.observableArrayList(list);
        
        montant.setCellValueFactory(new PropertyValueFactory<>("prix"));
       
        
        table.setItems(obs);

    }
       
        
    @FXML
        public float calculepromo () throws IOException{
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
            
             Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("votre offre est "+finalprix);
                ButtonType buttonTypeOne = new ButtonType("OK");
                alert.getButtonTypes().setAll(buttonTypeOne);
                Optional<ButtonType> result = alert.showAndWait();
                int st = 0;
                String reqt =" UPDATE tickets SET promotion ="+ finalprix ;
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
           public void finalPage (ActionEvent event) throws IOException{
                Parent root = FXMLLoader.load(getClass().getResource("testButtom.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
           }         
//           public void remplirTabPromo (){
//               // PromotionService ps1 = new PromotionService();
//             //  ArrayList<Double> listP = ps1.addPrix(finalprix);
//               
//             
//           }
//    public void getpromo(ActionEvent event){
//        
//     Tickets prixlist = new Tickets();
//       PromotionService ps = new PromotionService();
//      ArrayList<Tickets> prixList = ps.getTickets();
//      //for (int i =0 ; i<table.getItems().size();i++){
//        // ticket=table.getItems().get(i);
//        // arrList.add(new ArrayList<>());
//         //float prixv = ticket.prix;
//         //String pr = String.valueOf(prixv);
//         //String pr = prixv.toString();
//         //arrList.get(i).add(ticket.prix.get());
//         ObservableList<Tickets> obs = FXCollections.observableArrayList(arrList);
//         prf.setCellValueFactory(new PropertyValueFactory<>("prix"));
//         finaltable.setItems(obs);
//     // }
//    }

    @FXML
    private void checkinput(KeyEvent event) {
        if(event.getCharacter().matches("[^\\e\t\r\\d+$]")){
            event.consume();
            numeroCarte.setStyle("-fx-border-color: red");
            postal.setStyle("-fx-border-color: red");
        }else{
             numeroCarte.setStyle("-fx-border-color: bleu");
             postal.setStyle("-fx-border-color: bleu");
        }
    }

    @FXML
    private void printDate(ActionEvent event) {
        LocalDate d = exdate.getValue();
    }

    @FXML
    private void getTypePay(ActionEvent event) {
        if(tn.isSelected()){
            Notifications notificate = Notifications.create()
            .title("choisir payment type")
             .text("you choose edinar")
             .graphic(null)
             .hideAfter(Duration.seconds(5))
             .position(Pos.TOP_RIGHT)
             .onAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println("clicked on notifaction");
                                }
             });
            notificate.showConfirm();
                    }else if(visa.isSelected()){    
             Notifications notificatee = Notifications.create()
            .title("choisir payment type")
             .text("you choose visa")
             .graphic(null)
             .hideAfter(Duration.seconds(5))
             .position(Pos.TOP_RIGHT)
             .onAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println("clicked on notifaction");
                                }
             });
            notificatee.showConfirm();
        }
    }
}
