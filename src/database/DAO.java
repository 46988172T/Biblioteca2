package database;

import clases.Llibres;
import clases.Prestec;
import clases.Socis;
import org.hibernate.*;

import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.List;


/**
 * Created by leosss on 4/01/16.
 */
public class DAO {
    private static String DRIVERDD = "org.postgresql.Driver";
    private static String nombreDB = "jdbc:postgresql://192.168.1.39:5432/library";
    public static SessionFactory factory;

    /**
     * Inserta nou llibre.
     * @param llibre
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void insert_llibres(Llibres llibre) throws SQLException, ClassNotFoundException {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            session.save(llibre);
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        System.out.println(llibre);
    }

    /**
     * Inserta nou soci.
     * @param soci
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void insert_soci(Socis soci) throws SQLException, ClassNotFoundException {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            session.save(soci);
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        System.out.println(soci);
    }

    public static void insert_prestec(Prestec prestec) throws SQLException, ClassNotFoundException {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try{
            session.save(prestec);
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        System.out.println(prestec);
    }

    /**
     * Mostra llibres.
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void mostra_llibres() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVERDD);
        Connection c = DriverManager.getConnection(nombreDB,"leo","leo");
        c.setAutoCommit(false);
        Statement stmt = c.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM llibres ORDER BY id_llibre;");
        System.out.println("-------ID-------|-------LLIBRE-------");
        while (rs.next()) {
            int id = rs.getInt("id_llibre");
            String titol = rs.getString("titol");
            System.out.println("\t"+id+"\t\t\t|\t"+titol);
        }

        rs.close();
        stmt.close();
        c.close();
    }

    /**
     * Mostra socis.
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void mostra_socis() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVERDD);
        Connection c = DriverManager.getConnection(nombreDB,"leo","leo");
        c.setAutoCommit(false);
        Statement stmt = c.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM socis ORDER BY id_soci;");
        System.out.println("-------ID-------|-------NOM-------|-----COGNOMS-----");
        while (rs.next()) {
            int id = rs.getInt("id_soci");
            String nom = rs.getString("nom");
            String cognoms = rs.getString("cognoms");
            System.out.println("\t\t"+id+"\t\t\t\t"+nom+"\t\t\t\t"+cognoms);
        }

        rs.close();
        stmt.close();
        c.close();
    }

    /**
     * fa la baixa d'un llibre de la db segons la id.
     * @param a
     */
    public static void baixa_llibre(int a){
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Query query = session.createQuery("delete Llibres where id_llibres = :id_llibre");
        query.setParameter("id_llibre", a );
        int result = query.executeUpdate();

        if (result > 0) {
            System.out.println("Llibre esborrat");
        }
    }

    /**
     * fa la baixa d'un soci de la db segons la id.
     * @param a
     */
    public static void baixa_soci(int a){
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Query query = session.createQuery("delete Socis where id_soci = :id_soci");
        query.setParameter("id_soci", a );
        int result = query.executeUpdate();

        if (result > 0) {
            System.out.println("Llibre esborrat");
        }
    }

