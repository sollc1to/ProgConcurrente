/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ejercicio7;

import java.util.concurrent.Semaphore;

/**
 *
 * @author PC
 */
public class Silla {

    Semaphore semaforo = new Semaphore(1);

    public Silla() {
     

    }

    public void sentarse() {

        try {
            semaforo.acquire();
            System.out.println("El cliente " + Thread.currentThread().getName() + " se sento");
            //Le agrego un random con un sleep
            

        } catch (InterruptedException e) {

        }

    }

    public void liberarSilla() {
        System.out.println("El cliente" + Thread.currentThread().getName() + " se bajo de la silla");
        

        semaforo.release();

    }

}
