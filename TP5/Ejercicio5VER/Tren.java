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
public class Tren implements Runnable{
    Estacion estacion;
    
    public Tren(Estacion est){
        estacion = est;
        
    }
    
    public void run(){
        
        
        while(true){
            estacion.realizarRecorrido();
            try {
                Thread.sleep((int)(Math.random()*1000) + 1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Tren.class.getName()).log(Level.SEVERE, null, ex);
            }
            estacion.terminarRecorrido();
           
            
            
            
            
            
            
            
            
            
            
        }
      
                
                
                
                
                
    }
    
    
    
    
    
}
