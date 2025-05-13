/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ejercicio2.Monitor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Estudiante implements Runnable{
    
    SalaEstudio sala;
    
    public Estudiante(SalaEstudio s){
        this.sala = s;
    }
    
    public void run(){
        
        sala.sentarseMesa();
   
        try {
            Thread.sleep((int)(Math.random()*15000)+1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
        sala.levantarseMesa();
    }
    
    
}
