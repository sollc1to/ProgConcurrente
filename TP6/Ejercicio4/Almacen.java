/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ejercicio4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Almacen {

    int cantidad, maximo;

    public Almacen(int m) {
        this.cantidad = 0;
        this.maximo = m;
    }

    public synchronized void consumir() {

        try {
            while (cantidad == 0) {
                System.out.println("No hay productos disponibles..");

                wait();
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
        }

        cantidad--;
        System.out.println("    Termino de consumir");
        notify();

    }

    public synchronized void producir() {
        while (cantidad == maximo) {
            
            System.out.println("El almacen esta lleno..");
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Almacen.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        System.out.println("Empezo producir");

        cantidad++;
        System.out.println("Termino producir");
        notify();
    }

}
