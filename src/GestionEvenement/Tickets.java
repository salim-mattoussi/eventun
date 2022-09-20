/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionevenement;

/**
 *
 * @author SALIM
 */
public class Tickets {
    private int idT ;
   
    public float prix ;
    protected int promotion ;

    public Tickets() {
    }

    public Tickets(int idT,  float prix, int promotion) {
        this.idT = idT;
        
        this.prix = prix;
        this.promotion = promotion;
    }

    public int getId() {
        return idT;
    }

    public void setId(int idT) {
        this.idT = idT;
    }


    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }

    @Override
    public String toString() {
        return "Tickets{" + "id=" + idT + ",  prix=" + prix + ", promotion=" + promotion + '}';
    }
    
    
}
