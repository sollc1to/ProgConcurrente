/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioCanibales;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Cocinero implements Runnable {

    OllaSem olla;

    public Cocinero(OllaSem o) {
        this.olla = o;
    }

    public void run() {

        while (true) {
            olla.cocinar();

        }

    }

}
