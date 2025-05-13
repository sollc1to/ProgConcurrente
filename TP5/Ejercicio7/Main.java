/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.Ejercicio7;

/**
 *
 * @author PC
 */
public class Main {
    public static void main(String[] args) {
        ParqueAcuatico parque= new ParqueAcuatico(5);
        
        Encargado g = new Encargado(parque);
        Thread enc = new Thread(g);
        
        Thread[] perso = new Thread[10];
        
        for (int i = 0; i < perso.length; i++) {
            
            perso[i] = new Thread(new Persona(parque),""+i);
            perso[i].start();
            
        }
        enc.start();
    }
    
}
