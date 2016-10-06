/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;

import java.io.Serializable;

/**
 *
 * @author perdonal
 */
public class Ciudad extends General implements Serializable {
    
    public Ciudad(){}

    public Ciudad(int id, String nombre) {
        super(id,nombre);
        
    }

    @Override
    public String toString() {
        return super.get_id()+" - "+super.get_nombre();
    }
    
     
}
