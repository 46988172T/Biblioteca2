
import funcionalitats.FuncLlibres;
import funcionalitats.FuncSocis;

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
    public static void main(String[] args) {
        CreateDB.createTableLlibres();
        CreateDB.createTableSocis();
        CreateDB.createTablePrestec();
        menuPrincipal();
    }

    public static void menuPrincipal(){
        int menu;
        do {
            System.out.println("Menu\n1. Donar d'alta, de baixa i modificar llibres\n2. Donar d'alta, de baixa i modificar socis."
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

                    break;
                case 4:

                    break;
            }

        }while(menu != 0);

        entrada.close();
    }

    public static void menuLlibres(){
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

        entrada.close();
    }

    public static void menuSocis(){
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

        entrada.close();
    }


}
