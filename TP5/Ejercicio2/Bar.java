package TP5.Ejercicio2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bar { //Preguntar si los sleep estan bien puestos en el recurso compartido o hayq  ponerlos en el hilo

    /*public void irme(){ Preguntar si esta de mas
        
        try {
            System.out.println("El cliente ya se va");
            semaforoCliente.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Bar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    Semaphore espacioDisponible = new Semaphore(2);
    Semaphore semaforoMozo = new Semaphore(0), semaforoCocinero = new Semaphore(0), semaforoImprimir = new Semaphore(1);

    public void Bar() {

    }

    public void entrarBar() {

        try {
            espacioDisponible.acquire();

        } catch (InterruptedException ex) {
            Logger.getLogger(Bar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void llamarCocinero() {

        semaforoCocinero.release();

    }

    public void llamarMozo() {

        semaforoMozo.release();

    }

    public void servir() {

        try {
            semaforoMozo.acquire();
            
            System.out.println("El mozo esta sirviendo al cliente " + Thread.currentThread().getName());
            Thread.sleep((int) (Math.random() * 1000) + 1);
            
           

        } catch (InterruptedException ex) {
            Logger.getLogger(Bar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cocinar() {

        try {
            semaforoCocinero.acquire();

            semaforoImprimir.acquire();

            System.out.println("El cocinero esta cocinando al cliente" + Thread.currentThread().getName());
            Thread.sleep((int) (Math.random() * 1000) + 1);
            System.out.println("El cliente ya puede comer :)");
            semaforoImprimir.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Bar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void llamarMozoYCocinero() {

        semaforoMozo.release();
        semaforoCocinero.release();

    }

    public void irse() {
        try {
            semaforoImprimir.acquire();

            System.out.println("El cliente " + Thread.currentThread().getName() + " se va.");
            semaforoImprimir.release();

            espacioDisponible.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Bar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
