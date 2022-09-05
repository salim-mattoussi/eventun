/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionevenement;

/**
 *
 * @author SALIM
 */
public class evenement {
    protected int idE;
    protected String nom;
    protected String lieu;
    protected String dateevent;
    protected String description;

    public evenement(int idE, String nom, String lieu, String dateevent, String description) {
        this.idE = idE;
        this.nom = nom;
        this.lieu = lieu;
        this.dateevent = dateevent;
        this.description = description;
    }

    public evenement() {
    }

    public int getIdE() {
        return idE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDateevent() {
        return dateevent;
    }

    public void setDateevent(String dateevent) {
        this.dateevent = dateevent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
