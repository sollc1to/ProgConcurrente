/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ejercicio4.varios;

/**
 *
 * @author PC
 */
public class Productor implements Runnable{
     Almacen alm;
    
    public Productor(Almacen a){
        this.alm = a;
        
    }
    
    
    public void run(){
        
        while(true){
            
            alm.producir();
            try {
                Thread.sleep((int)(Math.random()*1500));
            } catch (InterruptedException ex) {
             
            }
            alm.terminarProducir();
        }
        
    }
    
}
