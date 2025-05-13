/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ejercicio2.Monitor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class SalaEstudio {

    int cantidadMesas, mesasOcupadas = 0;

    public SalaEstudio(int c) {
        this.cantidadMesas = c;
    }

    public synchronized void sentarseMesa() {

        while (mesasOcupadas == cantidadMesas) {
            System.out.println("No hay mesas disponibles..");

            try {
                wait();
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                Logger.getLogger(SalaEstudio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        System.out.println("El estudiante" + Thread.currentThread().getName() + " ocupo una mesa.");
        
        mesasOcupadas++;
        

    }
    public synchronized void levantarseMesa(){ // el mesas Ocupadas -- iria antes o despues del notify?
        
        System.out.println("El estudiante " + Thread.currentThread().getName() + " se va de la sala.");
        mesasOcupadas--;
        
        notify();
        
    }

}
