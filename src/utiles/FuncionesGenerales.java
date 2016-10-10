/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;
import basededatos.Contenedor;
import clases.*;
import java.util.Scanner;
/**
 *
 * @author perdonal
 */
public class FuncionesGenerales {
    private final static String ENTEROALERTA ="¡ALERTA! # debe ser un numero entero...\nIntente de nuevo...";
    
    public static void agregarObjeto_general(String title, Contenedor contenedor1, int tipoContenedor){
        Scanner c = new Scanner(System.in);
        System.out.print("\nDesea agregar "+title+"? (S/N): ");
        while (c.next().toUpperCase().equals("S")){
            switch(tipoContenedor){
                case 1:    
                contenedor1.agregarObjeto(Leer.leer_persona(contenedor1));  
                break;case 2:
                contenedor1.agregarObjeto(Leer.leer_institucion(contenedor1));    
                break;case 3:
                contenedor1.agregarObjeto(Leer.leer_ciudad(contenedor1));
                break; case 4:
                contenedor1.agregarObjeto(Leer.leer_pais(contenedor1));    
                break;    
                    
            }
            System.out.print("\nDesea agregar "+title+"? (S/N): ");
	}
    }
    
    
     public static void modificarObjeto_general(String title, Contenedor contenedor1, int tipoContenedor, int listCampos ){
        Scanner c = new Scanner(System.in);
        if(!contenedor1.esVacio()){
            System.out.println("--------------------------------------------------");
            switch(listCampos){
                case 1:
                    System.out.println("# :: ID - Nombre - Direccion");
                break;case 2:
                    System.out.println("# :: ID - Nombre");
                break;    
            }        
            contenedor1.listarObjetos(true);
            System.out.println("--------------------------------------------------");
            while (true){
              try{
                System.out.print("Ingrese el # de "+title+" a modificar o -1 para cancelar: ");
                int select = Integer.parseInt(c.nextLine()) ;
                if (select==-1) {
                    break;
                }else if(contenedor1.leerObjeto(select)!=null){
                        switch(tipoContenedor){
                            case 1:    
                                int ID = ((Persona)contenedor1.leerObjeto(select)).get_id();
                                contenedor1.modificarObjeto(select, Leer.leer_persona(contenedor1,false,ID));
                            break;case 2:
                                ID = ((Institucion)contenedor1.leerObjeto(select)).get_id();
                                contenedor1.modificarObjeto(select, Leer.leer_institucion(contenedor1,false,ID));
                            break;case 3:
                                ID = ((Ciudad)contenedor1.leerObjeto(select)).get_id();
                                contenedor1.modificarObjeto(select, Leer.leer_ciudad(contenedor1,false,ID));
                            break;case 4:
                                ID = ((Pais)contenedor1.leerObjeto(select)).get_id();
                                contenedor1.modificarObjeto(select, Leer.leer_pais(contenedor1,false,ID));
                            break;    
                        }
                        System.out.println(">>Se ha modificado con éxito...");
                        break;
                    }
              } catch (NumberFormatException e) {
                    System.out.println(ENTEROALERTA);
                }  
            }
                
                
        }else{
                    System.out.println("Vacio...");
        }
        
    }
     
    
    public static void eliminarPersona(Contenedor contenedor1, Contenedor relacionesP_I, Contenedor relacionesP_C){
        Scanner c = new Scanner(System.in);
        while (true){
          try{
            System.out.print("Ingrese el # de Persona a eliminar o -1 para cancelar: ");
            int select = Integer.parseInt(c.nextLine()) ;
            if (select==-1) {
                break;
            }else if(contenedor1.leerObjeto(select)!=null){
                Persona delPers = (Persona)contenedor1.leerObjeto(select);
                if (delPers.estaEnRelaciones(relacionesP_I,1)|| delPers.estaEnRelaciones(relacionesP_C,1)) {
                    System.out.println("No se eliminó... Hay relaciones pendientes...");
                    System.out.print("Desea eliminar a "+delPers.get_nombre()+ " y todas las relaciones asociadas? (S/N): ");
                    String resp=c.next();
                    if (resp.equals("S") || resp.equals("s")) {
                        delPers.borrarOcurenciasEnRelaciones(relacionesP_I, 1);
                        delPers.borrarOcurenciasEnRelaciones(relacionesP_C, 1);
                        contenedor1.eliminarObjeto(select);
                        System.out.println(">>Se ha eliminado con éxito...");
                    }else{
                        System.out.println("No se eliminó");
                    }
                } else {
                    contenedor1.eliminarObjeto(select);
                    System.out.println(">>Se ha eliminado con éxito...");
                }
            break;
            }
          } catch (NumberFormatException e) {
		System.out.println(ENTEROALERTA);
            }  
        }
    } 
    
    
    public static void  eliminarInstitucion(Contenedor contenedor1, Contenedor relacionesP_I, Contenedor relacionesI_C){
        Scanner c = new Scanner(System.in);
        while (true){
          try{
            System.out.print("Ingrese el # de Institución a eliminar o -1 para cancelar: ");
            int select = Integer.parseInt(c.nextLine()) ;
            if (select==-1) {
                break;
            }else if(contenedor1.leerObjeto(select)!=null){
                    Institucion delInst = (Institucion)contenedor1.leerObjeto(select);
                    if (delInst.estaEnRelaciones(relacionesP_I, 2) || delInst.estaEnRelaciones(relacionesI_C, 1)) {
                        System.out.println("No se eliminó... Hay relaciones pendientes...");
                        //PREGUNTAR
                        System.out.print("Desea eliminar institucion "+delInst.get_nombre()+ " y todas las relaciones asociadas? (S/N): ");
                        String resp = c.next();
                        if (resp.equals("S") || resp.equals("s")) {
                            delInst.borrarOcurenciasEnRelaciones(relacionesP_I, 2);
                            delInst.borrarOcurenciasEnRelaciones(relacionesI_C, 1);
                            contenedor1.eliminarObjeto(select);
                            System.out.println(">>Se ha eliminado con éxito...");
                        }else{
                            System.out.println("No se eliminó");
                        }
                    } else {
                        contenedor1.eliminarObjeto(select);
                        System.out.println(">>Se ha eliminado con éxito...");
                    }
                                                                        
                break;
            }
          } catch (NumberFormatException e) {
		System.out.println(ENTEROALERTA);
            }
        }
    }
    
