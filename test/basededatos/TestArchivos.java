/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;

import utiles.*;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;

/**
 *
 * @author perdonal
 */
public class TestArchivos  {
   public static void main(String args[])throws IOException{
       String title = "RPPI";
       String EXT = ".txt";
       String FILE = title+"("+ManejadorFechas.getFechaActual()+")("+ManejadorFechas.getHoraActual()+")"+EXT;
       
       Path p = Paths.get("logs/"+FILE);
       
       BufferedWriter reporteRPPI = null;
       
       try{
           reporteRPPI = Files.newBufferedWriter(p);
       
       }catch(IOException e){
           reporteRPPI = Files.newBufferedWriter(p);
       }
       
       
       
   } 
}
