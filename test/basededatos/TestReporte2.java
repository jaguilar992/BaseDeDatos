/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;
import clases.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Antonio
 */
public class TestReporte2 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
    	//PERSONAS APERTURA
            Contenedor personas;
            Contenedor instituciones;
            Contenedor ciudades;
            Contenedor paises;
            Contenedor relacionesP_I;//Contenedor de relaciones: persona-institucion
            Contenedor relacionesP_C;//Contenedor de relaciones: persona-ciudad
            Contenedor relacionesI_C;//Contenedor de relaciones: institucion-ciudad
            Contenedor relacionesC_P;//Contenedor de relaciones: ciudad-pais
            
            Scanner c = new Scanner(System.in);
            try {
                FileInputStream p = new FileInputStream("Personas.bin");
                FileInputStream i = new FileInputStream("Instituciones.bin");
                FileInputStream ci = new FileInputStream("Ciudades.bin");
                FileInputStream pa = new FileInputStream("Paises.bin");
                FileInputStream rP_I = new FileInputStream("RelacionesP_I.bin");//P_I -> Persona_Institucion
                FileInputStream rP_C = new FileInputStream("RelacionesP_C.bin");//P_C -> Persona_Ciudad 
                FileInputStream rI_C = new FileInputStream("RelacionesI_C.bin");//I_C -> Institucion_Ciudad
                FileInputStream rC_P = new FileInputStream("RelacionesC_P.bin");//C_P -> Ciudad_Pais
                  
                try {
                    ObjectInputStream pl = new ObjectInputStream(p);
                    personas = (Contenedor) pl.readObject();
                } catch (EOFException e) {
                    personas = new Contenedor();
                }
                
                try {
                    ObjectInputStream il = new ObjectInputStream(i);
                    instituciones = (Contenedor) il.readObject();
                } catch (EOFException e) {
                    instituciones = new Contenedor();
                }
                
                try {
                    ObjectInputStream cil = new ObjectInputStream(ci);
                    ciudades = (Contenedor) cil.readObject();
                } catch (EOFException e) {
                    ciudades = new Contenedor();
                }
                
                try {
                    ObjectInputStream pal = new ObjectInputStream(pa);
                    paises = (Contenedor) pal.readObject();
                } catch (EOFException e) {
                    paises = new Contenedor();
                }
                
                try {
                    ObjectInputStream rAl = new ObjectInputStream(rP_I);
                    relacionesP_I = (Contenedor) rAl.readObject();
                } catch (EOFException e) {
                    relacionesP_I = new Contenedor();
                }
                
                try {
                    ObjectInputStream rBl = new ObjectInputStream(rP_C);
                    relacionesP_C = (Contenedor) rBl.readObject();
                } catch (EOFException e) {
                    relacionesP_C = new Contenedor();
                }
                
                try {
                    ObjectInputStream rCl = new ObjectInputStream(rI_C);
                    relacionesI_C = (Contenedor) rCl.readObject();
                } catch (EOFException e) {
                    relacionesI_C = new Contenedor();
                }
                
                try {
                    ObjectInputStream rDl = new ObjectInputStream(rC_P);
                    relacionesC_P = (Contenedor) rDl.readObject();
                } catch (EOFException e) {
                    relacionesC_P = new Contenedor();
                }
                
                finally{
                    p.close();
                    i.close();
                    ci.close();
                    pa.close();
                    rP_I.close();
                    rP_C.close();
                    rI_C.close();
                    rC_P.close();
                }
		String ENTEROALERTA ="¡ALERTA! # debe ser un numero entero...\nIntente de nuevo...";
		
  
		if (!personas.esVacio()) {
		    System.out.println("--------------------------------------------------");
		    System.out.println("# :: ID - Nombre - Direccion");
		    personas.listarObjetos(true);
		    System.out.println("--------------------------------------------------");
		    while (true) {
			try {
			    System.out.print("Ingrese el # de Persona para generar reporte o -1 para cancelar: ");
			    int select = Integer.parseInt(c.nextLine());
			    if (select == -1) {
				break;
			    } else if (personas.leerObjeto(select) != null) {
				
				Persona sel = (Persona) personas.leerObjeto(select);
				Relacion[] e = sel.getAllRelaciones(relacionesP_I, 1);
				
				System.out.println();
				System.out.println("Persona: "+sel.get_nombre());
				System.out.println("Instituciones Relacionadas");
				System.out.println();
				System.out.println("Identificador - Nombre - Ciudad - Pais");
				for (Relacion r : e) {
				    Institucion asoc = new Institucion(r.get_id2(),"");
				    asoc = (Institucion)asoc.buscarObjeto(instituciones);
				    Relacion [] relciuds =  asoc.getAllRelaciones(relacionesI_C, 1);
				    if (relciuds.length>1) {
					for (Relacion relciud : relciuds) {
					    Ciudad cidl = new Ciudad(relciud.get_id2(),"");
					    cidl=(Ciudad)cidl.buscarObjeto(ciudades);
					    Relacion [] paish = cidl.getAllRelaciones(relacionesC_P, 1);
					    if (paish.length!=0) {
						Pais paisl = new Pais(paish[0].get_id2(),"");
						paisl=(Pais)paisl.buscarObjeto(paises);
						System.out.println(asoc+" - "+cidl.get_nombre()+" - "+paisl.get_nombre());
					    }else{
						System.out.println(asoc+" - "+cidl.get_nombre()+" - No encontrado");
					    }
					}
				    }else{
					System.out.println(asoc+" - No Encontrado - No Encontrado");
				    }
				}
				break;
			    }
			} catch (NumberFormatException e) {
			    System.out.println(ENTEROALERTA);
			}
		    }
		} else {
		    System.out.println("Vacio...");
		}		
		
		
                } catch (FileNotFoundException ex) {
                System.err.println("No se ha ejecutado módulo principal, las bases de datos no existen. Vuelva a ejecutar.");
                FileOutputStream p_new = new FileOutputStream("Personas.bin");
                FileOutputStream i_new = new FileOutputStream("Instituciones.bin");
                FileOutputStream ci_new = new FileOutputStream("Ciudades.bin");
                FileOutputStream pa_new = new FileOutputStream("Paises.bin");
                FileOutputStream rP_I_new = new FileOutputStream("RelacionesP_I.bin");//P_I -> Persona_Institucion
                FileOutputStream rP_C_new = new FileOutputStream("RelacionesP_C.bin");//P_C -> Persona_Ciudad
                FileOutputStream rI_C_new = new FileOutputStream("RelacionesI_C.bin");//I_C -> Institucion_Ciudad
                FileOutputStream rC_P_new = new FileOutputStream("RelacionesC_P.bin");//C_P -> Ciudad_Pais
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
