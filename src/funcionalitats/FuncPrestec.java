package funcionalitats;

import clases.Prestec;
import database.DAO;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by leosss on 6/01/16.
 */
public class FuncPrestec {
    static Scanner func = new Scanner(System.in);
    static Scanner funcInt = new Scanner(System.in);

    public static void altaPrestec() throws SQLException, ClassNotFoundException, ParseException {
        System.out.println("Indica ID llibre del prestec");
        DAO.mostra_llibres();
        int id_llibres = funcInt.nextInt();

        System.out.println("Indica ID soci del prestec");
        DAO.mostra_socis();
        int id_soci = funcInt.nextInt();

        System.out.println("Indica titol del llibre");
        String titol = func.nextLine();

        System.out.println("Indica data inici");
        String dateString = func.nextLine();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date data_inici = formatter.parse(dateString);

        System.out.println("Indica data_final");
        String dateString2 = func.nextLine();
        DateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
        Date data_final = formatter.parse(dateString2);

        Prestec nouPrestec = new Prestec(id_llibres, id_soci, titol, data_inici, data_final );
        DAO.insert_prestec(nouPrestec);
    }


}
