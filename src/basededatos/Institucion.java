package basededatos;

import java.io.Serializable;

public class Institucion extends General implements Serializable{
	
	public Institucion(){}
        
	public Institucion(int id, String nombre){
		super(id, nombre);
	}
	
        @Override
	public String toString(){
		return super.get_id()+" - "+super.get_nombre();
	}
        
        
}