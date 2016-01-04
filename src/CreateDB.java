import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by leosss on 4/01/16.
 *
 *  taules:
 * - Llibres (títol, nombre d'exemplars, editorial, nombre de pàgines, any d'edició)
 * - Socis (nom, cognom, edat, direcció, telèfon)
 * - Préstec (llibre, soci, data inici, data final)
 */
public class CreateDB {
    private static String DRIVERDD = "org.postgresql.Driver";
    private static String nombreDb = "jdbc:postgresql://192.168.1.39:5432/biblioteca";

    public static void createDB (String nom) {
        Connection c = null;

        try {
            Class.forName(DRIVERDD);
            c = DriverManager.getConnection(nombreDb,"leo","leo");
            System.out.println("Base de dades creada correctament");
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return;
    }

    public static void createTableLlibres(){

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName(DRIVERDD);
            c = DriverManager.getConnection(nombreDb,"leo","leo");
            System.out.println("Base de dades oberta correctament");

            stmt = c.createStatement();
            String sql = "CREATE TABLE LLIBRES " +
                    "(ID_LLIBRE INT PRIMARY KEY     NOT NULL," +
                    " TITOL           TEXT    NOT NULL," +
                    " NUM_EXEMPLARS   INT     NOT NULL," +
                    " EDITORIAL       TEXT    NOT NULL," +
                    " NUM_PAGINES     INT     NOT NULL," +
                    " ANY_EDICIO      INT     NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
            System.out.println("Taula creada correctament");
        } catch ( Exception e ) {
            System.out.println("La taula ja existeix");
        }

    }

    public static void createTableSocis(){

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName(DRIVERDD);
            c = DriverManager.getConnection(nombreDb,"leo","leo");
            System.out.println("Base de dades oberta correctament");

            stmt = c.createStatement();
            String sql = "CREATE TABLE SOCIS " +
                    "(ID_SOCI INT PRIMARY KEY     NOT NULL," +
                    " NOM           TEXT    NOT NULL," +
                    " COGNOMS       TEXT    NOT NULL," +
                    " EDAT          INT     NOT NULL," +
                    " ADRESS        TEXT    NOT NULL," +
                    " TELEFON       INT     NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
            System.out.println("Taula creada correctament");
        } catch ( Exception e ) {
            System.out.println("La taula ja existeix");
        }
    }

    public static void createTablePrestec(){

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName(DRIVERDD);
            c = DriverManager.getConnection(nombreDb,"leo","leo");
            System.out.println("Base de dades oberta correctament");
            stmt = c.createStatement();
            String sql = "CREATE TABLE PRESTEC " +
                    "(ID_LLIBRE     INT    NOT NULL," +
                    " ID_SOCI       INT    NOT NULL," +
                    " TITOL         TEXT   NOT NULL," +
                    " DATA_INICI    DATE   NOT NULL," +
                    " DATA_FINAL    DATE   NOT NULL," +
                    " PRIMARY KEY (ID_LLIBRE, ID_SOCI) )";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
            System.out.println("Taula creada correctament");
        } catch ( Exception e ) {
            System.out.println("La taula ja existeix");
        }
    }
}
