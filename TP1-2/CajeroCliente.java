/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progconcurrente;

/**
 *
 * @author PC
 */
public class CajeroCliente {

    public static void main(String[] args) {
        ClienteThread arreglo[] = new ClienteThread[10];
        arreglo[0] = new ClienteThread("Cliente 0", new int[]{2, 2, 1, 5,
            2, 3});
        arreglo[1] = new ClienteThread("Cliente 1", new int[]{2, 3, 5,
            2, 3});
        arreglo[2] = new ClienteThread("Cliente 2", new int[]{1, 3, 5, 1,
            1});
        long initialTime = System.currentTimeMillis();

        CajeroThread cajero1 = new CajeroThread("Cajero 1",arreglo,initialTime);
        
        cajero1.start();
    
      
    }
}
