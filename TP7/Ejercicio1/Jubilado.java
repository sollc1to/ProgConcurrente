/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP7.Ejercicio1;

/**
 *
 * @author PC
 */
public class Jubilado implements Runnable{
    private GestorSala gestor;

    public Jubilado(GestorSala g) {
        this.gestor = g;
    }

    public void run() {

        try {
            gestor.entrarSalaJubilado();
            Thread.sleep((int) (Math.random() * 2000) + 1);

            gestor.salirSala();
        } catch (InterruptedException e) {

        }

    }

    
}
