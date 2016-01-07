package clases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by leosss on 4/01/16.
 * Llibres (títol, nombre d'exemplars, editorial, nombre de pàgines, any d'edició)
 */
@Entity
public class Llibres {
    @Id
    @GeneratedValue
    @Column(name="id_llibre")
    private int id_llibres;

    @Column(name="titol")
    private String titol;

    @Column(name="autor")
    private String autor;

    @Column(name="num_exemplars")
    private int num_exemplars;

    @Column(name="editorial")
    private String editorial;

    @Column(name="num_pagines")
    private int num_pagines;

    @Column(name="any_edicio")
    private int any_edicio;

    public Llibres(){}
    public Llibres(String titol, String autor, int num_exemplars, String editorial, int num_pagines, int any_edicio) {
        this.id_llibres = id_llibres;
        this.autor = autor;
        this.num_exemplars = num_exemplars;
        this.titol = titol;
        this.num_pagines = num_pagines;
        this.editorial = editorial;
        this.any_edicio = any_edicio;
    }

    /*
    Getters i setters
     */

    public int getAny_edicio() {
        return any_edicio;
    }

    public void setAny_edicio(int any_edicio) {
        this.any_edicio = any_edicio;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNum_pagines() {
        return num_pagines;
    }

    public void setNum_pagines(int num_pagines) {
        this.num_pagines = num_pagines;
    }

    public int getNum_exemplars() {
        return num_exemplars;
    }

    public void setNum_exemplars(int num_exemplars) {
        this.num_exemplars = num_exemplars;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public int getId_llibres() {
        return id_llibres;
    }

    public void setId_llibres(int id_llibres) {
        this.id_llibres = id_llibres;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
