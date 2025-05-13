/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioCanibales;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class OllaSem {

    int raciones = 20;
    boolean avisarCocinero = false;

    Semaphore cocinero = new Semaphore(0), comer = new Semaphore(1), esperandoComida = new Semaphore(1);

    public void comer() {
        try {
            esperandoComida.acquire();
            System.out.println("El canibal " + Thread.currentThread().getName() + " quiere comer");

            if (raciones == 0) {
                System.out.println("El canibal avisa al cocinero que no hay mas raciones.");
                cocinero.release();
                esperandoComida.acquire();
                

            }
            esperandoComida.release();

            comer.acquire();
            System.out.println("El canibal " + Thread.currentThread().getName() + " esta comiendo..");
            raciones = raciones - 2;

        } catch (InterruptedException ex) {
            Logger.getLogger(OllaSem.class.getName()).log(Level.SEVERE, null, ex);
        }
        comer.release();

    }

    public void cocinar() {
        
        try {
            cocinero.acquire();
             
        System.out.println("El cocinero esta reponiendo raciones...");
        
        raciones = 20;
        
        
            System.out.println("Raciones: " + raciones);
            
            esperandoComida.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(OllaSem.class.getName()).log(Level.SEVERE, null, ex);
        }
       

    }

}
