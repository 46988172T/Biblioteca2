package clases;

/**
 * Created by leosss on 4/01/16.
 * Llibres (títol, nombre d'exemplars, editorial, nombre de pàgines, any d'edició)
 */
public class Llibres {
    private int id_llibres;
    private String titol;
    private int num_exemplars;
    private String editorial;
    private int num_pagines;
    private int any_edicio;

    public Llibres(int id, int num_exemplars, String titol, int num_pagines, String editorial, int any_edicio) {
        this.id_llibres = id;
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
}
