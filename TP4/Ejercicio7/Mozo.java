/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ejercicio7;

import java.util.concurrent.Semaphore;
//Hacer un bar que tnga a los mozos y los clientes.

/**
 *
 * @author PC
 */
public class Mozo implements Runnable {

    Bar bar;

    public Mozo(Bar bar) {
        this.bar = bar;
    }

    public void run() { //esta bien el run? 
        
        while(true){
                    bar.servir();

            
        }

        

    }

}
