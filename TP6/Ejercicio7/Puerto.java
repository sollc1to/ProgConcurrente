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
public class Puerto {

    int capacidadFerry, cantidadActual;
    boolean viajeTerminado = false;
    
    public Puerto(int capacidad){
        this.capacidadFerry = capacidad;
        cantidadActual  =0;
        
    }

    public synchronized void subirAuto() {

        while (cantidadActual + 3 > capacidadFerry) {
            //El auto ocupa 3 lugares.

            System.out.println("No hay espacio disponible para el auto " + Thread.currentThread().getName());
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Puerto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
         cantidadActual = cantidadActual + 3;
        System.out.println("El auto " + Thread.currentThread().getName() + " se subio al Ferry " + (cantidadActual));
       
    }
    public synchronized void bajarAuto(){
         while(!viajeTerminado){
            
            System.out.println("El viaje aun no termino... el auto " + Thread.currentThread().getName() + " no puede bajar");
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Puerto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
        cantidadActual = cantidadActual-3;
        System.out.println("El auto " + Thread.currentThread().getName() + "se bajo del ferry." + (cantidadActual));

    
        
    }

    public synchronized void subirPasajero() {

        while (cantidadActual + 1 > capacidadFerry) { //Si se llena la capacidad, espera.

            System.out.println("No hay espacio disponible para la persona" + Thread.currentThread().getName());

            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Puerto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        
        cantidadActual++;
        System.out.println("La persona " + Thread.currentThread().getName() + " se subio al Ferry. " + (cantidadActual));

    }
    
    
    public synchronized void bajarPersona(){
        
        while(!viajeTerminado){
            
            System.out.println("El viaje aun no termino... la persona " + Thread.currentThread().getName() + " no puede bajar");
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Puerto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
       
        cantidadActual--;
         System.out.println("La persona " + Thread.currentThread().getName() + "se bajo del ferry. "+ (cantidadActual));
        
     
    }
    
    public synchronized void iniciarViaje(){
        
        while(cantidadActual < capacidadFerry){
            
            System.out.println("El ferry no puede iniciar, aun no se lleno");
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Puerto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("El viaje inicio..");
        viajeTerminado = false;
        
        
        
    }
    
    public synchronized void terminarViaje(){
        System.out.println("El ferry termino su viaje.");
        viajeTerminado = true;
        
        notifyAll();
    }

}
