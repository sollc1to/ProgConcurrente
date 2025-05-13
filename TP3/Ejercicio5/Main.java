/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.Ejercicio5;

/**
 *
 * @author PC
 */
public class Main {

    public static void main(String[] args) {
        Surtidor surtidor = new Surtidor();

        Auto auto1 = new Auto(101, surtidor, "Suzuki");
        Auto auto2 = new Auto(102, surtidor,"Toyota");
        Auto auto3 = new Auto(103, surtidor,"Toyota Corolla");
        Auto auto4 = new Auto(104, surtidor,"Meriva");
        Auto auto5 = new Auto(105, surtidor,"Fiat");
        
        Thread hilo1 = new Thread(auto1);
        Thread hilo2 = new Thread(auto2);
        Thread hilo3 = new Thread(auto3);
        Thread hilo4 = new Thread(auto4);
        Thread hilo5 = new Thread(auto5);
      
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
     

    }

}
