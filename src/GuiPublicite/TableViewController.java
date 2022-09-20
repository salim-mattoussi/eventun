/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiPublicite;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import UtilData.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import GestionPublicite.Publicite;
import ServiceEvenTun.PubService;
import javafx.collections.ObservableList;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class TableViewController implements Initializable {

    @FXML
    private TableView<Publicite> publicitesTable;
    @FXML
    private TableColumn<Publicite, String> idCol;
    @FXML
    private TableColumn<Publicite, String> typeCol;
    @FXML
    private TableColumn<Publicite, String> descripCol;
    @FXML
    private TableColumn<Publicite, String> imgCol;
    @FXML
    private TableColumn<Publicite, String> editCol;

    @FXML
    private AnchorPane root;

    @FXML
    private Button btnPrint;

    String query = null;
    Connection cnx = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Publicite publicite= new Publicite();

    PubService ps = new PubService();
    ObservableList<Publicite> PubliciteList = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadDate();
    }

    public TableViewController() {
        cnx = DataSource.getConnection();
    }

    @FXML
    private void close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void getAddView(MouseEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/GuiPublicite/AddPublicite.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(TableViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void refreshTable() {

        PubliciteList.clear();
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        descripCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        imgCol.setCellValueFactory(new PropertyValueFactory<>("image"));
        publicitesTable.setItems(ps.readAll());

    }

    @FXML
    private void print(MouseEvent event) {
        /* btnPrint.setVisible(false);
        MouseEvent root = null;
        print(root); */
 /*  ObservableSet<Printer> printers = Printer.getAllPrinters();
 
for(Printer printer : printers) 
{
    textArea.appendText(printer.getName()+"\n");
} */

    }

    /*  private void print(Node node) {
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null && job.showPrintDialog(node.getScene().getWindow())){
            boolean success = job.printPage(node);
            if (success) {
                job.endJob();
            }
        }
        btnPrint.setVisible(true);
    }  
      
     */
    private void loadDate() {

        refreshTable();

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        descripCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        imgCol.setCellValueFactory(new PropertyValueFactory<>("image"));

        //add cell of button edit 
        Callback<TableColumn<Publicite, String>, TableCell<Publicite, String>> cellFoctory = (TableColumn<Publicite, String> param) -> {
            // make cell containing buttons
            final TableCell<Publicite, String> cell = new TableCell<Publicite, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {

                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);

                        deleteIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#ff1744;"
                        );
                        editIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#00E676;"
                        );
                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {

                            publicite = publicitesTable.getSelectionModel().getSelectedItem();
                            ps.deletepub(publicite);
                            refreshTable();

                        });
                        editIcon.setOnMouseClicked((MouseEvent event) -> {

                                                     publicite = publicitesTable.getSelectionModel().getSelectedItem();

                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("/GuiPublicite/AddPublicite.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(TableViewController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            AddPubliciteController AddPubliciteController = loader.getController();
                            AddPubliciteController.setUpdate(true);
                            AddPubliciteController.setTextField(publicite.getId(), publicite.getType(), 
                                    publicite.getDescription(), publicite.getImage());
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();
                            

                           
                         

                        });
                        HBox managebtn = new HBox(editIcon, deleteIcon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
                        HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));

                        setGraphic(managebtn);

                        setText(null);

                    }
                }

            };

            return cell;
        };
        editCol.setCellFactory(cellFoctory);
        publicitesTable.setItems(ps.readAll());

    }

}
