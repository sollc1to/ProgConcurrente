/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progconcurrente;

/**
 *
 * @author PC
 */
public class miClase implements Runnable {

    private String nombre;

    public miClase(String unombre) {
        this.nombre = unombre;

    }

    public String getName() {

        return this.nombre;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + this.nombre);
        }
        System.out.println("Termina thread " + this.nombre);
    }

}
