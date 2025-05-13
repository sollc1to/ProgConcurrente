/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ejercicio6;

import java.util.concurrent.Semaphore;

/**
 *
 * @author PC
 */
public class Taxi implements Runnable {

    Viaje viaje;

    public Taxi(Viaje viaje) {
        this.viaje = viaje;

    }

    public void run() {

        while (true) {
            viaje.conducirCliente(Thread.currentThread().getName());
            viaje.llegamosDestino(Thread.currentThread().getName());

        }

    }

}
