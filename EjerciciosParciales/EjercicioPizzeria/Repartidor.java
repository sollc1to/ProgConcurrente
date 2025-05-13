/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPizzeria;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Repartidor implements Runnable {

    private Restaurante restaurante;

    public Repartidor(Restaurante r) {

        restaurante = r;
    }

    public void run() {

        try {
            restaurante.repartirPedido();
            Thread.sleep(2500);
            restaurante.entregarPedido();
        } catch (InterruptedException ex) {
            Logger.getLogger(Repartidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
