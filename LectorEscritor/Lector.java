/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJericicoConcurrente;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Lector implements Runnable{
    
    Libro libro;
    
    
    public Lector(Libro l){
        this.libro = l;
    }
    
    
    public void run(){
        
        libro.quieroLeer();
        try {
            Thread.sleep((int)((Math.random())*2000)+1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Libro.class.getName()).log(Level.SEVERE, null, ex);
        }

        libro.terminarLeer();
        
    }
    
}
