/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioFilmacion;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Traductor implements Runnable {

    CompaniaFilmacion compania;

    public Traductor(CompaniaFilmacion c) {
        this.compania = c;
    }

    public void run() {

        try {
            while (true) {
                compania.iniciarTraduccion();
                Thread.sleep(2500 + (int) (Math.random() * 1000));
                compania.terminarTraduccion();

            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Traductor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
