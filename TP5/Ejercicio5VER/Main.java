/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.Ejercicio5VER;

/**
 *
 * @author PC
 */
public class Main {
    public static void main(String[] args) {
        Estacion estacion = new Estacion(5);
        
        
        Thread [] pasaje = new Thread[13];
        
        
        for (int i = 0; i < pasaje.length; i++) {
            pasaje [i] = new Thread(new Pasajero(estacion)," "+i);
            pasaje[i].start();
            
        }
        
        Thread tr = new Thread(new Tren(estacion));
        Thread t = new Thread(new VendedorTickets(estacion));
        tr.start();t.start();
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
