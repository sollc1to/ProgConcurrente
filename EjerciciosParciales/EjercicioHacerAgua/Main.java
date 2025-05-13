/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioHacerAgua;

/**
 *
 * @author PC
 */
public class Main {

    public static void main(String[] args) {
        Espacio espacio = new Espacio(10);

        Thread oxigeno[] = new Thread[60];
        Thread hidrogeno[] = new Thread[80];

        for (int i = 0; i < oxigeno.length; i++) {

            oxigeno[i] = new Thread(new Oxigeno(espacio));
            oxigeno[i].start();

        }
        for (int i = 0; i < hidrogeno.length; i++) {

            hidrogeno[i] = new Thread(new Hidrogeno(espacio));
            hidrogeno[i].start();

        }
    }

}
