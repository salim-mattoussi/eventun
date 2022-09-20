/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiUser;



import java.net.URL;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.mail.*;
import javax.mail.internet.*;

import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author panda
 */
public class SendmailController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField to;
    
    @FXML
    private TextArea cont;
    
    @FXML
    private TextField sub;
        @FXML
    private Button btnback;

    
    String fromE, toE, hostE, subE, contentE;
    
    @FXML
    void Envoyer(ActionEvent event) {
        
        fromE = "eventun097@gmail.com";
        toE = to.getText();
        hostE = "localhost";
        subE = sub.getText();
        contentE = cont.getText();
        if (to.getText().equals("") || cont.getText().equals("") || cont.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "svp remplir les champs ");
        } else {
        Properties properties = new Properties();
        //Enable authentication
        properties.put("mail.smtp.auth", "true");

        //Set TLS encryption enabled
        properties.put("mail.smtp.starttls.enable", "true");
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
        //Set SMTP host
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //Set smtp port
        properties.put("mail.smtp.port", "587");
        
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("eventun097@gmail.com", "cxlgmtfdidbyvdtp");
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromE));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toE));
            message.setSubject(subE);
            
            message.setText(contentE);
            //Send mail
            Transport.send(message);
            System.out.println("Message sent successfully");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }}


    void setTextField(String email) {
        
        to.setText(email);
        
    }

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
}
