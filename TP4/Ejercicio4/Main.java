/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.Ejercicio4;

import java.util.concurrent.Semaphore;

/**
 *
 * @author PC
 */
public class Main {

    public static void main(String[] args) {
        //Preguntar si esta bien y decir q nunca se llega a utilizar la impresora 3.
        
      
       

        Impresora[] arrImpresoras = new Impresora[3];
        Impresora impresoraA = new Impresora( 1);

        Impresora impresoraB = new Impresora( 2);
        Impresora impresoraC = new Impresora( 3);
        arrImpresoras[0] = impresoraA;
        arrImpresoras[1] = impresoraB;
        arrImpresoras[2] = impresoraC;
        
        GestorImpresoras gestor = new GestorImpresoras(arrImpresoras);

        Thread[] clientes = new Thread[10];

        for (int i = 0; i < clientes.length; i++) {
          
            
            clientes[i] = new Thread(new Cliente(gestor), String.valueOf(i));
          

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
