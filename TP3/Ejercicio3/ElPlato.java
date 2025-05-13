/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ejercicio3;

/**
 *
 * @author PC
 */
public class ElPlato {

    public ElPlato() {

    }

    public synchronized void  comer(String nombre) {
        
        try {
            System.out.println("El hamster " + nombre + " esta comiendo..");
            Thread.sleep(250);

        } catch (InterruptedException e) {
            System.out.println("");
        }
        System.out.println("El hamster " + nombre + " terminó de comer");
    }

}
