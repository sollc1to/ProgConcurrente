/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioAnimalitos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class AnimalMayor implements Runnable {

    private Casa casa;

    public AnimalMayor(Casa c) {
        this.casa = c;
    }

    public void run() {

        try {

            while (true) {
                System.out.println("El animal mayor esta dibujando..");

                casa.prepararComida();
                Thread.sleep((int) (Math.random() * 2500 + 1));

                casa.servirComida();

            }

        } catch (InterruptedException ex) {
            Logger.getLogger(AnimalMayor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
