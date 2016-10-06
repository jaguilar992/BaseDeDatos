package clases;

import java.io.Serializable;

public class Institucion extends General implements Serializable{
	
	public Institucion(){}
        
	public Institucion(int id, String nombre){
		super(id, nombre);
	}
	public Institucion(General g){
    	super.set_id(g.get_id());
        super.set_nombre(g.get_nombre());
    }
	
        @Override
	public String toString(){
		return super.get_id()+" - "+super.get_nombre();
	}
        
        
}