/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioParicalEmbotelladora;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Empaquetador implements Runnable {

    PlantaEmbotelladora planta;

    public Empaquetador(PlantaEmbotelladora pl) {
        this.planta = pl;

    }

    public void run() {

        try {
            while (true) {
                planta.iniciarEmpaque();

                Thread.sleep((int) (Math.random() * 2500));
                
                planta.terminarEmpaque();
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Empaquetador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
