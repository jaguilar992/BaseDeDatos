package basededatos;

import java.io.Serializable;

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
}