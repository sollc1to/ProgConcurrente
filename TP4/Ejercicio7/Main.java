/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ejercicio7;

import java.util.concurrent.Semaphore;

/**
 *
 * @author PC
 */
public class Main {

    public static void main(String[] args) {
        Silla silla = new Silla();
        Bar bar = new Bar(silla);

        Mozo mozo = new Mozo(bar);

        Thread mozoHilo = new Thread(mozo);


        Thread[] empleados = new Thread[5];

        for (int i = 0; i < 5; i++) {

            empleados[i] = new Thread(new Empleado(bar), String.valueOf(i));

            empleados[i].start();

        }
                mozoHilo.start();


    }

}
