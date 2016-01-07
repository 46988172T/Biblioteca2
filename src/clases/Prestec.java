package clases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by leosss on 4/01/16.
 * Préstec (llibre, soci, data inici, data final)
 */
@Entity
public class Prestec implements Serializable{
    @Id
    private int id_llibres;
    @Id
    private int id_soci;

    @Column(name="data_inici")
    private Date data_inici;
    @Column(name="data_final")
    private Date data_final;
    @Column(name="titol")
    private String titol;



    public Prestec( int id_llibres, int id_soci, String titol, Date data_inici, Date data_final) {
        this.id_llibres=id_llibres;
        this.id_soci=id_soci;
        this.titol = titol;
        this.data_inici = data_inici;
        this.data_final = data_final;
    }

    public Prestec() {
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

    public int getId_soci() {
        return id_soci;
    }

    public void setId_soci(int id_soci) {
        this.id_soci = id_soci;
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
