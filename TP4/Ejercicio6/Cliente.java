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
public class Cliente implements Runnable {
    //El cliente debe tener solo el taxi.
    //Todo lo que deben hacer varios hilos va al objeto compartido.
   
    // El cliente hace un taxi. release para liberar y que lo lleve. Luego el taxi hace cliente.acquire para
    //Bloquear al cliente y que no pueda bajarse hasta que el haga  clinete.release.
    
   
    Viaje viaje;

    public Cliente (Viaje viaje) {
        this.viaje = viaje;


    }

    public void run() { //Si el taxi esta libre, entonces lo llama.
        
        viaje.llamarTaxi(Thread.currentThread().getName());

    }

   
}
