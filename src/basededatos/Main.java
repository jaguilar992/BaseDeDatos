package basededatos;

import clases.*;
import utiles.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main{
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException {
            
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
                
                
       
        // MENU
		int op;
		do{
                        op=Menu.menu("Principal");
			switch (op) {
                                
				//INSTITUCIONES
				case 2: 
					int opt1 = Menu.menu("Instituciones");
					while (opt1!=5) {
						switch (opt1){
                                                       // 1 AGREGAR INSTITUCIONES
							case 1:
								System.out.print("\nDesea agregar institucion? (S/N): ");
								while (c.next().toUpperCase().equals("S")){
									instituciones.agregarObjeto(Leer.leer_institucion(instituciones,true));
									System.out.print("\nDesea agregar institucion? (S/N): ");
								}
                                                        //2 MODIFICAR INSTITUCION
							break;case 2:
                                                            if(!instituciones.esVacio()){
                                                               System.out.println("--------------------------------------------------");
                                                               System.out.println("# :: ID - Nombre");
                                                               instituciones.listarObjetos(true);
                                                               System.out.println("--------------------------------------------------");
                                                                 while (true){
                                                                     System.out.print("Ingrese el # de Institución a modificar o -1 para cancelar: ");
                                                                     int select = c.nextInt();
                                                                     if (select==-1) {
                                                                         break;
                                                                     }else if(instituciones.leerObjeto(select)!=null){
                                                                        instituciones.modificarObjeto(select, Leer.leer_institucion(instituciones,false));
                                                                        System.out.println(">>Se ha modificado con éxito...");
                                                                        break;
                                                                     }
                                                                  }                                                        
                                                            }else{
                                                                System.out.println("Vacio...");
                                                            }
                                                        // 3 ELMINAR INSTITUCION
							break;case 3:
                                                            if(!instituciones.esVacio()){
                                                               System.out.println("--------------------------------------------------");
                                                               System.out.println("# :: ID - Nombre");
                                                               instituciones.listarObjetos(true);
                                                               System.out.println("--------------------------------------------------");
                                                                 while (true){
                                                                     System.out.print("Ingrese el # de Institución a eliminar o -1 para cancelar: ");
                                                                     int select = c.nextInt();
                                                                     if (select==-1) {
                                                                         break;
                                                                     }else if(instituciones.leerObjeto(select)!=null){
                                                                        Institucion delInst = (Institucion)instituciones.leerObjeto(select);
                                                                         if (delInst.estaEnRelaciones(relacionesP_I, 2) || delInst.estaEnRelaciones(relacionesI_C, 1)) {
                                                                             System.out.println("No se eliminó... Hay relaciones pendientes...");
                                                                             //PREGUNTAR
                                                                             System.out.print("Desea eliminar institucion "+delInst.get_nombre()+ " y todas las relaciones asociadas? (S/N): ");
                                                                             String resp = c.next();
                                                                             if (resp.equals("S") || resp.equals("s")) {
                                                                                 delInst.borrarOcurenciasEnRelaciones(relacionesP_I, 2);
                                                                                 delInst.borrarOcurenciasEnRelaciones(relacionesI_C, 1);
                                                                                 instituciones.eliminarObjeto(select);
                                                                                 System.out.println(">>Se ha eliminado con éxito...");
                                                                             }else{
                                                                                 System.out.println("No se eliminó");
                                                                             }
                                                                             
                                                                         } else {
                                                                             instituciones.eliminarObjeto(select);
                                                                             System.out.println(">>Se ha eliminado con éxito...");
                                                                         }
                                                                        
                                                                        break;
                                                                     }
                                                                  }
                                                                                                                               
                                                            }else{
                                                                System.out.println("Vacio...");
                                                            }
							// 4 LISTAR INSTITUCIONES
                                                        break;case 4:
                                                            if(!instituciones.esVacio()){
                                                                System.out.println("--------------------------------------------------");
                                                                System.out.println("ID - Nombre");
								                                instituciones.listarObjetos();
                                                                System.out.println("--------------------------------------------------");
                                                            }else System.out.println("Vacio...");
							break;
						}
						opt1 = Menu.menu("Instituciones");
					}
				//PERSONAS
				break; case 1:
					int opt2 = Menu.menu("Personas");
					while (opt2!=5) {
						switch (opt2){
                                                        //1 AGREGAR PERSONAS
							case 1:
								System.out.print("\nDesea agregar persona? (S/N): ");
								while (c.next().toUpperCase().equals("S")){
									personas.agregarObjeto(Leer.leer_persona(personas,true));
									System.out.print("\nDesea agregar persona? (S/N): ");
								}
                                                        //2 MODIFICAR PERSONAS
							break;case 2:
                                                            if(!personas.esVacio()){
                                                               System.out.println("--------------------------------------------------");
                                                               System.out.println("# :: ID - Nombre - Direccion");
                                                               personas.listarObjetos(true);
                                                               System.out.println("--------------------------------------------------");
                                                                 while (true){
                                                                     System.out.print("Ingrese el # de Persona a modificar o -1 para cancelar: ");
                                                                     int select = c.nextInt();
                                                                     if (select==-1) {
                                                                         break;
                                                                     }else if(personas.leerObjeto(select)!=null){
                                                                        personas.modificarObjeto(select, Leer.leer_persona(personas,false));
                                                                        System.out.println(">>Se ha modificado con éxito...");
                                                                        break;
                                                                     }
                                                                  }
                                                                                                                               
                                                            }else{
                                                                System.out.println("Vacio...");
                                                            }
                                                        //3 ELIMINAR PERSONA
							break;case 3:
                                                            if(!personas.esVacio()){
                                                               System.out.println("--------------------------------------------------");
                                                               System.out.println("# :: ID - Nombre");
                                                               personas.listarObjetos(true);
                                                               System.out.println("--------------------------------------------------");
                                                                 while (true){
                                                                     System.out.print("Ingrese el # de Persona a eliminar o -1 para cancelar: ");
                                                                     int select = c.nextInt();
                                                                     if (select==-1) {
                                                                         break;
                                                                     }else if(personas.leerObjeto(select)!=null){
                                                                        Persona delPers = (Persona)personas.leerObjeto(select);
                                                                         if (delPers.estaEnRelaciones(relacionesP_I,1)|| delPers.estaEnRelaciones(relacionesP_C,1)) {
                                                                             System.out.println("No se eliminó... Hay relaciones pendientes...");
                                                                             System.out.print("Desea eliminar a "+delPers.get_nombre()+ " y todas las relaciones asociadas? (S/N): ");
                                                                             String resp=c.next();
                                                                             if (resp.equals("S") || resp.equals("s")) {
                                                                                 delPers.borrarOcurenciasEnRelaciones(relacionesP_I, 1);
                                                                                 delPers.borrarOcurenciasEnRelaciones(relacionesP_C, 1);
                                                                                 personas.eliminarObjeto(select);
                                                                                 System.out.println(">>Se ha eliminado con éxito...");
                                                                             }else{
                                                                                 System.out.println("No se eliminó");
                                                                             }
                                                                         } else {
                                                                             personas.eliminarObjeto(select);
                                                                             System.out.println(">>Se ha eliminado con éxito...");
                                                                         }
                                                                        
                                                                        break;
                                                                     }
                                                                  }                                                                  
                                                            }else{
                                                                System.out.println("Vacio...");
                                                            }
                                                        //4 LISTAR PERSONAS
							break;case 4:
                                                            if (!personas.esVacio()){
								System.out.println("--------------------------------------------------");
                                                                System.out.println("ID - Nombre - Direccion");
								personas.listarObjetos();
                                                                System.out.println("--------------------------------------------------");
                                                            }else System.out.println("Vacio...");
							break;
						}
						opt2 = Menu.menu("Personas");
					}
				//RELACIONES
				break; case 3:
					int opt3 = Menu.menu("Relaciones");
					while (opt3!=4) {
						switch (opt3){
                                                        //1 AGREGAR RELACIONES
							case 1:
								System.out.print("\nDesea agregar relacion? (S/N): ");
								while (c.next().toUpperCase().equals("S")){
                                                                        System.out.println("------------------------Personas------------------------");
                                                                        personas.listarObjetos();
                                                                        System.out.println("---------------------Instituciones ---------------------");
                                                                        instituciones.listarObjetos();
									relacionesP_I.agregarObjeto(Leer.leer_relacion(personas,instituciones));
									System.out.print("\nDesea agregar relacion? (S/N): ");
								};
                                                        //2 ELIMINAR RELACION
							break;case 2:
                                                        //3 LISTAR RELACIONES --------------- MODIFICAR *********************** Human Readable
							break;case 3:
                                                            if (!relacionesP_I.esVacio()){                                                                
                                                                for (int j = 0; j < instituciones.getLength(); j++) {
                                                                    if (instituciones.leerObjeto(j)!=null) {
                                                                        Institucion leida = (Institucion)instituciones.leerObjeto(j);
                                                                        if (leida.estaEnRelaciones(relacionesP_I, 1)) {
                                                                            
                                                                        }
                                                                    }
                                                                }
                                                                
                                                            }else System.out.println("Vacio..."); 
							break;
						}
						opt3 = Menu.menu("Relaciones");
					}
					break; case 4:
					//GUARDAR TODO
                                        
                                        FileOutputStream p2_new = new FileOutputStream("Personas.bin");
                                        FileOutputStream i2_new = new FileOutputStream("Instituciones.bin");
                                        FileOutputStream ci2_new = new FileOutputStream("Ciudades.bin");
                                        FileOutputStream pa2_new = new FileOutputStream("Paises.bin");
                                        FileOutputStream rP_I2_new = new FileOutputStream("RelacionesP_I.bin");
                                        FileOutputStream rP_C2_new = new FileOutputStream("RelacionesP_C.bin");
                                        FileOutputStream rI_C2_new = new FileOutputStream("RelacionesI_C.bin");
                                        FileOutputStream rC_P2_new = new FileOutputStream("RelacionesC_P.bin");
                                         
                                        while (true) {                                
                                        try {
                                           ObjectOutputStream ps1 = new ObjectOutputStream(p2_new);
                                           ps1.writeObject(personas);
                                           break;
                                        } catch (IOException e) {
                                            System.err.println("Error ... Reintentando...");
                                        }
                                        }
                                        
                                       while (true) {
                                        try {
                                           ObjectOutputStream is1 = new ObjectOutputStream(i2_new);
                                           is1.writeObject(instituciones);
                                           break;
                                        } catch (IOException e) {
                                            System.err.println("Error ... Reintentando...");
                                        }
                                       }
                                       
                                       while (true) {
                                        try {
                                           ObjectOutputStream cis1 = new ObjectOutputStream(ci2_new);
                                           cis1.writeObject(ciudades);
                                           break;
                                        } catch (IOException e) {
                                            System.err.println("Error ... Reintentando...");
                                        }
                                       }
                                       
                                       while (true) {
                                        try {
                                           ObjectOutputStream pas1 = new ObjectOutputStream(pa2_new);
                                           pas1.writeObject(paises);
                                           break;
                                        } catch (IOException e) {
                                            System.err.println("Error... Reintentando...");
                                        }
                                       }
                                       
                                        while(true){
                                        try {
                                           ObjectOutputStream rP_Is1 = new ObjectOutputStream(rP_I2_new);
                                           rP_Is1.writeObject(relacionesP_I);
                                           break;
                                        } catch (IOException e) {
                                            System.err.println("Error... Reintentando...");
                                        }
                                        }
                                        
                                        while(true){
                                        try {
                                           ObjectOutputStream rP_Cs1 = new ObjectOutputStream(rP_C2_new);
                                           rP_Cs1.writeObject(relacionesP_C);
                                           break;
                                        } catch (IOException e) {
                                            System.err.println("Error... Reintentando...");
                                        }
                                        }
                                        
                                        while(true){
                                        try {
                                           ObjectOutputStream rI_Cs1 = new ObjectOutputStream(rI_C2_new);
                                           rI_Cs1.writeObject(relacionesI_C);
                                           break;
                                        } catch (IOException e) {
                                            System.err.println("Error... Reintentando...");
                                        }
                                        }
                                        
                                        while(true){
                                        try {
                                           ObjectOutputStream rC_Ps1 = new ObjectOutputStream(rC_P2_new);
                                           rC_Ps1.writeObject(relacionesC_P);
                                           break;
                                        } catch (IOException e) {
                                            System.err.println("Error... Reintentando...");
                                        }
                                        }
                                        
                                        System.out.println("Guardado...");
					break;
					
			}
		}while(op!=4);
                
                // FIN MENUS
        
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