    /**
     * Mostra socis segons nom.
     * @param setnom
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void socis_per_nom(String setnom) throws SQLException, ClassNotFoundException {

        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String hql = "FROM Socis WHERE nom LIKE '"+setnom+"'";
        Query query = session.createQuery(hql);
        List results = query.list();
        if(results.isEmpty()){
            System.out.println("No hi ha resultats");
        }else{
            System.out.println("Resultats:\n---------------");
            for (int i = 0; i<results.size();i++) {
                Socis soci = (Socis) results.get(i);

                System.out.println("ID: " + soci.getId_soci());
                System.out.println("NOM: " + soci.getNom());
                System.out.println("COGNOMS: "+soci.getCognoms()+"\n");

            }
        }
    }

    /**
     * Mostra socis segons cognoms.
     * @param setcognoms
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void socis_per_cognoms(String setcognoms) throws SQLException, ClassNotFoundException {

        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String hql = "FROM Socis WHERE cognoms LIKE '"+setcognoms+"'";
        Query query = session.createQuery(hql);
        List results = query.list();
        if(results.isEmpty()){
            System.out.println("No hi ha resultats");
        }else{
            System.out.println("Resultats:\n---------------");
            for (int i = 0; i<results.size();i++) {
                Socis soci = (Socis) results.get(i);

                System.out.println("ID: " + soci.getId_soci());
                System.out.println("NOM: " + soci.getNom());
                System.out.println("COGNOMS: "+soci.getCognoms()+"\n");

            }
        }
    }

    /**
     * Mostra llibres segons titol.
     * @param settitol
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void llibres_per_titol(String settitol) throws SQLException, ClassNotFoundException {

        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String hql = "FROM Llibres WHERE titol LIKE '"+settitol+"'";
        Query query = session.createQuery(hql);
        List results = query.list();
        if(results.isEmpty()){
            System.out.println("No hi ha resultats");
        }else{
            System.out.println("Resultats:\n---------------");
            for (int i = 0; i<results.size();i++) {
                Llibres llibre = (Llibres) results.get(i);

                System.out.println("ID: " + llibre.getId_llibres());
                System.out.println("TITOL: " + llibre.getTitol());
                System.out.println("AUTOR: "+llibre.getAutor());
                System.out.println("EDITORIAL: "+llibre.getEditorial());
                System.out.println("EXEMPLARS: "+llibre.getNum_exemplars()+"\n");


            }
        }
    }

    /**
     * Mostra llibres per autor.
     * @param setautor
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void llibres_per_autor(String setautor) throws SQLException, ClassNotFoundException {

        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String hql = "FROM Llibres WHERE autor LIKE '"+setautor+"'";
        Query query = session.createQuery(hql);
        List results = query.list();
        if(results.isEmpty()){
            System.out.println("No hi ha resultats");
        }else{
            System.out.println("Resultats:\n---------------");
            for (int i = 0; i<results.size();i++) {
                Llibres llibre = (Llibres) results.get(i);

                System.out.println("ID: " + llibre.getId_llibres());
                System.out.println("TITOL: " + llibre.getTitol());
                System.out.println("AUTOR: "+llibre.getAutor());
                System.out.println("EDITORIAL: "+llibre.getEditorial());
                System.out.println("EXEMPLARS: "+llibre.getNum_exemplars()+"\n");


            }
        }
    }

    /**
     * Mostra tots els prestecs.
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void llistaPrestecs() throws SQLException, ClassNotFoundException {

        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String hql = "FROM Prestec";
        Query query = session.createQuery(hql);
        List results = query.list();
        if(results.isEmpty()){
            System.out.println("No hi ha resultats");
        }else{
            System.out.println("Resultats:\n---------------");
            for (int i = 0; i<results.size();i++) {
                Prestec prestec = (Prestec) results.get(i);

                System.out.println("ID: " + prestec.getId_llibres());
                System.out.println("TITOL: " + prestec.getTitol());
                System.out.println("PRESTAT A: ");
                socis_per_id(prestec.getId_soci());

            }
        }
    }

    /**
     * Mostra els llibres prestats a un soci segons la ID del soci.
     * @param id
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void llistaPrestecsPerSoci(int id) throws SQLException, ClassNotFoundException {

        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String hql = "FROM Prestec WHERE id_soci ="+id;
        Query query = session.createQuery(hql);
        List results = query.list();
        if(results.isEmpty()){
            System.out.println("No hi ha resultats");
        }else{
            System.out.println("Resultats:\n---------------");
            System.out.println("SOCI:");
            socis_per_id(id);
            for (int i = 0; i<results.size();i++) {
                Prestec prestec = (Prestec) results.get(i);
                System.out.println("ID: " + prestec.getId_llibres());
                System.out.println("TITOL: " + prestec.getTitol());
            }
        }
    }

    /**
     * Mostra socis per ID
     * @param id
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void socis_per_id(int id) throws SQLException, ClassNotFoundException {

        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String hql = "FROM Socis WHERE id_soci = "+id+"";
        Query query = session.createQuery(hql);
        List results = query.list();
        if(results.isEmpty()){
            System.out.println("No hi ha resultats");
        }else{
            System.out.println("Resultats:\n---------------");
            for (int i = 0; i<results.size();i++) {
                Socis soci = (Socis) results.get(i);

                System.out.println("ID: " + soci.getId_soci());
                System.out.println("NOM: " + soci.getNom());
                System.out.println("COGNOMS: "+soci.getCognoms()+"\n");

            }
        }
    }
}
