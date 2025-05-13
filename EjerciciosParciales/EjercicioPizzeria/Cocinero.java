/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPizzeria;

/**
 *
 * @author PC
 */
public class Cocinero implements Runnable {

    Restaurante r;
    int n;
    String tipo;

    public Cocinero(Restaurante r) {
        this.r = r;
    }

    public void run() {
        n = (int) ((Math.random() * 1000) + 1);

        if (n % 2 == 0) {
            r.cocinarPizzaVeggie();

        } else {
            r.cocinarPizza();
        }
        r.terminarPedido();

    }

}
