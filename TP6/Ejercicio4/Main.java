/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ejercicio4;

/**
 *
 * @author PC
 */
public class Main {
    public static void main(String[] args) {
        Almacen almacen = new Almacen(15);
        
        Thread productor = new Thread(new Productor(almacen));
        Thread consumidor = new Thread(new Consumidor(almacen));
        productor.start();consumidor.start();
        
    }
    
}
