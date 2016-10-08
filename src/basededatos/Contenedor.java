package basededatos;

import java.io.Serializable;

public class Contenedor implements Serializable{
	//Estructura de guardado
	private static final int N=1000;
	private Object [] contenedor = new Object[N];
	public Contenedor(){};
	//Metodos
	public int agregarObjeto(Object objeto){
		for (int i=0;i<this.contenedor.length ; i++) {
			if (this.contenedor[i]==null) {
				this.contenedor[i]=objeto;
				return i;
			}
		}
		return -1;
	}
        
        public boolean modificarObjeto(int index, Object objeto){
            if (index>=0 && index<N){
                if (this.contenedor[index]!=null){
                    this.contenedor[index]=objeto;
                    return true;
                }
            }
            return false;
        }
                
	public boolean eliminarObjeto(int index){
	    if (index>=0 && index<N) {
		this.contenedor[index]=null;
		return true;
	    }
	    return false;
	}
	public int buscarObjeto(Object objeto){
		for (int i=0; i<this.contenedor.length; i++) {
			if (this.contenedor[i]!=null && this.contenedor[i].equals(objeto)) {
				return i;
			}
		}
		return -1;
	}
	public Object leerObjeto(int index){
		if (index>=0 && index < this.contenedor.length ){
			return this.contenedor[index];
		}else{
			return null;
		}
	}

	public void listarObjetos(){
            for (Object contenedor1 : this.contenedor) {
                if (contenedor1 != null) {
                    System.out.println(contenedor1);
                }
            }
	}
        
        public void listarObjetos(boolean showIndexNumber){
            if (showIndexNumber==true) {
                for (int k = 0; k < this.contenedor.length; k++) {
                    if (this.contenedor[k] != null) {
                        System.out.println(k + " :: " + this.contenedor[k]);
                    }
                }
            }
	}

	public int getLength(){
		return Contenedor.N;
	}
        
        public boolean esVacio(){
            for (Object contenedor1 : this.contenedor) {
                if (contenedor1 != null) {
                    return false;
                }
            }
            return true;
        }
}