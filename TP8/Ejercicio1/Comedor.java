/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP8.Ejercicio1;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Comedor {

    Semaphore cantidad, mostrador, abridor, mostradorPostre;

    public Comedor(int cantidad, int mostrador) {

        this.cantidad = new Semaphore(cantidad);

        this.mostrador = new Semaphore(mostrador);

        this.abridor = new Semaphore(10);
        this.mostradorPostre = new Semaphore(3);

    }

    public void ingresarComedor() {

        System.out.println("El soldado " + Thread.currentThread().getName() + " quiere ingresar..");

        try {
            cantidad.acquire();

            System.out.println("El soldado " + Thread.currentThread().getName() + " ingreso al comedor");

        } catch (InterruptedException e) {

        }

    }
    
    public void tomarBandejaMostrador(){
        System.out.println("El soldado " + Thread.currentThread().getName() + " quiere tomar una bandeja..");
        try {
            mostrador.acquire();
            System.out.println("El soldado "  + Thread.currentThread().getName() + " tomo una bandeja ");
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
    
   public void desocuparMostrador(){
       System.out.println("El soldado "  + Thread.currentThread().getName() + " desocupa el mostrador ");
       mostrador.release();
       
   }
    public void tomarAbridor(){
         System.out.println("El soldado " + Thread.currentThread().getName() + " necesita un abridor..");
          try {
            abridor.acquire();
            System.out.println("El soldado "  + Thread.currentThread().getName() + " tomo un abridor ");
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
        
    }
    
    public void desocuparAbridor(){
      
            System.out.println("El soldado "  + Thread.currentThread().getName() + " deja el abridor");
            abridor.release();
            
       
        
    }
    
    
    public void pedirPostre(){
        
        System.out.println("El soldado " +Thread.currentThread().getName() + " quiere postre");
        
        try {
            mostradorPostre.acquire();
            
            System.out.println("El soldado " +Thread.currentThread().getName() +" esta agarrando postre.");
        } catch (InterruptedException ex) {
            Logger.getLogger(Comedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

}
