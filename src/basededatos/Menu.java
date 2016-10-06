package basededatos;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class Menu{
    public static int menu(String title) throws IOException{
	HashMap<String, String> dictionary = new HashMap<>();
	dictionary.put("principal", "MenuPrincipal");
	
	dictionary.put("personas", "MenuGeneral");
	dictionary.put("instituciones", "MenuGeneral");
	dictionary.put("ciudades", "MenuGeneral");
	dictionary.put("paises", "MenuGeneral");
	
	dictionary.put("relaciones", "MenuRelacionesPrincipal");	
	
	dictionary.put("personas-instituciones", "MenuRelacionesGeneral");
	dictionary.put("personas-ciudades", "MenuRelacionesGeneral");
	dictionary.put("instituciones-ciudades", "MenuRelacionesGeneral");
	dictionary.put("paises-ciudades", "MenuRelacionesGeneral");
	
	// OPCION
	int opcion=0;
	
	// TITLE
	String key=title.toLowerCase();
	String EXT=".txt";			   
	String FILE = dictionary.get(key)+EXT;
	Path p = Paths.get("menu/"+FILE);				
	BufferedReader FILEBuffer = Files.newBufferedReader(p);
	
	// IMPRESION DE CABECERA
	int n = ("Menú "+key).length();	// ANCHO DE MENU 60
	int spc = 60-n;
	int mtd = spc/2;
	System.out.println();
	for (int i = 0; i < mtd; i++) System.out.print("*");
	System.out.print("Menú "+title);
	for (int i = 0; i < mtd; i++) System.out.print("*");
	System.out.println();
	// IMPRESION DE LINEAS
	int cont=1;
	String linea;
	while ((linea = FILEBuffer.readLine())!=null) {				  
	    System.out.println(cont+". "+linea);
	    cont++;
	}
	
	Scanner scn = new Scanner(System.in);
	do {
	    System.out.print("Ingrese opcion: [1-"+(cont-1)+"]: ");
	    try {
		opcion=Integer.parseInt(scn.next());
		break;
	    } catch (NumberFormatException e) {
	        System.out.println("Ingrese un entero para elegir una opcion");
		return menu(title);
	    }
	} while (opcion<1 || opcion>cont-1);
	return opcion;
	}

}