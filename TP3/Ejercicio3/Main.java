/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ejercicio3;

/**
 *
 * @author PC
 */
public class Main {

    public static void main(String[] args) {
        LaRueda rueda = new LaRueda();
        ElDescanso descanso = new ElDescanso();
        ElPlato plato = new ElPlato();

        Hamster hamster = new Hamster("1", plato, rueda, descanso);
        Hamster hamster1 = new Hamster("2", plato, rueda, descanso);
        Hamster hamster2 = new Hamster("3", plato, rueda, descanso);
        Hamster hamster3 = new Hamster("4", plato, rueda, descanso);
        Hamster hamster4 = new Hamster("5", plato, rueda, descanso);
        Hamster hamster5 = new Hamster("6", plato, rueda, descanso);

        Thread hilo1 = new Thread(hamster);
        Thread hilo2 = new Thread(hamster1);
        Thread hilo3 = new Thread(hamster2);
        Thread hilo4 = new Thread(hamster3);
        Thread hilo5 = new Thread(hamster4);
        Thread hilo6 = new Thread(hamster5);
        
        hilo6.start();
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        
      
 

    }

}
