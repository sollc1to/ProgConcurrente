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
public class AnimalChiquito implements Runnable {

    private Casa casa;

    public AnimalChiquito(Casa c) {
        this.casa = c;
    }

    public void run() {

        try {
            System.out.println("El animalito " + Thread.currentThread().getName() + " esta jugando..");

            Thread.sleep((int) (Math.random() * 2500 + 1));

            casa.sentarseBanquito();
            Thread.sleep((int) (Math.random() * 2500 + 1));
            
            casa.terminarComer();
            

        } catch (InterruptedException ex) {
            Logger.getLogger(AnimalChiquito.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
