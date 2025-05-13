/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPizzeria;

import static java.lang.Math.random;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class GeneradorPedido implements Runnable {

    int n;
    String tipo, nombre;
    Random random = new Random();
    private String[] nombres = {"Juan", "Maria", "Pedro", "Ana", "Luis", "Carmen", "Carlos", "Elena"};
    Restaurante r;
    public GeneradorPedido(Restaurante r){
        this.r = r;
    }

    public void run() {

        while (true) {

            n = (int) ((Math.random() * 1000) + 1);

            if (n % 2 == 0) {
                tipo = "veggie";

            } else {
                tipo = "pizz";

            }
            nombre = nombres[random.nextInt(nombres.length)];
            
            r.tomarPedido(nombre, tipo);
            
            
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(GeneradorPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            

        }
    }

}
