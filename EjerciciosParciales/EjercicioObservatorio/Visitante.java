/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioObservatorio;


/**
 *
 * @author PC
 */
public class Visitante implements Runnable {

    private Sala sala;
    private int i;

    public Visitante(Sala s) {
        this.sala = s;
    }

    public void run() {
        i = (int) (Math.random() * 2);
        try {
            if (i == 0) {

                sala.ingresarSillaRueda();
                Thread.sleep((int) (Math.random() * 2500) + 1);
                sala.salirSillaRueda();
            } else {
                sala.ingresarVisitante();
                Thread.sleep((int) (Math.random() * 2500) + 1);
                sala.salirVisitante();

            }

        } catch (InterruptedException ex) {

        }

    }

}
