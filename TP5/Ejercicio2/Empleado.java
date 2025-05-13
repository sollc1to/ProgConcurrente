/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.Ejercicio2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Empleado implements Runnable {

    private Bar bar;
    private int decision;

    public Empleado(Bar bar, int decision) {
        this.bar = bar;
        this.decision = decision;

    }

    public void run() {

        try {
            bar.entrarBar();
            if (decision == 1) {

                bar.llamarMozo();

            } else if (decision == 2) {
                bar.llamarCocinero();
            } else {
                bar.llamarMozoYCocinero();
            }
            Thread.sleep((int) (Math.random() * 1000) + 1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        bar.irse();

    }
}
