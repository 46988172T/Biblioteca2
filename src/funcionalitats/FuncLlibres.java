package funcionalitats;
import clases.Llibres;
import database.DAO;
import database.DAO.*;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by leosss on 4/01/16.
 */
public class FuncLlibres {
    static Scanner func = new Scanner(System.in);
    static Scanner funcInt = new Scanner(System.in);
    public static void altaLlibres() throws SQLException, ClassNotFoundException {
        //System.out.println("Indica ID llibre");
        //int id_llibre = funcInt.nextInt();
        System.out.println("Indica titol del llibre");
        String titol = func.nextLine();
        System.out.println("Indica l'autor");
        String autor = func.nextLine();
        System.out.println("Indica número d'exemplars");
        int num_exemplars = funcInt.nextInt();
        System.out.println("Indica editorial");
        String editorial = func.nextLine();
        System.out.println("Indica número de pàgines");
        int num_pagines = funcInt.nextInt();
        System.out.println("Indica any edició");
        int any_edicio = funcInt.nextInt();
        Llibres nouLlibre = new Llibres(titol, autor, num_exemplars, editorial, num_pagines, any_edicio);
        DAO.insert_llibres(nouLlibre);
    }

    public static void baixaLlibres() throws SQLException, ClassNotFoundException {
        System.out.println("Verifica ID a esborrar");
        DAO.mostra_llibres();
        System.out.println("Indica ID del llibre");
        int esborraLlibre = funcInt.nextInt();
        DAO.baixa_llibre(esborraLlibre);
    }

    public static void modificarLlibres() throws SQLException, ClassNotFoundException {
        DAO.mostra_llibres();
    }

    public static void consultaLlibrePerTitol() throws SQLException, ClassNotFoundException {
        System.out.println("Indica titol del llibre a buscar");
        String titol = func.nextLine();
        DAO.llibres_per_titol(titol);
    }

    public static void consultaLlibrePerAutor() throws SQLException, ClassNotFoundException {
        System.out.println("Indica el nom de l'autor");
        String autor = func.nextLine();
        DAO.llibres_per_autor(autor);
    }




}
