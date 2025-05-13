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
public class Socio implements Runnable {

    int pagina;

    CompaniaFilmacion compania;

    public Socio(CompaniaFilmacion c) {
        this.compania = c;

    }

    public void run() {
        try {
            pagina = (int) (Math.random() * 10);

            if (pagina % 2 == 0) {

                for (int i = 0; i < 10; i++) {
                    compania.verCapEIngles(pagina);
                    Thread.sleep((int) (Math.random() * 1000));
                    compania.terminarCapIngles();
                    Thread.sleep((int) (Math.random() * 1000));

                }

            } else {
                for (int i = 0; i < 10; i++) {
                    compania.verCapEspañol(pagina);
                    Thread.sleep((int) (Math.random() * 1000));

                    compania.terminarCapEspañol();
                    Thread.sleep((int) (Math.random() * 1000));

                }

            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Socio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
