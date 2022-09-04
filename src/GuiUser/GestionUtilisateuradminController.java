/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiUser;

import GestionUser.User;
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
import UtilData.DataSource;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.userservice;

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
    private TableView<User> table;
    @FXML
    private TableColumn<User, Integer> tab_id;
    @FXML
    private TableColumn<User, String> tab_login;
    @FXML
    private TableColumn<User, String> tab_pwd;
    @FXML
    private TableColumn<User, Integer> tab_telf;
    @FXML
    private TableColumn<User, String> tab_email;
    @FXML
    private TableColumn<User, String> tab_role;
    @FXML
    private TableColumn<User, String> action;

    //private User u1;
    public GestionUtilisateuradminController() {

        cnx = DataSource.getConnection();
    }

    ObservableList<User> obs = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadDate();

    }

    public void Display() {
        obs.clear();
        String requete = "select * from user";

        try {
            ste = cnx.prepareStatement(requete);

            rs = ste.executeQuery(requete);

            while (rs.next()) {
                User u = new User(rs.getInt("id"), rs.getString("login"), rs.getString("pwd"), rs.getInt("Telephone"), rs.getString("email"), rs.getString("role"));
                obs.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionUtilisateuradminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tab_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tab_login.setCellValueFactory(new PropertyValueFactory<>("login"));
        tab_pwd.setCellValueFactory(new PropertyValueFactory<>("pwd"));
        tab_telf.setCellValueFactory(new PropertyValueFactory<>("Telephone"));
        tab_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        tab_role.setCellValueFactory(new PropertyValueFactory<>("role"));

        table.setItems(obs);
    }

    @FXML
    private void loadDate() {

        tab_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tab_login.setCellValueFactory(new PropertyValueFactory<>("login"));
        tab_pwd.setCellValueFactory(new PropertyValueFactory<>("pwd"));
        tab_telf.setCellValueFactory(new PropertyValueFactory<>("Telephone"));
        tab_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        tab_role.setCellValueFactory(new PropertyValueFactory<>("role"));
        Display();
        Callback<TableColumn<User, String>, TableCell<User, String>> cellFoctory = (TableColumn<User, String> param) -> {
            // make cell containing button
            final TableCell<User, String> cell = new TableCell<User, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {

                        final Button cellRemouv = new Button("Remove");
                        final Button cellmodif = new Button("modifier");
                        cellRemouv.setStyle(
                                " -fx-border-color:  #2A73FF ;"
                                + "-fx-border-radius:20px;"
                                + "-fx-background-color:transparent;"
                        );
                        cellmodif.setStyle(
                                " -fx-border-color:  #2A73FF ;"
                                + "-fx-border-radius:20px;"
                                + "-fx-background-color:transparent;"
                        );

                        cellRemouv.setOnAction(e -> {
                            User selectedItem = table.getSelectionModel().getSelectedItem();
                            //table.getItems().remove(selectedItem);
                            try {
                                pst = cnx.prepareStatement("Delete from user where id=?");
                                ste = cnx.createStatement();
                                pst.setInt(1, selectedItem.getId());
                                pst.executeUpdate();

                            } catch (SQLException ex) {
                                Logger.getLogger(GestionUtilisateuradminController.class.getName()).log(Level.SEVERE, null, ex);
                            }
//                                Display();
                        });

                        cellmodif.setOnMouseClicked((event) -> {
//                            try {
//                                 User u = getTableView().getItems().get(getIndex());
//
//                                
//                                Parent pane = FXMLLoader.load(getClass().getResource("Updateuser.fxml"));
//                                
//                                Scene scene = new Scene(pane);
//                                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                                window.setScene(scene);
//                                window.show();
//                            } catch (IOException ex) {
//                                Logger.getLogger(GestionUtilisateuradminController.class.getName()).log(Level.SEVERE, null, ex);
//                            }
                            User u = table.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("Updateuser.fxml"));
                  
                            try {
                                loader.load();
//                                sc.modifierCommentaire(c);
                            } catch (IOException ex) {
                                System.out.println(ex);
                            }
                            UpdateuserController updateuser = loader.getController();
                           
                            updateuser.setTextField(u.getId(), u.getLogin() ,u.getPwd(), u.getTelephone(), u.getEmail(), u.getRole());
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.show();

                        });
                        HBox btn = new HBox(cellRemouv, cellmodif);
                        setGraphic(btn);
                        setText(null);
                    }

                }

            };
            return cell;
        };
        action.setCellFactory(cellFoctory);
        table.setItems(obs);
    }

}
