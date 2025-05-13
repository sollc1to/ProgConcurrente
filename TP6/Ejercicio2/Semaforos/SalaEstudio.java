/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ejercicio2.Semaforos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class SalaEstudio {
    
    Semaphore cantidadMesas;
  
    
    public SalaEstudio (int cantidad){
        
        cantidadMesas = new Semaphore(cantidad);
    }
    
    
    public void sentarseMesa(){
        System.out.println("El estudiante" + Thread.currentThread().getName() + " quiere sentarse...");
        
        try { 
            cantidadMesas.acquire();
            System.out.println("El estudiante ]"+ Thread.currentThread().getName() +" se sento.");
        } catch (InterruptedException ex) {
            Logger.getLogger(SalaEstudio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void levantarseMesa(){
        System.out.println("El estudiante" + Thread.currentThread().getName()+ " se va de la sala.");
        cantidadMesas.release();
    }
    
    
}
