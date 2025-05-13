/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ejercicio2.Semaforos;

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
     
        }
        sala.levantarseMesa();
    }
    
    
}
