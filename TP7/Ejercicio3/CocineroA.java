/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP7.Ejercicio3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class CocineroA implements Runnable{
    
    Cocina c;
    public CocineroA(Cocina co){
        this.c = co;
    }
    
    public void run(){
        
        
       
        try {
             c.prepararCarne();
            Thread.sleep((int)(Math.random()*1000)+1);
            c.prepararPasta();
             Thread.sleep((int)(Math.random()*1000)+1);
             
             
             c.reponerAlimento(false,true,true);
              Thread.sleep((int)(Math.random()*1000)+1);
              
              System.out.println("El cocinero " + Thread.currentThread().getName() + " ya termino su plato. :)");
             
             

            
        } catch (InterruptedException ex) {
            Logger.getLogger(CocineroA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
}
