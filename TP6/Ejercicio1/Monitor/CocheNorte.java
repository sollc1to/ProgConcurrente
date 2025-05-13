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
public class CocheNorte implements Runnable{
   

    private GestionarTrafico g;

    public CocheNorte(GestionarTrafico g) {
        this.g = g;
    }

    public void run() {

        try {
            g.entrarCocheNorte();
            Thread.sleep((int) (Math.random() * 100) + 1);
        } catch (InterruptedException ex) {
            Logger.getLogger(CocheSur.class.getName()).log(Level.SEVERE, null, ex);
        }

        g.salirCocheNorte();
    }
    
}


