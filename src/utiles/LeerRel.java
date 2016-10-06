package utiles;
import clases.*;
import basededatos.Contenedor;
import basededatos.Relacion;
import java.util.Scanner;
public class LeerRel{
    public static Relacion leer_relacion(Contenedor contenedor1, Contenedor contenedor2){
        // Se envian los contenedores para verificar esxitencias de los objetos a relacionar
        int id1; int id2;
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------------------------");
                while (true) {                
                    try {
                        System.out.print("ID <<Ente1>>: ");
                        id1= Integer.parseInt(sc.next());
                        General general1 = new General();                        ;
                        general1.set_id(id1);
                        //Esta ente1 en contenedor1
                        if (general1.existeEn(contenedor1)) {
                            break; // SALE DEL CICLO
                        }else{
                            System.out.println("-------------------------------------------------");
                            System.out.println("ID de <<Ente1>> ingresado no existe..."); //ALERTA DE EXISTENCIA
                            System.out.println("-------------------------------------------------");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("ATENCION!!! ID debe ser un numero entero"); // ALERTA DE ERROR EN ID (TIPO INCORRECTO)
                    }
                }
                
                while (true) {                
                    try {
                        System.out.print("ID <<Ente2>>: ");
                        id2=Integer.parseInt(sc.next());
                        General general2 = new General();
                        general2.set_id(id2);
                        //Esta ente2 en contenedor2
                        if (general2.existeEn(contenedor2)) {
                            break;   
                        }else{
                            System.out.println("-------------------------------------------------");
                            System.out.println("ID de <<Ente2>> ingresado no existe..."); //ALERTA DE EXISTENCIA
                            System.out.println("-------------------------------------------------");
                        }                       
                    } catch (NumberFormatException e) {
                        System.out.println("ATENCION!!! ID debe ser un numero entero");
                    }
                }
        return new Relacion(id1, id2);
    }
}