/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ejercicio7;

/**
 *
 * @author PC
 */
public class Main {

    public static void main(String[] args) {
        Puerto puerto = new Puerto(15);

        Thread ferry = new Thread(new Ferry(puerto));

        ferry.start();

        Thread[] pasajeros = new Thread[20];
        Thread[] autos = new Thread[5];

        for (int i = 0; i < pasajeros.length; i++) {
            pasajeros[i] = new Thread(new Pasajero(puerto), "" + i);
            pasajeros[i].start();

        }

        for (int i = 0; i < autos.length; i++) {
            autos[i] = new Thread(new Auto(puerto), "" + i);
            autos[i].start();

        }

    }

}
