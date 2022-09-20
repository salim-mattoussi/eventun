package GuiUser;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller implements Initializable {

 

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

            Pane pane = FXMLLoader.load(getClass().getResource("GestionUtilisateuradmin.fxml"));
            anchtable.getChildren().setAll(pane);

        }
        if (actionEvent.getSource() == btnnotif) {
            Pane pane = FXMLLoader.load(getClass().getResource("Gestionpromoadmin.fxml"));
            anchtable.getChildren().setAll(pane);
        }
        if (actionEvent.getSource() == btnpub) {
            Pane pane = FXMLLoader.load(getClass().getResource("/GuiPublicite/TableView.fxml"));
            anchtable.getChildren().setAll(pane);
        }
        if (actionEvent.getSource() == btnevent) {
            Pane pane = FXMLLoader.load(getClass().getResource("Gestionpubadmin.fxml"));
            anchtable.getChildren().setAll(pane);
        }
        if (actionEvent.getSource() == btnSignout) {
            
              Parent root=FXMLLoader.load(getClass().getResource("logininterface.fxml"));
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();

        }
      
//        Scene scene =  btnCustomers.getScene();
//        stage.setScene(scene);
//       // stage.setTitle("");
//        stage.show();
        
    }
}
