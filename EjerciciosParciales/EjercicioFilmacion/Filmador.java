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
public class Filmador implements Runnable {

    CompaniaFilmacion compania;

    public Filmador(CompaniaFilmacion c) {
        this.compania = c;
    }

    public void run() {

        try {
            while (true) {
                compania.filmarCapitulo();
                Thread.sleep(2500);
                
            compania.terminarFilmarCap();

            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Filmador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
