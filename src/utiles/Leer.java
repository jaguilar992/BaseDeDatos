/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;


import clases.Ciudad;
import basededatos.Contenedor;
import clases.General;
import clases.Institucion;
import clases.Pais;
import clases.Persona;
import basededatos.Relacion;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Leer {
    	public static Institucion leer_institucion(Contenedor c, boolean pedirID,int ID){
		int id;
		String nombre;
		Scanner sc = new Scanner(System.in);
		System.out.println("---------------------------------------------------");
		System.out.println("Ingrese los datos de la institucion..."); 
        if(pedirID){
                while (true) {                
                    try {
                        System.out.print("ID: ");
                        id=Integer.parseInt(sc.nextLine());
                        // VERIFICACION
                        General objetoV = new General();
                        objetoV.set_id(id);
                        
                        if (!objetoV.existeEn(c)) {
                            break;   
                        }else{
                            System.out.println("-------------------------------------------------");
                            System.out.println("El ID que desea ingresar ya existe en el sistema.\nPor favor ingrese un ID nuevo..."); //ALERTA DE EXISTENCIA
                            System.out.println("-------------------------------------------------");
                        }    
                        
                    } catch (NumberFormatException e) {
                        System.out.println("ATENCION!!! ID debe ser un numero entero");
                    }                   
                }
        }else{
            id=ID;
        }
		System.out.print("Nombre: ");
		nombre=sc.nextLine();
		return new Institucion(id,nombre);
	}
    public static Institucion leer_institucion(Contenedor c){
        return leer_institucion(c,true,0);
    }

        
    public static Persona leer_persona(Contenedor c, boolean check){
		int id;
		String nombre;
		String direccion;
		Scanner sc = new Scanner(System.in);
		System.out.println("---------------------------------------------------");
		System.out.println("Ingrese los datos de la persona..."); 
                while (true) {                
                    try {
                        System.out.print("ID: ");
                        id=Integer.parseInt(sc.nextLine());
                        // VERIFICACION Si !Existe Entonces break Sino ALERTA
                        General objetoV = new General();
                        objetoV.set_id(id);
                        
			if(!check){
			    break;
			}else if (!objetoV.existeEn(c)) {
                            break;   
                        }else{
                            System.out.println("-------------------------------------------------");
                            System.out.println("El ID que desea ingresar ya existe en el sistema.\nPor favor ingrese un ID nuevo..."); //ALERTA DE EXISTENCIA
                            System.out.println("-------------------------------------------------");
                        }
                       
                    } catch (NumberFormatException e) {
                        System.out.println("ATENCION!!! ID debe ser un numero entero");
                    }                   
                }
        System.out.print("Nombre: ");
        nombre=sc.nextLine();
        System.out.print("Direccion: ");
        direccion=sc.nextLine();
        return new Persona(id,nombre,direccion);
    }
        
    public static Ciudad leer_ciudad(Contenedor c, boolean check){
        int id;
        String nombre;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------------------------");
        System.out.println("Ingrese los datos de la ciudad..."); 
                while (true) {                
                    try {
                        System.out.print("ID: ");
                        id=Integer.parseInt(sc.nextLine());
                        // VERIFICACION Si !Existe Entonces break Sino ALERTA
                        General objetoV = new General();
                        objetoV.set_id(id);
                        
			if(!check){
			    break;
			}else if (!objetoV.existeEn(c)) {
                            break;   
                        }else{
                            System.out.println("-------------------------------------------------");
                            System.out.println("El ID que desea ingresar ya existe en el sistema.\nPor favor ingrese un ID nuevo..."); //ALERTA DE EXISTENCIA
                            System.out.println("-------------------------------------------------");
                        }
                        
                    } catch (NumberFormatException e) {
                        System.out.println("ATENCION!!! ID debe ser un numero entero");
                    }                   
                }
        System.out.print("Nombre: ");
        nombre=sc.nextLine();
        return new Ciudad(id,nombre);
    }
        
    public static Pais leer_pais(Contenedor c, boolean check){
        int id;
        String nombre;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------------------------");
        System.out.println("Ingrese los datos del pais..."); 
                while (true) {                
                    try {
                        System.out.print("ID: ");
                        id=Integer.parseInt(sc.nextLine());
                        // VERIFICACION Si !Existe Entonces break Sino ALERTA
                        General objetoV = new General();
                        objetoV.set_id(id);
                        
			if(!check){
			    break;
			}else if (!objetoV.existeEn(c)) {
                            break;   
                        }else{
                            System.out.println("-------------------------------------------------");
                            System.out.println("El ID que desea ingresar ya existe en el sistema.\nPor favor ingrese un ID nuevo..."); //ALERTA DE EXISTENCIA
                            System.out.println("-------------------------------------------------");
                        }
                        
                    } catch (NumberFormatException e) {
                        System.out.println("ATENCION!!! ID debe ser un numero entero");
                    }                   
                }
        System.out.print("Nombre: ");
        nombre=sc.nextLine();
        return new Pais(id,nombre);
    }

        
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
