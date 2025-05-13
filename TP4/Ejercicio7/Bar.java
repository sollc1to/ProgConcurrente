/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ejercicio7;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bar {

    private Silla silla;
    Semaphore semaforoCliente = new Semaphore(0), semaforoMozo = new Semaphore(0);

    public Bar(Silla silla) {

        this.silla = silla;


    }

    public void sentarse() { //Metodo que llama el empleado
     System.out.println("El cliente" + Thread.currentThread().getName() + " llega al bar.");

        silla.sentarse(); //Cliente llega y se sienta en la silla. (.acquire)


    }

    public void servir() {

        try {
            semaforoMozo.acquire();
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Bar.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("El mozo sirve al cliente ");
        

        try {

            Thread.sleep(1500);
            System.out.println("El mozo "+ Thread.currentThread().getName() + "se va");

            
            semaforoCliente.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Bar.class.getName()).log(Level.SEVERE, null, ex);
        }


        
    }
    public void irme(){
        try {
            semaforoCliente.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Bar.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        silla.liberarSilla();

    }
    
    
    

    public void llamarMozo() {

        semaforoMozo.release();
    }


}
