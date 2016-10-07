package utiles;
import clases.*;
import basededatos.Contenedor;
import basededatos.Relacion;

import java.util.Scanner;
public class LeerRel{
    private static final String ALERTA_ENTERO="ATENCION!!! ID debe ser un numero entero";
    private static void alertInexistencia(){
        System.out.println("-------------------------------------------------");
        System.out.println("ID ingresado no existe..."); //ALERTA DE EXISTENCIA
        System.out.println("-------------------------------------------------");
    }

    public static Relacion leer_relacion(Contenedor contenedor1, Contenedor contenedor2,int tpRel){
	String [][] label  = new String[5][2];
	// Dejar label[0] en {null,null}
	label[1][0]="Persona"; label[1][1]="Institucion";
	label[2][0]="Persona"; label[2][1]="Ciudad";
	label[3][0]="Institucion"; label[3][1]="Ciudad";
	label[4][0]="Ciudad"; label[4][1]="Pais";
	if (tpRel<0 || tpRel>=label.length) tpRel=0;
	
        // Se envian los contenedores para verificar esxitencias de los objetos a relacionar
        int id1; int id2;
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------------------------");
                while (true) {                
                    try {
                        System.out.print("ID "+label[tpRel][0]+": ");
                        id1= Integer.parseInt(sc.next());
                        General gral1 = new General();
                        gral1.set_id(id1);
                        //Esta ente1 en contenedor1
                        if (gral1.existeEn(contenedor1)) {
                            break; // SALE DEL CICLO
                        }else{
                            alertInexistencia();
                        }

                    } catch (NumberFormatException e) {
                        System.out.println(ALERTA_ENTERO); // ALERTA DE ERROR EN ID (TIPO INCORRECTO)
                    }
                }
                while (true) {                
                    try {
                        System.out.print("ID "+label[tpRel][1]+": ");
                        id2=Integer.parseInt(sc.next());
                        General gral2 = new General();
                        gral2.set_id(id2);
                        //Esta ente2 en contenedor2
                        if (gral2.existeEn(contenedor2)) {
                            break;   
                        }else{
                            alertInexistencia();
                        }                       
                    } catch (NumberFormatException e) {
                        System.out.println(ALERTA_ENTERO); // ALERTA DE ERROR EN ID (TIPO INCORRECTO)
                    }
                }
        return new Relacion(id1, id2);
    }
}