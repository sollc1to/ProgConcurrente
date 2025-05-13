/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.Ejercicio5VER;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Pasajero implements Runnable{
    Estacion estacion;
    
    public Pasajero(Estacion estacion){
        
        this.estacion = estacion;
        
    }
    
    public void run(){
        
        
        estacion.comprarTickets();
              try {
            Thread.sleep((int)(Math.random()*1000)+1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pasajero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        estacion.subirseTren();
        
        try {
            Thread.sleep((int)(Math.random()*1000)+1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pasajero.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        estacion.bajarseTren();
        
        
        
        
        
        
    }

    
    
    
    
    
    
}
