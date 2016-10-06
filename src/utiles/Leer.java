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
        public static void alertExistence(){
            System.out.println("-------------------------------------------------");
            System.out.println("El ID que desea ingresar ya existe en el sistema.\nPor favor ingrese un ID nuevo..."); //ALERTA DE EXISTENCIA
            System.out.println("-------------------------------------------------");
        }

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
                            alertExistence();
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
                            alertExistence();
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
                            alertExistence();
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
                            alertExistence();
                        }
                        
                    } catch (NumberFormatException e) {
                        System.out.println("ATENCION!!! ID debe ser un numero entero");
                    }                   
                }
        System.out.print("Nombre: ");
        nombre=sc.nextLine();
        return new Pais(id,nombre);
    }
}
