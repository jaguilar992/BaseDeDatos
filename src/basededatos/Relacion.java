package basededatos;

import java.io.Serializable;
import clases.General;

public class Relacion implements Serializable{
	private int id1;
	private int id2;

	public Relacion(){}
	public Relacion(int id1, int id2){
		this.id1=id1;
		this.id2=id2;
	}

	// SETTERS
	
	public void set_id1 (int id){
		this.id1=id;
	}
	public void set_id2 (int id){
		this.id2=id;
	}

	// GETTERS
	public int get_id1(){
		return this.id1;
	}
	public int get_id2(){
		return this.id2;
	}

        @Override
	public String toString(){
		return this.id1+" En "+this.id2;
	}
	
	// Lista todas las relaciones en Contenedor relaciones - - c1 y c2 se pasan para hacerlo leible
	// El orden de c1 y c2 es el mismo que id1 e id2 de la tabla (Ver Tabla)
	public static void listarAllRelaciones(Contenedor relaciones, Contenedor c1, Contenedor c2){
		final String LINEA = "--------------------------------------------------";
		//CABECERA
		if(!relaciones.esVacio()){
			System.out.println(LINEA);System.out.println("Relaciones en Contenedor");System.out.println(LINEA);
			for (int i=0; i<relaciones.getLength();i++ ) {
				if (relaciones.leerObjeto(i)!=null){
					// TRABAJANDO RELACIONES NO NULAS (null)
					General obj1 = new General();
					General obj2 = new General();
					
					int id1 = ((Relacion)relaciones.leerObjeto(i)).get_id1();
					int id2 = ((Relacion)relaciones.leerObjeto(i)).get_id2();
					
					// General1 Busqueda
					for (int j=0; j<c1.getLength(); j++) {
						if(c1.leerObjeto(j)!=null && id1==((General)c1.leerObjeto(j)).get_id()) 
							obj1=(General)c1.leerObjeto(j);
					}
					
					// General2 Busqueda
					for (int k=0; k< c2.getLength(); k++) {
						if(c2.leerObjeto(k)!=null && id2==((General)c2.leerObjeto(k)).get_id()) 
							obj2=(General)c2.leerObjeto(k);
					}
					// IMPRIMIR OBJETOS Y CUBETA i de posicion en relaciones
					System.out.println(i+"::  "+obj1 +"  -->  "+obj2);
				}
			}
		}else System.out.println("Vacio...");
	}

	public static void listarGroupRelaciones(Contenedor relaciones, Contenedor c1, Contenedor c2, int group){
		final String LINEA = "--------------------------------------------------";
		if(!relaciones.esVacio()){
			for (int j = 0; j < c2.getLength(); j++) {
			    if (c2.leerObjeto(j)!=null) {
			    	// IMPRESION DE COLECCIONES AGRUPADAS POR ID2 DE RELACION
			        General obj2 = (General)c2.leerObjeto(j);
			        int idObj2 = obj2.get_id();

			        // VERIFICA SI OBJETO2 TIENE RELACIONES
			        if (obj2.estaEnRelaciones(relaciones,2)) {
			            // IMPRESION DE NOMBRE OBJ2
			            System.out.println(LINEA);System.out.println(obj2.get_nombre());System.out.println(LINEA);
						
						// BUSCA LAS RELACIONES EN LAS QUE SE ENCUENTRA OBJ2
			            for (int k = 0; k < relaciones.getLength(); k++) {
			                if (relaciones.leerObjeto(k)!=null) {
			                	// RELACIONES NO NULAS
			                    Relacion link = (Relacion)relaciones.leerObjeto(k);
			                	// TOMA CADA RELACION DONDE APARECE OBJ2
			                    if ((link.get_id2())==idObj2) {
			                    	int id1=link.get_id1();
			                    	// BUSCA EL OBJETO QUE TIENE ID1 SEGUN LA RELACION (link) con id1 - PARA IMPRIMIRLO
			                        for (int l = 0; l < c1.getLength(); l++) {
			                            if (c1.leerObjeto(l)!=null) {
			                            	General obj1 = (General)c1.leerObjeto(l);
			                            	int idObj1 = obj1.get_id();
			                                if (idObj1==id1) {
			                                    System.out.println((General)c1.leerObjeto(l));
			                                }
			                            }
			                        }
			                    }
			                }
			            }
			            System.out.println(LINEA);
			        }
			    }
			}
		}else System.out.println("Vacio...");
	}

	public static void listarGroupRelaciones(Contenedor relaciones, Contenedor c1, Contenedor c2){
		listarGroupRelaciones(relaciones,c1,c2,1);
	}
}