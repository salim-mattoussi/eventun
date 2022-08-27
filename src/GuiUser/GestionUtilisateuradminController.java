/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiUser;

import GestionUser.user;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import util.DataSource;

/**
 * FXML Controller class
 *
 * @author panda
 */
public class GestionUtilisateuradminController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
 
   
    @FXML
    private TableView<user> table;
    @FXML
    private TableColumn<user, Integer> tab_id;
    @FXML
    private TableColumn<user, String> tab_login;
    @FXML
    private TableColumn<user, String> tab_pwd;
    @FXML
    private TableColumn<user, Integer> tab_telf;
    @FXML
    private TableColumn<user, String> tab_email;
    @FXML
    private TableColumn<user, String> tab_role;
    @FXML
    private TableColumn<user, String> action;

    public GestionUtilisateuradminController() {

        cnx = DataSource.getInstance().getConnection();
    }

    ObservableList<user> obs = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadDate();
    }

    @FXML
    public void Display() {
        try {
            String requete = "select * from user";

            ste = cnx.createStatement();

            rs = ste.executeQuery(requete);

            while (rs.next()) {
                user u = new user(rs.getInt("id"), rs.getString("login"), rs.getString("pwd"), rs.getInt("telephone"), rs.getString("email"), rs.getString("role"));
                obs.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateuradminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tab_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tab_login.setCellValueFactory(new PropertyValueFactory<>("login"));
        tab_pwd.setCellValueFactory(new PropertyValueFactory<>("pwd"));
        tab_telf.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        tab_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        tab_role.setCellValueFactory(new PropertyValueFactory<>("role"));

        
        table.setItems(obs);
    }

    @FXML
    private void loadDate() {

        tab_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tab_login.setCellValueFactory(new PropertyValueFactory<>("login"));
        tab_pwd.setCellValueFactory(new PropertyValueFactory<>("pwd"));
        tab_telf.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        tab_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        tab_role.setCellValueFactory(new PropertyValueFactory<>("role"));
        Display();
        Callback<TableColumn<user, String>, TableCell<user, String>> cellFoctory = (TableColumn<user, String> param) -> {
            // make cell containing button
            final TableCell<user, String> cell = new TableCell<user, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {

                        final Button cellButton = new Button("Remove");
                        final Button cellmodif = new Button("modifier");
                        cellButton.setStyle(
                                " -fx-border-color:  #2A73FF ;"
                                + "-fx-border-radius:20px;"
                                + "-fx-background-color:transparent;"
                        );
                         cellmodif.setStyle(
                                " -fx-border-color:  #2A73FF ;"
                                + "-fx-border-radius:20px;"
                                + "-fx-background-color:transparent;"
                        );
                        cellButton.setOnMouseClicked((event) -> {

//                            @Override
//                            public void handle(ActionEvent t) {
//                                int selectedIndex = getTableRow().getIndex();
//                                user toRemove = (user) tblView.getItems().get(selectedIndex);
//                                // tempBoM.remove(toRemove);
//                                // prepareBoMTable();
                        });
                        cellmodif.setOnMouseClicked((event) -> {

//                            @Override
//                            public void handle(ActionEvent t) {
//                                int selectedIndex = getTableRow().getIndex();
//                                user toRemove = (user) tblView.getItems().get(selectedIndex);
//                                // tempBoM.remove(toRemove);
//                                // prepareBoMTable();
                        });
                        HBox btn = new HBox(cellButton, cellmodif);
                        setGraphic(btn);
                        setText(null);
                    }

                }

            };
            return cell;
        };
        action.setCellFactory(cellFoctory);
    }
}
