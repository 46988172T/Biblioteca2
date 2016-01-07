package funcionalitats;

import clases.Socis;
import database.DAO;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by leosss on 4/01/16.
 */
public class FuncSocis {
    static Scanner func = new Scanner(System.in);
    static Scanner funcInt = new Scanner(System.in);
    public static void altaSocis() throws SQLException, ClassNotFoundException {
        System.out.println("Indica nom");
        String nom = func.nextLine();
        System.out.println("Indica cognoms");
        String cognoms = func.nextLine();
        System.out.println("Indica edat");
        int edat = funcInt.nextInt();
        System.out.println("Indica adreça");
        String adress = func.nextLine();
        System.out.println("Indica telèfon");
        int telefon = funcInt.nextInt();
        Socis nouSoci = new Socis(nom, cognoms, edat, adress, telefon);
        DAO.insert_soci(nouSoci);
    }

    public static void baixaSocis() throws SQLException, ClassNotFoundException {
        System.out.println("Verifica ID a esborrar");
        DAO.mostra_socis();
        System.out.println("Indica ID del llibre");
        int esborraSoci = funcInt.nextInt();
        DAO.baixa_llibre(esborraSoci);
    }

    public static void modificarSocis() throws SQLException, ClassNotFoundException {
        DAO.mostra_socis();
    }

    public static void consultaSociPerNom() throws SQLException, ClassNotFoundException {
        System.out.println("Indica nom a buscar");
        String nom = func.nextLine();
        DAO.socis_per_nom(nom);
    }

    public static void consultaSociPerCognoms() throws SQLException, ClassNotFoundException {
        System.out.println("Indica cognoms a buscar");
        String cognom = func.nextLine();
        DAO.socis_per_cognoms(cognom);
    }
    public static void llistatPerId() throws SQLException, ClassNotFoundException {
        System.out.println("Tria ID del soci per veure els llibres.");
        DAO.mostra_socis();
        int id = funcInt.nextInt();
        DAO.llistaPrestecsPerSoci(id);
    }
}
