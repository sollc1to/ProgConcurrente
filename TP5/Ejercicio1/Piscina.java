/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.Ejercicio1;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Piscina {

    Semaphore semaforo = new Semaphore(4); //Capacidad maxima 10 personas.

    public Piscina() {

    }

    public void ingresarPiscina() {
        try {
            semaforo.acquire();

            System.out.println("El cliente " + Thread.currentThread().getName() + " está disfrutando la piscina...");

            Thread.sleep((int) (Math.random() * 1000) + 1);

        } catch (InterruptedException ex) {
            Logger.getLogger(Piscina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salirPiscina() {

        System.out.println("    El cliente " + Thread.currentThread().getName() + " Ya se va de la piscina...");
        
        semaforo.release();
    }

}
