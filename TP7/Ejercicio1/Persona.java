/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP7.Ejercicio1;

/**
 *
 * @author PC
 */
public class Persona implements Runnable {

    private GestorSala gestor;

    public Persona(GestorSala g) {
        this.gestor = g;
    }

    public void run() {

        try {
           
            gestor.entrarSala();
            Thread.sleep((int) (Math.random() * 2500) + 1);

            gestor.salirSala();
        } catch (InterruptedException e) {

        }

    }

}
