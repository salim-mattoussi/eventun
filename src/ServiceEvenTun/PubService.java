/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceEvenTun;

import GestionPublicite.Publicite;
import UtilData.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

   public class PubService {
    private final Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public PubService() {
        cnx = DataSource.getInstance().getConnection();
    }


    public void add(Publicite p) throws SQLException {
        String requete = "insert into Publicite (type,description) values(?,?)";

        pst = cnx.prepareStatement(requete);

       
        pst.setString(1, p.getType());
        pst.setString(2, p.getDescription());
       

        pst.executeUpdate();

    }
        }