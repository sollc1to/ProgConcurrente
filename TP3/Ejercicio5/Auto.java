/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ejercicio5;

/**
 *
 * @author PC
 */
public class Auto extends Vehiculo implements Runnable {

    String modelo, marca;
    int patente, km, combustible;
    Surtidor surtidor;

    public Auto(int patente, Surtidor surtidor, String modelo) {
        super(patente, 500, 0);
        this.modelo = modelo;
        this.combustible = 500;
        this.patente = patente;
        this.surtidor = surtidor;

    }

    public void run() {
        int i = 0;

        while ( i < 30 && combustible > 50) {
            this.recorre(i);

            if (combustible < 200) { //Nivel de la reserva. combustible < 100

                combustible = surtidor.despacharCombustible(combustible, modelo);

            }
            i++;

        }

        System.out.println("Auto " + patente + " Termino su recorrido. Km:" + km + " Combustible: " + combustible);

    }

    public void recorre(int i) {

        if (i % 3 == 0) {

            combustible = combustible - 50;
            km = km + i * 3;
        }

    }
}
