/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioHacerAgua;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Oxigeno implements Runnable{
    
    private Espacio espacio;
    
    
    public  Oxigeno(Espacio e){
        this.espacio = e;
    }
    
    public void run(){
        
            espacio.Olisto();
         
    }
    
}
