package com.mycompany.progconcurrente;

public class Corredores extends Thread {

    public static void main(String[] args) {
        int distancia = -1;
        Thread[] hilos = new Thread[10];
        Corredor corredor = null;

        Corredor arreglo[] = new Corredor[10];

        for (int i = 0; i < 6; i++) {

            arreglo[i] = new Corredor("Corredor " + i, (i * i + (3 * i)));
            hilos[i] = new Thread(arreglo[i]);
            hilos[i].start();

        }

        System.out.println("Carga de hilos terminada");

        for (int i = 0; i < 6; i++) {

            try {

                hilos[i].join();

                if (arreglo[i].getDistancia() > distancia) {
                    distancia = arreglo[i].getDistancia();
                    corredor = arreglo[i];

                }

            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido");

            }

        }
        System.out.println("Carrera terminada");
        System.out.println(corredor.toString());

    }
}
