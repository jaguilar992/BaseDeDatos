/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;

/**
 *
 * @author perdonal
 */
public class Pais extends General implements Serializable {
    public Pais(){}

    public Pais(int id, String nombre) {
        super(id, nombre);
    }

    public Pais(General g){
    	super.set_id(g.get_id());
        super.set_nombre(g.get_nombre());
    }
    
    @Override
    public String toString() {
        return super.get_id()+" - "+super.get_nombre();
    }
    
    
    
}
