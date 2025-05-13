/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioParicalEmbotelladora;

/**
 *
 * @author PC
 */
public class Main {

    public static void main(String[] args) {
        PlantaEmbotelladora planta = new PlantaEmbotelladora();

        Thread empaquetador = new Thread(new Empaquetador(planta));
        Thread transportador = new Thread(new Transportador(planta));
        transportador.start();

        empaquetador.start();

        Thread embotelladores[] = new Thread[150];

        for (int i = 0; i < embotelladores.length; i++) {

            embotelladores[i] = new Thread(new Embotellador(planta), "" + i);
            embotelladores[i].start();

        }

    }

}
