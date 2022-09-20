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

import java.sql.Statement;
import java.util.ResourceBundle;

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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ServiceEvenTun.userservice;
import java.awt.event.MouseEvent;
import javafx.event.ActionEvent;
import javax.swing.JOptionPane;

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
//    private Statement ste;
//    private PreparedStatement pst;
//    private ResultSet rs;

    @FXML
    private TableView<User> table;
    @FXML
    private TableColumn<User, Integer> tab_id;
     @FXML
    private TableColumn<User, String> tab_Nom;
    @FXML
    private TableColumn<User, String> tab_Prenom;
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
userservice us = new userservice();
   // ObservableList<User> obs = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadDate();
        // Display();

    }

    public void Display() {

       
        

       
        tab_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tab_Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tab_Prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        tab_login.setCellValueFactory(new PropertyValueFactory<>("login"));
        tab_pwd.setCellValueFactory(new PropertyValueFactory<>("pwd"));
        tab_telf.setCellValueFactory(new PropertyValueFactory<>("Telephone"));
        tab_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        tab_role.setCellValueFactory(new PropertyValueFactory<>("role"));
        ObservableList<User> s = FXCollections.observableArrayList(us.readAll());

        table.setItems(s);
       //  s.clear();
        System.out.println("ok");
    }

 

    @FXML
    private void loadDate() {
    

        ObservableList<User> s = FXCollections.observableArrayList(us.readAll());

        tab_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tab_Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tab_Prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        tab_login.setCellValueFactory(new PropertyValueFactory<>("login"));
        tab_pwd.setCellValueFactory(new PropertyValueFactory<>("pwd"));
        tab_telf.setCellValueFactory(new PropertyValueFactory<>("Telephone"));
        tab_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        tab_role.setCellValueFactory(new PropertyValueFactory<>("role"));
        table.setItems(s);

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
                        final Button cellcontact = new Button("Envoyer mail");
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
                        cellcontact.setStyle(
                                " -fx-border-color:  #2A73FF ;"
                                + "-fx-border-radius:20px;"
                                + "-fx-background-color:transparent;"
                        );

                        cellRemouv.setOnAction(e -> {
                            userservice us = new userservice();
                            User selectedItem = table.getSelectionModel().getSelectedItem();
                           

                            us.deleteuser(selectedItem);

                                Display();
                        });

                        cellmodif.setOnMouseClicked((event) -> {
                           

                            User u = table.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("UpdateuserAdmin.fxml"));

                            try {
                                loader.load();
//                                sc.modifierCommentaire(c);
                            } catch (IOException ex) {
                                System.out.println(ex);
                            }
                    UpdateuserController updateuser = loader.getController();

                            updateuser.setTextField(u.getId(),u.getNom(),u.getPrenom(), u.getLogin(), u.getPwd(), u.getTelephone(), u.getEmail(), u.getRole());
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.show();
                      // Display();
                        });
                         cellcontact.setOnMouseClicked((event) -> {
              

                            User u = table.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("sendmail.fxml"));

                            try {
                                loader.load();
//                                sc.modifierCommentaire(c);
                            } catch (IOException ex) {
                                System.out.println(ex);
                            }
                            SendmailController sendemail = loader.getController();

                            sendemail.setTextField(u.getEmail());
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.show();

                        });
                        HBox btn = new HBox(cellRemouv, cellmodif, cellcontact);
                        setGraphic(btn);
                        setText(null);
                    }

                }

            };
            return cell;
        };
        action.setCellFactory(cellFoctory);
         table.setItems(s);
    }

}
