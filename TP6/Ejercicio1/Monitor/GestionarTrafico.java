/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ejercicio1.Monitor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class GestionarTrafico { //Monitor

    int cantidadSur = 0, cantidadNorte = 0;
    boolean norte = false, sur = false;

    public GestionarTrafico() {

    }

    public synchronized void entrarCocheNorte() {
        System.out.println("El auto " + Thread.currentThread().getName() + " quiere entrar por el norte.");

        while (cantidadSur > 0 && cantidadSur <=10) {
            try {
                System.out.println("Estan ingresando autos del sur... :C");

                wait();
                Thread.sleep((int) (Math.random() * 1500));
            } catch (InterruptedException ex) {
                Logger.getLogger(GestionarTrafico.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        System.out.println("El auto " + Thread.currentThread().getName() + " esta ingresando por el norte..");
        cantidadNorte++;
    }

    public synchronized void entrarCocheSur() {
        System.out.println("El auto " + Thread.currentThread().getName() + " quiere entrar por el sur.");

        while (cantidadNorte > 0 && cantidadNorte <=10) {
            try {
                System.out.println("Estan ingresando autos del Norte... :c");

                wait();
                Thread.sleep((int) (Math.random() * 1500));
            } catch (InterruptedException ex) {
                Logger.getLogger(GestionarTrafico.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        System.out.println("El auto " + Thread.currentThread().getName() + " esta ingresando por el sur..");
        cantidadSur++;
    }

    public synchronized void salirCocheNorte() {
        System.out.println("El auto " + Thread.currentThread().getName() + " esta saliendo del norte");
        cantidadNorte--;
        notify();

    }

    public synchronized void salirCocheSur() {
        System.out.println("El auto " + Thread.currentThread().getName() + " esta saliendo del sur");
        cantidadSur--;
        notify();

    }

}
