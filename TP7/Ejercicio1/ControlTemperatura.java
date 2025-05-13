/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP7.Ejercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class ControlTemperatura implements Runnable {
    
    private GestorSala g;
    int temperatura;
    
    public ControlTemperatura(GestorSala s) {
        this.g = s;
    }
    
    public void run() {
        
        while (true) {
            try {
                temperatura = (int) (Math.random() * 50) + 1;
                
                g.actualizarTemperatura(temperatura);
                
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControlTemperatura.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
}
