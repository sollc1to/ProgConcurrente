/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ejercicio5;

import java.util.concurrent.Semaphore;

/**
 *
 * @author PC
 */
public class Main {
    public static void main(String[] args) {
        
        Impresora[] arrImpresoras = new Impresora[3];
        Impresora impresoraA = new Impresora(1,"A");

        Impresora impresoraB = new Impresora( 2,"B");
        Impresora impresoraC = new Impresora( 3,"A");
        arrImpresoras[0] = impresoraA;
        arrImpresoras[1] = impresoraB;
        arrImpresoras[2] = impresoraC;
        
        GestorImpresoras gestor = new GestorImpresoras(arrImpresoras);

        Thread[] clientes = new Thread[10];

        for (int i = 0; i < 5; i++) {
          
            
            clientes[i] = new Thread(new Cliente(gestor), "A");
          

        }
         for (int i = 5; i < 8; i++) {
          
            
            clientes[i] = new Thread(new Cliente(gestor), "B");
          

        }
         for (int i = 8; i < 10; i++) {
              clientes[i] = new Thread(new Cliente(gestor), "X");
            
        }
         
         
        //Preguntar si dos clientes podrian usar una impresora al mismo tiempo
        clientes[0].start();
        clientes[1].start();
        clientes[2].start();
        clientes[3].start();
        clientes[4].start();
        clientes[5].start();
        clientes[6].start();
        clientes[7].start();
        clientes[8].start();
        clientes[9].start();
        
        
        
        
    }
        
       
    
}
