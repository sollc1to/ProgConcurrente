/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP7.Ejercicio3;

/**
 *
 * @author PC
 */
public class Main {
    public static void main(String[] args) {
        
        Cocina cocina = new Cocina(3,2,1);
        
        
        Thread A  = new Thread(new CocineroA(cocina), "A");
        Thread B  = new Thread(new CocineroB(cocina), "B");
        Thread C  = new Thread(new CocineroC(cocina), "C");
        
        A.start();
        B.start();
        C.start();
    }
    
}
