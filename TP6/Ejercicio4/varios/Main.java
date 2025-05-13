/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.Ejercicio4.varios;

/**
 *
 * @author PC
 */
public class Main {
      public static void main(String[] args) {
        Almacen almacen = new Almacen(15);
        
        
        Thread [] productor = new Thread[15];
        
        Thread [] consumidor = new Thread [15];
        
        
          for (int i = 0; i < productor.length; i++) {
              productor[i] = new Thread(new Productor(almacen),""+i);
              productor[i].start();
              
          }
          
          for (int i = 0; i < consumidor.length; i++) {
              consumidor[i] = new Thread(new Consumidor(almacen),""+i);
              consumidor[i].start();
              
          }
        
        
        
    }
    
}
