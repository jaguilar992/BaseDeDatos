package utiles;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author jaguilar992
 */

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
		dictionary.put("ciudades-paises", "MenuRelacionesGeneral");
                dictionary.put("reportes","MenuReportes");

		// OPCION
		int opcion=0;
		Scanner scn = new Scanner(System.in);
		// TITLE
		String EXT=".txt";			   
		String key=title.toLowerCase();
		String FILE = dictionary.get(key)+EXT;
		Path p = Paths.get("menu/"+FILE);				
		BufferedReader FILEBuffer = Files.newBufferedReader(p);
		// IMPRESION DE CABECERA
		int n = ("Menú "+key).length();
		int spc = 60-n; // ANCHO DE MENU 60
		int mtd = spc/2;
		System.out.println();
		for (int i = 0; i < mtd; i++) System.out.print("*");
		System.out.print("Menú "+title);
		for (int i = 0; i < mtd; i++) System.out.print("*");
		System.out.println();
		// IMPRESION DE OPCIONES DE MENU DESDE ARCHIVO
		int cont=1;
		String linea;
		while ((linea = FILEBuffer.readLine())!=null) {				  
			System.out.println(cont+". "+linea);
			cont++;
		}
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