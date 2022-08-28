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
    private int id ;
    protected int numero ;
    public float prix ;
    protected int promotion ;

    public Tickets() {
    }

    public Tickets(int id, int numero, float prix, int promotion) {
        this.id = id;
        this.numero = numero;
        this.prix = prix;
        this.promotion = promotion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Tickets{" + "id=" + id + ", numero=" + numero + ", prix=" + prix + ", promotion=" + promotion + '}';
    }
    
    
}
