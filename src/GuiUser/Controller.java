package GuiUser;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.layout.AnchorPane;


public class Controller implements Initializable {

    
    @FXML
    private Button btnPromo;

    @FXML
    private Button btnSignout;

    
    @FXML
    private Button btnevent;

    @FXML
    private Button btnnotif;

    @FXML
    private Button btnpub;

    @FXML
    private Button btnuser;

     @FXML
    private AnchorPane anchtable;

   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       

    }


    public void handleClicks(ActionEvent actionEvent) throws IOException {
      
           
           if (actionEvent.getSource() == btnuser) {
     
           Pane pane =   FXMLLoader.load(getClass().getResource("GestionUtilisateuradmin.fxml"));
           anchtable.getChildren().setAll(pane);
          
        }
        if (actionEvent.getSource() == btnnotif) {
            Pane pane =   FXMLLoader.load(getClass().getResource("Gestionpromoadmin.fxml"));
           anchtable.getChildren().setAll(pane);
        }
          if (actionEvent.getSource() == btnpub) {
          Pane pane =   FXMLLoader.load(getClass().getResource("Gestionpubadmin.fxml"));
           anchtable.getChildren().setAll(pane);
        }
        if (actionEvent.getSource() == btnevent) {
          Pane pane =   FXMLLoader.load(getClass().getResource("Gestionpubadmin.fxml"));
           anchtable.getChildren().setAll(pane);
        }
          if (actionEvent.getSource() == btnSignout) {
          Pane pane =   FXMLLoader.load(getClass().getResource("logininterface.fxml"));
          
             
        }
        if(actionEvent.getSource()==btnPromo)
        {
           Pane pane =   FXMLLoader.load(getClass().getResource("Gestionpubadmin.fxml"));
           anchtable.getChildren().setAll(pane);
//        Scene scene =  btnCustomers.getScene();
//        stage.setScene(scene);
//       // stage.setTitle("");
//        stage.show();
    }
}}
