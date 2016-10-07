/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;

import java.io.IOException;
import utiles.Menu;

/**
 *
 * @author Antonio
 */
public class TestMenus {
    public static void main(String [] args) throws IOException{
        Menu.menu("Principal");
	
	Menu.menu("Personas");
	Menu.menu("Instituciones");
	Menu.menu("Ciudades");
	Menu.menu("Paises");

	Menu.menu("Relaciones");
	
	Menu.menu("Personas-Instituciones");
	Menu.menu("Personas-Ciudades");
	Menu.menu("Instituciones-Ciudades");
	Menu.menu("Ciudades-Paises");
    }
}
