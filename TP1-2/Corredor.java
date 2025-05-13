/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progconcurrente;

/**
 *
 * @author PC
 */
public class Corredor implements Runnable {

    private String nombre;
    private int distancia;

    public Corredor(String nombre, int distancia) {
        this.nombre = nombre;
        this.distancia = distancia;

    }
    
    public int getDistancia(){
        return distancia;
        
    }

    public void run() {
        int avance;
        


        for (int i = 0; i < 100 ; i++) {
            avance = (int) (Math.random() * 10) + 1;

            System.out.println("Corredor " + nombre + " Distancia " + distancia + " avance" + avance);
            distancia = distancia + avance;
            try {
                Thread.sleep(200);
            } catch (InterruptedException exc) {
                System.out.println("Hilo interrumpido");
            }

        }

    }
    
    public String toString(){
        
        return ("Corredor " + nombre + " Distancia " + distancia);
    }

}
