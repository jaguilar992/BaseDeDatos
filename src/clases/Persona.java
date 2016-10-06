package clases;

import java.io.Serializable;

public class Persona extends General implements Serializable{
	private String direccion;

	public Persona(){}
        
	public Persona(int id, String nombre, String direccion){
		super(id, nombre);
		this.direccion=direccion;
	}
	public Persona(General g,String direccion){
    	super.set_id(g.get_id());
        super.set_nombre(g.get_nombre());
		this.direccion=direccion;
    }



	@Override
	public String toString(){
		return super.get_id()+" - "+super.get_nombre()+" - " + this.direccion;
	}
        
}