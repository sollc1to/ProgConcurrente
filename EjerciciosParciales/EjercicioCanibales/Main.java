/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioCanibales;

/**
 *
 * @author PC
 */
public class Main {

    public static void main(String[] args) {
        OllaSem olla = new OllaSem();
        Thread cocinero = new Thread(new Cocinero(olla));
        cocinero.start();

        Thread[] canibales = new Thread[60];

        for (int i = 0; i < canibales.length; i++) {
            canibales[i] = new Thread(new Canibal(olla), "" + i);
            canibales[i].start();

        }

    }

}
