
import database.CreateDB;
import database.DAO;
import funcionalitats.FuncLlibres;
import funcionalitats.FuncPrestec;
import funcionalitats.FuncSocis;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * Created by leosss on 4/01/16.
 *
 * taules:
 * - Llibres (títol, nombre d'exemplars, editorial, nombre de pàgines, any d'edició)
 * - Socis (nom, cognom, edat, direcció, telèfon)
 * - Préstec (llibre, soci, data inici, data final)
 *
 *  què ha de fer?
 *  - Donar d'alta, de baixa i modificar llibres.
 *  - Donar d'alta, de baixa i modificar socis.
 *  - Consultar socis i llibres per diferents criteris: nom,
 *      cognom, títol, autor.
 *  - Realitzar préstecs d'un llibre a un soci.
 *  - Llistar de llibres prestats.
 *  - Llistar els llibres prestats a un soci determinat.
 *  - Llistar els llibres que han superat la data de fi de
 *      préstec.
 *  - Llistar els socis que tenen llibres que han superat a
 *      data de fi de préstec.
 *
 */
public class Principal {
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        CreateDB.createTableLlibres();
        CreateDB.createTableSocis();
        CreateDB.createTablePrestec();
        menuPrincipal();
    }

    public static void menuPrincipal() throws SQLException, ClassNotFoundException, ParseException {
        int menu;
        do {
            System.out.println("\n-----------------------\n--------Menu-----------\n-----------------------\n1. Donar d'alta, de baixa i modificar llibres\n2. Donar d'alta, de baixa i modificar socis."
                    + "\n3. Consultes llibres i socis \n4. Alta prèstec \n5. Llistats");
            menu = entrada.nextInt();

            switch (menu) {

                case 1:
                    menuLlibres();
                    break;
                case 2:
                    menuSocis();
                    break;
                case 3:
                    menuConsultes();
                    break;
                case 4:
                    FuncPrestec.altaPrestec();
                    break;
                case 5:
                    menuLlistats();
                    break;
            }

        }while(menu != 0);


    }

    public static void menuLlibres() throws SQLException, ClassNotFoundException {
        int menu;
        do {
            System.out.println("Llibres\n1. Donar d'alta llibres\n2. Donar de baixa llibres."
                    + "\n3. Modificar llibres");
            menu = entrada.nextInt();

            switch (menu) {

                case 1:
                    FuncLlibres.altaLlibres();
                    break;
                case 2:
                    FuncLlibres.baixaLlibres();
                    break;
                case 3:
                    FuncLlibres.modificarLlibres();
                    break;
            }

        }while(menu != 0);


    }

    public static void menuSocis() throws SQLException, ClassNotFoundException {
        int menu;
        do {
            System.out.println("Socis\n1. Donar d'alta socis\n2. Donar de baixa socis"
                    + "\n3. Modificar socis");
            menu = entrada.nextInt();

            switch (menu) {

                case 1:
                    FuncSocis.altaSocis();
                    break;
                case 2:
                    FuncSocis.baixaSocis();
                    break;
                case 3:
                    FuncSocis.modificarSocis();
                    break;
            }

        }while(menu != 0);


    }

    public static void menuConsultes() throws SQLException, ClassNotFoundException {
        int menu;
        do {
            System.out.println("Socis\n1. Consulta soci per nom\n2. Consulta soci per cognoms"
                    + "\n3. Consulta llibre per titol\n3. Consulta llibre per autor");
            menu = entrada.nextInt();

            switch (menu) {

                case 1:
                    FuncSocis.consultaSociPerNom();
                    break;
                case 2:
                    FuncSocis.consultaSociPerCognoms();
                    break;
                case 3:
                    FuncLlibres.consultaLlibrePerTitol();
                    break;
                case 4:
                    FuncLlibres.consultaLlibrePerAutor();
                    break;
            }

        }while(menu != 0);


    }

    public static void menuLlistats() throws SQLException, ClassNotFoundException {
        int menu;
        do {
            System.out.println("Llistats\n1. Tots els prestecs\n2. Prestecs a un soci determinat");
            menu = entrada.nextInt();

            switch (menu) {

                case 1:
                    DAO.llistaPrestecs();
                    break;
                case 2:
                    FuncSocis.llistatPerId();
                    break;
            }

        }while(menu != 0);
    }


}
