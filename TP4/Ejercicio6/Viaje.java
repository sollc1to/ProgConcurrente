/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ejercicio6;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Viaje {

    Semaphore semaforoCliente = new Semaphore(1);
    Semaphore semaforoTaxi = new Semaphore(0);

    public Viaje() {

    }

    public void llamarTaxi(String n) {

        semaforoTaxi.release(); //Le doy un permiso al taxi para q pase.
        System.out.println("El cliente" + n + " llama al taxi.");

    }

    public void conducirCliente(String n) {

        try {
            semaforoTaxi.acquire();
            System.out.println("Taxi llevando al cliente " + n);
            semaforoCliente.acquire();

            Thread.sleep(1000);

        } catch (InterruptedException ex) {
            Logger.getLogger(Viaje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llegamosDestino(String n) {

        System.out.println("El taxi deja a su cliente " + n);
        semaforoCliente.release();

    }

}
