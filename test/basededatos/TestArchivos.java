/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;

import utiles.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;

/**
 *
 * @author perdonal
 */
public class TestArchivos  {
   public static void main(String args[])throws IOException{
       String title1 = "RPPI";
       String EXT = ".txt";
       String FILE = title1+"("+ManejadorFechas.getFechaActual()+")("+ManejadorFechas.getHoraActual()+")"+EXT;
       
       Path p = Paths.get("logs/"+FILE);
       
       BufferedWriter reporteRPPI = null;
       
      
       reporteRPPI = Files.newBufferedWriter(p);
       
      
       
       
       
   } 
}
