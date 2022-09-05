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
    protected int numero ;
    public float prix ;
    protected int promotion ;

    public Tickets() {
    }

    public Tickets(int idT, int numero, float prix, int promotion) {
        this.idT = idT;
        this.numero = numero;
        this.prix = prix;
        this.promotion = promotion;
    }

    public int getId() {
        return idT;
    }

    public void setId(int idT) {
        this.idT = idT;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
        return "Tickets{" + "id=" + idT + ", numero=" + numero + ", prix=" + prix + ", promotion=" + promotion + '}';
    }
    
    
}
