/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ejercicio7;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Ferry implements Runnable{
    
    Puerto puerto;
    public Ferry(Puerto p){
        this.puerto = p;
    }
    public void run(){
        
        
        while(true){
             puerto.iniciarViaje();
        
            puerto.terminarViaje();
            
            
        }
            
            
            
        
        
    }
    
}
