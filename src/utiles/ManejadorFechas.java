/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author perdonal
 */
public class ManejadorFechas {
    public static String  getFechaActual(){
        Date fechaActual = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        return formateador.format(fechaActual);
     }
    
    public static String  getHoraActual(){
        Date horaActual = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh-mm-ss");
        return formateador.format(horaActual);
     }
    
    
    
}
