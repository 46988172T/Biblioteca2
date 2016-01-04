package funcionalitats;

import clases.Llibres;

/**
 * Created by leosss on 4/01/16.
 */
public class FuncLlibres {
    public static void altaLlibres() {
        /*todo: alta del libro y pasarlo por el DAO*/
        System.out.println("Indica titol del llibre");
        System.out.println("Indica número d'exemplars");
        System.out.println("Indica editorial");
        System.out.println("Indica número de pàgines");
        System.out.println("Indica any edició");
        Llibres nouLlibre = new Llibres(id, num_exemplars, titol, num_pagines, editorial, any_edicio);
    }

    public static void baixaLlibres(){
        /*todo: seleccionar libro y borrarlo de la db*/
    }

    public static void modificarLlibres(){
        /*todo: seleccionar libro y modificarlo*/
    }
}
