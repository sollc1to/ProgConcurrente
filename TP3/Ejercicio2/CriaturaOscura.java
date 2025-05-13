/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ejercicio2;

/**
 *
 * @author PC
 */
public class CriaturaOscura implements Runnable{

    String nombre;
    Energia energia;

    public CriaturaOscura(String nombre, Energia energia) {

        this.nombre = nombre;
        this.energia = energia;
    }

    public void run() {

        for (int i = 0; i < 10; i++) {
            this.energia.restar();
            System.out.println("Criatura oscura resta.." + energia.getCantidad());

        }
    }
}
