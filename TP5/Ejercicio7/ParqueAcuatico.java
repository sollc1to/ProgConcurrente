/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.Ejercicio7;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParqueAcuatico {

    Semaphore cantidadEscalones = new Semaphore(0), tobogan1 = new Semaphore(0), tobogan2 = new Semaphore(0), esperaCliente = new Semaphore(0), mutex = new Semaphore(1);
    int cantidad, toboganActual;

    public ParqueAcuatico(int cantidad) {
        this.cantidad = cantidad;
        toboganActual = 1;
    }

    public void subirEscalon() {

        cantidadEscalones.release(); //Cada persona que sube le otorga un permiso a la escalera hastq que se llene.
        System.out.println("La persona " + Thread.currentThread().getName() + " subio un escalon.");
        try {
            esperaCliente.acquire(); //El cliente se queda esperando hasta que el encargado le de periso.
        } catch (InterruptedException ex) {
            Logger.getLogger(ParqueAcuatico.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void bajarTobogan() {
        if (toboganActual == 1) {
            try {
                tobogan1.acquire();
                System.out.println("El visitante " + Thread.currentThread().getName() + " esta bajando por el tobogán 1.");

                tobogan1.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(ParqueAcuatico.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                tobogan2.acquire();
                System.out.println("El visitante " + Thread.currentThread().getName() + " esta bajando por el tobogán 2.");

                tobogan2.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(ParqueAcuatico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void habilitarToboganes() {
        try {
            cantidadEscalones.acquire(cantidad); //Una vez que se llena, se habilitan los toboganes
            tobogan1.release();
            tobogan2.release();
            toboganActual = 1;

            System.out.println("El encargado habilitó los toboganes");
        } catch (InterruptedException ex) {
            Logger.getLogger(ParqueAcuatico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void asignarTobogan() {
        try {
            mutex.acquire();

            if (toboganActual == 1) { //Va intercambiando entre los toboganes.
                toboganActual = 2;
                System.out.println("Cambia tobogan 2");

            } else {
                toboganActual = 1;
                System.out.println("Cambia tobogan 1");

            }

        } catch (InterruptedException ex) {
            Logger.getLogger(ParqueAcuatico.class.getName()).log(Level.SEVERE, null, ex);
        }
                    esperaCliente.release();

        mutex.release();

    }

}
