/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio6;

/**
 *
 * @author PC
 */
public class SumasParciales implements Runnable {

    int[] arreglo;

    int sumaParcial;
    sumaFinal suma;
    int nombre;

    public SumasParciales(int[] arreglo, sumaFinal suma, int nombre) {

        this.arreglo = arreglo;
        this.suma = suma;
        this.nombre = nombre;

    }

    public void run() {

        sumarArreglo();

    }

    public synchronized void sumarArreglo() {
        int i = 0;
        boolean realizarSuma = false;

        while (i < arreglo.length && !realizarSuma) {

            if (arreglo[i] != 0) {
                realizarSuma = true;

                for (int j = i; j < 10; j++) {

                    arreglo[i] = 0;

                    sumaParcial = sumaParcial + arreglo[j];

                }

            }
            i++;

        }
        System.out.println("Suma parcial del hilo" + nombre + " es: " + sumaParcial);

        suma.agregarCantidad(sumaParcial);

    }

}
