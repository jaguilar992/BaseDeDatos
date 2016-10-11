package basededatos;

//import clases.*; // NO SE USA LOL
import utiles.*;
import clases.*;
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
            String ENTEROALERTA ="¡ALERTA! # debe ser un numero entero...\nIntente de nuevo...";
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
                                //PERSONAS
				case 1:
					int opt1 = Menu.menu("Personas");
					while (opt1!=5) {
						switch (opt1){
                                                        //1 AGREGAR PERSONAS
							case 1:
								String title = "persona";
								FuncionesGenerales.agregarObjeto_general(title, personas, 1);
                                                        //2 MODIFICAR PERSONAS
							break;case 2:
                                                            title = "Persona";
                                                            FuncionesGenerales.modificarObjeto_general(title, personas,1,1);
                                                        //3 ELIMINAR PERSONA
							break;case 3:
                                                            if(!personas.esVacio()){
                                                               System.out.println("--------------------------------------------------");
                                                               System.out.println("# :: ID - Nombre");
                                                               personas.listarObjetos(true);
                                                               System.out.println("--------------------------------------------------");
                                                               FuncionesGenerales.eliminarPersona(personas, relacionesP_I, relacionesP_C);                                                                    
                                                            }else{
                                                                System.out.println("Vacio...");
                                                            }
                                                        //4 LISTAR PERSONAS
							break;case 4:
                                                            FuncionesGenerales.listarObjeto_general(personas, 1);
							break;
						}
						opt1 = Menu.menu("Personas");
					}
                                       
				       //INSTITUCIONES
				break; case 2: 
					int opt2 = Menu.menu("Instituciones");
					while (opt2!=5) {
						switch (opt2){
                                                       // 1 AGREGAR INSTITUCIONES
							case 1:
                                                            String title = "intitucion";
                                                            FuncionesGenerales.agregarObjeto_general(title, instituciones, 2);
                                                        //2 MODIFICAR INSTITUCION
							break;case 2:
                                                             title = "Institucion";
                                                            FuncionesGenerales.modificarObjeto_general(title, instituciones,2,2);
                                                        // 3 ELMINAR INSTITUCION
							break;case 3:
                                                            if(!instituciones.esVacio()){
                                                               System.out.println("--------------------------------------------------");
                                                               System.out.println("# :: ID - Nombre");
                                                               instituciones.listarObjetos(true);
                                                               System.out.println("--------------------------------------------------");
                                                               FuncionesGenerales.eliminarInstitucion(instituciones, relacionesP_I, relacionesI_C);  
                                                                                                                               
                                                            }else{
                                                                System.out.println("Vacio...");
                                                            }
							// 4 LISTAR INSTITUCIONES
                                                        break;case 4:
                                                            FuncionesGenerales.listarObjeto_general(instituciones, 2);
							break;
						}
						opt2 = Menu.menu("Instituciones");
					}
				      //CIUDADES
				break;case 3:
                                        int opt3 = Menu.menu("Ciudades");
					while (opt3!=5) {
						switch (opt3){
                                                       // 1 AGREGAR CIUDAD
							case 1:
                                                            String title = "ciudad";
                                                            FuncionesGenerales.agregarObjeto_general(title, ciudades, 3);
                                                        //2 MODIFICAR CIUDAD
							break;case 2:
                                                             title = "Ciudad";
                                                            FuncionesGenerales.modificarObjeto_general(title, ciudades, 3, 2);
                                                        // 3 ELMINAR CIUDAD
							break;case 3:
                                                            if(!ciudades.esVacio()){
                                                               System.out.println("--------------------------------------------------");
                                                               System.out.println("# :: ID - Nombre");
                                                               ciudades.listarObjetos(true);
                                                               System.out.println("--------------------------------------------------");
                                                               FuncionesGenerales.eliminarCiudad(ciudades, relacionesP_C, relacionesI_C, relacionesC_P);  
                                                                                                                               
                                                            }else{
                                                                System.out.println("Vacio...");
                                                            }
							// 4 LISTAR CIUDAD
                                                        break;case 4:
                                                            FuncionesGenerales.listarObjeto_general(ciudades, 2);
							break;
						}
						opt3 = Menu.menu("Ciudades");
					}
                                      //PAISES
                                break;case 4:
                                        int opt4 = Menu.menu("Paises");
					while (opt4!=5) {
						switch (opt4){
                                                       // 1 AGREGAR CIUDAD
							case 1:
                                                            String title = "pais";
                                                            FuncionesGenerales.agregarObjeto_general(title, paises, 4);
                                                        //2 MODIFICAR CIUDAD
							break;case 2:
                                                             title = "Pais";
                                                            FuncionesGenerales.modificarObjeto_general(title, paises, 4, 2);
                                                        // 3 ELMINAR CIUDAD
							break;case 3:
                                                            if(!ciudades.esVacio()){
                                                               System.out.println("--------------------------------------------------");
                                                               System.out.println("# :: ID - Nombre");
                                                               paises.listarObjetos(true);
                                                               System.out.println("--------------------------------------------------");
                                                               FuncionesGenerales.eliminarPais(paises, relacionesC_P);  
                                                                                                                               
                                                            }else{
                                                                System.out.println("Vacio...");
                                                            }
							// 4 LISTAR CIUDAD
                                                        break;case 4:
                                                            FuncionesGenerales.listarObjeto_general(paises, 2);
							break;
						}
						opt4 = Menu.menu("Paises");
					}
                                      //RELACIONES
                                break;case 5:
					int opt5 = Menu.menu("Relaciones");
					while (opt5!=5) {
						switch (opt5){
                                                        //PERSONAS-INSTITUCIONES
							case 1:
                                                            int opt5_1 = Menu.menu("Personas-Instituciones");
                                                            while(opt5_1!=4){
								switch(opt5_1){
                                                                    //1 AGREGAR RELACIONES
                                                                    case 1:                                                                        
                                                                        FuncionesGenerales.agregarRelacion_general(personas, instituciones, relacionesP_I, 1);
                                                                    //2 ELIMINAR RELACION
                                                                    break;case 2:
                                                                        if(!relacionesP_I.esVacio()){
                                                                        Relacion.listarAllRelaciones(relacionesP_I, personas, instituciones);
                                                                        FuncionesGenerales.eliminarRelacion_general(relacionesP_I);
                                                                        }else{
                                                                             System.out.println("Vacio...");
                                                                        }
                                                                        
                                                                    //3 LISTAR RELACIONES --------------- MODIFICAR *********************** Human Readable
                                                                    break;case 3:                                                                        
                                                                        if (!relacionesP_I.esVacio()){                                                                
                                                                            Relacion.listarGroupRelaciones(relacionesP_I, personas, instituciones);
                                                                        }else System.out.println("Vacio..."); 
                                                                     break;
                                                                }
                                                                opt5_1 = Menu.menu("Personas-Instituciones");
                                                            }  
                                                             //PERSONAS-CIUDADES 
                                                        break;case 2:
                                                            int opt5_2 = Menu.menu("Personas-Ciudades");
                                                            while(opt5_2!=4){
								switch(opt5_2){
                                                                    //1 AGREGAR RELACIONES
                                                                    case 1:
                                                                        FuncionesGenerales.agregarRelacion_general(personas, ciudades, relacionesP_C, 2);
                                                                    //2 ELIMINAR RELACION
                                                                    break;case 2:
                                                                        if(!relacionesP_C.esVacio()){
                                                                        Relacion.listarAllRelaciones(relacionesP_C, personas, ciudades);
                                                                        FuncionesGenerales.eliminarRelacion_general(relacionesP_C);
                                                                        }else{
                                                                             System.out.println("Vacio...");
                                                                        }
                                                                    //3 LISTAR RELACIONES --------------- MODIFICAR *********************** Human Readable
                                                                    break;case 3:
                                                                         if (!relacionesP_C.esVacio()){                                                                
                                                                            Relacion.listarGroupRelaciones(relacionesP_C, personas, ciudades);
                                                                        }else System.out.println("Vacio..."); 
                                                                     break;
                                                                }
                                                                opt5_2 = Menu.menu("Personas-Ciudades");
                                                            }
                                                              //INSTITUCIONES-CIUDADES
                                                        break;case 3:
                                                            int opt5_3 = Menu.menu("Instituciones-Ciudades");
                                                            while(opt5_3!=4){
								switch(opt5_3){
                                                                    //1 AGREGAR RELACIONES
                                                                    case 1:                                                                        
                                                                        FuncionesGenerales.agregarRelacion_general(instituciones, ciudades, relacionesI_C, 3);
                                                                    //2 ELIMINAR RELACION
                                                                    break;case 2:
                                                                        if(!relacionesI_C.esVacio()){
                                                                        Relacion.listarAllRelaciones(relacionesI_C, instituciones, ciudades);
                                                                        FuncionesGenerales.eliminarRelacion_general(relacionesI_C);
                                                                        }else{
                                                                             System.out.println("Vacio...");
                                                                        }
                                                                    //3 LISTAR RELACIONES --------------- MODIFICAR *********************** Human Readable
                                                                    break;case 3:
                                                                         if (!relacionesI_C.esVacio()){                                                                
                                                                            Relacion.listarGroupRelaciones(relacionesI_C, instituciones, ciudades);
                                                                        }else System.out.println("Vacio..."); 
                                                                     break;
                                                                }
                                                                opt5_3 = Menu.menu("Instituciones-Ciudades");
                                                            }
                                                            //CIUDADES-PAISES
                                                        break;case 4:
                                                            int opt5_4 = Menu.menu("Ciudades-Paises");
                                                            while(opt5_4!=4){
								switch(opt5_4){
                                                                    //1 AGREGAR RELACIONES
                                                                    case 1:
                                                                        FuncionesGenerales.agregarRelacion_general(ciudades, paises, relacionesC_P, 4);
                                                                    //2 ELIMINAR RELACION
                                                                    break;case 2:
                                                                        if(!relacionesC_P.esVacio()){
                                                                        Relacion.listarAllRelaciones(relacionesC_P, ciudades, paises);
                                                                        FuncionesGenerales.eliminarRelacion_general(relacionesC_P);
                                                                        }else{
                                                                             System.out.println("Vacio...");
                                                                        }
                                                                    //3 LISTAR RELACIONES --------------- MODIFICAR *********************** Human Readable
                                                                    break;case 3:
                                                                         if (!relacionesC_P.esVacio()){                                                                
                                                                            Relacion.listarGroupRelaciones(relacionesC_P, ciudades, paises);
                                                                        }else System.out.println("Vacio..."); 
                                                                     break;
                                                                }
                                                                opt5_4 = Menu.menu("Ciudades-Paises");
                                                            }
                                                        break;    
                                                }
						opt5 = Menu.menu("Relaciones");
					}
				break; case 6: 
                                    int opt6 = Menu.menu("Reportes");
                                    while(opt6!=5){
                                        switch(opt6){
                                            case 1:
                                            //Reportes de persona por institucion 
                                                System.out.println("1)Reporte de Personas por Institucion"); 
                                                if(!personas.esVacio()){
                                                    System.out.println("--------------------------------------------------");
                                                    System.out.println("# :: ID - Nombre - Direccion");
                                                    instituciones.listarObjetos(true);
                                                    System.out.println("--------------------------------------------------");
                                                    while (true){
                                                        try{
                                                            System.out.print("Ingrese el # de Institucion para generar reporte o -1 para cancelar: ");
                                                         int select = Integer.parseInt(c.nextLine()) ;
                                                            if (select==-1) {
                                                                break;
                                                         }else if(instituciones.leerObjeto(select)!=null){
                                                                Institucion sel = (Institucion)instituciones.leerObjeto(select);
				
                                                                //Relacio cids = sel.getAllRelaciones(relacionesI_C, 1);
				
                                                                Ciudad city = new Ciudad(sel.getAllRelaciones(relacionesI_C, 1)[0].get_id2(),"");
                                                                city = (Ciudad)city.buscarObjeto(ciudades);
                                                                Pais cntry  = new Pais  (city.getAllRelaciones(relacionesC_P,1)[0].get_id2(),"");
                                                                cntry= (Pais)cntry.buscarObjeto(paises);
				
				
                                
                                                                Relacion [] rels = sel.getAllRelaciones(relacionesP_I, 2);
                                                                System.out.println();
                                                                System.out.println("Institucion: "+sel.get_nombre()+"          Ciudad: "+city.get_nombre()+"         Pais: "+cntry.get_nombre());
                                                                System.out.println("Personas Relacionadas");
								System.out.println();
                                                                System.out.println("Identificador - Nombre - Direccion");
                                                                for (Relacion r : rels) {
                                                                Persona person = new Persona(r.get_id1(),"","");
                                                                person = (Persona)(person.buscarObjeto(personas));
                                                                System.out.println(person);
                                                                }
                                                            break;
                                                           }
                                                        } catch (NumberFormatException e) {
                                                        System.out.println(ENTEROALERTA);
                                                        }  
                                                    }
                                                }else{
                                                System.out.println("Vacio...");
                                                }   
                                           break; case 2:
                                            //Reportes de institucion por persona 
                                                System.out.println("2)Reporte de Institucion por Persona"); 
                                             if(!personas.esVacio()){
                                                System.out.println("--------------------------------------------------");
                                                System.out.println("# :: ID - Nombre - Direccion");
                                                personas.listarObjetos(true);
                                                System.out.println("--------------------------------------------------");
                                                    while (true){
                                                    try{
                                                        System.out.print("Ingrese el # de Persona para generar reporte o -1 para cancelar: ");
                                                        int select = Integer.parseInt(c.nextLine()) ;
                                                        if (select==-1) {
                                                            break;
                                                        }else if(personas.leerObjeto(select)!=null){
							    Persona sel = (Persona)personas.leerObjeto(select);
                                                            Relacion [] e = sel.getAllRelaciones(relacionesP_I, 1);
							    for (Relacion r : e) {
								
							    }
                                                        break;
                                                        }
                                                    } catch (NumberFormatException e) {
                                                            System.out.println(ENTEROALERTA);
                                                    }  
                                                 }
                                              }else{
                                                  System.out.println("Vacio...");
                                              }
                                            break; case 3:
                                            //Reporte de instituciones por pais
                                                 System.out.println("3)Reporte de Institucion por Pais"); 
                                             if(!paises.esVacio()){
                                                System.out.println("--------------------------------------------------");
                                                System.out.println("# :: ID - Nombre - Direccion");
                                                paises.listarObjetos(true);
                                                System.out.println("--------------------------------------------------");
                                                    while (true){
                                                    try{
                                                        System.out.print("Ingrese el # de Pais para generar reporte o -1 para cancelar: ");
                                                        int select = Integer.parseInt(c.nextLine()) ;
                                                        if (select==-1) {
                                                            break;
                                                        }else if(paises.leerObjeto(select)!=null){
							    Pais sel = (Pais)paises.leerObjeto(select);
                                                            Relacion [] e = sel.getAllRelaciones(relacionesC_P, 2);
							    for (Relacion r : e) {
								
							    }
                                                        break;
                                                        }
                                                    } catch (NumberFormatException e) {
                                                            System.out.println(ENTEROALERTA);
                                                    }  
                                                 }
                                              }else{
                                                  System.out.println("Vacio...");
                                              }
                                            break; case 4:
                                            //Reporte de instituciones por ciudad
                                                 System.out.println("4)Reporte de Institucion por Ciudad"); 
                                             if(!ciudades.esVacio()){
                                                System.out.println("--------------------------------------------------");
                                                System.out.println("# :: ID - Nombre - Direccion");
                                                ciudades.listarObjetos(true);
                                                System.out.println("--------------------------------------------------");
                                                    while (true){
                                                    try{
                                                        System.out.print("Ingrese el # de Ciudad para generar reporte o -1 para cancelar: ");
                                                        int select = Integer.parseInt(c.nextLine()) ;
                                                        if (select==-1) {
                                                            break;
                                                        }else if(ciudades.leerObjeto(select)!=null){
							    Ciudad sel = (Ciudad)ciudades.leerObjeto(select);
                                                            Relacion [] e = sel.getAllRelaciones(relacionesI_C, 2);
							    System.out.println();
							    System.out.println("Ciudad: " + sel.get_nombre());
							    System.out.println("Instituciones Relacionadas");
							    System.out.println();
							    System.out.println("Identificador - Nombre");
							    for (Relacion r : e) {
								Institucion inst = new Institucion(r.get_id1(), "");
								inst = (Institucion) (inst.buscarObjeto(instituciones));
								System.out.println(inst);
							    }
                                                        break;
                                                        }
                                                    } catch (NumberFormatException e) {
                                                            System.out.println(ENTEROALERTA);
                                                    }  
                                                 }
                                              }else{
                                                  System.out.println("Vacio...");
                                              }
                                            break;
                                        }        
                                       opt6 = Menu.menu("Reportes");
                                    }
                                                   
                                break;case 7:case 8:
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
		}while(op!=8);
                
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