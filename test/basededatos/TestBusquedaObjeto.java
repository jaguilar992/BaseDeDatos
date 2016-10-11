/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;
import clases.*;

/**
 *
 * @author Antonio
 */
public class TestBusquedaObjeto {
    
    public static void main(String args[]){
	Contenedor c = new Contenedor();
	c.agregarObjeto(new Persona(1,"Lorem","Nowhere"));
	c.agregarObjeto(new Persona(2,"ipsum","Nowhere"));
	c.agregarObjeto(new Persona(3,"dolor","Nowhere"));
	c.agregarObjeto(new Persona(4,"sit","Nowhere"));
	c.agregarObjeto(new Persona(5,"amet","Nowhere"));
	c.agregarObjeto(new Persona(6,"consectetur","Nowhere"));
	c.agregarObjeto(new Persona(7,"adipisicing","Nowhere"));
	c.agregarObjeto(new Persona(8,"elit","Nowhere"));

	Persona buscame = new Persona();
	buscame.set_id(8);

	System.out.println(buscame.buscarObjeto(c));

    }

}
