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
public class Transportador implements Runnable {

    private PlantaEmbotelladora planta;

    public Transportador(PlantaEmbotelladora p) {
        this.planta = p;
    }

    public void run() {

        try {
            while (true) {

                planta.transportarCajas();
                Thread.sleep((int) (Math.random() * 2500));
                
                planta.terminarTransporteCajas();
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Transportador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
