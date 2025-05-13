/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioObservatorio;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Mantenimiento implements Runnable {

    private Sala s;

    public Mantenimiento(Sala s) {
        this.s = s;
    }

    public void run() {
        try {
            s.ingresarMantenimiento();
            Thread.sleep((int) (Math.random() * 2500) + 1);
            s.salirMantenimiento();
        } catch (InterruptedException ex) {
            Logger.getLogger(Mantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
