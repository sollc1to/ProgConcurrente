/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ejercicio3;

/**
 *
 * @author PC
 */
public class ElDescanso {

    public ElDescanso() {
    }

    public synchronized void descansar(String nombre) {
       
        try {
             System.out.println("El hamster " + nombre + " esta descansando..");
            Thread.sleep(250);

        } catch (InterruptedException e) {
            System.out.println("");
        }
        System.out.println("El hamster " + nombre + " terminó de descansar");
    }

}
