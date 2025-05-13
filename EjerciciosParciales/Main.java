/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio6;

/**
 *
 * @author PC
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = new int[50];
        //El arreglo es el recurso compartido
        //No tiene que usar synchronized. Se le pasa x parametro el intervalo y listo. 

        cargarArreglo(arr);

        for (int i = 0; i < arr.length; i++) {
            //Cargo el arreglo

            System.out.println(arr[i]);

        }
        sumaFinal suma = new sumaFinal();

        Thread[] sumaParcial = new Thread[5];

        for (int i = 0; i < sumaParcial.length; i++) {

            sumaParcial[i] = new Thread(new SumasParciales(arr, suma, i));

        }

        for (Thread hilo : sumaParcial) {
            try {
                hilo.start();
                hilo.join(); //Espera a que cada hilo termine
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }

    }

    public static void cargarArreglo(int[] arreglo) {

        for (int i = 0; i < arreglo.length; i++) {

            arreglo[i] = (int) (Math.random() * 10) + 1;

        }

    }

}
