/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import basededatos.Contenedor;
import clases.*;
import java.util.Scanner;

/**
 *
 * @author jaguilar992
 */
public class Leer {
	private final static String LINEA="-------------------------------------------------";
	private final static String PETICION="Ingrese los datos...";
	private final static String ENTEROALERTA ="¡ALERTA! ID debe ser un numero entero...\nIntente de nuevo...";
		
	private static void alertExistence(){
		System.out.println(LINEA);
		System.out.println("El ID que desea ingresar ya existe en el sistema.\nPor favor ingrese un ID nuevo..."); //ALERTA DE EXISTENCIA
		System.out.println(LINEA);
	}
	// METODOS DE LECTURA
	//////////////////////////////////////////////////////////////////////// LEER_GENERAL
	private static General leer(Contenedor c, boolean pedirID,int ID){
		int id; String nombre;
		Scanner sc = new Scanner(System.in);
		 
		System.out.println(LINEA);
		System.out.println(PETICION); 
		if(pedirID){
			while (true) {
				try {
					System.out.print("ID: ");
					id=Integer.parseInt(sc.nextLine());
					// VERIFICACION DE EXISTENCIA DE ID
					General objct_ID = new General(id,null);
					if (!objct_ID.existeEn(c)) break;
					else alertExistence();
				} catch (NumberFormatException e) {
					System.out.println(ENTEROALERTA);
				}				  
			}
		}else id=ID;
		System.out.print("Nombre: ");
		nombre=sc.nextLine();
		return new General(id,nombre);
	}
	
	////////////////////////////////////////////////////////////////////////// METODOS PUBLICOS
	// A) LEER_PERSONA
	public static Persona leer_persona(Contenedor c, boolean pedirID,int ID){
		General tmp = leer(c,pedirID,ID);
		String direccion;
		Scanner sc = new Scanner(System.in);
		System.out.print("Direccion: ");
		direccion=sc.nextLine();
		return new Persona(tmp,direccion);
	}
	//SOBRECARGA LEER_PERSONA
	public static Persona leer_persona(Contenedor c){
		return leer_persona(c,true,0);
	}

	// B) LEER_INSTITUCION
	public static Institucion leer_institucion(Contenedor c, boolean pedirID,int ID){
		return new Institucion(leer(c,pedirID,ID));
	}
	//SOBRECARGA LEER_INSTITUCION
	public static Institucion leer_institucion(Contenedor c){
		return leer_institucion(c,true,0);
	}

	// C) LEER_CIUDAD
	public static Ciudad leer_ciudad(Contenedor c, boolean pedirID,int ID){
		return new Ciudad(leer(c,pedirID,ID));
	}
	//SOBRECARGA LEER_CIUDAD
	public static Ciudad leer_ciudad(Contenedor c){
		return leer_ciudad(c,true,0);
	}

	// D) LEER_PAIS
	public static Pais leer_pais(Contenedor c, boolean pedirID,int ID){
		return new Pais(leer(c,pedirID,ID));
	}
	//SOBRECARGA LEER_PAIS
	public static Pais leer_pais(Contenedor c){
		return leer_pais(c,true,0);
	}

}