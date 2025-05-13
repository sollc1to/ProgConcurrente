/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ejercicio3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author PC
 */
public class Proceso implements Runnable {

    private Semaphore semaforo1, semaphoro2;

    public Proceso(Semaphore semaforo1, Semaphore semaforo2) {

        this.semaforo1 = semaforo1;
        this.semaphoro2 = semaforo2;
    }

    public void run() {
        
        while(true){
            
        iniciaProceso();
        
        terminaProceso();
        
            
        }

    }

    public void iniciaProceso() {

        try {

            semaforo1.acquire();

            System.out.println("Semaforo " + Thread.currentThread().getName() + " laburando...");

            Thread.sleep(500);

        } catch (InterruptedException e) {

        }

    }
    
    public void terminaProceso(){
        
        System.out.println("El semaforo " + Thread.currentThread().getName() + " libera la CPU.");
        
        semaphoro2.release();
        
        
    }

}
