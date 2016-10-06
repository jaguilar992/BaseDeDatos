/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;

import java.io.Serializable;

public class General implements Serializable{
	private int id;
	private String nombre;

	public General(){};
	public General(int id, String nombre){
		this.id=id;
		this.nombre=nombre;
	}

	public int get_id(){
		return this.id;
	}

	public String get_nombre(){
		return this.nombre;
	}

	public void set_id(int id){
		this.id=id;
	}

	public void set_nombre (String nombre){
		this.nombre=nombre;
	}

	
	// 	DESCRIPCIONES
	// id1 			id2 			Contenedor 		    Contenedor1 	Contenedor2
	// Persona 		Institucion             relacionesP_I   	    personas 		instituciones
	// Persona  	        Ciudad 			relacionesP_C 	               ""		ciudades
	// Institucion          Ciudad			relacionesI_C	            instituciones 	   ""
	// Ciudad 		Pais 			realcionesC_P 	            ciudades 		paises

	//EJEMPLO:: persona.estaEnRelaciones(relacionesP_I,1) // true or false
	//EJEMPLO:: ciudad.estaEnRelaciones(relacionesI_C,2) // true or false
	public boolean estaEnRelaciones(Contenedor c,int idABuscar){
		// Revisa el contenedor c, y devuelve <<true>> si el objeto esta presente en alguna relacion en c
		// El idABuscar corresponde al id propio del objeto ubicado en el tipo de relacion que almacena c.
	    for (int i = 0; i < c.getLength(); i++) {
	        if (c.leerObjeto(i)!=null) {
	            Relacion r = (Relacion)c.leerObjeto(i);
			int pid = 0;	
				switch(idABuscar){
					case 1:
						pid = r.get_id1();
						break;
					case 2:
						pid = r.get_id2();
						break;
					default:
						break;
				}

	            if (pid==this.id) {
	                return true;
	            }
	        }
	    }
	    return false;
	}

	//EJEMPLO:: persona.borrarOcurenciasEnRelaciones(relacionesP_I,1) // Borrar todas las relaciones en que aparece la persona
	//EJEMPLO:: ciudad.borrarOcurenciasEnRelaciones(relacionesI_C,2) // Borrar todas las relaciones en que aparece la persona
	public void borrarOcurenciasEnRelaciones(Contenedor c, int idABuscar) {
		// Revisa el contenedor c, y elimina las relaciones en 
		// las que el objeto esta presente, el idABuscar corresponde
		// al id propio del objeto ubicado en el tipo de relacion que almacena c.
		for (int i = 0; i < c.getLength(); i++) {
			if (c.leerObjeto(i) != null) {
				Relacion r = (Relacion) c.leerObjeto(i);
				int pid = 0;
                                switch(idABuscar){
					case 1:
						pid = r.get_id1();
						break;
					case 2:
						pid = r.get_id2();
						break;
					default:
						break;
				}
				if (pid == this.id) {
					c.eliminarObjeto(i);
				}
			}
		}
	}

	// EJEMPLO:: persona.existe(personas)
	// EJEMPLO:: ciudad.existe(ciudades)
	public boolean existeEn(Contenedor c){
		for (int i=0; i<c.getLength();i++ ) {
			if (c.leerObjeto(i)!=null) {
				General m = (General) c.leerObjeto(i);
				int pid = m.get_id();
				if (pid==this.id) {
					return true;
				}
			}
		}
		return false;
	}

}