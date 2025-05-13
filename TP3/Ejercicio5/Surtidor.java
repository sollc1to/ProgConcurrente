/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ejercicio5;

/**
 *
 * @author PC
 */
public class Surtidor {

    int combustible = 1000;

    public synchronized int despacharCombustible(int comb, String nombre) {

        if (combustible >= 50) {

            try {
                System.out.println("El modelo " + nombre + " esta cargando combustible...");
                Thread.sleep(500);
                comb = comb + 50;
                combustible = combustible - 50;
                            System.out.println("El modelo " + nombre + "dejo de cargar combustible");


            } catch (InterruptedException e) {
                System.out.println("Error!!!!!!!! ! !!");

            }finally{
                
                System.out.println("Combustible despachador:" + combustible);
                
                
            }


        }

        return comb;

    }

}
