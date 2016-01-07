package clases;

import javax.persistence.*;

/**
 * Created by leosss on 4/01/16.
 * Socis (nom, cognom, edat, direcció, telèfon)
 */
@Entity
public class Socis {
    @Id
    @Column(name="id_soci")
    private int id_soci;

    @Column(name="nom")
    private String nom;

    @Column(name="cognoms")
    private String cognoms;

    @Column(name="edat")
    private int edat;

    @Column(name="adress")
    private String adress;

    @Column(name="telefon")
    private int telefon;

    public Socis() {    }

    public Socis(String nom, String cognoms, int edat, String adress, int telefon) {
        this.id_soci = id_soci;
        this.nom = nom;
        this.cognoms = cognoms;
        this.edat = edat;
        this.adress = adress;
        this.telefon = telefon;
    }

    /*
    Getters i setters
     */

    public int getId_soci() {
        return id_soci;
    }

    public void setId_soci(int id_soci) {
        this.id_soci = id_soci;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }
}
