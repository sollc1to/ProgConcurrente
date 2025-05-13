/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.Ejercicio6VER;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class AvionAterrizaje implements Runnable{

   TorreControl torre;
    
    
    public AvionAterrizaje(TorreControl t){
        this.torre = t;
     
        
    }
    
    
    
    public void run(){
        
        torre.pedirAterrizaje();

        torre.aterrizar();
       try {
           Thread.sleep((int)Math.random()*1000);
       } catch (InterruptedException ex) {
           Logger.getLogger(AvionAterrizaje.class.getName()).log(Level.SEVERE, null, ex);
       }
       
        
        
    }

}
