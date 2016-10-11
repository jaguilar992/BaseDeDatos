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
public class TestBuscarRelaciones {
    public static void main(String args[]){
	Contenedor c = new Contenedor();
	c.agregarObjeto(new Relacion(1,2));
	c.agregarObjeto(new Relacion(3,2));
	c.agregarObjeto(new Relacion(4,4));
	c.agregarObjeto(new Relacion(7,6));
	c.agregarObjeto(new Relacion(9,7));
	c.agregarObjeto(new Relacion(1,9));
	c.agregarObjeto(new Relacion(10,2));
	c.agregarObjeto(new Relacion(18,2));

	Institucion i = new Institucion(2,"UNAH");

	Relacion [] h = i.getAllRelaciones(c,2);

	for (Relacion j : h ) {
		System.out.println(j);
	}

    }
}
