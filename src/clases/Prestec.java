package clases;

import java.util.Date;

/**
 * Created by leosss on 4/01/16.
 * Préstec (llibre, soci, data inici, data final)
 */
public class Prestec {
    private Date data_inici;
    private Date data_final;
    private int id_llibres;
    private String titol;
    private int soci;

    public Prestec(int id_llibres, String titol, int soci, Date data_inici, Date data_final) {
        this.id_llibres = id_llibres;
        this.titol = titol;
        this.soci = soci;
        this.data_inici = data_inici;
        this.data_final = data_final;
    }

    /*
    Getters i setters
     */

    public int getId_llibres() {
        return id_llibres;
    }

    public void setId_llibres(int id_llibres) {
        this.id_llibres = id_llibres;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public int getSoci() {
        return soci;
    }

    public void setSoci(int soci) {
        this.soci = soci;
    }

    public Date getData_final() {
        return data_final;
    }

    public void setData_final(Date data_final) {
        this.data_final = data_final;
    }

    public Date getData_inici() {
        return data_inici;
    }

    public void setData_inici(Date data_inici) {
        this.data_inici = data_inici;
    }
}
