/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;

import clases.Persona;
import utiles.LeerRel;

/**
 *
 * @author Antonio
 */
public class TestLeerRelacion {
    public static void main(String args[]){
	Contenedor contenedor1=new Contenedor();
        Contenedor contenedor2=new Contenedor();
	Persona p1 = new Persona();
	p1.set_id(1);
	contenedor1.agregarObjeto(p1);
	contenedor2.agregarObjeto(p1);
	
	LeerRel.leer_relacion(contenedor1, contenedor2, 5);
    }
}
