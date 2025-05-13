/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPizzeria;

/**
 *
 * @author PC
 */
public class Main {

    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        Thread generarPedido = new Thread(new GeneradorPedido(restaurante));
        generarPedido.start();

        Thread[] cocineros = new Thread[30];

        Thread[] repart = new Thread[30];

        for (int i = 0; i < cocineros.length; i++) {
            cocineros[i] = new Thread(new Cocinero(restaurante));
            cocineros[i].start();

        }

        for (int i = 0; i < repart.length; i++) {
            repart[i] = new Thread(new Repartidor(restaurante));
            repart[i].start();

        }

    }

}
