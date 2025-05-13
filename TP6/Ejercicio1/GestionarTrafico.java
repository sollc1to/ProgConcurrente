/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ejercicio1;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class GestionarTrafico {

    int cantidadSur = 0, cantidadNorte = 0;
    Semaphore puente = new Semaphore(1), mutex = new Semaphore(1);

    public GestionarTrafico() {

    }
    public void entrarNorte(){
         try {

            mutex.acquire();
            cantidadNorte++;
            if (cantidadSur == 0 && cantidadNorte == 1) { //Si es el primero en llegar, entonces toma el permiso del puente.
                puente.acquire();

            }
            System.out.println("El auto " + Thread.currentThread().getName() + " esta entrando por el norte. ");

        } catch (InterruptedException ex) {
            Logger.getLogger(GestionarTrafico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void salirNorte(){
          System.out.println("El auto " + Thread.currentThread().getName() + " esta saliendo por el norte. ");
        cantidadNorte--;

        if (cantidadNorte == 0) {
            puente.release(); //Si no hay mas autos, libero el puente.

        }

        mutex.release();

    }
        
    

    public void entrarSur() {
        try {

            mutex.acquire();
            cantidadSur++;
            if (cantidadSur == 1 && cantidadNorte == 0) { //Si es el primero en llegar, entonces toma el permiso del puente.
                puente.acquire();

            }
            System.out.println("El auto " + Thread.currentThread().getName() + " esta entrando por el sur. ");

        } catch (InterruptedException ex) {
            Logger.getLogger(GestionarTrafico.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void salirSur() {
        System.out.println("El auto " + Thread.currentThread().getName() + " esta saliendo por el sur. ");
        cantidadSur--;

        if (cantidadSur == 0) {
            puente.release(); //Si no hay mas autos, libero el puente.

        }

        mutex.release();

    }

}
