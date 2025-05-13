/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ejercicio4.varios;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Almacen {
    
    int cantidad, maximo;

    public Almacen(int m) {
        this.cantidad = 0;
        this.maximo = m;
    }

    public synchronized void consumir() {

        while (cantidad == 0) {
            System.out.println("No hay productos disponibles..");
            notifyAll(); //Despierta al productor.
            try {
                wait();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(TP6.Ejercicio4.Almacen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        cantidad--;

        System.out.println("El consumidor " + Thread.currentThread().getName()+ " esta consumiendo..." + (cantidad));

    }

    public synchronized void terminarConsumir() {
        System.out.println("El consumidor " + Thread.currentThread().getName()+ " termino de consumir.");

        notifyAll();

    }

    public synchronized void producir() {
        while (cantidad == maximo) {
            System.out.println("El almacen esta lleno..");
            notifyAll(); //Despierta a todos
            try {
                wait();
           
            } catch (InterruptedException ex) {
                Logger.getLogger(TP6.Ejercicio4.Almacen.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        cantidad++;

        System.out.println("El productor " + Thread.currentThread().getName()+ " produce" + (cantidad));
    }
    
    public synchronized void terminarProducir(){
        
        System.out.println("El productor " + Thread.currentThread().getName()+ " termino de producir");
        notifyAll();
    }

    
}