    public static void  eliminarCiudad(Contenedor contenedor1, Contenedor relacionesP_C, Contenedor relacionesI_C, Contenedor relacionesC_P){
        Scanner c = new Scanner(System.in);
        while (true){
          try{
            System.out.print("Ingrese el # de Ciudad a eliminar o -1 para cancelar: ");
            int select = Integer.parseInt(c.nextLine()) ;
            if (select==-1) {
                break;
            }else if(contenedor1.leerObjeto(select)!=null){
                    Ciudad delCiu = (Ciudad)contenedor1.leerObjeto(select);
                    if (delCiu.estaEnRelaciones(relacionesP_C, 2) || delCiu.estaEnRelaciones(relacionesI_C, 2) || delCiu.estaEnRelaciones(relacionesC_P, 1)) {
                        System.out.println("No se eliminó... Hay relaciones pendientes...");
                        //PREGUNTAR
                        System.out.print("Desea eliminar ciudad "+delCiu.get_nombre()+ " y todas las relaciones asociadas? (S/N): ");
                        String resp = c.next();
                        if (resp.equals("S") || resp.equals("s")) {
                            delCiu.borrarOcurenciasEnRelaciones(relacionesP_C, 2);
                            delCiu.borrarOcurenciasEnRelaciones(relacionesI_C, 2);
                            delCiu.borrarOcurenciasEnRelaciones(relacionesC_P, 1);
                            contenedor1.eliminarObjeto(select);
                            System.out.println(">>Se ha eliminado con éxito...");
                        }else{
                            System.out.println("No se eliminó");
                        }
                    } else {
                        contenedor1.eliminarObjeto(select);
                        System.out.println(">>Se ha eliminado con éxito...");
                    }
                                                                        
                break;
            }
          } catch (NumberFormatException e) {
		System.out.println(ENTEROALERTA);
            }
        }
    }
    
    
    public static void  eliminarPais(Contenedor contenedor1, Contenedor relacionesC_P){
        Scanner c = new Scanner(System.in);
        while (true){
          try{
            System.out.print("Ingrese el # de Pais a eliminar o -1 para cancelar: ");
            int select = Integer.parseInt(c.nextLine()) ;
            if (select==-1) {
                break;
            }else if(contenedor1.leerObjeto(select)!=null){
                    Pais delPais = (Pais)contenedor1.leerObjeto(select);
                    if (delPais.estaEnRelaciones(relacionesC_P, 2)) {
                        System.out.println("No se eliminó... Hay relaciones pendientes...");
                        //PREGUNTAR
                        System.out.print("Desea eliminar pais "+delPais.get_nombre()+ " y todas las relaciones asociadas? (S/N): ");
                        String resp = c.next();
                        if (resp.equals("S") || resp.equals("s")) {
                            delPais.borrarOcurenciasEnRelaciones(relacionesC_P, 2);
                            contenedor1.eliminarObjeto(select);
                            System.out.println(">>Se ha eliminado con éxito...");
                        }else{
                            System.out.println("No se eliminó");
                        }
                    } else {
                        contenedor1.eliminarObjeto(select);
                        System.out.println(">>Se ha eliminado con éxito...");
                    }
                                                                        
                break;
            }
          } catch (NumberFormatException e) {
		System.out.println(ENTEROALERTA);
            }
        }
    }
    
    
    public static void listarObjeto_general(Contenedor contenedor1, int listCampos){
        if (!contenedor1.esVacio()){
            System.out.println("--------------------------------------------------");
            switch(listCampos){
                case 1:
                    System.out.println("ID - Nombre - Direccion");
                break;case 2:
                    System.out.println("ID - Nombre");
                break;    
            } 
            
            contenedor1.listarObjetos();
            System.out.println("--------------------------------------------------");
        }else System.out.println("Vacio...");
    
    }
    
    
    public static void agregarRelacion_general(Contenedor contenedor1, Contenedor contenedor2, Contenedor relacion, int tipoRelacion){
        Scanner c = new Scanner(System.in);
        System.out.print("\nDesea agregar relacion? (S/N): ");
        while (c.next().toUpperCase().equals("S")){
            if(!contenedor1.esVacio() && !contenedor2.esVacio()){
            switch(tipoRelacion){
                case 1:
                    System.out.println("------------------------Personas------------------------");
                    contenedor1.listarObjetos();
                    System.out.println("----------------------Instituciones---------------------");
                    contenedor2.listarObjetos();                    
                break;case 2:
                    System.out.println("------------------------Personas------------------------");
                    contenedor1.listarObjetos();
                    System.out.println("------------------------Ciudades------------------------");
                    contenedor2.listarObjetos();                    
                break;case 3:
                    System.out.println("----------------------Instituciones---------------------");
                    contenedor1.listarObjetos();
                    System.out.println("------------------------Ciudades------------------------");
                    contenedor2.listarObjetos();                    
                break;case 4:
                    System.out.println("------------------------Ciudades------------------------");
                    contenedor1.listarObjetos();
                    System.out.println("-------------------------Paises-------------------------");
                    contenedor2.listarObjetos();                    
                break;    
            }        
            
            relacion.agregarObjeto(LeerRel.leer_relacion(contenedor1,contenedor2,tipoRelacion ));
            System.out.print("\nDesea agregar relacion? (S/N): ");
            }else{
                System.out.println("ATENCION!! La relacion no puede ser creada. No existen datos en el sistema de una o ambas entidades a relacionar");
                System.out.println("Asegurese de agregar datos de las entidades previamente antes de crear una relacion");
                break;
            }
        }
    
    }
    
    public static void eliminarRelacion_general(Contenedor relacion){
        Scanner c = new Scanner(System.in);      
            while (true){
                System.out.print("Ingrese el # de Relacion a eliminar o -1 para cancelar: ");
                try{
		    int select = Integer.parseInt(c.next());
		    if (select==-1) {
                        break;
                    }else if (relacion.leerObjeto(select)!=null){
			relacion.eliminarObjeto(select);
			System.out.println(">>Se ha eliminado con éxito...");
			break;
		    }
		}catch(NumberFormatException e){
		    System.out.println(ENTEROALERTA);
		}
            }                                               
        
    }
    
    
   
}
